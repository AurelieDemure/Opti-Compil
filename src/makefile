all :
	find . -name *.java | xargs javac -d .run

tests :
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/tests_work.txt
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_unknown_char.txt
	java -classpath .run lexer/TestError
clean :
	find . -name *.class -delete
