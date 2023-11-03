package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/
 
import java.io.IOException;


public class AutomateCaractere extends Automate {

    public AutomateCaractere(char token, char read, char nextLexeur) {
        super(token, read, nextLexeur);
    }
    
    /*public void main(String[] args, char firstLexeur) {
        estCaractere(firstLexeur);
    }*/
    
    public void estCaractere(char firstLexeur, Lexer Lexer) throws IOException{

        this.token += firstLexeur;
        this.read += firstLexeur;
        this.nextLexeur = (char)Lexer.read();

        if (nextLexeur >= 32 && nextLexeur <= 126) {            /* les caractères ASCII imprimables vont de l'indice 32 à 126*/   
            this.token += nextLexeur;
            this.read += nextLexeur;
        }
        else{
            /*System.out.println("Le caractère n'est pas un caracère ASCII imprimable");*/
            Lexer.errorManager.saveError(Lexer.getLine(), Lexer.getNbChar(), "Le caractère n'est pas un caractère ASCII imprimable");
        }

        this.nextLexeur = (char)Lexer.read();

        if (nextLexeur == '\'') {
            this.token += nextLexeur;
            this.read += nextLexeur;
        }

        else {
            /*System.out.println("Pour identifier un caractère il faut fermer le guillemet");*/
            Lexer.errorManager.saveError(Lexer.getLine(), Lexer.getNbChar(), "Pour identifier un caractère il faut fermer le guillemet");
            this.token += '\'';
        }
    }

    
}
