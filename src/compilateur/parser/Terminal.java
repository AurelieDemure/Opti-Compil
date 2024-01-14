package compilateur.parser;

import compilateur.lexer.*;

public class Terminal extends Symbole{

    private Token token;
    private Grammaire grammar;

    public Terminal(Token token, Grammaire grammar){
        this.token=token;
        this.grammar = grammar;
    }

    public Token getToken(){
        return(this.token);
    }

    public int getTag() {
        return this.token.tag;
    }

    public String getValue() {
        if (this.token instanceof Mots) {
            return ((Mots)this.token).lexeme;
        } else {
            return this.grammar.getTerminal(this.getTag());
        }
    }
}