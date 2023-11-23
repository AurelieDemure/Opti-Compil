all :
	find . -name *.java | xargs javac -d .run

test :
	java -classpath .run tests.TestLexer < tests/test_folders/test_lexer.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_identificateur.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_symboles.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_caractere.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_entier.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaSujet.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaErreur.txt
	java -classpath .run tests.TestError
	java -classpath .run testTableAnalyse

testError :
	java -classpath .run tests.TestError

testTableAnalyse :
	java -classpath .run testTableAnalyse

testLexer :
	java -classpath .run tests.TestLexer < tests/test_folders/test_lexer.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaSujet.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaErreur.txt

testIdent : 
	java -classpath .run tests.TestLexer < tests/test_folders/test_identificateur.txt

testSymbole : 
	java -classpath .run tests.TestLexer < tests/test_folders/test_symboles.txt
	
testCaractere :
	java -classpath .run tests.TestLexer < tests/test_folders/test_caractere.txt

testEntier :
	java -classpath .run tests.TestLexer < tests/test_folders/test_entier.txt

clean :
	find . -name *.class -delete
