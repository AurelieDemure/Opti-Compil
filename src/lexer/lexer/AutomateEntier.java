package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.io.IOException;

public class AutomateEntier extends Automate {

    public AutomateEntier() {
        super();
    }

    /*public void main(char firstLexeur, String[] args){
        estEntier(firstLexeur, args, lexer);
    }*/

    public void estEntier(char firstLexeur, Lexer Lexer) throws IOException{
        this.token += firstLexeur;
        this.read += firstLexeur;
        this.nextLexeur = (char)Lexer.read();
        while(estReconnu(nextLexeur)){ 
            this.token += nextLexeur;
            this.read += nextLexeur;
            this.nextLexeur = (char)Lexer.read();
        }
    }

    public static boolean estReconnu(char nextLexeur){
        if (nextLexeur>='0'&& nextLexeur<='9')
            return true;
        else
            return false;
    }
}
