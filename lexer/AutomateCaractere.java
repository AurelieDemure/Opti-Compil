package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.util.Scanner;

public class AutomateCaractere{
    public static void main(String[] args){
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une séquence :");
        String input = clavier.nextLine();
        clavier.close();
        if (estReconnuCaractere(input)){ 
            System.out.println("L'input est reconnu");
        }
        else{
            System.out.println("L'input n'est pas reconnu");
        }
    }

    public static boolean estReconnuCaractere(String input){
        if (input.length() != 3) 
            return false;
        if(input.charAt(0) != '\'')
            return false;
        if (input.charAt(input.length()-1) != '\'') 
            return false;
        else {
        return true;
        }
    }

}
