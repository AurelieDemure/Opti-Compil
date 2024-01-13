package tests;

import java.io.IOException;

import parser.*;
import parse_tree.ArbreSyntaxique;

public class TestParseurTree {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireLL1Test();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        arbreSyntaxique.showAsAbstractTree(arbreSyntaxique.getRacine(), "",true);
    }
}
