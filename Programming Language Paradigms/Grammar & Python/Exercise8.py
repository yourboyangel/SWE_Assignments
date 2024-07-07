from typing import List
import math

def imageSmoother(img: List[List[int]])->List[List[int]]:
    m=len(img)
    n=len(img[0])
    smoothed_img=[[0]*n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            sum=0
            cnt=0
            for x in range(max(0,i-1),min(m,i+2)):
                for y in range(max(0,j-1),min(n,j+2)):
                    sum+=img[x][y]
                    cnt+=1
            smoothed_img[i][j]=sum//cnt
    return smoothed_img



            
def main():
    m=int(input("Enter number of rows: "))
    n=int(input("Enter the number of columns: "))

    img=[]

    for i in range(m):
        row_input=input()
        value=list(map(int,row_input.split()))
        img.append(value)

    smoothed_image=imageSmoother(img)
    for row in smoothed_image:
        print(row)

if __name__=="__main__":
    main()
            
    

