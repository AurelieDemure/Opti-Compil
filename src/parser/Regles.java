package parser;

import java.util.*;

public class Regles {
    public final List<RegleGrammaire> regles;
    public RegleGrammaire getRegle(int num){
        for (int i=0;i<this.regles.size();i++){
            if (this.regles.get(i).Numero==num){
                return this.regles.get(i);
            }
        }
        return this.regles.get(-1);
    }

    
}
