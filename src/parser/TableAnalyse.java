package parser;

public class TableAnalyse {
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
    public Symbole.List RenvoieSortiePile(NonTerminal sommetPile, Terminal teteLecture) {
        int numRegle=TrouveRegle(sommetPile,teteLecture);
        RegleGrammaire r=getRegle(numRegle);
    }



}
