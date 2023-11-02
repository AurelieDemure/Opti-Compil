package lexer;

public class Automate {
    protected String token;
    protected String read;
    protected char nextLexeur;

    public Automate(char token, char read, char nextLexeur){
        String t="";
        t+=token;
        this.token = t;
        String r="";
        r+=read;
        this.read = r;
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
