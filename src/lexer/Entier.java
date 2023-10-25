package lexer;

//Tokens particuliers ayant le tag "entier"
public class Entier extends Token{

    public final int value;//valeur de l entier (qu'on ne voudra pas changer)

    public Entier(int v){
        super(Tag.ENTIER); value=v;
    }
}