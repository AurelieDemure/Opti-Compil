package error; /*pour le mettre dans le package d'erreur'*/

/*import java.io.*;*/
import java.util.*;

import lexer.Lexer;

public class ErrorManager {
    //Ensemble des erreurs a traiter
    private List<Error> errors = new ArrayList<Error>();

    //Sauvegarder un errerus
    public void saveError(String message){
        Error errorMessage = new Error(message);//on creer l erreur
        errors.add(errorMessage);//On ajoute a la liste des erreurs a renvoyer
    }

    //Sauvegarder un errerus du lexeur
    public void saveError(int line, int nbChar, String message){
        Error errorMessage = new Error(line, nbChar, message);//on creer l erreur
        errors.add(errorMessage);//On ajoute a la liste des erreurs a renvoyer
    }


    //renvoie toutes les erreurs de la liste d erreur
    public void throwErrors(){
        for(Error error : this.errors){
            error.throwError();
        }
        this.errors.clear();//On reinitialise la liste d erreurs
    }

    //renvoie toutes les erreurs de la liste d erreur avec les infos du lexeur
    public void throwErrorsLexer(Lexer lexer){
        for(Error error : this.errors){
            error.throwErrorLexer(lexer);
        }
        this.errors.clear();//On reinitialise la liste d erreurs
    }
}