package lexer;

public class Automate {
    protected String token;
    protected String read;
    protected char nextLexeur;

    public Automate(String token, String read, char nextLexeur){
        this.token = token;
        this.read = read;
        this.nextLexeur = nextLexeur;
    }

    public void setToken(){
        token = null;
    }

    public String getToken(){
        return this.token;
    }

    public String getRead(){
        return this.read;
    }

    public char getNextLexeur(){
        return this.nextLexeur;
    }
}
