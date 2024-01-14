package compilateur.parse_tree;

import compilateur.parser.*;
import compilateur.abstractTree.*;

import java.util.*;

public class NonTerminalExpression implements AbstractExpression{
    private int id;
    private String valeur;
    private List<AbstractExpression> listFils;
    private Grammaire grammar;

    public NonTerminalExpression(int id, String valeur, Grammaire grammar){   
        this.id = id;
        this.valeur = valeur;
        this.grammar = grammar;
        this.listFils = new ArrayList<>();
        this.grammar = grammar;
    }

    @Override
    public void show() {
        System.out.print(this.valeur);
    }

    public void ajouterFils(AbstractExpression fils){
        this.listFils.add(fils);
    }

    public Component interpret(){
        return this.grammar.fonctionSemantique(id,this);
    }

    public AbstractExpression getFils(int index){
        return listFils.get(index);
    }

    public int getId(){
        return this.id;
    }

    public List<AbstractExpression> getListFils() {
        return this.listFils;
    }

    public String getValeur(){
        return this.valeur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValeur (String valeur) {
        this.valeur = valeur;
    }

}
