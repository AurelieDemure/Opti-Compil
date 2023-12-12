package parser;

public interface AbstractExpression {
    public void add(Symbole S);
    public void remove(Symbole S);
    public Symbole getChild(int numChild);
}
