package parser;

import lexer.*;

public class Terminal implements Symbole{

    private Token value;

    public Terminal(Token value){
        this.value=value;
    }

    public Token getValue(){
        return(this.value);
    }

}