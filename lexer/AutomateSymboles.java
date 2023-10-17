package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.util.Scanner;

public class AutomateSymboles{
    public static void main(String[] args){
        Scanner clavier = new Scanner(System.in);
        System.out.println("chaine :");
        String input = clavier.nextLine();
        clavier.close();
        if (estReconnu(input)){ 
            System.out.println("L'input est reconnu");
        }
        else{
            System.out.println("L'input n'est pas reconnu");
        }
    }

    public static boolean estReconnu(String input){
        for (int i=0; i<input.length();i++){
            char caractere = input.charAt(i);
            if (estSymbAvecEgal(caractere)){
                if (estSymbEgal(input.charAt(i+1))){
                i++;
            }
            }
            if (!estSymbAvecEgal(caractere) && !estSymb(caractere)){
                return false;
            }
        }
        return true;
    }

    public static boolean estSymbAvecEgal(char caractere){
        if (caractere=="<" || caractere==">"  || caractere==":" || caractere=="/")
            return true;
        else
            return false;
    }

    public static boolean estSymbEgal(char caractere){
        if (caractere=="=")
            return true;
        else
            return false;
    }

    public static boolean estSymb(char caractere){
        if (caractere==";" || caractere=="(" || caractere==")" || caractere=="+" || caractere=="-" ||caractere=="*" || caractere=="." || caractere=="=")
            return true;
        else
            return false;
    }
}