package parser;

import java.util.*;

public class NoeudNonTerminal implements Noeud{
    private int fonctionSemantique;
    private List<Noeud> listFils;

    public NoeudNonTerminal(int fonctionSemantique){   
        this.fonctionSemantique = fonctionSemantique;
        this.listFils = new ArrayList<>();
    }

    @Override
    public void ajouterFils(Noeud fils){
        this.listFils.add(fils);
    }

    @Override
    public void interpret(){
        //appelle fontionSémantique en tant qu'instruction
    }

    @Override
    public Noeud getFils(Noeud NoeudCourant, int index){
        return listFils.get(index);
    }

    public int getFonctionSemantique(){
        return this.fonctionSemantique;
    }
    public String getValeur(){
        return "test";
    }

}
