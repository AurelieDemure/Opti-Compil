package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.util.Scanner;

public class AutomateIdentificateur{
    public static void main(String[] args){
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez un caractere minuscule :");
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
        if(input.charAt(0)<'a'|| input.charAt(0)>'z')
            return false;
        else{
            for (int i=1; i<input.length();i++){
                char caractere = input.charAt(i);
                if (!estCaractere(caractere)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean estCaractere(char caractere){
        if (caractere >='a' && caractere <='z' || caractere>='A' && caractere <='Z'|| caractere>='0'&& caractere<='9'|| caractere=='_')
            return true;
        else
            return false;
    }
}
