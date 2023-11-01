package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

public class AutomateIdentificateur extends Automate{

    public AutomateIdentificateur(String token, String read, char nextLexeur) {
        super(token, read, nextLexeur);
    }

    public void estIdenticateur(char firstLexeur){
        this.token += firstLexeur;
        this.read += firstLexeur;
        this.nextLexeur = (char)Lexer.read();
        while(estReconnu(nextLexeur)){ 
            this.token += nextLexeur;
            this.read += nextLexeur;
            this.nextLexeur = (char)Lexer.read();
        }
    }

    public boolean estReconnu(char nextLexeur){
        if(nextLexeur >='a' && nextLexeur <='z' || nextLexeur>='A' && nextLexeur <='Z'|| nextLexeur>='0'&& nextLexeur<='9'|| nextLexeur=='_')         
            return true;
        else
            return false;
    }

    public void main(char firstLexeur){
        estIdenticateur(firstLexeur);
    }
}
