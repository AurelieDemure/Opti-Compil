package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/
 
import java.util.Scanner;

public class AutomateCaractere{
    public static void main(String[] args){
        Scanner clavier = new Scanner(System.in);
        System.out.println("Entrez une séquence :");
        String input = clavier.nextLine();
        clavier.close();
        if (estReconnuCaractere(input) != null){ 
            System.out.println("L'input est reconnu");
            System.out.println(input);
        }
        else{
            System.out.println("L'input n'est pas reconnu");
        }
    }

    public static String estReconnuCaractere(String input){
        if (input.length() != 3) 
            return null;
        if(input.charAt(0) != '\'')
            return null;
        if (input.charAt(input.length()-1) != '\'') 
            return null;
        else {
        return input;
        }
    }

}
