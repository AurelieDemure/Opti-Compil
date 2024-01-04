package parse_tree;

public class NoeudTerminal implements Noeud {
    private String valeur;

    public NoeudTerminal(String valeur){
        this.valeur=valeur;
    }

    @Override
    public String interpret(){
        return this.valeur;
    }

    @Override
    public Noeud getFils(Noeud NoeudCourant, int index){}
}
