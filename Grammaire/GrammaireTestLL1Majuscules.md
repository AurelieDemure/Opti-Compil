# Traitement de la grammaire

## Grammaire originelle avec ajout des non-terminaux relatifs aux automates


**\<fichier>** = with Ada.Text_I0; use Ada.Text_I0;
procedure **\<ident>** is **\<decl>***
begin **\<instr>*** end **\<ident>**? ; EOF

**\<decl>** = type **\<ident>** ;
\| type **\<ident>** is access **\<ident>**;
\| type **\<ident>** is record **\<champs>**+ end record ;
\| **\<ident>**+, : **\<type>** (:= **\<expr>**)?
\| procedure **\<ident>** **\<params>**? is **\<decl>*** 
begin **\<instr>**+ end **\<ident>**?
\| function **\<ident>** **\<params>**? return **\<type>** is **\<decl>*** 
begin **\<instr>**+ end **\<ident>**?

**\<champs>** = **\<ident>**+, : **\<type>**;

**\<type>** = **\<ident>**
\| access **\<ident>**

**\<params>** = (**\<param>**+; )

**\<param>** = **\<ident>**+, : **\<mode>**? **\<type>**

**\<mode>** = in 
\| in out

**\<expr>** = **\<entier>** I **\<caractère>** I true | false | null
\| (**\<expr>**)
\| **\<accès>**
\| **\<expr>** **\<opérateur>** **\<expr>**
\| **\<expr>**
\| not **\<expr>**
\| new **\<ident>**
\| **\<ident>** (**\<expr>**+,)
\| character' val  (**\<expr>**)

**\<instr>** = **\<accès>** := **\<expr>**;
\| **\<ident>**
\| **\<ident>** (**\<expr>**+,);
\| return **\<expr>**?;
\| begin **\<instr>**+ end
\| if **\<expr>** then **\<instr>**+ (elsif **\<expr>** then **\<instr>**+)* 
(else **\<instr>** +)? end if;
\| for **\<ident>** in reverse? **\<expr>** .. **\<expr>** 
loop **\<instr>**+ end loop ;
\| while **\<expr>** loop **\<instr>**+ end loop ;

**\<opérateur>** ::= = | /= | < | <= | > | >=
\| + | - | * | / | rem
\| and | and then | or | or else

**\<accès>** ::= **\<ident>** | **\<expr>** . **\<ident>**

**\<ident>** ::= **\<alpha>** (**\<alpha>** | **\<chiffre>** | _ )*

**\<alpha>** ::= [a-z|A-Z]

**\<entier>** ::= **\<chiffre>**+

**\<chiffre>** ::= [0-9]

**\<caractère>** ::= '**\<ASCII>**'

**\<ASCII>** ::= SPC | ! | " | # | $ | % | & | ' | ( | ) | * | + | , | - | . | / | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | : | ; | < | = | > | ? | @ | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z | [ | \ | ] | ^ | _ | \` | a | b | c | d | e| f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | { | | | } | ~ |


<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>

## Premiers Suivants

