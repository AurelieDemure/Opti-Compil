all :
	find . -name *.java | xargs javac -d .run

test :
	java -classpath .run tests.TestLexer < tests/test_folders/test_work.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_identificateur.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_symboles.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_caractere.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_entier.txt
	java -classpath .run tests.TestError

testError :
	java -classpath .run tests.TestError

testlexer :
	java -classpath .run tests.TestLexer < tests/test_folders/test_work.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaSujet.txt

testIdent : 
	java -classpath .run tests.TestLexer < tests/test_folders/test_identificateur.txt

test_symboles : 
	java -classpath .run tests.TestLexer < tests/test_folders/test_symboles.txt
	
testsCaractere :
	java -classpath .run tests.TestLexer < tests/test_folders/test_caractere.txt

testEntier :
	java -classpath .run tests.TestLexer < tests/test_folders/test_entier.txt

clean :
	find . -name *.class -delete
