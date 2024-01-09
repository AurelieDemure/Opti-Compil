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
                this.pile.add(noeud.getFils(0).interpret());//pour empiler
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

            case 61:
                node=new Node("Soustraction");
                node.addChild(pile.remove());
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                //ajout du deuxième fils
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 62:
                return pile.remove();

            case 63:
                this.pile.add(noeud.getFils(0).interpret());//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 64:
                //Création du noeud
                node = new Node("Multiplication");
                //ajout du premier fils (dépile)
                node.addChild(pile.remove());
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                //ajout du deuxième fils
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 65:
                //Création du noeud
                node = new Node("Quotient division");
                //ajout du premier fils (dépile)
                node.addChild(pile.remove());
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                //ajout du deuxième fils
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 66:
                //Création du noeud
                node = new Node("Reste division");
                //ajout du premier fils (dépile)
                node.addChild(pile.remove());
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                //ajout du deuxième fils
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 67:
                return pile.remove();

            case 68:
                return noeud.getFils(0).interpret();

            case 69:
                return noeud.getFils(0).interpret();

            case 70:
                node=new Node("Opposé");
                node.addChild(noeud.getFils(0).interpret());
                return node;

            case 71:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 72:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 73:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 74:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 75:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 76:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 77:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 78:
                node=new Node("new");
                node.addChild(noeud.getFils(0));
                this.pile.add(node);
                return noeud.getFils(1).interpret();

            case 79:
                node=new Node("val");
                node.addChild(noeud.getFils(0));
                node.addChild(noeud.getFils(1).interpret());
                this.pile.add(node);
                return noeud.getFils(2).interpret();

            case 80:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 81:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 82:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 83:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 84:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 85:
                this.pile.add(noeud.getFils(0).interpret());//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 86:
                node=new Node("new");
                node.addChild(noeud.getFils(0));
                this.pile.add(node);
                return noeud.getFils(1).interpret();

            case 87:
                node=new Node("val");
                node.addChild(noeud.getFils(0));
                node.addChild(noeud.getFils(1).interpret());
                this.pile.add(node);
                return noeud.getFils(2).interpret();

            case 88:
                return noeud.getFils(0).interpret();

            case 89:
                node=new Node("Appel methode");
                node.addChild(this.pile.remove());
                Node nodeFilsDroit=new Node("param");
                nodeFilsDroit.addChild(noeud.getFils(0).interpret());
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                node.addChild((nodeFilsDroit));
                this.pile.add(node);
                return noeud.getFils(2).interpret();
                
            case 90:
                node=new Node("acces");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                this.pile.add(noeud.getFils(0));
                return node;

            case 91:
                return this.pile.remove();

            case 92:
                node=new Node("acces");
                node.addChild(this.pile.remove());
                node.addChild((noeud.getFils(1).interpret()));
                this.pile.add(noeud.getFils(0));
                return node; 

            case 93:
                return null;

            case 94:
                //a voir

            case 95:
                this.pile.add(noeud.getFils(0));
                return noeud.getFils(1).interpret();

            case 96:
                node=new Node("Affectation");
                Node nodeFilsGauche=new Node("Terme gauche");
                nodeFilsDroit=new Node("Terme droit");
                nodeFilsGauche.addChild(noeud.getFils(0).interpret());
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFilsGauche);
                node.addChild(nodeFilsDroit);
                return node;

            case 97:
                node=new Node("Return");
                node.addChild(noeud.getFils(0).interpret());
                return node;

            case 98:
                node=new Node("Block");
                node.addChild(noeud.getFils(0).interpret());
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 99:
                node=new Node("If");
                Node nodeFils1=new Node("Cond");
                nodeFils1.add(noeud.getFils(0).interpret());
                node.addChild(nodeFils1);
                Node nodeFils2=new Node("Block");
                nodeFils2.addChild(noeud.getFils(1).interpret());
                nodeFils2.addChild(noeud.getFils(2).interpret());
                node.addChild(nodeFils2);
                node.addChild(noeud.getFils(3).interpret());
                node.addChild(noeud.getFils(4).interpret());
                return node;   

            case 100:
            //a verifier avec pierre
                node=new Node("For");
                nodeFils1=new Node("Variable");
                nodeFils1.addChild(noeud.getFils(0));
                node.addChild(nodeFils1);
                nodeFils2=new Node("Intervalle");
                Node nodeFilsFils=new Node("reverse?");
                nodeFilsFils.addChild(noeud.getFils(1).interpret());
                nodeFilsFils.addChild(noeud.getFils(2).interpret());
                nodeFils2.addChild(nodeFilsFils);
                node.addChild(nodeFils2);
                Node nodeFils3=new Node("Block");
                nodeFils3.addChild(noeud.getFils(3).interpret());
                nodeFils3.addChild(noeud.getFils(4).interpret());
                node.addChild(nodeFils3);
                return node;

            case 101:
                node=new Node("While");
                nodeFilsGauche=new Node("Cond");
                nodeFilsGauche.addChild(noeud.getFils(0).interpret());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Block");
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                nodeFilsDroit.addChild(noeud.getFils(2).interpret());
                node.addChild(nodeFilsDroit);
                return node;

            case 102:
                node=new Node("Affectation");
                nodeFilsGauche=new Node("Terme gauche");
                nodeFilsGauche.addChild(this.pile.remove());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Terme droit");
                nodeFilsDroit.addChild(noeud.getFils(0).interpret());
                node.addChild(nodeFilsDroit);
                return node;

            case 103:
                return this.pile.remove();

            case 104:
                node=new Node("Appel methode");
                node.addChild(this.pile.remove());
                nodeFilsDroit=new Node("Param");
                nodeFilsDroit.addChild(noeud.getFils(0).interpret());
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFilsDroit);
                this.pile.add(node);
                return noeud.getFils(2).interpret();

            case 105:
                node=new Node("Affectation");
                nodeFilsGauche=new Node("Terme gauche");
                nodeFilsGauche.addChild(noeud.getFils(0).interpret());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Terme droit");
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFilsDroit);
                return node;
                
            case 106:
                return this.pile.remove();

            case 107:
                node=new Node("Affectation");
                nodeFilsGauche=new Node("Terme gauche");
                nodeFilsGauche.addChild(noeud.getFils(0).interpret());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Terme droit");
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFilsDroit);
                return node;

            case 108:
                return null;

            case 109:
                return noeud.getFils(0).interpret();

            case 110:
                return null;

            case 111:
                node=new Node("Elsif");
                nodeFils1=new Node("Cond");
                nodeFils1.addChild(noeud.getFils(0).interpret());
                node.addChild(nodeFils1);
                nodeFils2=new Node("Block");
                nodeFils2.addChild(noeud.getFils(1).interpret());
                nodeFils2.addChild(noeud.getFils(2).interpret());
                node.addChild(nodeFils2);
                node.addChild(noeud.getFils(3).interpret());
                return node;

            case 112:
                return null;

            case 113:
                node=new Node("Else");
                node.addChild(noeud.getFils(0).interpret());
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 114:
                return null;

            case 115:
                return noeud.getFils(0);

            default:
                return null;
            
        }
    }
}
