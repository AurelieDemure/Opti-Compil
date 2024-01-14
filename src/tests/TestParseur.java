package tests;

import java.io.*;
import compilateur.parse_tree.*;
import compilateur.parser.*;

public class TestParseur {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireTest();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        arbreSyntaxique.showAsAbstractTree(arbreSyntaxique.getRacine(), "",true);
    }
}
