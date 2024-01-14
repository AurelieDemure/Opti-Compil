package tests;

import compilateur.lexer.*;
import java.io.*;

public class TestLexer{

    public static void main(String[] arg) throws IOException{
        Lexer lexer = new Lexer();
        Token token = new Token(0);
        while(token.tag!=36){
            if(token.tag!=0){
                System.out.println("##line : "+ lexer.getLine());
                System.out.println("Token : "+token.tag);
                if(token instanceof Mots){
                    System.out.println("Its value : "+((Mots)token).lexeme);
                }
                else if(token.tag<256){
                    System.out.println("Its value : "+(char)token.tag);
                }
            }
            token = lexer.scan();
        }
        System.out.println("###EOF###");
        //System.out.println(lexer.getMots());
    }
}