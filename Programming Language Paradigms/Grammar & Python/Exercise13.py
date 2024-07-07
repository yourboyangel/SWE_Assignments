import math
def value_of_function(n):
    result=0
    for i in range(n,0,-1):
        result=math.sqrt(i**3+result)

    return result

def main():
    n=int(input("Enter a number: "))
    function=value_of_function(n)
    formatted_function=f"{function:.3f}"
    print(formatted_function)
    
if __name__=="__main__":
    main()