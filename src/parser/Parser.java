package parser;

import java.io.IOException;
import java.util.*;
import lexer.*;

public class Parser {
    public Stack<Symbole> Pile=new Stack<Symbole>();
    private int[] tableTag; 
    public TableAnalyse table;

    public Parser(int[] tableTag, int[][] tab){
        this.table=new TableAnalyse(tab);
        NonTerminal axiome=table.getAxiome();
        Token d=new Token((int) '$');
        Terminal dollar=new Terminal(d);
        this.Pile.push(dollar);
        this.Pile.push(axiome);
        this.tableTag = tableTag;
    }

    public int getId(int tag){
        for(int i=0; i<tableTag.length; i++){
            if(tableTag[i]==tag){
                return(i);
            }
        }
        return(-1);
    }

    public int Analyseur() throws IOException{
        Lexer lexer=new Lexer();
        int statut=-1;
        Terminal a=new Terminal(lexer.scan());
        while (statut==-1) {

            Token token = a.getValue();
            if(token.tag!=0){
                System.out.println("##line : "+ lexer.getLine());
                System.out.println("Token : "+token.tag);
                if(token instanceof Mots){
                    System.out.println("Its value : "+((Mots)token).lexeme);
                }
                else if(token.tag<256){
                    System.out.println("Its value : "+(char)token.tag);
                }
            }

            Symbole X=Pile.peek();
            if (X instanceof NonTerminal) {
                List<Symbole> mDroit=table.RenvoieSortiePile(((NonTerminal)X).getId(),getId((a.getValue()).tag));
                if (mDroit.get(0) instanceof Terminal && ((Terminal)mDroit.get(0)).getValue().tag!=-1){
                    statut=1;
                }
                else {
                    Pile.pop();
                    for (int i=mDroit.size()-1;i>=0;i--){
                        Pile.push(mDroit.get(i));
                    }
                }
            }
            else {
                if (((Terminal)X).getValue().tag==((int) '$')){
                    if ((Terminal)X==a){
                        statut=0;
                    }
                    else{
                        statut=1;
                    }
                }
                else{
                    if ((Terminal)X==a){
                        Pile.pop();
                        a=new Terminal(lexer.scan());
                    }
                    else {
                        statut=1;
                    }
                }
            }


            
        }
        return statut;
        
    }

    
}
