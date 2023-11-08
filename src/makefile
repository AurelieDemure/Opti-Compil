all :
	find . -name *.java | xargs javac -d .run

tests :
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_work.txt
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_identificateur.txt
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_symboles.txt
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_caractere.txt
	java -classpath .run lexer/TestError

testError :
	java -classpath .run lexer/TestError

testlexer :
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_work.txt
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_unknown_char.txt

testIdent : 
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_identificateur.txt

test_symboles : 
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_symboles.txt
	
testsCaractere :
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_caractere.txt

clean :
	find . -name *.class -delete
