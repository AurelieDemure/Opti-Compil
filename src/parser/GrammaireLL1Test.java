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
            case 0:
                Node node=new Node("Entete");
                node.addChild(noeud.getFils(7));
                node.addChild(noeud.getFils(9).interpret());
                Node nodeFils1=new Node("block");
                nodeFils1.addChild(noeud.getFils(11).interpret());
                nodeFils1.addChild(noeud.getFils(12).interpret());
                node.addChild(nodeFils1);
                node.addChild(noeud.getFils(14).interpret());
                return node;

            case 1:
                return null;
                
            case 2:
                node=new Node("Declaration");
                node.addChild(noeud.getFils(0).interpret());
                node.addChild(noeud.getFils(1).interpret());
                return node;
                
            case 3:
                return null;

            case 4:
                node=new Node("Instanciation");
                node.addChild(noeud.getFils(0).interpret());
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 5:
                return null;

            case 6:
                this.pile.add(noeud.getFils(0).interpret());
                return null;

            case 7:
                this.pile.add(noeud.getFils(1));
                return noeud.getFils(2).interpret();
                
            case 8:
                node=new Node("Declaration");
                node.addChild(noeud.getFils(0));
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(3).interpret());
                node.addChild(noeud.getFils(4).interpret());
                return node;
                
            case 9:
                node=new Node("Procedure");
                node.addChild(noeud.getFils(1));
                node.addChild(noeud.getFils(2).interpret());
                node.addChild(noeud.getFils(4).interpret());
                nodeFils1=new Node("Block");
                nodeFils1.addChild(noeud.getFils(6).interpret());
                nodeFils1.addChild(noeud.getFils(7).interpret());
                node.addChild(nodeFils1);
                node.addChild(noeud.getFils(9).interpret());
                return node;

            case 10:
                node=new Node("Fonction");
                node.addChild(noeud.getFils(1));
                node.addChild(noeud.getFils(2).interpret());
                node.addChild(noeud.getFils(4).interpret());
                node.addChild(noeud.getFils(6).interpret());
                nodeFils1=new Node("Block");
                nodeFils1.addChild(noeud.getFils(8).interpret());
                nodeFils1.addChild(noeud.getFils(9).interpret());
                node.addChild(nodeFils1);
                node.addChild(noeud.getFils(11).interpret());
                return node;

            case 11:
                return this.pile.remove();

            case 12:
                return noeud.getFils(1).interpret();
                
            case 13:
                this.pile.add(noeud.getFils(1));
                return this.pile.remove();
                
            case 14:
                node=new Node("Record");
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;
                
            case 15:
                return this.pile.remove();
                
            case 16:
                node=new Node("Champ");
                node.addChild(noeud.getFils(0).interpret());
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 17:
                node=new Node("Suite d'ident");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(2).interpret());
                this.pile.add(noeud.getFils(1));
                return node;

            case 18:
                return null;
                
            case 19:
                return this.pile.remove();
                
            case 20:
                node=new Node("Expression");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                return node;
                
            case 21:
                return noeud.getFils(0).interpret();

            case 22:
                return null;
                
            case 23:
                node=new Node("Champ");
                node.addChild(noeud.getFils(0));
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(3).interpret());
                return node;
                
            case 24:
                this.pile.add(noeud.getFils(0));
                return this.pile.remove();
                
            case 25:
                this.pile.add(noeud.getFils(1));
                return this.pile.remove();

            case 26:
                node=new Node("Parametres");
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 27:
                return this.pile.remove();
                
            case 28:
                //a voir

            case 29:
                node=new Node("parametres");
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(3).interpret());
                node.addChild(noeud.getFils(4).interpret());
                this.pile.add(noeud.getFils(0));
                return node;
                
            case 30:
                return null;

            case 31:
                return noeud.getFils(0).interpret();

            case 32:
                return noeud.getFils(1).interpret();
                
            case 33:
                return null;

            case 34:
                return null;

            case 35:
                return noeud.getFils(0).interpret();

            case 36:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();

            case 37:
                node=new Node("Ou");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 38:
                return this.pile.remove();
                
            case 39:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();

            case 40:
                //a voir
                this.pile.add(noeud.getFils(1).interpret());
                return noeud.getFils(2).interpret();

            case 41:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();

            case 42:
                node=new Node("And");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 43:
                return this.pile.remove();
                
            case 44:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();
    
            case 45:
                //a voir
                this.pile.add(noeud.getFils(1).interpret());
                return noeud.getFils(2).interpret();

            case 46:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();

            case 47:
                node=new Node("Negation");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 48:
                return this.pile.remove();
                
            case 49:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();
   
            case 50:
                node=new Node("Egalite");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 51:
                node=new Node("Inegalite");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 52:
                return this.pile.remove();

            case 53:
                //a voir
                this.pile.add(noeud.getFils(0).interpret());
                return noeud.getFils(1).interpret();

            case 54:
                node=new Node("Sup");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 55:
                node=new Node("SupEgal");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 56:
                node=new Node("Inf");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 57:
                node=new Node("InfEgal");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 58:
                return this.pile.remove();


            case 59:
                this.pile.add(noeud.getFils(0).interpret());//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 60:
                //Création du noeud
                node = new Node("Somme");
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
                node.addChild(noeud.getFils(1).interpret());
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
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                return noeud.getFils(3).interpret();//on interprete la suite

            case 77:
                this.pile.add(noeud.getFils(0));//pour empiler
                return noeud.getFils(1).interpret();//on interprete la suite

            case 78:
                node=new Node("new");
                node.addChild(noeud.getFils(1));
                this.pile.add(node);
                return noeud.getFils(2).interpret();

            case 79:
                node=new Node("val");
                node.addChild(noeud.getFils(2).interpret());
                this.pile.add(node);
                return noeud.getFils(4).interpret();

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
                this.pile.add(noeud.getFils(1).interpret());//pour empiler
                return noeud.getFils(3).interpret();//on interprete la suite

            case 86:
                node=new Node("new");
                node.addChild(noeud.getFils(1));
                this.pile.add(node);
                return noeud.getFils(2).interpret();

            case 87:
                node=new Node("val");
                node.addChild(noeud.getFils(2).interpret());
                this.pile.add(node);
                return noeud.getFils(4).interpret();

            case 88:
                return noeud.getFils(0).interpret();

            case 89:
                node=new Node("Appel methode");
                node.addChild(this.pile.remove());
                Node nodeFilsDroit=new Node("param");
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                nodeFilsDroit.addChild(noeud.getFils(2).interpret());
                node.addChild((nodeFilsDroit));
                this.pile.add(node);
                return noeud.getFils(4).interpret();
                
            case 90:
                node=new Node("acces");
                node.addChild(this.pile.remove());
                node.addChild(noeud.getFils(2).interpret());
                this.pile.add(noeud.getFils(1));
                return node;

            case 91:
                return this.pile.remove();

            case 92:
                node=new Node("acces");
                node.addChild(this.pile.remove());
                node.addChild((noeud.getFils(2).interpret()));
                this.pile.add(noeud.getFils(1));
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
                nodeFilsDroit.addChild(noeud.getFils(2).interpret());
                node.addChild(nodeFilsGauche);
                node.addChild(nodeFilsDroit);
                return node;

            case 97:
                node=new Node("Return");
                node.addChild(noeud.getFils(1).interpret());
                return node;

            case 98:
                node=new Node("Block");
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
                return node;

            case 99:
                node=new Node("If");
                Node nodeFils1=new Node("Cond");
                nodeFils1.add(noeud.getFils(1).interpret());
                node.addChild(nodeFils1);
                Node nodeFils2=new Node("Block");
                nodeFils2.addChild(noeud.getFils(3).interpret());
                nodeFils2.addChild(noeud.getFils(4).interpret());
                node.addChild(nodeFils2);
                node.addChild(noeud.getFils(5).interpret());
                node.addChild(noeud.getFils(6).interpret());
                return node;   

            case 100:
            //a verifier avec pierre
                node=new Node("For");
                nodeFils1=new Node("Variable");
                nodeFils1.addChild(noeud.getFils(1));
                node.addChild(nodeFils1);
                nodeFils2=new Node("Intervalle");
                Node nodeFilsFils=new Node(noeud.getFils(3).interpret());
                nodeFilsFils.addChild(noeud.getFils(4).interpret());
                nodeFilsFils.addChild(noeud.getFils(7).interpret());
                nodeFils2.addChild(nodeFilsFils);
                node.addChild(nodeFils2);
                Node nodeFils3=new Node("Block");
                nodeFils3.addChild(noeud.getFils(9).interpret());
                nodeFils3.addChild(noeud.getFils(10).interpret());
                node.addChild(nodeFils3);
                return node;

            case 101:
                node=new Node("While");
                nodeFilsGauche=new Node("Cond");
                nodeFilsGauche.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Block");
                nodeFilsDroit.addChild(noeud.getFils(3).interpret());
                nodeFilsDroit.addChild(noeud.getFils(4).interpret());
                node.addChild(nodeFilsDroit);
                return node;

            case 102:
                node=new Node("Affectation");
                nodeFilsGauche=new Node("Terme gauche");
                nodeFilsGauche.addChild(this.pile.remove());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Terme droit");
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFilsDroit);
                return node;

            case 103:
                return this.pile.remove();

            case 104:
                node=new Node("Appel methode");
                node.addChild(this.pile.remove());
                nodeFilsDroit=new Node("Param");
                nodeFilsDroit.addChild(noeud.getFils(1).interpret());
                nodeFilsDroit.addChild(noeud.getFils(2).interpret());
                node.addChild(nodeFilsDroit);
                this.pile.add(node);
                return noeud.getFils(2).interpret();

            case 105:
                node=new Node("Affectation");
                nodeFilsGauche=new Node("Terme gauche");
                nodeFilsGauche.addChild(noeud.getFils(0).interpret());
                node.addChild(nodeFilsGauche);
                nodeFilsDroit=new Node("Terme droit");
                nodeFilsDroit.addChild(noeud.getFils(2).interpret());
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
                nodeFilsDroit.addChild(noeud.getFils(2).interpret());
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
                nodeFils1.addChild(noeud.getFils(1).interpret());
                node.addChild(nodeFils1);
                nodeFils2=new Node("Block");
                nodeFils2.addChild(noeud.getFils(3).interpret());
                nodeFils2.addChild(noeud.getFils(4).interpret());
                node.addChild(nodeFils2);
                node.addChild(noeud.getFils(5).interpret());
                return node;

            case 112:
                return null;

            case 113:
                node=new Node("Else");
                node.addChild(noeud.getFils(1).interpret());
                node.addChild(noeud.getFils(2).interpret());
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
