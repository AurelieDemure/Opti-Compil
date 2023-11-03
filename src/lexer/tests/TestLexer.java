package lexer;

import java.io.*;
import java.util.*;

public class TestLexer{

    public static void main(String[] arg) throws IOException{
        Lexer lexer = new Lexer();
        Token token = new Token(0);
        while(token.tag!=36){
            if(token.tag!=0){
                System.out.println("##line : "+ lexer.getLine());
                System.out.println("Token : "+token.tag);
                if(token.tag>255){
                    System.out.println("Its value : "+((Mots)token).lexeme);
                }
            }
            token = lexer.scan();
        }
        System.out.println("###EOF###");
    }
}