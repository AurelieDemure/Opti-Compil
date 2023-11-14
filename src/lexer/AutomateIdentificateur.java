package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.io.IOException;

public class AutomateIdentificateur extends Automate{

    public AutomateIdentificateur() {
        super();
    }

    /*public void main(char firstLexeur, String[] args){
        estIdenticateur(firstLexeur, args, lexer);
    }*/

    public void estIdenticateur(char firstLexeur, Lexer Lexer) throws IOException{
        int flag = 0;
        this.token += Character.toLowerCase(firstLexeur);
        this.read += firstLexeur;
        this.nextLexeur = (char)Lexer.read();
        while(estReconnu(nextLexeur)){ 
            this.token += Character.toLowerCase(nextLexeur);
            this.read += nextLexeur;
            this.nextLexeur = (char)Lexer.read();
        }
        if(estReconnuAda(nextLexeur)){                      //On regarde si le prochain caractère est . ou ' afin de voir si c'est une chaine spécifique du langage Ada
            if(nextLexeur=='\'' && token.compareTo("character")==0){       //Si on reconnait ' on vérifie que la chaine avant est "character" et on continue sinon erreur
                this.token += nextLexeur;
                this.read += nextLexeur;
                this.nextLexeur = (char)Lexer.read();
                while(estReconnu(nextLexeur)){          
                    this.token += Character.toLowerCase(nextLexeur);
                    this.read += nextLexeur;
                    this.nextLexeur = (char)Lexer.read();
                }
                if(!estAda(token)){                           //On regarde si c'est bien la chaine character'val, sinon on corrige
                    token="character'val";
                    Lexer.errorManager.saveError(Lexer.getLine(), Lexer.getNbChar(), "La chaine n'est pas un identificateur, correction en \"character\'val\""); 
                }
            }
            if(nextLexeur=='.' && token.compareTo("ada")==0){              //Si on reconnait . on vérifie que la chaine avant est "Ada" et on continue sinon erreur
                this.token += nextLexeur;
                this.read += nextLexeur;
                this.nextLexeur = (char)Lexer.read();
                if(nextLexeur=='I')
                    flag = 1;
                while(estReconnu(nextLexeur)){          
                    this.token += Character.toLowerCase(nextLexeur);
                    this.read += nextLexeur;
                    this.nextLexeur = (char)Lexer.read();
                }
                if(!estAda(token))                           //On regarde si c'est bien la chaine Ada.*, sinon on corrige
                    if(flag==0){
                        token="Ada.Text_IO";
                        Lexer.errorManager.saveError(Lexer.getLine(), Lexer.getNbChar(), "La chaine n'est pas un identificateur, correction en \"Ada.Text_IO\"");
                    }
                    else {
                        token="Ada.Integer_IO";
                        Lexer.errorManager.saveError(Lexer.getLine(), Lexer.getNbChar(), "La chaine n'est pas un identificateur, correction en \"Ada.Integer_IO\"");
                    }
            }
        }
    }

    public boolean estReconnu(char nextLexeur){
        if(nextLexeur >='a' && nextLexeur <='z' || nextLexeur>='A' && nextLexeur <='Z'|| nextLexeur>='0'&& nextLexeur<='9'|| nextLexeur=='_')         
            return true;
        else
            return false;
    }
    
    public boolean estReconnuAda(char nextLexeur){
        if(nextLexeur=='\'' || nextLexeur=='.')
            return true;
        else
            return false;
    }

    public boolean estAda(String token){
        if(token.compareTo("character'val")==0 || token.compareTo("ada.text_io")==0 || token.compareTo("ada.integer_io")==0)
            return true;
        else
            return false;
    }
}
