package parser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import lexer.*;
import abstractTree.*;

public class GrammaireLL1Test extends Grammaire{

    private Deque<Component> pile = new ArrayDeque<Component>();
    
    public GrammaireLL1Test(int[] tableTag, int[][] table) {
        super(tableTag, table);
    }
    //La classe Noeud est pas définie car nicolas a encore des trucs a faire, mais hesite pas à aller voir sur la branche parser_tree et notamment la classe Noeud pour les fonctions à utiliser
    public Component fonctionSemantique(int regle, Noeud noeud){
        switch(regle){
            case 59:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 60:
                //Création du noeud
                Node node = new Node("Somme");
                //ajout du premier fils (dépile)
                node.addChild(pile.remove());
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                //ajout du deuxième fils
                node.addChild(noeud.getFils(2).interpret());
                return node;
            default:
                return null;
        }
    }
}
