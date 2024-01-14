package compilateur.parser;

import compilateur.lexer.*;

public class Terminal extends Symbole{

    private Token value;

    public Terminal(Token value){
        this.value=value;
    }

    public Token getValue(){
        return(this.value);
    }

}