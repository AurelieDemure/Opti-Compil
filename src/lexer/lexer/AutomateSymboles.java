package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.util.Scanner;

public class AutomateSymboles{
    public static void main(String[] args){
        Scanner clavier = new Scanner(System.in);
        System.out.println("chaine :");
        String input = clavier.nextLine();
        clavier.close();
        if (estSymbole(input)){ 
            System.out.println("L'input est reconnu");
        }
        else{
            System.out.println("L'input n'est pas reconnu");
        }
    }

    public static boolean estSymbole(String input){
        if (input.length()==1){
            if (estSymb(input.charAt(0)) || estSymbAvecEgal(input.charAt(0))){
                return true;
            }
        }
        if (input.length()==2){
            if (estSymbAvecEgal(input.charAt(0))){
                if (input.charAt(1)=='='){
                    return true;
                }
            }
        }
        return false;
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