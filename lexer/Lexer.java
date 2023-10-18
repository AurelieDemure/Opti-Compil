package lexer; /*pour le mettre dans le package de l'analyseur lexical*/

import java.io.*;
import java.util.*;

public class Lexer {

    public int line=1;/*compteur de ligne*/
    private char caractere;
    private char prochain=null;/*prochain caractere a lire*/
    private Hashtable words=new Hashtable();/* Table des string, pour gerer les mots cles et identifiants. Utilisation d une table de hashage*/

    /*permet de mettre les tokens des mots cles dans la table des strings*/
    void reserve(Word t){
        words.put(t.lexeme, t);
    }

    /*on initialise la table des strings*/
    public Lexer(){
        reserve(new Word(Tag.TRUE, "true"));
        reserve(new Word(TAG.FALSE, "false"));
        /*a continuer avec les autres mots cles*/
    }
    public Token scan() throws IOExeption{/*type d'erreur a renvoyer (d apres le cours, mais jsp en vrais)*/
        
        /*suppression des espaces et tabulation (on pourra aussi traiter les commentaires en meme temps*/
        /*on initialise caractere à espace, et tant que l'on a des espaces ou tabulation, on continue de lire*/
        if(prochain!=null){
            caractere=prochian;
        }
        else{
            caractere=(char)System.in.read()
        }
        for(; caractere!=' ' || caractere!='\t' || caractere !='\n' || caractere !='-'; caractere=(char)System.in.read()){
            if(caractere=='\n'){/*on incremente le compteur de ligne si on a un saut de ligne, utile pour la gestion de bug*/
                line=line+1;
            }
            else if(caractere='-'){
                caractere=(char)System.in.read();
                if(caractere='-'){
                    caractere=(char)System.in.read();
                    while(caractere!='-'and (char)System.in.read()!='-'){
                        caractere=(char)System.in.read();
                    }
                    
                }
                else{
                    prochain=caractere;
                    caractere='-';
                }
            }
        }

        /*on teste si on a un nombre (automate entier)*/

        /*on teste si on a un identifiant (automate ident)*/
        if(Automate.estIdent(caractere)){
            String s;/*le mot qu'on a recconu avec l'automate*/
            Word w=(Word)words.get(s);/*on recupere sa valeur dans la table des strings*/
            if(w!=null){
                return w;/*si il est dans la table, on a pas a le traiter plus*/
            }
            w=new Word(Tag.IDENT, s);/*si il n est pas dans la table, on cree le token associe*/
            words.put(s,w);/*et on le met dans la table*/
            return w;
        }

        /*on teste si on a un symbole (automate symbole)*/

        /*on teste si on a un caractere (automate caractere)*/

        /*gestion des nombres flottants ? pas vu dans le sujet en tout cas*/

        /*si on a pas reconnu le caractere*/
        /*il faudra plutot renvoyer une erreur si aucun automate n'a reconnu le caractere ou la chaine suivante*/
        Token t=newToken(caractere);/*on renvoie le caractere en question sous forme de token*/
        return t;
    }
}
