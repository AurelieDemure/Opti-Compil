package parse_tree;

public class NoeudNonTerminal implements Noeud{
    private String fonctionSemantique;
    private List<Noeud> listFils;

    public NoeudNonTerminal(String fonctionSemantique){   //voir comment récupérer la fonction en tant qu'instructions
        this.fonctionSemantique = fonctionSemantique;
        this.fils = new ArrayList<>();
    }

    @Override
    public void ajouterFils(Noeud fils){
        this.listFils.add(fils);
    }

    @Override
    public String interpret(){
        //appelle fonction sémantique et la retourne
    }

    @Override
    public Noeud getFils(Noeud NoeudCourant, int index){
        return listFils.get(index);
    }

}
