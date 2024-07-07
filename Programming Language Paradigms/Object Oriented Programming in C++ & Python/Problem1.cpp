#include <iostream>
#include <cstring>

using namespace std;

class String {
private:
    char* str;
    int* strCount;
public:
    String(): str(nullptr), strCount(nullptr){}
    String(const char* s){
        str=new char[strlen(s)+1];
        strcpy(str,s);
        strCount=new int(1);
    }
    
    String(const String& s2): str(s2.str), strCount(s2.strCount){
        if(strCount){
            (*strCount)++;
        }
    }
    ~String(){
        if(strCount && --(*strCount)==0){
            delete[] str;
            delete strCount;
        }
    }

    String operator + (const String s2) const {
        char* temp=new char[strlen(str)+strlen(s2.str)+1];
        strcpy(temp,str);
        strcat(temp,s2.str);
        String tempString(temp);
        delete[] temp;
        return tempString;
    }

    bool operator == (String s2) const {
        return strcmp(str, s2.str) == 0;
    }

    bool operator < (String s2) const {
        return strcmp(str, s2.str) < 0;
    }

    bool operator > (String s2) const {
        return strcmp(str, s2.str) > 0;
    }

    char operator [] (int i) {
        if (i < 0 || i >= strlen(str)) {
            cout << "Index out of bounds"<<endl;
            exit(1);
        }
        return str[i];
    }

    void display() {
        cout << str << " (mem = " << &str << ")" << endl;
    }

    explicit operator char*() {
        return str;
    }

    String assignLeftMost(String s2, int n)const{
        String temp;
        temp.str=new char[n+1];
        for(int i=0; i<n; i++){
            temp.str[i]=s2.str[i];
        }
        temp.str[n]='\0';
        return temp;
    }

    String assignRightMost(String s2, int n)const{
        String temp;
        temp.str=new char[n+1];
        int length=strlen(s2.str)-n;
        int j=0;
        for(int i=length; i<strlen(s2.str) ;i++){
            temp.str[j]=s2.str[i];
            j++;
        }
        temp.str[n]='\0';
        return temp;
    }

    String assignMid(String s2, int n1, int n2)const{
        if(n1<0 || n2<n1 || n2>=strlen(s2.str)){
            cout<<"The indexes are not meaningful!"<<endl;
            exit(1);
        }
        String temp;
        temp.str=new char[n2-n1+1];
        n1--;
        int j=0;
        int i=n1-1;
        for(int i=n1;i<n2;i++){
            temp.str[j]=s2.str[i];
            j++;
        }
        temp.str[j]='\0';
        return temp;
    }

};


int main() {
    char s0[] = "Hello";
    String s1 = s0;
    String s2 = " World";
    String s3 = s1 + s2;
    s3.display();
    String s4 = "Hello World";
    cout << (s3 == s4) << endl;
    cout << s3[1] << endl;
    char* s6 = static_cast<char*>(s1);
    cout << s6 << endl;
    String s7 = s4;
    s4.display();
    s7.display();

    String s8("Engjell");
    String s9("Abazaj");

    String left=s8.assignLeftMost(s9,3);
    String right=s8.assignRightMost(s9,4);
    String middle=s8.assignMid(s9,2,4);
    

    left.display();
    right.display();
    middle.display();

    
    return 0;
}