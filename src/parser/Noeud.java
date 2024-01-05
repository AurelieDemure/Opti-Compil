package parser;

public interface Noeud {
    public void interpret();
    public void ajouterFils(Noeud fils);
    public Noeud getFils(Noeud NoeudCourant, int index);
    public String getValeur();
    public int getFonctionSemantique();
}
