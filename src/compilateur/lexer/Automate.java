package compilateur.lexer;

public class Automate {
    protected String token="";
    protected String read="";
    protected char nextLexeur=' ';

    public Automate(){
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
