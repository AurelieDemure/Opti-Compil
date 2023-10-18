package lexer;

import java.util.Scanner;

public class AutomateEntier {
    public static String main(String[] args){
        Scanner clavier = new Scanner(System.in);                               /*Récupération caractère depuis le terminal */
        System.out.println("Entrez un entier :");
        String input = clavier.nextLine();
        clavier.close();
        if (estReconnu(input)){ 
            System.out.println("L'input est reconnu");
            return input;
        }
        else{
            System.out.println("L'input n'est pas reconnu");
        }
    }

    public static boolean estReconnu(String input){
        if (!estEntier(input.charAt(0))){
            return false;
        }
        return true;
    }
    
    public static boolean estEntier(char caractere){
        if (caractere>='0'&& caractere<='9')
            return true;
        else
            return false;
    }
}
