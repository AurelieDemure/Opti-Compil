package parser;

import java.io.IOException;
import java.util.*;
import lexer.*;

public class Parser (int[][] table){
    public Stack<Symbole> Pile=new Stack<Symbole>();
    public TableAnalyse table=new TableAnalyse(int[][] table);
    public Parser(){
        NonTerminal axiome=table.getAxiome();
        Token d=new Token((int) '$');
        Terminal dollar=new Terminal(d);
        this.Pile.push(dollar);
        this.Pile.push(axiome);
        
    }
    public int Analyseur() throws IOException{
        Lexer lexer=new Lexer();
        int statut=-1;
        Terminal a=new Terminal(lexer.scan());
        while (statut==-1) {
            Symbole X=Pile.peek();
            if (X instanceof NonTerminal) {
                List<Symbole> mDroit=table.RenvoieSortiePile(((NonTerminal)X).getId(),(a.getValue()).tag);
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
