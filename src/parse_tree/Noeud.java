package parse_tree;

public interface Noeud {
    public String interpret();
    public void ajouterFils(Noeud fils);
    public Noeud getFils(Noeud NoeudCourant, int index);
}
