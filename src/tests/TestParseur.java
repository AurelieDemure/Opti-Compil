package tests;

import java.io.IOException;

import parser.*;
import abstractTree.*;
import parse_tree.ArbreSyntaxique;

public class TestParseur {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireLL1Test();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        arbreSyntaxique.showAsAbstractTree(arbreSyntaxique.getRacine(), "",true);
        //Component abstractTree = arbreSyntaxique.getRacine().interpret();    
        //AbstractTree.showAsAbstractTree(abstractTree,"",true);
    }
}
