package parse_tree;

public class ArbreSyntaxique {
    private Noeud racine;

    public void setRacine(Noeud racine){
        this.racine=racine;
    }

    public void ajouterFils(Noeud parent, Noeud fils){
        parent.ajouterFils(fils);
    }
}
