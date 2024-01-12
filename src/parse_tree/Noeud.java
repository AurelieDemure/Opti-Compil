package parse_tree;

import parser.*;
import abstractTree.*;
public interface Noeud {
    public Component interpret();
    public void ajouterFils(Noeud fils);
    public Noeud getFils(int index);
    public String getValeur();
    public int getFonctionSemantique();
}
