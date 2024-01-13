package parse_tree;

import parser.*;

import java.util.ArrayList;
import java.util.List;

import abstractTree.*;
public class ArbreSyntaxique {
    private Noeud racine;

    public void setRacine(Noeud racine){
        this.racine=racine;
    }

    public Noeud getRacine() {
        return this.racine;
    }

    public void showAsAbstractTree(Noeud noeud, String indentation, boolean dernier) {
        System.out.print(indentation);
        if (dernier) {
            System.out.print("|__ ");
        } else {
            System.out.print("|__ ");
        } noeud.show();


        if (noeud instanceof NoeudNonTerminal) {
            List<Noeud> children = ((NoeudNonTerminal) noeud).getListFils();
            if (children.size() > 0) {
                System.out.println();
            }
            for (int i=0; i<children.size(); i++) {
                String indentationBis = indentation + (dernier? "    " : "|    ");
                showAsAbstractTree(children.get(i), indentationBis, i == (children.size()-1));
            }
        } else {
            System.out.println();
        }
    }
}
