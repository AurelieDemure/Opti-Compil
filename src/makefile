all :
	find . -name *.java | xargs javac -d .run

tests :
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_work.txt
	java -classpath .run lexer/TestLexer < lexer/tests/test_folders/test_onknown_char.txt
	java -classpath .run lexer/TestError
clean :
	find . -name *.class -delete
