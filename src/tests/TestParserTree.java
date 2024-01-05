package tests;

import java.io.IOException;

import parser.*;

public class TestParserTree {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireTest();
        ArbreSyntaxique arbre=g.analyse();
        
    }
}
