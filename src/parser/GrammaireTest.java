package parser;

import java.io.IOException;
import java.util.Arrays;

import lexer.*;

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

    
    
}
