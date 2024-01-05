package parser;

import java.util.*;

public class NoeudTerminal implements Noeud {
    private String valeur;

    public NoeudTerminal(String valeur){
        this.valeur=valeur;
    }

    @Override
    public void interpret(){
        System.out.println("jsp");
    }

    @Override
    public Noeud getFils(Noeud NoeudCourant, int index){
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
