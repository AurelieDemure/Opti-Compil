package compilateur.parser;

import java.io.*;
import java.util.*;
import compilateur.lexer.*;
import compilateur.parse_tree.*;

public class Parser {
    public GrammaireLL1Test grammar;
    public Stack<Symbole> Pile=new Stack<Symbole>();
    private int[] tableTag; 
    public TableAnalyse table;
    Lexer lexer=new Lexer();
    private Terminal lastTerminal;

    public Parser(GrammaireLL1Test grammar, int[] tableTag, int[][] tab){
        this.grammar = grammar;
        this.table=new TableAnalyse(tab, grammar);
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
        Stack<AbstractExpression> pileNoeuds = new Stack<>();   //pile pour gérer les noeuds de l'arbre
        Stack<AbstractExpression> pileNoeudsTmp = new Stack<>(); 
        ArbreSyntaxique arbreSyntaxique = new ArbreSyntaxique();

        NonTerminal axiome=table.getAxiome();
        Token d=new Token((int) '$');
        Terminal dollar=new Terminal(d, this.grammar);
        this.Pile.push(dollar);
        this.Pile.push(axiome);
        //NonTerminalExpression racine = new NonTerminalExpression(0, this.grammar.getNonTerminal(0));
        NonTerminalExpression racine = new NonTerminalExpression(0, "0", this.grammar);
        pileNoeuds.push(new TerminalExpression("$"));
        pileNoeuds.push(racine);
        int statut=-1;
        Terminal a=new Terminal(lexer.scan(), this.grammar);
        this.lastTerminal = a;
        while (statut==-1) {
            //System.out.println("##### New Etape #####");
            Token token = a.getToken();
            if(token.tag!=0){
                if(token instanceof Mots){
                    //System.out.println("Its value : "+((Mots)token).lexeme);
                }
                else if(token.tag<256){
                    //System.out.println("Its value : "+(char)token.tag);
                }
            }

            Symbole X=Pile.pop();
            AbstractExpression noeudActuel = pileNoeuds.pop();
            AbstractExpression noeudFils = null;
            if (X instanceof NonTerminal) {
                RegleGrammaire regle=table.RenvoieSortiePile(((NonTerminal)X).getId(),getId((a.getToken()).tag));
                if (regle.getMembreDroit().isEmpty() || regle.getMembreDroit().get(0) instanceof NonTerminal || ((Terminal)regle.getMembreDroit().get(0)).getTag()!=-1){
                    ((NonTerminalExpression) noeudActuel).setId(regle.getNumero());
                    ((NonTerminalExpression) noeudActuel).setValeur(this.grammar.getNonTerminalValue(regle.getNumero()));
                    for (int i=0; i<regle.getMembreDroit().size(); i++){
                        if(regle.getMembreDroit().get(i) instanceof Terminal){
                            noeudFils = new TerminalExpression(this.grammar.getTerminalValue((Terminal)regle.getMembreDroit().get(i)));
                        }
                        else{
                            noeudFils = new NonTerminalExpression(-1, "", this.grammar);
                        }
                        ((NonTerminalExpression) noeudActuel).ajouterFils(noeudFils);
                        pileNoeudsTmp.push(noeudFils);
                    }
                    for (int i=regle.getMembreDroit().size()-1;i>=0;i--){
                        Pile.push(regle.getMembreDroit().get(i));
                        pileNoeuds.push(pileNoeudsTmp.pop());
                    }
                }
                else {
                    statut=1;
                    this.lexer.saveNewError("Le programme n'est pas reconnu par la grammaire, le token '" + this.grammar.getTerminalValue(a) + "' ne donne aucune règle dans ce contexte");
                }
            }
            else {
                ((TerminalExpression)noeudActuel).setValeur(this.grammar.getTerminalValue(a));
                if (((Terminal)X).getTag()==((int)'$')){
                    if ((((Terminal)X).getTag())==(a.getTag())){
                        statut=0;
                    }
                    else{
                        //System.out.println("Le terminal n'est pas $");
                        statut=1;
                        this.lexer.saveNewError("Le programme est sensé s'arrêter avant le token '" + this.lastTerminal.getValue() + "'");
                    }
                }
                else{
                    if ((((Terminal)X).getTag())==(a.getTag())){
                        a=new Terminal(lexer.scan(), this.grammar);
                        this.lastTerminal = a;
                    }
                    else {
                        //System.out.println("Le terminal n'est pas le même");
                        statut=1;
                        this.lexer.saveNewError("Le tag '" + this.grammar.getTerminalValue((Terminal)X) + "' est attendu, le tag '" + this.grammar.getTerminalValue(a) + "' à été trouvée");
                    }
                }
            }  
        }
        arbreSyntaxique.setRacine(racine);
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
