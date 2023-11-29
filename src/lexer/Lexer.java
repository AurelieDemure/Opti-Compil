package lexer; //pour le mettre dans le package de l'analyseur lexical

import java.io.*;
import java.util.*;

public class Lexer {

    //compteur de ligne
    private int line=1;
    //compteur de caractere
    private int nbChar=0;
    //la ligne en cours
    private String currentLine="";
    //le caractere que l on lit
    private char caractere=' ';
    //prochain caractere a lire
    private char prochain=' ';
    // Table des string, pour gerer les mots cles et identifiants. Utilisation d une table de hashage
    private HashMap<String, Mots> mots=new HashMap<String, Mots>();
    //Pour gerer les erreurs, ie les stocker et les envoyer
    public ErrorManager errorManager = new ErrorManager();

    //permet de mettre les tokens des mots cles dans la table des strings
    void reserve(Mots t){
        mots.put(t.lexeme, t);
    }

    //on initialise la table des strings
    public Lexer(){
        reserve(new Mots(Tag.TRUE, "true"));
        reserve(new Mots(Tag.FALSE, "false"));
        reserve(new Mots(Tag.ACCESS,"access"));
        reserve(new Mots(Tag.AND,"and"));
        reserve(new Mots(Tag.BEGIN,"begin"));
        reserve(new Mots(Tag.ELSE,"else"));
        reserve(new Mots(Tag.ELSIF,"elsif"));
        reserve(new Mots(Tag.END,"end"));
        reserve(new Mots(Tag.FOR,"for"));
        reserve(new Mots(Tag.FUNCTION,"function"));
        reserve(new Mots(Tag.IF,"if"));
        reserve(new Mots(Tag.IN,"in"));
        reserve(new Mots(Tag.IS,"is"));
        reserve(new Mots(Tag.LOOP,"loop"));
        reserve(new Mots(Tag.NEW,"new"));
        reserve(new Mots(Tag.NOT,"not"));
        reserve(new Mots(Tag.NULL,"null"));
        reserve(new Mots(Tag.OR,"or"));
        reserve(new Mots(Tag.OUT,"out"));
        reserve(new Mots(Tag.PROCEDURE,"procedure"));
        reserve(new Mots(Tag.RECORD,"record"));
        reserve(new Mots(Tag.REM,"rem"));
        reserve(new Mots(Tag.RETURN,"return"));
        reserve(new Mots(Tag.REVERSE,"reverse"));
        reserve(new Mots(Tag.THEN,"then"));
        reserve(new Mots(Tag.TYPE,"type"));
        reserve(new Mots(Tag.USE,"use"));
        reserve(new Mots(Tag.WHILE,"while"));
        reserve(new Mots(Tag.WITH,"with"));
        reserve(new Mots(Tag.CARACTEREVAL,"character'val"));
        reserve(new Mots(Tag.ADAINTEGERIO,"ada.text_io"));
        reserve(new Mots(Tag.ADATEXTIO,"ada.integer_io"));
        reserve(new Mots(Tag.PUT,"put"));
    }

    public int getLine(){
        return(this.line);
    }

    public int getNbChar(){
        return(this.nbChar);
    }

    public String getCurrentLine(){
        return(this.currentLine);
    }

    public HashMap<String, Mots> getMots(){
        return(this.mots);
    }

    //pour lire le prochain caractere
    public char read() throws IOException{
        this.nbChar+=1;
        this.caractere=this.prochain;
        this.prochain=(char)System.in.read();
        //on incremente le compteur de ligne si on a un saut de ligne, utile pour la gestion de bug
        if(this.caractere=='\n'){
            errorManager.throwErrorsLexer(this);//On renvoie toutes les erreurs
            this.line+=1;//incremente le nombre de ligne
            this.nbChar=0;//Le compteur de caractere repart au debut
            this.currentLine="";//La ligne courante se reinitialise
        }
        else if((int)this.caractere!=65535){//On rajoute le caractere lu a la ligne courante
            this.currentLine+=this.caractere;
        }
        return this.caractere;
    }

