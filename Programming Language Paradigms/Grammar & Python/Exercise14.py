def fraction_as_decimal(m,n):
    full_part=m//n
    remainder=m%n
    decimal_part=''
    seen={}

    while remainder !=0:
        if remainder in seen:
            decimal_part=decimal_part[:seen[remainder]]+"("+decimal_part[seen[remainder]:]+")"
            break
        seen[remainder]=len(decimal_part)
        a=remainder*10//n
        decimal_part=decimal_part+str(a)
        remainder=remainder* 10 %n

    if decimal_part:
        return f"{full_part}.{decimal_part}"
    else:
        return str(full_part)
    
    

def main():
    print(fraction_as_decimal(-50,8))
    print(fraction_as_decimal(25,9))
    print(fraction_as_decimal(19,12))
    print(fraction_as_decimal(400,99))
    print(fraction_as_decimal(1,28))
    

if __name__=="__main__":
     main()

        

        


