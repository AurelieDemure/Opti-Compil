package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.io.IOException;

public class AutomateIdentificateur extends Automate{

    public AutomateIdentificateur(char token, char read, char nextLexeur) {
        super(token, read, nextLexeur);
    }

    /*public void main(char firstLexeur, String[] args){
        estIdenticateur(firstLexeur, args, lexer);
    }*/

    public void estIdenticateur(char firstLexeur, Lexer Lexer) throws IOException{
        this.token += firstLexeur;
        this.read += firstLexeur;
        this.nextLexeur = (char)Lexer.read();
        while(estReconnu(nextLexeur)){ 
            this.token += nextLexeur;
            this.read += nextLexeur;
            this.nextLexeur = (char)Lexer.read();
        }
        if(estReconnuAda(firstLexeur)){             //On regarde si le prochain caractère est . ou ' afin de voir si c'est une chaine spécifique du langage Ada
            while(estReconnu(nextLexeur)){          //Si on reconnait . ou ' on continue jusqu'à la ne plus reconnaitre de caractère
                this.token += nextLexeur;
                this.read += nextLexeur;
                this.nextLexeur = (char)Lexer.read();
            }
            if(!estAda(token))                      //Si on a reconnu . ou ' on vérifie bien finalement que c'est l'une des 3 chaines de Ada 
                Lexer.errorManager.saveError("La chaine n'est pas un identificateur");
        }
    }

    public boolean estReconnuAda(char nextLexeur){
        if(nextLexeur=='\'' || nextLexeur=='.')
            return true;
        else
            return false;
    }

    public boolean estReconnu(char nextLexeur){
        if(nextLexeur >='a' && nextLexeur <='z' || nextLexeur>='A' && nextLexeur <='Z'|| nextLexeur>='0'&& nextLexeur<='9'|| nextLexeur=='_')         
            return true;
        else
            return false;
    }

    public boolean estAda(String token){
        if(token =="character'val" || token=="Ada.Text_IO" || token=="Ada.Integer_IO")
            return true;
        else
            return false;
    }
}
