package compilateur.parse_tree;

import compilateur.abstractTree.*;

public interface AbstractExpression {
    public Component interpret();
    void show();
    public abstract void setValeur(String valeur);
    public abstract String getValeur();
}
