package parse_tree;

import parser.*;
import abstractTree.*;

import java.util.*;

public class NoeudNonTerminal implements Noeud{
    private int fonctionSemantique;
    private List<Noeud> listFils;
    private GrammaireLL1Test grammar = new GrammaireLL1Test();

    public NoeudNonTerminal(int fonctionSemantique){   
        this.fonctionSemantique = fonctionSemantique;
        this.listFils = new ArrayList<>();
    }

    @Override
    public void show() {
        System.out.print("" + fonctionSemantique);
    }

    @Override
    public void ajouterFils(Noeud fils){
        this.listFils.add(fils);
    }

    @Override
    public Component interpret(){
        return this.grammar.fonctionSemantique(fonctionSemantique,this);
    }

    @Override
    public Noeud getFils(int index){
        return listFils.get(index);
    }

    public int getFonctionSemantique(){
        return this.fonctionSemantique;
    }
    public String getValeur(){
        return "test";
    }

    public List<Noeud> getListFils() {
        return this.listFils;
    }

}
