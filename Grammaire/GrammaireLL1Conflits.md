fichier ::= with Ada.Text_IO; use Ada.Text_IO; procedure ident is DECL* begin instr INSTR* end IDENT?
DECL* ::= '' 
DECL* ::= decl DECL*
INSTR* ::= '' 
INSTR* ::= instr INSTR*
IDENT? ::= ''  ; EOF
IDENT? ::= ident  ; EOF

decl ::= type ident A1
decl ::= ident IDENT,* : TYPE EXPR?:=
decl ::= procedure ident PARAMS? is DECL* begin instr INSTR* end IDENT
decl ::= function ident PARAMS? return TYPE is DECL* begin instr INSTR* end IDENT?

A1 ::= ; 
A1 ::= is B1

B1 ::= access ident; 
B1 ::= record champs CHAMPS* end record ;

CHAMPS* ::= '' 
CHAMPS* ::= champs CHAMPS*
IDENT,* ::= , ident IDENT,* 
IDENT,* ::= ''
EXPR?:= ::= '' 
EXPR?:= ::= :=expr
PARAMS? ::= params 
PARAMS? ::= ''

champs ::= ident IDENT,* : TYPE ;

TYPE ::= ident
TYPE ::= access ident

params ::= ( param PARAM;* )

PARAM;* ::= '' 
PARAM;* ::= ; param PARAM;*

param ::= ident IDENT,* : MODE? TYPE

MODE? ::= '' 
MODE? ::= mode

mode ::= in C1

C1 ::= ''
C1 ::= out

expr ::= exprOperateur

exprOperateur ::= exprAnd EXPROPERATEUR

EXPROPERATEUR ::= or D1 
EXPROPERATEUR ::= ''

D1 ::= exprAnd EXPROPERATEUR 
D1 ::= else exprAnd EXPROPERATEUR

exprAnd ::= exprNot EXPRAND

EXPRAND ::= and E1 
EXPRAND ::= ''

E1 ::= exprNot EXPRAND 
E1 ::= then exprNot EXPRAND

exprNot ::= exprEgal EXPRNOT

EXPRNOT ::= not exprEgal EXPRNOT 
EXPRNOT ::= ''

exprEgal ::= exprComparaison EXPREGAL

EXPREGAL ::= = exprComparaison EXPREGAL
EXPREGAL ::= /= exprComparaison EXPREGAL 
EXPREGAL ::= ''

exprComparaison ::= exprSomme EXPRCOMPARAISON

EXPRCOMPARAISON ::= > exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= >= exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= < exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= <= exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= ''

exprSomme ::= exprMult EXPRSOMME

EXPRSOMME ::= + exprMult EXPRSOMME 
EXPRSOMME ::= - exprMult EXPRSOMME 
EXPRSOMME ::= ''

exprMult ::= exprUnaire EXPRMULT

EXPRMULT ::= * exprUnaire EXPRMULT 
EXPRMULT ::= / exprUnaire EXPRMULT 
EXPRMULT ::= rem exprUnaire EXPRMULT 
EXPRMULT ::= ''

exprUnaire ::= exprTerm1
exprUnaire ::= exprTerm2 
exprUnaire ::= - exprUnaire

exprTerm1 ::= entier EXPRTERM
exprTerm1 ::= caractère EXPRTERM
exprTerm1 ::= true EXPRTERM
exprTerm1 ::= false EXPRTERM
exprTerm1 ::= null EXPRTERM
exprTerm1 ::= (expr) EXPRTERM
exprTerm2 ::= ident G1
exprTerm1 ::= not expr EXPRTERM
exprTerm1 ::= new ident EXPRTERM
exprTerm1 ::= character' val ( expr ) EXPRTERM

G1 ::= G11
G1 ::= G12
G11 ::= EXPRTERM
G12 ::= ( expr EXPR,* ) EXPRTERM


EXPRTERM ::= . ident EXPRTERM 
EXPRTERM ::= ''

EXPR,* ::= '' 
EXPR,* ::= , expr EXPR,*

instr ::= ident H1
instr ::= exprTerm1 . ident := expr ;
instr ::= return EXPR? ;
instr ::= begin instr INSTR* end
instr ::= if expr then instr INSTR* ELSIF ELSE end if;
instr ::= for ident in reverse? expr .. expr loop instr INSTR* end loop ;
instr ::= while expr loop instr INSTR* end loop ;

F11 ::= := expr ; 

H1 ::= F11
H1 ::= '' 
H1 ::= . ident J1
H1 ::= ( expr EXPR,* ) I1


I1 ::= ;
I1 ::= EXPRTERM . ident := expr ;

