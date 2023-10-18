JC =javac

all: lexer/lexer.java

lexer : lexer/lexer.java

clean:\
	rm -f *.class