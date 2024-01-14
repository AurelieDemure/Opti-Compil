package compilateur.lexer; /*pour le mettre dans le package de l'analyseur lexicale*/
 
import java.io.*;

/* Cet automate reconnaît les caractères c'est-à-dire les éléments du code source sous la forme 'x' avec x un caractère ASCII imprimable */
public class AutomateCaractere extends Automate {

    public AutomateCaractere() {
        super();
    }
    
    /*public void main(String[] args, char firstLexeur) {
        estCaractere(firstLexeur);
    }*/
    
    public void estCaractere(char firstLexeur, Lexer Lexer) throws IOException{
        /* le premier caractère a déjà été reconnu par le lexeur, c'est un guillemet, pas besoin de le tester */
        this.token += firstLexeur;
        this.read += firstLexeur; 
        this.nextLexeur = (char)Lexer.read(); /* on avance dans la lecture */

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
            this.read += nextLexeur; /* s'il s'agit bien d'un guillemet, pas de souci, on a reconnu ce qu'on devait reconnaître donc token et read ne diffèrent pas */
        }

        else {
            /*System.out.println("Pour identifier un caractère il faut fermer le guillemet");*/
            Lexer.errorManager.saveError(Lexer.getLine(), Lexer.getNbChar(), "Pour identifier un caractère il faut fermer le guillemet");
            this.token += '\''; /* on ajoute un guillemet dans le token même s'il n'apparait pas dans le code source pour "corriger" le programme et continuer la lecture */
        }
    }

    
}
