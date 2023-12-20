package tests;

import java.io.IOException;
import java.util.Arrays;

import parser.*;
import lexer.*;

public class TestParseur {
    public static void main(String[] arg) throws IOException{
        Grammaire g=new GrammaireTest();
        int statut=g.analyse();
        if (statut==1){
            System.out.println("Le programme n'est pas reconnu par la grammaire");
        }
        else{
            System.out.println("Le programme est accepté par la grammaire");
        }
    }

    
}
