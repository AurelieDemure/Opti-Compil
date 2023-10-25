all :
	javac lexer/Tag.java
	javac lexer/Token.java
	javac lexer/Mots.java
	javac lexer/Entier.java
	javac lexer/Lexer.java
	javac lexer/TestLexer.java

tests :
	java lexer/TestLexer < lexer/test_folders/test_work.txt
	java lexer/TestLexer < lexer/test_folders/test_unknow_char.txt
clean :
	rm -f lexer/*.class
