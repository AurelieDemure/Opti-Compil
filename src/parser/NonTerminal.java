package parser;

public class NonTerminal extends Symbole{

    private int value;

    public NonTerminal(int value){
        super(Symbole.TERMINAL);
        this.value=value;
    }

    public int getValue(){
        return(this.value);
    }

}