    public Token scan() throws IOException{
        
        //suppression des espaces, tabulations et commentaires
        while(this.caractere<=32 || this.caractere =='-' && this.prochain=='-'){

            //on gere les commentaires
            if(this.caractere=='-' && this.prochain=='-'){
                //detection du debut du commentaire
                while(this.caractere!='\n'){
                    //on continue a skip
                    this.read();
                }
            }
   
            //on avance
            this.read();
        }

        //on teste si on a un nombre (automate entier)
        if(caractere>=48 && caractere <=57){
            //l'automate pour les entiers
            AutomateEntier automateEntier = new AutomateEntier();
            automateEntier.estEntier(caractere, this);
            String s=automateEntier.getToken();;//le mot qu'on a reconnu avec l'automate
            this.caractere=automateEntier.getNextLexeur();
            Token t=new Mots(Tag.ENTIER, s);
            return t;
        }

        //on teste si on a un identifiant (automate ident)
        else if(this.caractere >='a' && this.caractere <='z' || this.caractere>='A' && this.caractere <='Z'){
            //l'automate pour les indentifiants
            AutomateIdentificateur automateIndent = new AutomateIdentificateur();
            automateIndent.estIdenticateur(caractere, this);
            String s=automateIndent.getToken();;//le mot qu'on a reconnu avec l'automate
            this.caractere=automateIndent.getNextLexeur();
            Mots w=(Mots)mots.get(s);//on recupere sa valeur dans la table des strings
            if(w!=null){
                return w;//si il est dans la table, pas besoin de le traiter plus
            }
            w=new Mots(Tag.IDENT, s);//si il n est pas dans la table, on cree le token associe
            reserve(w);//et on le met dans la table
            return w;
        }
        
        //on teste si on a un symbole (automate symbole)
        else if(caractere==';' || caractere=='(' || caractere==')' || caractere=='+' || caractere=='-' ||caractere=='*' || caractere=='.' || caractere=='=' || caractere=='<' || caractere=='>'  || caractere==':' || caractere=='/' || caractere==','){
            //l'automate pour les symboles 
            AutomateSymboles automateSymboles = new AutomateSymboles();
            automateSymboles.estSymbole(caractere, this);
            String s=automateSymboles.getToken();//le mot qu'on a reconnu avec l'automate
            this.caractere=automateSymboles.getNextLexeur();
            Token t;
            if(s.compareTo(";")==0){
                t=new Token(Tag.POINTV);
            }
            else if(s.compareTo("(")==0){
                t=new Token(Tag.PO);
            }
            else if(s.compareTo(")")==0){
                t=new Token(Tag.PF);
            }
            else if(s.compareTo("+")==0){
                t=new Token(Tag.PLUS);
            }
            else if(s.compareTo("-")==0){
                t=new Token(Tag.MOINS);
            }
            else if(s.compareTo("*")==0){
                t=new Token(Tag.ETOILE);
            }
            else if(s.compareTo(".")==0){
                t=new Token(Tag.POINT);
            }
            else if(s.compareTo("=")==0){
                t=new Token(Tag.EGALE);
            }
            else if(s.compareTo(">")==0){
                t=new Token(Tag.SUP);
            }
            else if(s.compareTo("<")==0){
                t=new Token(Tag.INF);
            }
            else if(s.compareTo(":")==0){
                t=new Token(Tag.DPOINTS);
            }
            else if(s.compareTo("/")==0){
                t=new Token(Tag.DIV);
            }
            else if(s.compareTo(">=")==0){
                t=new Token(Tag.SUPEG);
            }
            else if(s.compareTo("<=")==0){
                t=new Token(Tag.INFEG);
            }
            else if(s.compareTo(":=")==0){
                t=new Token(Tag.AFFECT);
            }
            else if(s.compareTo(",")==0){
                t=new Token(Tag.VIRGULE);
            }
            else if(s.compareTo("..")==0){
                t=new Token(Tag.POINTPOINT);
            }
            else{// /=
                t=new Token(Tag.NEGALE);
            }
            return t;
        }

        //on teste si on a un caractere (automate caractere)
        else if(this.caractere=='\''){
            //l'automate pour les caracteres 
            AutomateCaractere automateCar = new AutomateCaractere();
            automateCar.estCaractere(caractere, this);
            String s=automateCar.getToken();;//le mot qu on a reconnu avec l automate
            if(this.caractere=='\''){
                this.caractere=' ';
            }
            Token t=new Mots(Tag.CHAR, s);
            return t;
        }

        //Si on arrive en fin du fichier
        else if((int)this.caractere==65535){
            Token t=new Token((int)'$');//token fin de texte
            errorManager.throwErrorsLexer(this);//On renvoie toutes les erreurs
            return t;
        }
        //si on a pas reconnu le caractere
        else{
            //sauvegarde du message d erreur
            errorManager.saveError(this.line, this.nbChar, "Le caractere " + this.caractere + " n'est pas reconnu");
            this.caractere=' ';
            return(this.scan());
        }
    }
}
