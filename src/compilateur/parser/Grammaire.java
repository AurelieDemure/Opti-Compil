package compilateur.parser;

import java.io.*;
import java.util.*;

import compilateur.abstractTree.*;
import compilateur.lexer.*;
import compilateur.parse_tree.*;


public abstract class Grammaire {
    public Parser parser;
    public Grammaire(int[] tableTag,int[][] table){
        parser=new Parser(this, tableTag, table);
    }
    public ArbreSyntaxique analyse() throws IOException{
        return parser.Analyseur();
    }
    public void createRegle(NonTerminal mGauche,List<Symbole> mDroit){
        parser.table.addRegle(new RegleGrammaire(mGauche,mDroit));
    }
    public Terminal createTerminal(int tag){
        return new Terminal(new Token(tag));
    }
    public NonTerminal createNonTerminal(){
        return new NonTerminal();
    }

    public abstract Component fonctionSemantique(int regle, NonTerminalExpression noeud);

    public abstract String getNonTerminal(int idRegle);

    public abstract String getTerminal(int tag);

}
