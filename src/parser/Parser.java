package parser;

import java.io.IOException;
import java.util.*;
import lexer.*;
import parser.NonTerminal;
import parser.Symbole;
import parser.TableAnalyse;
import parser.Terminal;

public class Parser {
    public Stack<Symbole> Pile=new Stack<Symbole>();
    private int[] tableTag; 
    public TableAnalyse table;
    Lexer lexer=new Lexer();

    public Parser(int[] tableTag, int[][] tab){
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
        pileNoeuds.push(new NoeudNonTerminal(1));
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
            Noeud noeudActuel = pileNoeuds.peek();
            Noeud noeudFils = null;
            if (X instanceof NonTerminal) {
                List<Symbole> mDroit=table.RenvoieSortiePile(((NonTerminal)X).getId(),getId((a.getValue()).tag));
                if (mDroit.isEmpty() || mDroit.get(0) instanceof NonTerminal || ((Terminal)mDroit.get(0)).getValue().tag!=-1){
                    Pile.pop();
                    pileNoeuds.pop();   // on synchronise la pile avec celle des symboles
                    for (int i=mDroit.size()-1;i>=0;i--){
                        Pile.push(mDroit.get(i));

                        if(mDroit.get(i) instanceof Terminal){
                            noeudFils = new NoeudTerminal(mDroit.get(i).toString());
                            System.out.println(noeudFils.getValeur());
                        }
                        else{
                            noeudFils = new NoeudNonTerminal(1); //dépend de fonction sémantique à voir !
                            System.out.println(noeudFils.getFonctionSemantique());
                        }
                        noeudActuel.ajouterFils(noeudFils);
                        pileNoeuds.push(noeudFils); //correspond au Pile.push(mDroit.get(i));
                    }
                }
                else {
                    statut=1;
                    this.lexer.saveNewError("Le programme n'est pas reconnue par la grammaire, le token précédent ne donne aucune règle dans ce contexte");
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
                        this.lexer.saveNewError("Le programme est sensé s'arrêter ici");
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
                        this.lexer.saveNewError("Le tag " + ((Terminal)X).getValue().tag + " est attendu, le tag " + a.getValue().tag + " à été trouvée");
                    }
                }
            }  
        }
        if(!pileNoeuds.isEmpty()){
            arbreSyntaxique.setRacine(pileNoeuds.pop());
        }
        exitParser();
        return arbreSyntaxique;
        
    }

    public void exitParser() throws IOException {
        int c = 0;
        while (this.lexer.scan().tag != (int)'$' && c<1000){
            c++;
        }
    }

}
