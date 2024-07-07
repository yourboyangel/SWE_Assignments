# Lexical and Syntax Analysis Exercises 1,2 and 3
import sys
'''
A lexical analyzer for simple arithmetic expressions
To run this script: python lex.py filepath
'''

input_file = "program.txt"
char_class = None
next_char = None


# character classes
LETTER = 0
DIGIT = 1
UNKNOWN = 2
FLOAT = 3


# tokens
INT_LIT = 'int literal'
IDENT = 'identifier'
ASSIGN_OP = 'assign operator'
ADD_OP = 'add operator'
SUB_OP = 'subtract operator'
MULT_OP = 'multiply operator'
DIV_OP = 'divide operator'
LEFT_PAREN = 'left parentheses'
RIGHT_PAREN = 'right parentheses'
EOF = 'EOF'
FLOAT_LIT = 'floating-point literal'
RIGHT_COMMENT='right comment sign'
LEFT_COMMENT='left comment sign'
SINGLE_COMMENT='single-line comment'
WHILE='while statement'

# lookup
LOOKUP_TABLE = {
    '(': LEFT_PAREN,
    ')': RIGHT_PAREN,
    '+': ADD_OP,
    '-': SUB_OP,
    '*': MULT_OP,
    '/': DIV_OP,
}

def get_char():
    global next_char
    global char_class
    next_char = input_file.read(1)
    if next_char != '':
        if next_char.isalpha():
            char_class = LETTER
        elif next_char.isdigit() or next_char=='.':
            char_class = DIGIT if next_char.isdigit() else FLOAT
        elif next_char == '.':
            char_class = FLOAT
        else:
            char_class = UNKNOWN
    else:
        char_class = EOF


def lex():
    next_token=None
    lexeme = ''
    # get next non blank
    while next_char.isspace():
        get_char()
    # parse identifiers
    if char_class == LETTER:
        lexeme += next_char # add char
        get_char()
        while char_class == LETTER or char_class == DIGIT:
            lexeme += next_char
            get_char()
        next_token = IDENT
        if lexeme=='while':
            next_token=WHILE
    elif char_class == DIGIT:
        while char_class==DIGIT and next_char != '.':
            lexeme += next_char
            get_char()
        if next_char=='.':
            lexeme+=next_char
            get_char()
            while char_class==DIGIT:
                lexeme+=next_char
                get_char()
            next_token=FLOAT_LIT
        else:
            next_token=INT_LIT


    elif char_class == UNKNOWN:
        if next_char=='/':
            lexeme+=next_char
            get_char()
            if next_char=='*':
                lexeme+=next_char
                next_token=LEFT_COMMENT
                get_char()
            elif next_char=='/':
                lexeme+=next_char
                next_token=SINGLE_COMMENT
                get_char()
            else:
                next_token=DIV_OP
        elif next_char=='*':
            lexeme+=next_char
            get_char()
            if next_char=='/':
                lexeme+=next_char
                next_token=RIGHT_COMMENT
                get_char()
            else:
                next_token=MULT_OP
        else:
            next_token = LOOKUP_TABLE.get(next_char, EOF)
            lexeme += next_char
            get_char() 
        
            
    elif char_class == EOF:
        next_token = EOF
        lexeme = EOF
    return (lexeme, next_token)

if __name__ == '__main__':
    input_file = open(input_file, 'r')
    get_char()
    while True: # do ... while next token is EOF
        lexeme, token = lex()
        print(f'Next token is: {token}, Next lexeme is {lexeme}')
        if token == EOF:
            break

