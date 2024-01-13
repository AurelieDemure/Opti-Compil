package parse_tree;

import parser.*;
import abstractTree.*;

import java.util.*;

public class NonTerminalExpression implements AbstractExpression{
    private int Id;
    private String valeur;
    private List<AbstractExpression> listFils;
    private GrammaireLL1Test grammar = new GrammaireLL1Test();

    public NonTerminalExpression(int Id, String valeur){   
        this.Id = Id;
        this.valeur = valeur;
        this.listFils = new ArrayList<>();
    }

    @Override
    public void show() {
        System.out.print(this.valeur);
    }

    public void ajouterFils(AbstractExpression fils){
        this.listFils.add(fils);
    }

    public Component interpret(){
        return this.grammar.fonctionSemantique(Id,this);
    }

    public AbstractExpression getFils(int index){
        return listFils.get(index);
    }

    public int getId(){
        return this.Id;
    }

    public List<AbstractExpression> getListFils() {
        return this.listFils;
    }

    public String getValeur(){
        return this.valeur;
    }

}
