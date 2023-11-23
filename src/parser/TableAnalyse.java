package parser;

import java.util.*;

import lexer.*;

public class TableAnalyse {
    private List<RegleGrammaire> regles=new ArrayList<RegleGrammaire>();
    private int[][] table;    

    public void setRegles(List<RegleGrammaire> regles){
        this.regles=regles;
    }
    public List<RegleGrammaire> getRegles(){
        return this.regles;
    }
    public void setTable(int[][] table){
        this.table=table;
    }
    public int[][] getTable(){
        return this.table;
    }

    public void addRegle(RegleGrammaire regle){
        this.regles.add(regle);
    }


    public TableAnalyse(int[][] table){
        /*ajout d'une regle d'erreur dans la liste des regles*/
        Mots erreur=new Mots(Tag.ERREUR,"Le programme n'est pas reconnu par la grammaire");
        Terminal symbMembreDroit=new Terminal(erreur);
        List<Symbole> membreDroit=Arrays.asList(symbMembreDroit);
        RegleGrammaire regleErreur=new RegleGrammaire(new NonTerminal(),membreDroit);
        this.regles.add(regleErreur);
        this.table=table;
    }
  

    public int TrouveNumRegle(int idSommetPile, int tagTeteLecture){ /* trouve dans la table quel est le numero de la regle à appliquer */
        return this.table[idSommetPile][tagTeteLecture];
    }
    public RegleGrammaire getRegle(int num){ /*renvoie l'objet regle qui a le numero num */
        for (int i=0;i<this.regles.size();i++){
            if (this.regles.get(i).getNumero()==num){
                return this.regles.get(i);
            }
        }
        return this.regles.get(0);
    }
    
    public NonTerminal getAxiome(){ 
        return getRegle(0).getMembreGauche();
    }
    public List<Symbole> RenvoieSortiePile(int idSommetPile, int tagTeteLecture) { /*renvoie l'action a effectuer a partir du numero de regle trouvé dans la table */
        int numRegle=TrouveNumRegle(idSommetPile,tagTeteLecture);
        RegleGrammaire r=getRegle(numRegle);
        return r.getMembreDroit();
    }



}