package compilateur.parse_tree;

import java.util.*;

public class ArbreSyntaxique {
    private AbstractExpression racine;

    public void setRacine(AbstractExpression racine){
        this.racine=racine;
    }

    public AbstractExpression getRacine() {
        return this.racine;
    }

    public void showAsAbstractTree(AbstractExpression abstractExpression, String indentation, boolean dernier) {
        System.out.print(indentation);
        if (dernier) {
            System.out.print("|__ ");
        } else {
            System.out.print("|__ ");
        } abstractExpression.show();


        if (abstractExpression instanceof NonTerminalExpression) {
            List<AbstractExpression> children = ((NonTerminalExpression) abstractExpression).getListFils();
            System.out.println();
            for (int i=0; i<children.size(); i++) {
                String indentationBis = indentation + (dernier? "    " : "|    ");
                showAsAbstractTree(children.get(i), indentationBis, i == (children.size()-1));
            }
        } else {
            System.out.println();
        }
    }
}
