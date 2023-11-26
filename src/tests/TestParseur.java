package tests;

import java.io.IOException;
import java.util.Arrays;

import parser.*;
import lexer.*;

public class TestParseur {
    public static void main(String[] arg) throws IOException{
        int[] tableTag = {(int)'a',(int)'b',(int)'(',(int)')',(int)';',(int)'$'};
        int[][] table = {{0,1,2,-1,-1,-1},
                         {3,3,3,-1,-1,-1},
                         {-1,-1,-1,5,6,-1}};
        Parser parser=new Parser(tableTag, table);
        NonTerminal S = new NonTerminal();
        NonTerminal T = new NonTerminal();
        NonTerminal U = new NonTerminal();
        Terminal a = new Terminal(new Token((int)'a'));
        Terminal b = new Terminal(new Token((int)'b'));
        Terminal c = new Terminal(new Token((int)'('));
        Terminal d = new Terminal(new Token((int)')'));
        Terminal e = new Terminal(new Token((int)';'));
        Terminal f = new Terminal(new Token((int)'$'));
        parser.table.addRegle(new RegleGrammaire(S,Arrays.asList(a)));
        parser.table.addRegle(new RegleGrammaire(S,Arrays.asList(b)));
        parser.table.addRegle(new RegleGrammaire(S,Arrays.asList(c,T,d)));
        parser.table.addRegle(new RegleGrammaire(T,Arrays.asList(S,U)));
        parser.table.addRegle(new RegleGrammaire(T,Arrays.asList(S,U)));
        parser.table.addRegle(new RegleGrammaire(U,Arrays.asList()));
        
        int statut=parser.Analyseur();
        if (statut==1){
            System.out.println("Le programme n'est pas reconnu par la grammaire");
        }
        else{
            System.out.println("Le programme est accepté par la grammaire");
        }
    }

    
}
