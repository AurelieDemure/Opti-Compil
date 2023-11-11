package parser;

import java.util.List;

public class RegleGrammaire {
    public final NonTerminal MembreGauche;
    public final List<Symbole> MembreDroit;
    public final int Numero;
    public static int DernierNumero=-1;
    public RegleGrammaire(NonTerminal mGauche,List<Symbole> mDroit){
        this.Numero=RegleGrammaire.DernierNumero;
        RegleGrammaire.DernierNumero++;
        this.MembreGauche=mGauche;
        this.MembreDroit=mDroit;
    }
}
