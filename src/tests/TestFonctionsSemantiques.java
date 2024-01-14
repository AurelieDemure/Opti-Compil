package tests;

import java.io.IOException;

import compilateur.abstractTree.*;
import compilateur.parser.*;
import compilateur.parse_tree.*;

public class TestFonctionsSemantiques {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireLL1Test();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        Component abstractTree = arbreSyntaxique.getRacine().interpret();    
        AbstractTree.showAsAbstractTree(abstractTree,"",true);
    }
}
