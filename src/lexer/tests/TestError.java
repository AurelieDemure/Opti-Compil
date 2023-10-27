package lexer; /*pour le mettre dans le package de l'analyseur lexical*/

import java.io.*;
import java.util.*;

public class TestError {

public static void main(String[] arg){
        Error error = new Error(("this is an error"));
        error.throwError(); 
    }
}
