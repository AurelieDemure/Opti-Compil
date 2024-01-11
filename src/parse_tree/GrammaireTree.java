package parser;

import java.io.IOException;
import java.util.List;

import lexer.Token;

public abstract class GrammaireTree {
    private ParserTree parser;
    public GrammaireTree(int[] tableTag,int[][] table){
        parser=new ParserTree(tableTag, table);
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
