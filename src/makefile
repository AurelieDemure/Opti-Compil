all :
	javac lexer/Tag.java
	javac lexer/Token.java
	javac lexer/Mots.java
	javac lexer/Entier.java
	javac lexer/Lexer.java
	javac lexer/TestLexer.java
	javac lexer/Error.java
	javac lexer/TestError.java

tests :
	java lexer/TestLexer < lexer/test_folders/test_work.txt
	java lexer/TestLexer < lexer/test_folders/test_unknow_char.txt
	java lexer/TestError
clean :
	rm -f lexer/*.class
