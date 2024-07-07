def shift(digits):
    while digits[0]==0 and len(digits)>1:
        digits.pop(0)
    return digits
    
def decrement(digits):
    last=len(digits)-1
    check=True
    if digits[last]==0:
        for i in range(last,-1,-1):
            if (digits[i]==0 and check) or digits[i]==-1:
                digits[i]=9
                digits[i-1]-=1
                if(digits[i-1]==0):
                    check=False
    else:
        digits[last]-=1
            
    digits=shift(digits)
    return digits

def main():
    digits=input().split()
    digits=[int(digit) for digit in digits]
    digits=decrement(digits)
    print("[", end=' ')
    for i in digits:
        print(i,end=' ')
    print("]",end=' ')

if __name__=="__main__":
    main()



        
       
                
            


            

            
            

        