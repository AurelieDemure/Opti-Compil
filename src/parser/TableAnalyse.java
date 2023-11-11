package parser;

import java.util.ArrayList;
import java.util.List;

public class TableAnalyse {
    public final List<RegleGrammaire> regles=new ArrayList<RegleGrammaire>();
    public final int[][] table={
        {,},
        {,},
    };
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
            if (this.regles.get(i).Numero==num){
                return this.regles.get(i);
            }
        }
        return this.regles.get(-1);
    }
    public List<Symbole> RenvoieSortiePile(NonTerminal sommetPile, Terminal teteLecture) {
        int numRegle=TrouveNumRegle(sommetPile,teteLecture);
        RegleGrammaire r=getRegle(numRegle);
        return r.MembreDroit;
    }



}
