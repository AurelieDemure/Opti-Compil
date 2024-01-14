package compilateur.lexer; /*pour le mettre dans le package de l'analyseur lexical*/

import java.io.*;

public class AutomateSymboles extends Automate{

    public AutomateSymboles(){
        super();
    }

    /*public void main(char first,String[] args){
        Symbole(first,args);
    }*/
    public void estSymbole(char first,Lexer Lexer) throws IOException{
        this.token+=first;
        this.read=this.token;
        this.nextLexeur=(char)Lexer.read();
        if (estSymb(first)){
        }
        else{
            if (estSymbAvecPoint(first)){
                if (this.nextLexeur=='.'){
                    this.token+='.';
                    this.nextLexeur=(char)Lexer.read();
                } 
                this.read=this.token;
            }
            else if (estSymbAvecEgal(first)){
                if (this.nextLexeur=='='){
                    this.token+='=';
                    this.nextLexeur=(char)Lexer.read();
                } 
                this.read=this.token;
            } 
            else {
                (Lexer.errorManager).saveError(Lexer.getLine(), Lexer.getNbChar(), "Le caractère n'est pas un symbole");
            }
        }
    }

    public boolean estSymbAvecEgal(char caractere){
        if (caractere=='<' || caractere=='>'  || caractere==':' || caractere=='/')
            return true;
        else
            return false;
    }

     public boolean estSymbAvecPoint(char caractere){
        if (caractere=='.')
            return true;
        else
            return false;
    }


    public boolean estSymb(char caractere){
        if (caractere==';' || caractere=='(' || caractere==')' || caractere=='+' || caractere=='-' ||caractere=='*' || caractere=='=' || caractere==',')
            return true;
        else
            return false;
    }
}