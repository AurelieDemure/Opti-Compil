package parse_tree;

import java.io.IOException;
import java.util.*;
import lexer.*;

public class ParserTree {
    public Stack<Symbole> Pile=new Stack<Symbole>();
    private int[] tableTag; 
    public TableAnalyse table;

    public ParserTree(int[] tableTag, int[][] tab){
        this.table=new TableAnalyse(tab);
        this.tableTag = tableTag;
    }

    public int getId(int tag){
        for(int i=0; i<tableTag.length; i++){
            if(tableTag[i]==tag){
                return(i);
            }
        }
        return(-1);
    }

    public ArbreSyntaxique Analyseur() throws IOException{
        Stack<Noeud> pileNoeuds = new Stack<>();   //pile pour gérer les noeuds de l'arbre
        ArbreSyntaxique arbreSyntaxique = new ArbreSyntaxique();

        NonTerminal axiome=table.getAxiome();
        Token d=new Token((int) '$');
        Terminal dollar=new Terminal(d);
        this.Pile.push(dollar);
        this.Pile.push(axiome);
        pileNoeuds.push(new NoeudNonTerminal("axiome"));

        Lexer lexer=new Lexer();
        int statut=-1;
        Terminal a=new Terminal(lexer.scan());
        while (statut==-1) {
            //System.out.println("##### New Etape #####");
            Token token = a.getValue();
            if(token.tag!=0){
                if(token instanceof Mots){
                    //System.out.println("Its value : "+((Mots)token).lexeme);
                }
                else if(token.tag<256){
                    //System.out.println("Its value : "+(char)token.tag);
                }
            }

            Symbole X=Pile.peek();
            Noeud noeudActuel = pilNoeuds.peek();
            if (X instanceof NonTerminal) {
                List<Symbole> mDroit=table.RenvoieSortiePile(((NonTerminal)X).getId(),getId((a.getValue()).tag));
                if (mDroit.isEmpty() || mDroit.get(0) instanceof NonTerminal || ((Terminal)mDroit.get(0)).getValue().tag!=-1){
                    Pile.pop();
                    pileNoeuds.pop();   // on synchronise la pile avec celle des symboles
                    for (int i=mDroit.size()-1;i>=0;i--){
                        Pile.push(mDroit.get(i));

                        if(mDroit.get(i) instanceof Terminal){
                            Noeud noeudFils = new NoeudTerminal(mDroit.get(i).toString());
                        }
                        else{
                            Noeud noeudFils = new NoeudNonTerminal("La fonction sémantique"); //dépend de fonction sémantique à voir !
                        }
                        noeudActuel.ajouterFils(noeudFils);
                        pileNoeuds.push(noeudFils); //correspond au Pile.push(mDroit.get(i));
                    }
                }
                else {
                    statut=1;
                }
            }
            else {
                if (((Terminal)X).getValue().tag==((int)'$')){
                    if ((((Terminal)X).getValue().tag)==(a.getValue().tag)){
                        statut=0;
                    }
                    else{
                        //System.out.println("Le terminal n'est pas $");
                        statut=1;
                    }
                }
                else{
                    if ((((Terminal)X).getValue().tag)==(a.getValue().tag)){
                        Pile.pop();
                        a=new Terminal(lexer.scan());
                    }
                    else {
                        //System.out.println("Le terminal n'est pas le même");
                        statut=1;
                    }
                }
            }  
        }
        if(!pileNoeuds.isEmpty()){
            arbreSyntaxique.setRacine(pileNoeuds.pop());
        }
        return arbreSyntaxique;
        System.err.println("Arbre créé !");
    }
}
