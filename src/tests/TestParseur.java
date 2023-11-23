package tests;

import java.io.IOException;

import parser.*;

public class TestParseur {
    public void main() throws IOException{
        int[][] table = {{0,1,2,-1,-1,-1},
                         {3,3,3,-1,-1,-1},
                         {-1,-1,-1,5,6,-1}};
        TableAnalyse tableA = new TableAnalyse(table);
        NonTerminal S = new NonTerminal();
        NonTerminal T = new NonTerminal();
        NonTerminal U = new NonTerminal();
        Terminal a = new Terminal(new Token(0));
        Terminal b = new Terminal(new Token(1));
        Terminal c = new Terminal(new Token(2));
        Terminal d = new Terminal(new Token(3));
        Terminal e = new Terminal(new Token(4));
        Terminal f = new Terminal(new Token(5));
        TableA.addRegle(new RegleGrammaire(S,{a}));
        TableA.addRegle(new RegleGrammaire(S,{b}));
        TableA.addRegle(new RegleGrammaire(S,{c,T,d}));
        TableA.addRegle(new RegleGrammaire(T,{S,U}));
        TableA.addRegle(new RegleGrammaire(T,{S,U}));
        TableA.addRegle(new RegleGrammaire(U,{}));
        
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
