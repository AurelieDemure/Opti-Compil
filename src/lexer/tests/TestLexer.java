package lexer;

import java.io.*;
import java.util.*;

public class TestLexer{

    public static void main(String[] arg) throws IOException{
        Lexer lexer = new Lexer();
        Token token = new Token(' ');
        while(token.tag!='$'){
            token = lexer.scan();
        }
    }
}