J1 ::= := expr ;
J1 ::= EXPRTERM . ident := expr ;

EXPR? ::= '' 
EXPR? ::= expr
ELSIF ::= '' 
ELSIF ::= elsif expr then instr INSTR* ELSIF
ELSE ::= '' 
ELSE ::= else instr INSTR*
reverse? ::= '' 
reverse? ::= reverse

ident ::= alpha IDENT

IDENT ::= '' 
IDENT ::= alpha IDENT 
IDENT ::= chiffre IDENT 
IDENT ::= _ IDENT

alpha ::= a 
alpha ::= b 
alpha ::= c 
alpha ::= d 
alpha ::= e
alpha ::= f 
alpha ::= g 
alpha ::= h 
alpha ::= i 
alpha ::= j 
alpha ::= k 
alpha ::= l 
alpha ::= m 
alpha ::= n 
alpha ::= o 
alpha ::= p 
alpha ::= q 
alpha ::= r
alpha ::= s 
alpha ::= t 
alpha ::= u 
alpha ::= v 
alpha ::= w 
alpha ::= x 
alpha ::= y 
alpha ::= z 
alpha ::= A 
alpha ::= B 
alpha ::= C 
alpha ::= D 
alpha ::= E 
alpha ::= F 
alpha ::= G 
alpha ::= H 
alpha ::= I 
alpha ::= J 
alpha ::= K 
alpha ::= L 
alpha ::= M 
alpha ::= N 
alpha ::= O 
alpha ::= P 
alpha ::= Q 
alpha ::= R 
alpha ::= S
alpha ::= T 
alpha ::= U 
alpha ::= V 
alpha ::= W 
alpha ::= X 
alpha ::= Y 
alpha ::= Z 

entier ::= chiffre CHIFFRE*

CHIFFRE* ::= '' 
CHIFFRE* ::= chiffre CHIFFRE*

chiffre ::= 0
chiffre ::= 1
chiffre ::= 2
chiffre ::= 3
chiffre ::= 4
chiffre ::= 5
chiffre ::= 6
chiffre ::= 7
chiffre ::= 8
chiffre ::= 9

caractère ::= ' ASCII '

ASCII ::= SPC 
ASCII ::= ! 
ASCII ::= " 
ASCII ::= # 
ASCII ::= $ 
ASCII ::= % 
ASCII ::= & 
ASCII ::= ' 
ASCII ::= ( 
ASCII ::= ) 
ASCII ::= * 
ASCII ::= + 
ASCII ::= , 
ASCII ::= - 
ASCII ::= . 
ASCII ::= / 
ASCII ::= 0 
ASCII ::= 1 
ASCII ::= 2 
ASCII ::= 3 
ASCII ::= 4 
ASCII ::= 5 
ASCII ::= 6 
ASCII ::= 7 
ASCII ::= 8 
ASCII ::= 9
ASCII ::= : 
ASCII ::= ; 
ASCII ::= < 
ASCII ::= =  
ASCII ::= > 
ASCII ::= ? 
ASCII ::= @ 
ASCII ::= A 
ASCII ::= B 
ASCII ::= C 
ASCII ::= D 
ASCII ::= E 
ASCII ::= F 
ASCII ::= G 
ASCII ::= H 
ASCII ::= I 
ASCII ::= J 
ASCII ::= K 
ASCII ::= L 
ASCII ::= M 
ASCII ::= N 
ASCII ::= O 
ASCII ::= P 
ASCII ::= Q 
ASCII ::= R 
ASCII ::= S
ASCII ::= T 
ASCII ::= U 
ASCII ::= V 
ASCII ::= W 
ASCII ::= X 
ASCII ::= Y 
ASCII ::= Z 
ASCII ::= [  
ASCII ::= \ 
ASCII ::= ] 
ASCII ::= ^
ASCII ::= _ 
ASCII ::= ` 
ASCII ::= a 
ASCII ::= b 
ASCII ::= c 
ASCII ::= d 
ASCII ::= e
ASCII ::= f 
ASCII ::= g 
ASCII ::= h 
ASCII ::= i 
ASCII ::= j 
ASCII ::= k 
ASCII ::= l 
ASCII ::= m 
ASCII ::= n 
ASCII ::= o 
ASCII ::= p 
ASCII ::= q 
ASCII ::= r 
ASCII ::= s 
ASCII ::= t 
ASCII ::= u 
ASCII ::= v 
ASCII ::= w 
ASCII ::= x 
ASCII ::= y 
ASCII ::= z 
ASCII ::= { 
ASCII ::= | 
ASCII ::= } 
ASCII ::= ~ 