package parser;

import java.util.List;

public class RegleGrammaire {
    private final NonTerminal MembreGauche;
    private final Symbole[] MembreDroit;
    private final int Numero;
    public static int DernierNumero=-1;
    public RegleGrammaire(NonTerminal mGauche,Symbole[] mDroit){
        this.Numero=RegleGrammaire.DernierNumero;
        RegleGrammaire.DernierNumero++;
        this.MembreGauche=mGauche;
        this.MembreDroit=mDroit;
    }
    public NonTerminal getMembreGauche(){
        return this.MembreGauche;
    }
    public Symbole[] getMembreDroit(){
        return this.MembreDroit;
    }
    public int getNumero(){
        return this.Numero;
    }
}
