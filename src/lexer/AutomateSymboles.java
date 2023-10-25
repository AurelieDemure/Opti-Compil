package lexer; /*pour le mettre dans le package de l'analyseur lexical*/

import java.util.Scanner;

public class AutomateSymboles extends Automate{

    public AutomateSymboles(String token,String read,char nextLexeur){
        super(token,read,nextLexeur);
    }

    public static void main(char first,String[] args){
        Symbole(first,args);
    }
    public static void Symbole(char first,String[] args){
        this.token+=first;
        this.read=this.token;
        this.nextLexeur=(char)Lexer.read();
        if (estSymb(this.token)){
            return this;
        }
        else{
            if (estSymbAvecEgal(this.token)){
                if (this.nextLexeur=='='){
                    this.token+='=';
                    this.nextLexeur=(char)Lexer.read();
                } 
                this.read=this.token;
                return this;
            }
            else {
                System.out.println("Erreur");
            }
        }
    }

    public static boolean estSymbAvecEgal(char caractere){
        if (caractere=='<' || caractere=='>'  || caractere==':' || caractere=='/')
            return true;
        else
            return false;
    }

    public static boolean estSymb(char caractere){
        if (caractere==';' || caractere=='(' || caractere==')' || caractere=='+' || caractere=='-' ||caractere=='*' || caractere=='.' || caractere=='=')
            return true;
        else
            return false;
    }
}