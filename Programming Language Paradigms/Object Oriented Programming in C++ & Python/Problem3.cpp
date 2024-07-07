#include <iostream>
using namespace std;

class Stack{
    public:
        virtual void pop()=0;
        virtual void push(int value)=0;
        virtual bool is_empty()=0;
};

class ArrayStack: public Stack{
    private:
        static const int CAPACITY=10;
        int array[CAPACITY];
        int top;
    public: 
        ArrayStack(): top(-1){}

        void pop(){
            if(is_empty()){
                throw runtime_error("Stack is empty");
            }
            --top;
        }

        void push(int value){
            if(top==CAPACITY-1){
                throw runtime_error("Stack is full");
            }
            array[++top]=value;
        }

        bool is_empty(){
            return top==-1;
        }
};


