package parser;

public class NonTerminal extends Symbole{

    private static int nextId = -1;
    private int id;

    public NonTerminal(){
        System.out.println(NonTerminal.nextId);
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