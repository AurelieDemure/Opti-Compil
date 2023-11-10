package parser;

import java.util.List;

public class TableAnalyse {
    public final List<RegleGrammaire> regles;
    public final int[][] table={
        {,},
        {,},
    };
    /*première ligne correspond aux terminaux (numéros d'id), première colonne aux non-terminaux (numéros d'id) */
    public int TrouveRegle(NonTerminal sommetPile, Terminal teteLecture){
        int i=1;
        int j=1;
        while (this.table[1][j]!=sommetPile.value) {
            j++;
        }
        while (this.table[i][1]!=teteLecture.value) {
            i++;
        }
        return this.table[i][j];
    }
    public RegleGrammaire getRegle(int num){
        for (int i=0;i<this.regles.size();i++){
            if (this.regles.get(i).Numero==num){
                return this.regles.get(i);
            }
        }
        return this.regles.get(-1);
    }
    public List<Symbole> RenvoieSortiePile(NonTerminal sommetPile, Terminal teteLecture) {
        int numRegle=TrouveRegle(sommetPile,teteLecture);
        RegleGrammaire r=getRegle(numRegle);
        return r.MembreDroit;
    }



}
