all :
	find . -name *.java | xargs javac -d .run

tests :
	java -classpath .run TestLexer < tests/test_folders/test_work.txt
	java -classpath .run TestLexer < tests/test_folders/test_identificateur.txt
	java -classpath .run TestLexer < tests/test_folders/test_symboles.txt
	java -classpath .run TestLexer < tests/test_folders/test_caractere.txt
	java -classpath .run TestError

testError :
	java -classpath .run TestError

testlexer :
	java -classpath .run TestLexer < tests/test_folders/test_work.txt
	java -classpath .run TestLexer < tests/test_folders/test_unknown_char.txt

testparser :
	java -classpath .run TestParseur 

testTableAnalyse :
	java -classpath .run testTableAnalyse

testIdent : 
	java -classpath .run TestLexer < tests/test_folders/test_identificateur.txt

test_symboles : 
	java -classpath .run TestLexer < tests/test_folders/test_symboles.txt
	
testsCaractere :
	java -classpath .run TestLexer < tests/test_folders/test_caractere.txt

clean :
	find . -name *.class -delete
