package parser;

import java.util.Arrays;

import abstractTree.Component;
import abstractTree.Leaf;
import lexer.*;
import parse_tree.AbstractExpression;

public class GrammaireTest extends Grammaire{
    private static int[] tableTag = {Tag.AND,Tag.BEGIN,(int)'(',(int)')',(int)';',(int)'$'};
    private static int[][] table = 
                        {{0,1,2,-1,-1,-1},
                         {3,3,3,-1,-1,-1},
                         {-1,-1,-1,5,4,-1}};

    private NonTerminal S = createNonTerminal();
    private NonTerminal T = createNonTerminal();
    private NonTerminal U = createNonTerminal();
    private Terminal a = createTerminal(Tag.AND);
    private Terminal b = createTerminal(Tag.BEGIN);
    private Terminal c = createTerminal((int)'(');
    private Terminal d = createTerminal((int)')');
    private Terminal e = createTerminal((int)';');
    private Terminal f = createTerminal((int)'$');
    public GrammaireTest(){
        super(tableTag, table);
        createRegle(S,Arrays.asList(a));
        createRegle(S,Arrays.asList(b));
        createRegle(S,Arrays.asList(c,T,d));
        createRegle(T,Arrays.asList(S,U));
        createRegle(T,Arrays.asList(e,S,U));
        createRegle(U,Arrays.asList());
    }  

    public String getNonTerminal(int idRegle) {
        switch (this.parser.table.getRegle(idRegle).getMembreGauche().getId()) {
            case 0:
                return "S";     
            case 1:
                return "T";  
            case 2:
                return "U";     
            default:
                return "Unknown Terminal";
        }
    }

    public String getTerminal(int tag) {
        switch (tag) {
            case Tag.AND:
                return "a";     
            case Tag.BEGIN:
                return "b";  
            case (int)'(':
                return "(";  
            case (int)')':
                return ")";     
            case (int)';':
                return ";";  
            case (int)'$':
                return "$";     
            default:
                return "Unknown NonTerminal";
        }
    }

    public Component fonctionSemantique(int regle, AbstractExpression abstractExpression){
        return new Leaf("coucou");
    }
    
}
