package parse_tree;

public class NoeudNonTerminal implements Noeud{
    private int fonctionSemantique;
    private List<Noeud> listFils;

    public NoeudNonTerminal(int fonctionSemantique){   
        this.fonctionSemantique = fonctionSemantique;
        this.fils = new ArrayList<>();
    }

    @Override
    public void ajouterFils(Noeud fils){
        this.listFils.add(fils);
    }

    @Override
    public Void interpret(){
        //appelle fontionSémantique en tant qu'instruction
    }

    @Override
    public Noeud getFils(Noeud NoeudCourant, int index){
        return listFils.get(index);
    }

}
