package compilateur;

import java.io.*;
import compilateur.abstractTree.*;
import compilateur.parse_tree.*;
import compilateur.parser.*;

public class OptiCompil {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireLL1Test();
        ArbreSyntaxique arbreSyntaxique=g.analyse();
        Component abstractTree = arbreSyntaxique.getRacine().interpret();    
        AbstractTree.showAsAbstractTree(abstractTree,"",true);
    }
}
