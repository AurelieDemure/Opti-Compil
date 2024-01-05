package tests;

import java.io.IOException;

import parser.*;

public class TestParseur {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireTest();
        ArbreSyntaxique arbre=g.analyse();
        int statut=1;
        if (statut==1){
            System.out.println("Le programme n'est pas reconnu par la grammaire");
        }
        else{
            System.out.println("Le programme est accepté par la grammaire");
        }
    }

    
}
