package lexer; /*pour le mettre dans le package de l'analyseur lexical*/

import java.util.Scanner;

public class AutomateSymboles extends Automate{

    public AutomateSymboles(String token,String read,char nextLexeur){
        super(token,read,nextLexeur);
    }

    public void main(char first,String[] args){
        Symbole(first,args);
    }
    public Automate Symbole(char first,String[] args){
        this.token+=first;
        this.read=this.token;
        this.nextLexeur=(char)Lexer.read();
        if (estSymb(first)){
        }
        else{
            if (estSymbAvecEgal(first)){
                if (this.nextLexeur=='='){
                    this.token+='=';
                    this.nextLexeur=(char)Lexer.read();
                } 
                this.read=this.token;
            }
            else {
                System.out.println("Erreur");
            }
        }
    }

    public boolean estSymbAvecEgal(char caractere){
        if (caractere=='<' || caractere=='>'  || caractere==':' || caractere=='/')
            return true;
        else
            return false;
    }

    public boolean estSymb(char caractere){
        if (caractere==';' || caractere=='(' || caractere==')' || caractere=='+' || caractere=='-' ||caractere=='*' || caractere=='.' || caractere=='=')
            return true;
        else
            return false;
    }
}