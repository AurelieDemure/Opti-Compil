package tests;

import java.io.IOException;

import parser.*;

public class TestParseur {
    public void main() throws IOException{
        Parser parser=new Parser();
        int statut=parser.Analyseur();
        if (statut==1){
            System.out.println("Le programme n'est pas reconnu par la grammaire");
        }
        else{
            System.out.println("Le programme est accepté par la grammaire");
        }
    }

    
}
