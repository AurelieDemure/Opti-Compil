package parser;

public class Symbole{
    
    private int id;
    public final static int TERMINAL=1;
    public final static int NTERMINAL=0;

    public Symbole(int id){
        this.id=id;
    }

    public int getId(){
        return(this.id);
    }

}