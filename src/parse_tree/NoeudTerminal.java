package parse_tree;

import parser.*;
import abstractTree.*;
import java.util.*;

public class NoeudTerminal implements Noeud {
    private String valeur;

    public NoeudTerminal(String valeur){
        this.valeur=valeur;
    }

    @Override
    public Component interpret(){
        return new Leaf(this.valeur);
    }

    @Override
    public Noeud getFils(int index){
        return this;
    }

    @Override
    public void ajouterFils(Noeud fils){}

    public String getValeur(){
        return this.valeur;
    }

    public int getFonctionSemantique(){
        return 0 ;
    }
}
