package tests;

import abstractTree.Leaf;
import abstractTree.Node;
import abstractTree.AbstractTree;

import static abstractTree.AbstractTree.showAsAbstractTree;

public class TestAbstractTree {
    public static void main(String[] args) {
        Node racine = new Node("Racine");
        Node noeud1 = new Node("Noeud 1");
        Node noeud2 = new Node("Noeud 2");
        Node noeud3 = new Node("Noeud 3");
        Leaf feuille1 = new Leaf("Feuille 1");
        Leaf feuille2 = new Leaf("Feuille 2");
        Leaf feuille3 = new Leaf("Feuille 3");
        Leaf feuile4 = new Leaf("Feuille 4");

        racine.addChild(noeud1);
        racine.addChild(feuille1);
        noeud1.addChild(noeud2);
        noeud2.addChild(feuille2);
        noeud2.addChild(feuille3);
        noeud2.addChild(noeud3);
        noeud3.addChild(feuile4);

        showAsAbstractTree(racine,"",true);
    }
}
