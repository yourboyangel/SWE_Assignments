def lengthOfLongestSubstring(s: str)->int:
    array=[]
    counter_array=[]
    cnt=0

    for c in s:
        if c not in array:
            array.append(c)
            cnt+=1
        else: 
            array.clear()
            array.append(c)
            counter_array.append(cnt)
            cnt=1
    max_cnt=0
    
    for i in range(len(counter_array)):
        if counter_array[i]>=max_cnt:
            max_cnt=counter_array[i]

    return max_cnt

def main():
    s=input("Enter a string:")
    print(lengthOfLongestSubstring(s))

if __name__=="__main__":
    main()



            
