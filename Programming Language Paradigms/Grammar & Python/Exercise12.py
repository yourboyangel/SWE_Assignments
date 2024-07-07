def representative(numbers):
    s=sum(numbers)
    avg=s/10

    smallest_diff=float("inf")
    rep=None

    for number in numbers:
        difference=abs(number-avg)
        if difference < smallest_diff:
            smallest_diff=difference
            rep=number

    return rep

def main():
    numbers=[]
    numbers=[float(i) for i in input("Enter 10 numbers: ").split()]

    print(representative(numbers))

if __name__=="__main__":
    main()





