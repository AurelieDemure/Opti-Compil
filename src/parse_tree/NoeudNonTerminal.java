package parse_tree;

public class NoeudNonTerminal implements Noeud{
    private String fonctionSemantique;
    private List<Noeud> listFils;

    public NoeudNonTerminal(String fonctionSemantique){
        this.fonctionSemantique = fonctionSemantique;
        this.fils = new ArrayList<>();
    }

    @Override
    public void ajouterFils(Noeud fils){
        this.listFils.add(fils);
    }

    @Override
    public String interpret(){
        /* return grammaire.fonctionSemantique(jsp) */
    }

}
