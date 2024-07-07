#Lexical and Syntax Analysis Exercise 3
import lex

next_token=''
lexeme=''

def expr():
    global next_token
    global lexeme
    print("Enter <expr>")
    term()
    while next_token==lex.ADD_OP or next_token==lex.SUB_OP:
        token_tuple=lex.lex()
        lexeme=token_tuple[0]
        next_token=token_tuple[1]
        term()
    print("Exit <expr>")

def term():
    global next_token
    global lexeme
    print("Enter <term>")
    factor()
    while next_token==lex.MULT_OP or next_token==lex.DIV_OP:
        token_tuple=lex.lex()
        lexeme=token_tuple[0]
        next_token=token_tuple[1]
        factor()
    print("Exit <term>")

def factor():
    global next_token
    global lexeme
    print("Enter <factor>")
    if next_token==lex.IDENT or next_token==lex.INT_LIT or next_token==lex.FLOAT_LIT or next_token==lex.WHILE:
        print(lexeme)
        token_tuple=lex.lex()
        lexeme=token_tuple[0]
        next_token=token_tuple[1]
        print("Exit <factor>")
    elif next_token==lex.LEFT_PAREN:
        token_tuple=lex.lex()
        lexeme=token_tuple[0]
        next_token=token_tuple[1]
        expr()
        if next_token==lex.RIGHT_PAREN:
            next_token=lex.lex()[1]
        else:
            print("Missing right parenthesis!")
            exit(1)
        print("Exit <factor>")
    elif next_token==lex.RIGHT_PAREN:
        print("Missing left paranthesis!")
        exit(1)
    else:
        print("Invalid factor literal!")
        exit(1)
    print("Exit <factor>")

def main():
    global next_token
    global lexeme
    input_file=open("parse_tester.txt", 'r')
    lex.input_file=input_file
    lex.get_char()
    next_token=lex.lex()[1]
    expr()
    if next_token!=lex.EOF:
        print("Problem during parsing!")
        exit(1)
    input_file.close()

if __name__=='__main__':
    main()


