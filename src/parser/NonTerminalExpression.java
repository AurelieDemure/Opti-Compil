package parser;

import java.util.List;

public class NonTerminalExpression implements AbstractExpression {
    NonTerminal nonTerminal;
    List<Symbole> children;
    @Override
    public void add(Symbole S) {
        this.children.add(S);
    }

    @Override
    public void remove(Symbole S) {
        this.children.remove(S);
    }

    @Override
    public Symbole getChild(int numChild) {
        return this.children.get(numChild);
    }
}