|           | Premiers                                                                                    | Suivants                                                                                                     |
| --------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| Fichiers  | with                                                                                        | $                                                                                                            |
| Decl      | type, a-z, A-Z, procedure, function                                                         | begin, PREMIERDECL                                                                                           |
| Champs    | a-z, A-Z                                                                                    | end, PREMIERCHAMPS                                                                                           |
| Type      | a-z, A-Z , access                                                                           | :, is, ; , SUIVANTPARAM                                                                                      |
| Params    | (                                                                                           | is, return                                                                                                   |
| Param     | a-z, A-Z                                                                                    | ;                                                                                                            |
| Mode      | in, in out                                                                                  | PREMIERTYPE                                                                                                  |
| Expr      | a-z, A-Z , 0-9, ', true, false, null, (, not, new, character'val                            | ) , PREMIEROPÉRATEUR, , (virgule) , ; ,then, SUIVANTINSTR, loop, . ,  ????????                                         |
| Instr     | a-z, A-Z , 0-9, ', true, false, null, (, not, new, character'val, return, begin, if, for, while | PREMIERINSTR, end                                                                                            |
| Opérateur | =, /=, <, <=, >, >=, +, -, *, / , rem, and, and then, or, or else                           | PREMIEREXPR                                                                                                  |
| Accès     | a-z, A-Z , 0-9, ', true, false, null, (, not, new, character'val                               | SUIVANTEXPR, :                                                                                               |
| Ident     | a-z, A-Z                                                                                    | is, ; , , (virgule) , PREMIERPARAMS, SUIVANTDECL, return, SUIVANTTYPE, SUIVANTEXPR, ( , SUIVANTINSTR, in, SUIVANTACCES |
| Alpha     | a-z, A-Z                                                                                    | SUIVANTIDENT, PREMIERCHIFFRE, _ , PREMIERALPHA                                                               |
| Entier    | 0-9                                                                                         | SUIVANTEXPR                                                                                                  |
| Chiffre   | 0-9                                                                                         | PREMIERCHIFFRE, _ , PREMIERALPHA, SUIVANTENTIER                                                              |
| Caractère | '                                                                                           | SUIVANTEXPR                                                                                                  |
| ASCII     | ASCII                                                                                       | '                                                                                                            |

<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>

## Définition propre de la grammaire :
G = (S', N, T, ->) avec :

S' = **\<fichier>**

N = {fichier, decl, champs, type, params, param, mode, expr, instr, opérateur, accès, 		ident, alpha, entier, chiffre, caractere, ASCII}

T = {with, Ada.Text_I0, ; , use, procedure, is, begin, end, EOF, type, access, record, 		function, return, access, in, out, true, false, null, not, new, character'val, if, then, 			elsif, else, for, reverse?, loop, while, = , /= , < , <= , > , >=, +, -, *, rem, and, or, SPC , 	! , " , # , $ , % , & , ' , ( , ) , * , + , , , - , . , / , 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , : , ; , < , = 	, > , ? , @ , A , B , C , D , E , F , G , H , I , J , K , L , M , N , O , P , Q , R , S , T , U , V		, W , X , Y , Z , [ | \ | ] , ^ , _ , \` , a , b , c , d , e, f , g , h , i , j , k , l , m , n , o , p , q , r 	, s , t , u , v , w , x , y , z , { | | | } , ~  }

-> ensemble des règles définies plus haut par des ::=


## Réduction de la grammaire
### Réduction supérieure

1. fichier 
1.1. ident 
	___1.1.1. alpha
	___1.1.2. chiffre
1.2. decl
___1.2.1 expr
_______1.2.1.1 opérateur
_______1.2.1.2 accès
_______1.2.1.3 caractère
_____________1.2.1.3.1 ASCII
_______1.2.1.4 entier
___1.2.2 champs
___1.2.3 type
___1.2.4 params
_______1.2.4.1 param
_____________1.2.4.1.1 mode
1.3. instr

A ce stade, tous les non-terminaux apparaissent dans l'arbre de recherche donc tous les non-terminaux sont accessibles depuis fichier. Ainsi nous avons effectué une réduction supérieure de notre grammaire.

### Réduction inférieure

E0 = ∅
E1 = {mode, expr, opérateur, alpha, chiffre, ASCII}
E2 = {ident, entier, caractère} U E1
E3 = {decl, type, instr, acces} U E2
E4 = {fichier, champs, param} U E3
E5 = {params} U E4

Ainsi E5 = {params, fichier, champs, param, decl, type, instr, acces, ident, entier, caractère, mode, expr, opérateur, alpha, chiffre, ASCII}

On retrouve bien les 17 non-terminaux de N dans la définition propre de la grammaire. Ainsi, nous avons effectué la réduction inférieure de la grammaire.

## Dérécursivation

**\<fichier>** ::= with Ada.Text_I0; use Ada.Text_I0;
procedure **\<ident>** is **\<decl>***
begin **\<instr>**+ end **\<ident>**? ; EOF

**\<decl>** ::= type **\<ident>** ;
\| type **\<ident>** is access **\<ident>**;
\| type **\<ident>** is record **\<champs>**+ end record ;
\| **\<ident>**+, : **\<type>** (:= **\<expr>**)?;
\| procedure **\<ident>** **\<params>**? is **\<decl>*** 
begin **\<instr>**+ end **\<ident>**?;
\| function **\<ident>** **\<params>**? return **\<type>** is **\<decl>*** 
begin **\<instr>**+ end **\<ident>**?;

**\<champs>** ::= **\<ident>**+, : **\<type>**;

**\<type>** ::= **\<ident>**
\| access **\<ident>**

**\<params>** ::= (**\<param>**+; )

**\<param>** ::= **\<ident>**+, : **\<mode>**? **\<type>**

**\<mode>** ::= in 
\| in out

**\<expr>** ::= **\<entier>** **\<EXPR>** I **\<caractère>** **\<EXPR>** I true **\<EXPR>** | false **\<EXPR>** | null **\<EXPR>**
\| (**\<expr>**) **\<EXPR>**
\| **\<ident>** **\<EXPR>**
\| - **\<expr>** **\<EXPR>**
\| not **\<expr>** **\<EXPR>**
\| new **\<ident>** **\<EXPR>**
\| **\<ident>** (**\<expr>**+,) **\<EXPR>**
\| character'val  (**\<expr>**) **\<EXPR>**
\|  **\<entier>** I **\<caractère>** I true | false | null 
\| (**\<expr>**)
\| **\<ident>** 
\| - **\<expr>** 
\| not **\<expr>** 
\| new **\<ident>** 
\| **\<ident>** (**\<expr>**+,) 
\| character'val  (**\<expr>**) 

**\<EXPR>** ::=  . **\<ident>** **\<EXPR>**
\| **\<opérateur>** **\<expr>** **\<EXPR>**
\| . **\<ident>**
\| **\<opérateur>** **\<expr>**

**\<instr>** ::= **\<ident>** := **\<expr>**;
\|  **\<expr>** . **\<ident>** := **\<expr>**;
\| **\<ident>**;
\| **\<ident>** (**\<expr>**+,);
\| return **\<expr>**?;
\| begin **\<instr>**+ end;
\| if **\<expr>** then **\<instr>**+ (elsif **\<expr>** then **\<instr>**+)* 
(else **\<instr>**+)? end if;
\| for **\<ident>** in reverse? **\<expr>** .. **\<expr>** 
loop **\<instr>**+ end loop ;
\| while **\<expr>** loop **\<instr>**+ end loop ;

**\<opérateur>** ::= = | /= | < | <= | > | >=
\| + | - | * | / | rem
\| and | and then | or | or else


**\<ident>** ::= **\<alpha>** (**\<alpha>** | **\<chiffre>** | _ )*

**\<alpha>** ::= [a-z|A-Z]

**\<entier>** ::= **\<chiffre>**+

**\<chiffre>** ::= [0-9]

**\<caractère>** ::= '**\<ASCII>**'

**\<ASCII>** ::= SPC | ! | " | # | $ | % | & | ' | ( | ) | * | + | , | - | . | / | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | : | ; | < | = | > | ? | @ | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z | [ | \ | ] | ^ | _ | \` | a | b | c | d | e| f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | { | | | } | ~ |


La création de EXPR et le changement de quelques règles relatives a permis de dérécursiver la grammaire.

## Factorisation

## Explicitation des +*,? et priorités

**\<fichier>** = with Ada.Text_I0; use Ada.Text_I0;
procedure **\<ident>** is **\<DECL\*>**
begin **\<instr>** **\<INSTR\*>** end **\<IDENT?>** ; EOF

**\<DECL\*>** = ^ | **\<decl>** **\<DECL\*>**
**\<INSTR\*>** = ^ | **\<instr>** **\<INSTR\*>**
**\<IDENT?>** = ^ | **\<ident>**

**\<decl>** = type **\<ident>** ;
\| type **\<ident>** is access **\<ident>**;
\| type **\<ident>** is record **\<champs>** **\<CHAMPS\*>** end record ;
\| **\<ident>** **\<IDENT,*>** : **\<type>** **\<EXPR?:=>**
\| procedure **\<ident>** **\<PARAMS?>** is **\<DECL\*>**
begin **\<instr>** **\<INSTR\*>** end **\<IDENT>**
\| function **\<ident>** **\<PARAMS?>** return **\<type>** is **\<DECL\*>** 
begin **\<instr>** **\<INSTR\*>** end **\<IDENT?>**

**\<CHAMPS\*>** = ^ | **\<champs>** **\<CHAMPS\*>**
**\<IDENT,*>** = , **\<ident>** **\<IDENT,*>** | ^
**\<EXPR?:=>** = ^ | :=**\<expr>**
**\<PARAMS?>** = **\<params>** | ^

**\<champs>** = **\<ident>** **\<IDENT,*>** : **\<type>**;

**\<type>** = **\<ident>**
\| access **\<ident>**

**\<params>** = (**\<param>** **\<PARAM;*>** )

**\<PARAM;*>** = ^ | ; **\<param>** **\<PARAM;*>**

**\<param>** = **\<ident>** **\<IDENT,*>** : **\<MODE?>** **\<type>**

**\<MODE?>** = ^ | **\<mode>**

**\<mode>** = in 
\| in out

**\<expr>** = **\<exprOperateur>**

**\<exprOperateur>** =  **\<exprOperateur>** or **\<exprAnd>** |  **\<exprOperateur>** or else **\<exprAnd>** | **\<exprAnd>**

**\<exprAnd>** = **\<exprAnd>** and **\<exprNot>** | **\<exprAnd>** and then **\<exprNot>** | **\<exprNot>**

**\<exprNot>** = **\<exprNot>** not **\<exprEgal>** | **\<exprEgal>**

**\<exprEgal>** = **\<exprEgal>** = **\<exprComparaison>** | **\<exprEgal>** /= **\<exprComparaison>** | **\<exprComparaison>**

**\<exprComparaison>** = **\<exprComparaison>** > **\<exprSomme>** | **\<exprComparaison>** >= **\<exprSomme>** | **\<exprComparaison>** < **\<exprSomme>** | **\<exprComparaison>** <= **\<exprSomme>** | **\<exprSomme>**

**\<exprSomme>** = **\<exprSomme>** + **\<exprMult>** | **\<exprSomme>** - **\<exprMult>** | **\<exprMult>**

**\<exprMult>** = **\<exprMult>** * **\<exprUnaire>** | **\<exprMult>** / **\<exprUnaire>** | **\<exprMult>** rem **\<exprUnaire>** | **\<exprUnaire>**

**\<exprUnaire>** = **\<exprTerm>** | - **\<exprTerm>**

**\<exprTerm>** = **\<entier>** I **\<caractère>** I true | false | null
\| (**\<expr>**)
\| **\<accès>**
\| not **\<expr>**
\| new **\<ident>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**)
\| character' val  (**\<expr>**)


**\<EXPR,*>** = ^ | , **\<expr>** **\<EXPR,*>**

**\<instr>** = **\<accès>** := **\<expr>**;
\| **\<ident>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**);
\| return **\<EXPR?>**;
\| begin **\<instr>** **\<INSTR\*>** end
\| if **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>** 
**\<ELSE>** end if;
\| for **\<ident>** in **\<reverse?>** **\<expr>** .. **\<expr>** 
loop **\<instr>** **\<INSTR\*>** end loop ;
\| while **\<expr>** loop **\<instr>** **\<INSTR\*>** end loop ;

**\<EXPR?>** = ^ | **\<expr>**
**\<ELSIF>** = ^ | elsif **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>**
**\<ELSE>** = ^ | else **\<instr>** **\<INSTR\*>** 
**\<reverse?>** = ^ | reverse

**\<accès>** ::= **\<ident>** | **\<exprTerm>** . **\<ident>**

**\<ident>** ::= **\<alpha>** **\<IDENT>**

**\<IDENT>** = ^ | **\<alpha>** **\<IDENT>** | **\<chiffre>** **\<IDENT>** | _ **\<IDENT>**

**\<alpha>** ::= [a-z|A-Z]

**\<entier>** ::= **\<chiffre>** **\<CHIFFRE\*>**

**\<CHIFFRE\*>** = ^ | **\<chiffre>** **\<CHIFFRE\*>**

**\<chiffre>** ::= [0-9]

**\<caractère>** ::= '**\<ASCII>**'

**\<ASCII>** ::= SPC | ! | " | # | $ | % | & | ' | ( | ) | * | + | , | - | . | / | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | : | ; | < | = | > | ? | @ | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z | [ | \ | ] | ^ | _ | \` | a | b | c | d | e| f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | { | | | } | ~ |


## Gestion des priorités et associativité

**\<expr>** = **\<exprOperateur>**

**\<exprOperateur>** =  **\<exprOperateur>** or **\<exprAnd>** |  **\<exprOperateur>** or else **\<exprAnd>** | **\<exprAnd>**

**\<exprAnd>** = **\<exprAnd>** and **\<exprNot>** | **\<exprAnd>** and then **\<exprNot>** | **\<exprNot>**

**\<exprNot>** = **\<exprNot>** not **\<exprEgal>** | **\<exprEgal>**

**\<exprEgal>** = **\<exprEgal>** = **\<exprComparaison>** | **\<exprEgal>** /= **\<exprComparaison>** | **\<exprComparaison>**

**\<exprComparaison>** = **\<exprComparaison>** > **\<exprSomme>** | **\<exprComparaison>** >= **\<exprSomme>** | **\<exprComparaison>** < **\<exprSomme>** | **\<exprComparaison>** <= **\<exprSomme>** | **\<exprSomme>**

**\<exprSomme>** = **\<exprSomme>** + **\<exprMult>** | **\<exprSomme>** - **\<exprMult>** | **\<exprMult>**

**\<exprMult>** = **\<exprMult>** * **\<exprUnaire>** | **\<exprMult>** / **\<exprUnaire>** | **\<exprMult>** rem **\<exprUnaire>** | **\<exprUnaire>**

**\<exprUnaire>** = **\<exprTerm>** | - **\<exprTerm>**

**\<exprTerm>** = **\<entier>** I **\<caractère>** I true | false | null
\| (**\<expr>**)
\| **\<accès>**
\| not **\<expr>**
\| new **\<ident>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**)
\| character' val  (**\<expr>**)


**\<EXPR,*>** = ^ | , **\<expr>** **\<EXPR,*>**

**\<instr>** = **\<accès>** := **\<expr>**;
\| **\<ident>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**);
\| return **\<EXPR?>**;
\| begin **\<instr>** **\<INSTR\*>** end
\| if **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>** 
**\<ELSE>** end if;
\| for **\<ident>** in **\<reverse?>** **\<expr>** .. **\<expr>** 
loop **\<instr>** **\<INSTR\*>** end loop ;
\| while **\<expr>** loop **\<instr>** **\<INSTR\*>** end loop ;

**\<EXPR?>** = ^ | **\<expr>**
**\<ELSIF>** = ^ | elsif **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>**
**\<ELSE>** = ^ | else **\<instr>** **\<INSTR\*>** 
**\<reverse?>** = ^ | reverse

**\<accès>** ::= **\<ident>** | **\<exprTerm>** . **\<ident>**

# Dérécursivation V2 

**\<fichier>** = with Ada.Text_I0; use Ada.Text_I0;
procedure **\<ident>** is **\<DECL\*>**
begin **\<instr>** **\<INSTR\*>** end **\<IDENT?>** ; EOF

**\<DECL\*>** = ^ | **\<decl>** **\<DECL\*>**
**\<INSTR\*>** = ^ | **\<instr>** **\<INSTR\*>**
**\<IDENT?>** = ^ | **\<ident>**

**\<decl>** = type **\<ident>** ;
\| type **\<ident>** is access **\<ident>**;
\| type **\<ident>** is record **\<champs>** **\<CHAMPS\*>** end record ;
\| **\<ident>** **\<IDENT,*>** : **\<type>** **\<EXPR?:=>**
\| procedure **\<ident>** **\<PARAMS?>** is **\<DECL\*>**
begin **\<instr>** **\<INSTR\*>** end **\<IDENT>**
\| function **\<ident>** **\<PARAMS?>** return **\<type>** is **\<DECL\*>** 
begin **\<instr>** **\<INSTR\*>** end **\<IDENT?>**

**\<CHAMPS\*>** = ^ | **\<champs>** **\<CHAMPS\*>**
**\<IDENT,*>** = , **\<ident>** **\<IDENT,*>** | ^
**\<EXPR?:=>** = ^ | :=**\<expr>**
**\<PARAMS?>** = **\<params>** | ^

**\<champs>** = **\<ident>** **\<IDENT,*>** : **\<type>**;

**\<type>** = **\<ident>**
\| access **\<ident>**

**\<params>** = (**\<param>** **\<PARAM;*>** )

**\<PARAM;*>** = ^ | ; **\<param>** **\<PARAM;*>**

**\<param>** = **\<ident>** **\<IDENT,*>** : **\<MODE?>** **\<type>**

**\<MODE?>** = ^ | **\<mode>**

**\<mode>** = in 
\| in out

**\<expr>** = **\<exprOperateur>**

**\<exprOperateur>** =  **\<exprAnd>** **\<EXPROPERATEUR>**

**\<EXPROPERATEUR>** = or **\<exprAnd>** **\<EXPROPERATEUR>** | or else **\<exprAnd>** **\<EXPROPERATEUR>** | ^

**\<exprAnd>** = **\<exprNot>** **\<EXPRAND>**

**\<EXPRAND>** = and **\<exprNot>** **\<EXPRAND>** | and then **\<exprNot>** **\<EXPRAND>** | ^

**\<exprNot>** = **\<exprEgal>** **\<EXPRNOT>**

**\<EXPRNOT>** = not **\<exprEgal>** **\<EXPRNOT>** | ^

**\<exprEgal>** = **\<exprComparaison>** **\<EXPREGAL>**

**\<EXPREGAL>** = = **\<exprComparaison>** **\<EXPREGAL>**| /= **\<exprComparaison>** **\<EXPREGAL>** | ^

**\<exprComparaison>** =**\<exprSomme>** **\<EXPRCOMPARAISON>**

**\<EXPRCOMPARAISON>** = > **\<exprSomme>** **\<EXPRCOMPARAISON>** | >= **\<exprSomme>** **\<EXPRCOMPARAISON>** | < **\<exprSomme>** **\<EXPRCOMPARAISON>** | <= **\<exprSomme>** **\<EXPRCOMPARAISON>**  | ^

**\<exprSomme>** = **\<exprMult>** **\<EXPRSOMME>**

**\<EXPRSOMME>** = + **\<exprMult>** **\<EXPRSOMME>** | - **\<exprMult>** **\<EXPRSOMME>** | ^

**\<exprMult>** = **\<exprUnaire>** **\<EXPRMULT>** 

**\<EXPRMULT>** = * **\<exprUnaire>** **\<EXPRMULT>** | / **\<exprUnaire>** **\<EXPRMULT>** | rem **\<exprUnaire>** **\<EXPRMULT>** | ^
 
**\<exprUnaire>** = **\<exprTerm>** | - **\<exprTerm>**

**\<exprTerm>** = **\<entier>** **\<EXPRTERM>** 
\| **\<caractère>** **\<EXPRTERM>**  
\| true **\<EXPRTERM>**
\| false **\<EXPRTERM>**
\| null **\<EXPRTERM>**
\| (**\<expr>**) **\<EXPRTERM>**
\| **\<ident>** **\<EXPRTERM>**
\| not **\<expr>** **\<EXPRTERM>**
\| new **\<ident>** **\<EXPRTERM>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**) **\<EXPRTERM>**
\| character' val  (**\<expr>**) **\<EXPRTERM>**


**\<EXPRTERM>** = . **\<ident>** **\<EXPRTERM>** | ^

**\<EXPR,*>** = ^ | , **\<expr>** **\<EXPR,*>**

**\<instr>** = **\<ident>**  := **\<expr>**;
\|  **\<exprTerm>** . **\<ident>** := **\<expr>**;
\| **\<ident>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**);
\| return **\<EXPR?>**;
\| begin **\<instr>** **\<INSTR\*>** end
\| if **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>** 
**\<ELSE>** end if;
\| for **\<ident>** in **\<reverse?>** **\<expr>** .. **\<expr>** 
loop **\<instr>** **\<INSTR\*>** end loop ;
\| while **\<expr>** loop **\<instr>** **\<INSTR\*>** end loop ;

**\<EXPR?>** = ^ | **\<expr>**
**\<ELSIF>** = ^ | elsif **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>**
**\<ELSE>** = ^ | else **\<instr>** **\<INSTR\*>** 
**\<reverse?>** = ^ | reverse

**\<ident>** ::= **\<alpha>** **\<IDENT>**

**\<IDENT>** = ^ | **\<alpha>** **\<IDENT>** | **\<chiffre>** **\<IDENT>** | _ **\<IDENT>**

**\<alpha>** ::= [a-z|A-Z]

**\<entier>** ::= **\<chiffre>** **\<CHIFFRE\*>**

**\<CHIFFRE\*>** = ^ | **\<chiffre>** **\<CHIFFRE\*>**

**\<chiffre>** ::= [0-9]

**\<caractère>** ::= '**\<ASCII>**'

**\<ASCII>** ::= SPC | ! | " | # | $ | % | & | ' | ( | ) | * | + | , | - | . | / | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | : | ; | < | = | > | ? | @ | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z | [ | \ | ] | ^ | _ | \` | a | b | c | d | e| f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | { | | | } | ~ |


# Réduction Supérieure



![RéductionSupérieure.png](../_resources/RéductionSupérieure-1.png)

Tous les non terminaux sont bien accessibles depuis fichier.


# Réduction Inférieure

E0 = ∅

E1 = {mode , alpha , chiffre , ASCII , reverse?}

E2 = {caractère , CHIFFRE* , IDENT , MODE?} U E1

E3 = {entier , ident , exprTerm} U E2

E4 = {accès , instr , exprUnaire , type , IDENT,* , decl , IDENT?} U E3

E5 = {EXPRMULT , param , champs , INSTR* , DECL*} U E4

E6 = {ELSE , exprMult , PARAM;* , CHAMPS* , fichier} U E5

E7 = {EXPRSOMME , params} U E6

E8 = {exprSomme , PARAMS?} U E7

E9 = {EXPRCOMPARAISON} U E8

E10 = {exprComparaison} U E9

E11 = {EXPREGAL} U E10

E12 = {exprEgal} U E11

E13 = {EXPRNOT} U E12

E14 = {exprNot} U E13

E15 = {EXPRAND} U E14

E16 = {exprAnd} U E15

E17 = {EXPROPERATEUR} U E16

E18 = {exprOperateur} U E17

E19 = {expr} U E18

E20 = {EXPR?:= , EXPR,* , EXPR? , ELSIF} U E19


On obtient également tous les non terminaux.

# Factorisation gauche 


**\<fichier>** = with Ada.Text_I0; use Ada.Text_I0;
procedure **\<ident>** is **\<DECL\*>**
begin **\<instr>** **\<INSTR\*>** end **\<IDENT?>** ; EOF

**\<DECL\*>** = ^ | **\<decl>** **\<DECL\*>**
**\<INSTR\*>** = ^ | **\<instr>** **\<INSTR\*>**
**\<IDENT?>** = ^ | **\<ident>**

**\<decl>** = type **\<ident>** A
\| **\<ident>** **\<IDENT,*>** : **\<type>** **\<EXPR?:=>**
\| procedure **\<ident>** **\<PARAMS?>** is **\<DECL\*>**
begin **\<instr>** **\<INSTR\*>** end **\<IDENT>**
\| function **\<ident>** **\<PARAMS?>** return **\<type>** is **\<DECL\*>** 
begin **\<instr>** **\<INSTR\*>** end **\<IDENT?>**

A = ; | is B

B = access **\<ident>**; | record **\<champs>** **\<CHAMPS\*>** end record ;

**\<CHAMPS\*>** = ^ | **\<champs>** **\<CHAMPS\*>**
**\<IDENT,*>** = , **\<ident>** **\<IDENT,*>** | ^
**\<EXPR?:=>** = ^ | :=**\<expr>**
**\<PARAMS?>** = **\<params>** | ^

**\<champs>** = **\<ident>** **\<IDENT,*>** : **\<type>**;

**\<type>** = **\<ident>**
\| access **\<ident>**

**\<params>** = (**\<param>** **\<PARAM;*>** )

**\<PARAM;*>** = ^ | ; **\<param>** **\<PARAM;*>**

**\<param>** = **\<ident>** **\<IDENT,*>** : **\<MODE?>** **\<type>**

**\<MODE?>** = ^ | **\<mode>**

**\<mode>** = in C

C = ^| out 

**\<expr>** = **\<exprOperateur>**

**\<exprOperateur>** =  **\<exprAnd>** **\<EXPROPERATEUR>**

**\<EXPROPERATEUR>** = or D | ^

D = **\<exprAnd>** **\<EXPROPERATEUR>** | else **\<exprAnd>** **\<EXPROPERATEUR>**

**\<exprAnd>** = **\<exprNot>** **\<EXPRAND>**

**\<EXPRAND>** = and E | ^

E = **\<exprNot>** **\<EXPRAND>** | then **\<exprNot>** **\<EXPRAND>**

**\<exprNot>** = **\<exprEgal>** **\<EXPRNOT>**

**\<EXPRNOT>** = not **\<exprEgal>** **\<EXPRNOT>** | ^

**\<exprEgal>** = **\<exprComparaison>** **\<EXPREGAL>**

**\<EXPREGAL>** = = **\<exprComparaison>** **\<EXPREGAL>**| /= **\<exprComparaison>** **\<EXPREGAL>** | ^

**\<exprComparaison>** =**\<exprSomme>** **\<EXPRCOMPARAISON>**

**\<EXPRCOMPARAISON>** = > **\<exprSomme>** **\<EXPRCOMPARAISON>** | >= **\<exprSomme>** **\<EXPRCOMPARAISON>** | < **\<exprSomme>** **\<EXPRCOMPARAISON>** | <= **\<exprSomme>** **\<EXPRCOMPARAISON>**  | ^

**\<exprSomme>** = **\<exprMult>** **\<EXPRSOMME>**

**\<EXPRSOMME>** = + **\<exprMult>** **\<EXPRSOMME>** | - **\<exprMult>** **\<EXPRSOMME>** | ^

**\<exprMult>** = **\<exprUnaire>** **\<EXPRMULT>** 

**\<EXPRMULT>** = * **\<exprUnaire>** **\<EXPRMULT>** | / **\<exprUnaire>** **\<EXPRMULT>** | rem **\<exprUnaire>** **\<EXPRMULT>** | ^
 
**\<exprUnaire>** = **\<exprTerm>** | - **\<exprTerm>**

**\<exprTerm>** = **\<entier>** **\<EXPRTERM>** 
\| **\<caractère>** **\<EXPRTERM>**  
\| true **\<EXPRTERM>**
\| false **\<EXPRTERM>**
\| null **\<EXPRTERM>**
\| (**\<expr>**) **\<EXPRTERM>**
\| **\<ident>** **\<EXPRTERM>**
\| not **\<expr>** **\<EXPRTERM>**
\| new **\<ident>** **\<EXPRTERM>**
\| **\<ident>** (**\<expr>** **\<EXPR,*>**) **\<EXPRTERM>**
\| character' val  (**\<expr>**) **\<EXPRTERM>**


**\<EXPRTERM>** = . **\<ident>** **\<EXPRTERM>** | ^

**\<EXPR,*>** = ^ | , **\<expr>** **\<EXPR,*>**

**\<instr>** = **\<ident>**  F
\|  **\<exprTerm>** . **\<ident>** := **\<expr>**;
\| return **\<EXPR?>**;
\| begin **\<instr>** **\<INSTR\*>** end
\| if **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>** 
**\<ELSE>** end if;
\| for **\<ident>** in **\<reverse?>** **\<expr>** .. **\<expr>** 
loop **\<instr>** **\<INSTR\*>** end loop ;
\| while **\<expr>** loop **\<instr>** **\<INSTR\*>** end loop ;

F = := **\<expr>**; | ^ | (**\<expr>** **\<EXPR,*>**);

**\<EXPR?>** = ^ | **\<expr>**
**\<ELSIF>** = ^ | elsif **\<expr>** then **\<instr>** **\<INSTR\*>** **\<ELSIF>**
**\<ELSE>** = ^ | else **\<instr>** **\<INSTR\*>** 
**\<reverse?>** = ^ | reverse

**\<ident>** ::= **\<alpha>** **\<IDENT>**

**\<IDENT>** = ^ | **\<alpha>** **\<IDENT>** | **\<chiffre>** **\<IDENT>** | _ **\<IDENT>**

**\<alpha>** ::= [a-z|A-Z]

**\<entier>** ::= **\<chiffre>** **\<CHIFFRE\*>**

**\<CHIFFRE\*>** = ^ | **\<chiffre>** **\<CHIFFRE\*>**

**\<chiffre>** ::= [0-9]

**\<caractère>** ::= '**\<ASCII>**'

**\<ASCII>** ::= SPC | ! | " | # | $ | % | & | ' | ( | ) | * | + | , | - | . | / | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | : | ; | < | = | > | ? | @ | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z | [ | \ | ] | ^ | _ | \` | a | b | c | d | e| f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z | { | | | } | ~ |


# Mofif adaptation site pour génération de la table

fichier ::= with Ada.Text_IO; use Ada.Text_IO; procedure ident is DECL* begin instr INSTR* end IDENT? ; EOF

DECL* ::= ^ 
DECL* ::= decl DECL*
INSTR* ::= ^ 
INSTR* ::= instr INSTR*
IDENT? ::= ^ 
IDENT? ::= ident

decl ::= type ident A1
decl ::= ident IDENT,* : TYPE EXPR?:=
decl ::= procedure ident PARAMS? is DECL* begin instr INSTR* end IDENT
decl ::= function ident PARAMS? return TYPE is DECL* begin instr INSTR* end IDENT?

A1 ::= ; 
A1 ::= is B1

B1 ::= access ident; 
B1 ::= record champs CHAMPS* end record ;

CHAMPS* ::= ^ 
CHAMPS* ::= champs CHAMPS*
IDENT,* ::= , ident IDENT,* 
IDENT,* ::= ^
EXPR?:= ::= ^ 
EXPR?:= ::= :=expr
PARAMS? ::= params 
PARAMS? ::= ^

champs ::= ident IDENT,* : TYPE ;

TYPE ::= ident
TYPE ::= access ident

params ::= ( param PARAM;* )

PARAM;* ::= ^ 
PARAM;* ::= ; param PARAM;*

param ::= ident IDENT,* : MODE? TYPE

MODE? ::= ^ 
MODE? ::= mode

mode ::= in C

C1 ::= ^
C1 ::= out

expr ::= exprOperateur

exprOperateur ::= exprAnd EXPROPERATEUR

EXPROPERATEUR ::= or D1 
EXPROPERATEUR ::= ^

D1 ::= exprAnd EXPROPERATEUR 
D1 ::= else exprAnd EXPROPERATEUR

exprAnd ::= exprNot EXPRAND

EXPRAND ::= and E1 
EXPRAND ::= ^

E1 ::= exprNot EXPRAND 
E1 ::= then exprNot EXPRAND

exprNot ::= exprEgal EXPRNOT

EXPRNOT ::= not exprEgal EXPRNOT 
EXPRNOT ::= ^

exprEgal ::= exprComparaison EXPREGAL

EXPREGAL ::= = exprComparaison EXPREGAL
EXPREGAL ::= /= exprComparaison EXPREGAL 
EXPREGAL ::= ^

exprComparaison ::= exprSomme EXPRCOMPARAISON

EXPRCOMPARAISON ::= > exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= >= exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= < exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= <= exprSomme EXPRCOMPARAISON 
EXPRCOMPARAISON ::= ^

exprSomme ::= exprMult EXPRSOMME

EXPRSOMME ::= + exprMult EXPRSOMME 
EXPRSOMME ::= - exprMult EXPRSOMME 
EXPRSOMME ::= ^

exprMult ::= exprUnaire EXPRMULT

EXPRMULT ::= * exprUnaire EXPRMULT 
EXPRMULT ::= / exprUnaire EXPRMULT 
EXPRMULT ::= rem exprUnaire EXPRMULT 
EXPRMULT ::= ^

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
EXPRTERM ::= ^

EXPR,* ::= ^ 
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
H1 ::= ^ J1
H1 ::= ( expr EXPR,* ) I1
H1 ::= . ident EXPRTERM . ident := expr ;

I1 ::= ;
I1 ::= EXPRTERM . ident := expr ;

J1 ::= ^
J1 ::= . ident := expr ;


EXPR? ::= ^ 
EXPR? ::= expr
ELSIF ::= ^ 
ELSIF ::= elsif expr then instr INSTR* ELSIF
ELSE ::= ^ 
ELSE ::= else instr INSTR*
reverse? ::= ^ 
reverse? ::= reverse

ident ::= alpha IDENT

IDENT ::= ^ 
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

CHIFFRE* ::= ^ 
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