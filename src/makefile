all :
	find . -name *.java | xargs javac -d .run

opticompil :
	java -classpath .run compilateur.OptiCompil

test :
	java -classpath .run tests.TestLexer < tests/test_folders/test_lexer.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_identificateur.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_symboles.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_caractere.txt
	java -classpath .run tests.TestLexer < tests/test_folders/test_entier.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaSujet.txt
	java -classpath .run tests.TestLexer < tests/test_folders/canAdaErreur.txt
	java -classpath .run tests.TestError
	java -classpath .run tests.TestTableAnalyse

testError :
	java -classpath .run tests.TestError

testAbstractTree :
	java -classpath .run tests.TestAbstractTree

testTableAnalyse :
	java -classpath .run tests.TestTableAnalyse

testParser :
	java -classpath .run tests.TestParseur < tests/test_folders/test_parser.txt
	java -classpath .run tests.TestParseur < tests/test_folders/test_parser2.txt
	java -classpath .run tests.TestParseur < tests/test_folders/test_parser3.txt
	java -classpath .run tests.TestParseur < tests/test_folders/test_parser4.txt

testParserTree :
	java -classpath .run tests.TestParseurTree < tests/test_folders/canAdaSujet.txt
	java -classpath .run tests.TestParseurTree < tests/test_folders/canAdaErreur.txt
	java -classpath .run tests.TestParseurTree < tests/test_folders/canAdaTest1.txt

testFonctionsSemantiques :
	java -classpath .run tests.TestFonctionsSemantiques < tests/test_folders/canAdaTest1.txt

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
