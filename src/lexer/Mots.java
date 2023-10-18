package lexer;

/*Tokens particuliers ayant le tag "ident" ou etant un mot cle*/

public class Mots extends Token{

    public final String lexeme;/*le mot en question (qu'on ne voudra pas changer plus tard)*/

    /*le tag dependra si il est un "ident" ou un mot cle*/
    public Mots(int t, String s){
        super(t);
        lexeme=new String(s);
    }
}