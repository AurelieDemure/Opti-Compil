package lexer; /*pour le mettre dans le package de l'analyseur lexicale*/

import java.io.*;
import java.util.*;

public class Lexer {

    public int line=1;/*compteur de ligne*/
    private char prochain;/*prochain charactere a lire*/
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
        /*on initialise prochain à espace, et tant que l'on a des espaces ou tabulation, on continue de lire*/
        for(prochain=' '; prochain!=' ' || prochain!='\t' || prochain !='\n' ;prochain=(char)System.in.read()){
            if(prochain=='\n'){/*on incremante le compteur de ligne si on a un saut de ligne, utile pour la gestion de bug*/
                line=line+1;
            }
        }

        /*on test si on a un nombre (automate entier)*/

        /*on test si on a un identifiant (automate ident)*/
        if(Automate.estIdent(prochain)){
            String s;/*le mot qu'on a reconue avec l'automate*/
            Word w=(Word)words.get(s);/*on recupere sa valeur dans la table des strings*/
            if(w!=null){
                return w;/*si il est dans la table, on a pas a le traiter plus*/
            }
            w=new Word(Tag.IDENT, s);/*si il n est pas dans la table, on ceer le token associe*/
            words.put(s,w);/*et on le met dans la table*/
            return w;
        }

        /*on test si on a un symbole (automate symbole)*/

        /*on test si on a un caractere (automate caractere)*/

        /*gestion des nombres flottants ? pas vu dans le sujet en tout cas*/

        /*si on a pas reconnu le caractere*/
        /*il faudra plutot renvoyer une erreur si aucun automate n'a reconnu le caractere ou la chaine suivante*/
        Token t=newToken(prochain);/*on renvoie le caractere en question sous forme de token*/
        return t;
    }
}
