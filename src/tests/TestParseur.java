package tests;

import java.io.IOException;
import java.util.Arrays;

import parser.*;
import lexer.*;

public class TestParseur {
    public void main() throws IOException{
        int[][] table = {{0,1,2,-1,-1,-1},
                         {3,3,3,-1,-1,-1},
                         {-1,-1,-1,5,6,-1}};
        TableAnalyse TableA = new TableAnalyse(table);
        NonTerminal S = new NonTerminal();
        NonTerminal T = new NonTerminal();
        NonTerminal U = new NonTerminal();
        Terminal a = new Terminal(new Token(0));
        Terminal b = new Terminal(new Token(1));
        Terminal c = new Terminal(new Token(2));
        Terminal d = new Terminal(new Token(3));
        Terminal e = new Terminal(new Token(4));
        Terminal f = new Terminal(new Token(5));
        TableA.addRegle(new RegleGrammaire(S,Arrays.asList(a)));
        TableA.addRegle(new RegleGrammaire(S,Arrays.asList(b)));
        TableA.addRegle(new RegleGrammaire(S,Arrays.asList(c,T,d)));
        TableA.addRegle(new RegleGrammaire(T,Arrays.asList(S,U)));
        TableA.addRegle(new RegleGrammaire(T,Arrays.asList(S,U)));
        TableA.addRegle(new RegleGrammaire(U,Arrays.asList()));
        
        Parser parser=new Parser(TableA.getTable());
        int statut=parser.Analyseur();
        if (statut==1){
            System.out.println("Le programme n'est pas reconnu par la grammaire");
        }
        else{
            System.out.println("Le programme est accepté par la grammaire");
        }
    }

    
}
