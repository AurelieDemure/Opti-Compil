package parser;

public class NonTerminal extends Symbole{

    private static int nextId = -1;
    private int id;

    public NonTerminal(){
        this.id=this.nextId;
        this.nextId++;
    }

    public int getId(){
        return(this.id);
    }

}