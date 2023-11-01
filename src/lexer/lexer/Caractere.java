package lexer;

//Tokens particuliers ayant le tag "ident" ou etant un mot cle

public class Caractere extends Token{

    public final char lexeme;//le mot en question (qu'on ne voudra pas changer plus tard)

    //le tag dependra si il est un "ident" ou un mot cle
    public Caractere(int t, char s){
        super(t);
        lexeme=s;
    }
}