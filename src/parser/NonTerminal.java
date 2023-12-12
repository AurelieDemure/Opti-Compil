package parser;

import java.util.List;

public class NonTerminal implements Symbole{

    private static int nextId = -1;
    private int id;

    public NonTerminal(){
        this.id=NonTerminal.nextId;
        NonTerminal.nextId++;
    }

    public int getId(){
        return(this.id);
    }

    public static int getNextId(){
        return NonTerminal.nextId;
    }

    

    

}