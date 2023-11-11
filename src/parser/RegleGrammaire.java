package parser;

import java.util.List;

public class RegleGrammaire {
    public final NonTerminal MembreGauche;
    public final List<Symbole> MembreDroit;
    public final int Numero;
    public static int DernierNumero=-1;
    public RegleGrammaire(NonTerminal mGauche,List<Symbole> mDroit){
        RegleGrammaire.DernierNumero++;
        this.Numero=RegleGrammaire.DernierNumero;
        this.MembreGauche=mGauche;
        this.MembreDroit=mDroit;
    }
}
