package lexer;

//on cree une classe Token pour pouvoir les manipuler ensuite
public class Token{

    public final int tag;//un entier symbolisant un caractere, ou autre. ie ce qui sera utilise par le parseur plus tard
    //initialise en final car on ne voudra pas le modifie une fois fixe
    
    public Token(int t){
        tag=t;
    }

}
