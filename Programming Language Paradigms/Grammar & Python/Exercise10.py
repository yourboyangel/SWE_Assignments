from typing import List
def findRepeatedDnaSequence(s: str)->List[str]:
    seen=set()
    reoccuring=set()

    for i in range(len(s)):
        sequence=s[i:i+10]
        if sequence not in seen:
            seen.add(sequence)
        else:
            reoccuring.add(sequence)
    
    return reoccuring

def main():
    s=input("Enter a DNA Sequence: ")
    print(findRepeatedDnaSequence(s))

if __name__=="__main__":
    main()
