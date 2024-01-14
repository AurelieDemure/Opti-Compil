package tests;

import java.io.*;
import compilateur.parser.*;
import compilateur.parse_tree.*;

public class TestParseurTree {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireLL1Test();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        arbreSyntaxique.showAsAbstractTree(arbreSyntaxique.getRacine(), "",true);
    }
}
