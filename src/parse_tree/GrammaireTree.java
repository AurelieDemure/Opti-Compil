package parser;

import java.io.IOException;
import java.util.List;

import lexer.Token;

public abstract class Grammaire {
    private Parser parser;
    public Grammaire(int[] tableTag,int[][] table){
        parser=new Parser(tableTag, table);
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

}
