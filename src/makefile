all :
	find . -name *.java | xargs javac -d .run -Xlint:unchecked

tests :
	java /.run/lexer/TestLexer < lexer/tests/test_folders/test_work.txt
	java /.run/lexer/TestLexer < lexer/tests/test_folders/test_unknow_char.txt
	java /.run/lexer/TestError
clean :
	find . -name *.class -delete
