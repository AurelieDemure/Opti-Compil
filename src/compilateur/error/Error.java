package compilateur.error; /*pour le mettre dans le package d'erreur'*/

import compilateur.lexer.*;

/*import java.io.*;
import java.util.*;*/

public class Error {
    // Declaring ANSI_RESET so that we can reset the color 
    public static final String ANSI_RESET = "\u001B[0m"; 
        // Declaring the color 
        // Custom declaration 
    public static final String ANSI_RED = "\u001B[31m"; 

    public Error(){}

        int line = 0;
        int nbChar = 0;
        String message = "";

    public Error(String message){
        this.message = message;
    }

    public Error(int line, int nbChar, String message){
        this.line = line;
        this.nbChar = nbChar;
        this.message = message;
    }
    public void throwError(){
        System.out.println(ANSI_RED + "ERROR : " + ANSI_RESET + this.message);
    }

    public void throwErrorLexer(Lexer lexer){
        String currentLine = lexer.getCurrentLine();
        System.out.println(ANSI_RED + "ERROR : " + ANSI_RESET);
        System.out.println("Ligne :" + this.line);
        System.out.println(currentLine);
        for(int i=1; i<nbChar; i++){
            System.out.print(" ");
        }
        System.out.println("^");
        System.out.println("Message : " + this.message);
        System.out.println("");
    }
}
