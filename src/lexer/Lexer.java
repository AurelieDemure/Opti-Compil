package lexer; /*pour le mettre dans le package de l'analyseur lexical*/

import java.io.*;
import java.util.*;

/*Le programme peut marcher avec une extension pour les commentaires : un commentaire ne s'arrete plus en fin de ligne mais au prochain "--"*/

public class Lexer {

    /*compteur de ligne*/
    public int line=1;
    /*pour sauvegarder le debut des commentaires, afin de gerer les messages d erreurs*/
    /*public int lineComment=1;*/
    /*le caractere que l on lit*/
    private char caractere=' ';
    /*prochain caractere a lire*/
    private char prochain=' ';
    /* Table des string, pour gerer les mots cles et identifiants. Utilisation d une table de hashage*/
    private Hashtable mots=new Hashtable();

    /*permet de mettre les tokens des mots cles dans la table des strings*/
    void reserve(Mots t){
        mots.put(t.lexeme, t);
    }

    /*on initialise la table des strings*/
    public Lexer(){
        reserve(new Mots(Tag.TRUE, "true"));
        reserve(new Mots(Tag.FALSE, "false"));
        /*a continuer avec les autres mots cles*/
    }
    public int scan() throws IOException{/*pour le System.in.read()*/
        
        /*suppression des espaces, tabulation, retours a la ligne et les commentaires*/

        /*on remet caractere a la bonne valeur si jamais on a lut 1 caractere en avance a un moment*/
        if(prochain!=' '){
            caractere=prochain;
        }
        else{
            caractere=(char)System.in.read();
        }

        while(caractere<=32 || caractere =='-'){

            /*on incremente le compteur de ligne si on a un saut de ligne, utile pour la gestion de bug*/
            if(caractere=='\n'){
                line=line+1;
            }

            /*on gere les commenentaires*/
            else if(caractere=='-'){
                caractere=(char)System.in.read();
                if(caractere=='-'){
                    /*detection du debut du commentaire*/

                    /*on enregistre la ligne du debut du commentaire*/
                    /*lineComment=line;
                    prochain=(char)System.in.read();*//*on lit en avance*/

                    /*tant que les deux curseurs n ont pas des "-", on continue a skip*/
                    while(caractere!='\n'){/*(caractere!='-' || prochain!='-'){*/
                        /*on continue a compter les retours a la ligne*/
                        /*if(prochain=='\n'){
                            line=line+1;
                        }*/
                        /*on decales les curseurs de 1*/
                        caractere=(char)System.in.read();
                        /*caractere=prochain;
                        prochain=(char)System.in.read();*/

                        /*si le commentaire n a pas de fin, on renvoie une erreur*/
                        /*if((int)prochain==65535){
                            throw new IOException("The comment begin on line " + lineComment + " has not end");
                        }*/
                    }
                    /*quand on a fini de traiter les commentaires, on remet les curseurs comme il faut*/
                    line=line+1;
                    caractere=(char)System.in.read();
                    /*prochain=' ';*/
                }

                /*si ce n est pas un debut de commentaire, on remet le curseur comme il faut*/
                else{
                    prochain=caractere;
                    caractere='-';
                }
            }
        
            /*on avance*/
            caractere=(char)System.in.read();
        }

        /*on teste si on a un nombre (automate entier)*/

        /*on teste si on a un identifiant (automate ident)*/
        /*
        if(Automate.estIdent(caractere)){
            String s;/*le mot qu'on a recconu avec l'automate*//*
            Mots w=(Mots)mots.get(s);/*on recupere sa valeur dans la table des strings*//*
            if(w!=null){
                return w;/*si il est dans la table, on a pas a le traiter plus*//*
            }
            w=new Mots(Tag.IDENT, s);/*si il n est pas dans la table, on cree le token associe*//*
            mots.put(s,w);/*et on le met dans la table*//*
            return w;
        }
        */
        /*on teste si on a un symbole (automate symbole)*/

        /*on teste si on a un caractere (automate caractere)*/

        /*gestion des nombres flottants ? pas vu dans le sujet en tout cas*/

        /*si on a pas reconnu le caractere*/
        /*il faudra plutot renvoyer une erreur si aucun automate n'a reconnu le caractere ou la chaine suivante*/
        Token t=new Token(caractere);/*on renvoie le caractere en question sous forme de token*/
        return 1;
    }
}
