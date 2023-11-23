package parser;

import java.util.*;

import lexer.*;

public class TableAnalyse {
    private final List<RegleGrammaire> regles=new ArrayList<RegleGrammaire>();
    private final int[][] table={
        {,},
        {,},
    };
    public TableAnalyse(){
        Mots erreur=new Mots(Tag.ERREUR,"Le programme n'est pas reconnu par la grammaire");
        Terminal symbMembreDroit=new Terminal(erreur);
        List<Symbole> membreDroit=Arrays.asList(symbMembreDroit);
        RegleGrammaire regleErreur=new RegleGrammaire(new NonTerminal(),membreDroit);
        this.regles.add(regleErreur);
    }
    public List<RegleGrammaire> getRegles(){
        return this.regles;
    }
    public int[][] getTable(){
        return this.table;
    }
    /*première ligne correspond aux terminaux (numéros d'id), première colonne aux non-terminaux (numéros d'id) */
    public int TrouveNumRegle(NonTerminal sommetPile, Terminal teteLecture){
        int i=1;
        int j=1;
        while (this.table[1][j]!=sommetPile.getValue()) {
            j++;
        }
        while (this.table[i][1]!=(teteLecture.getValue()).tag) {
            i++;
        }
        return this.table[i][j];
    }
    public RegleGrammaire getRegle(int num){
        for (int i=0;i<this.regles.size();i++){
            if (this.regles.get(i).getNumero()==num){
                return this.regles.get(i);
            }
        }
        return this.regles.get(0);
    }
    
    public NonTerminal getAxiome(){
        return getRegle(0).getMembreGauche();
    }
    public List<Symbole> RenvoieSortiePile(NonTerminal sommetPile, Terminal teteLecture) {
        int numRegle=TrouveNumRegle(sommetPile,teteLecture);
        RegleGrammaire r=getRegle(numRegle);
        return r.getMembreDroit();
    }



}
