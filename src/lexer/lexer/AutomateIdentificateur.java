package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

public class AutomateIdentificateur{
    public static void main(String[] args){
        String input = args[0];
        if (estReconnu(input)){ 
            System.out.println("L'input est reconnu");
        }
        else{
            System.out.println("L'input n'est pas reconnu");
        }
    }

    public static boolean estReconnu(String input){
        if(input.charAt(0)<'A'|| input.charAt(0)>'Z' && input.charAt(0)<'a' || input.charAt(0)>'z')           /*Vérification premier caractère lettre minuscule */
            return false;
        else{
            for (int i=1; i<input.length();i++){                            /*Vérification des autres caractères */
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
