package compilateur.parse_tree;

import compilateur.abstractTree.*;

public class TerminalExpression implements AbstractExpression {
    private String valeur;

    public TerminalExpression (String valeur){
        this.valeur=valeur;
    }

    @Override
    public void show() {
        System.out.print(valeur);
    }

    @Override
    public Component interpret(){
        return new Leaf(this.valeur);
    }

    public String getValeur(){
        return this.valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

}
