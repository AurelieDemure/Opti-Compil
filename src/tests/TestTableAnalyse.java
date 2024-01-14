package tests;

import java.util.*;
import compilateur.lexer.*;
import compilateur.parser.*;

public class TestTableAnalyse {
    
    public static void main(String[] args){
        Grammaire grammar = new GrammaireTest();
        int[][] table = {{0,1,2,-1,-1,-1},
                         {3,3,3,-1,-1,-1},
                         {-1,-1,-1,5,6,-1}};
        TableAnalyse TableA = new TableAnalyse(table, grammar);
        NonTerminal S = new NonTerminal();
        NonTerminal T = new NonTerminal();
        NonTerminal U = new NonTerminal();
        Terminal a = new Terminal(new Token(0), grammar);
        Terminal b = new Terminal(new Token(1), grammar);
        Terminal c = new Terminal(new Token(2), grammar);
        Terminal d = new Terminal(new Token(3), grammar);
        Terminal e = new Terminal(new Token(4), grammar);
        Terminal f = new Terminal(new Token(5), grammar);
        TableA.addRegle(new RegleGrammaire(S,Arrays.asList(a)));
        TableA.addRegle(new RegleGrammaire(S,Arrays.asList(b)));
        TableA.addRegle(new RegleGrammaire(S,Arrays.asList(c,T,d)));
        TableA.addRegle(new RegleGrammaire(T,Arrays.asList(S,U)));
        TableA.addRegle(new RegleGrammaire(T,Arrays.asList(S,U)));
        TableA.addRegle(new RegleGrammaire(U,Arrays.asList()));
        int valTNR=TableA.TrouveNumRegle(0,c.getTag());
        if (valTNR!=2){
            System.out.println("Test TrouveNumRegle faux :\n valeur trouvee :"+valTNR+" valeur souhaitee : 2");
        }
        else {System.out.println("Test TrouveNumRegle ok");}
        RegleGrammaire r=TableA.getRegle(3);
        NonTerminal mbG=r.getMembreGauche();
        List<Symbole> mbD=r.getMembreDroit();
        if (!mbG.equals(T) || !mbD.equals(Arrays.asList((Symbole)S,(Symbole)U))){
            System.out.println(("Test getRegle faux :\n mbG trouvé :"+mbG+"mbG souhaité : T\n" + "mbD trouve : "+mbD+"mbD souhaite : SU" ));
        }
        else {System.out.println("Test getRegle ok");}
        RegleGrammaire sortiePile=TableA.RenvoieSortiePile(S.getId(),a.getTag());
        List<Symbole> sortiePileVoulue=Arrays.asList(a);
        if(!sortiePile.equals(sortiePileVoulue)){
            System.out.println("Test RenvoieSortiePile faux : \n SortiePile trouvée"+ sortiePile +"\nsortie pile voulue : a");
        }
        else {System.out.println("Test RenvoieSortiePile ok");}

        
}
}
