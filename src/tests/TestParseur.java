package tests;

import java.io.IOException;

import parser.*;
import parser_tree.*;
import abstractTree.*;

public class TestParseur {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireLL1Test();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        Component abstractTree = arbreSyntaxique.analyse();    
        AbstractTree.showAsAbstractTree(abstractTree,"",true);
    }
}
