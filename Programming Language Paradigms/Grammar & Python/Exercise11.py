def classify(n):
    sum=0
    for i in range(1,n):
        if n%i==0:
            sum+=i
    
    if sum==n:
        return "perfect"
    elif sum<n:
        return "deficient"
    else:
        return "abundant"
    
def main():
    n=int(input("Enter a number:"))
    print(f"The number {n} is {classify(n)}.")

if __name__=="__main__":
    main()

            
   
    