# PS: I did some internet research and modifed the structure of the Y function as the definition in the pdf was causing an infinite loop
Y = (lambda y: (lambda x: y(lambda v: x(x)(v))) (lambda x: y(lambda v: x(x)(v))))
SUM= Y(lambda x: lambda n: 0 if n==0 else n+x(n-1))

def main():
    print(SUM(3))

if __name__=='__main__':
    main()

