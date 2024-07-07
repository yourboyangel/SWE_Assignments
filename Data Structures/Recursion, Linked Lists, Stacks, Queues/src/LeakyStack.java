//Exercise 10
public class LeakyStack<E> {
    final int capacity;
    final E[] array;
    int top;
    int end;
    int size;

    public LeakyStack(int capacity){
        this.capacity=capacity;
        this.array=(E[]) new Object[capacity];
        this.top=0;
        this.end=0;
        this.size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void push(E item){
        if(size==capacity){
            end=(end+1)%capacity;
        }
        else{
            size++;
        }
        array[top]=item;
        top=(top+1)%capacity;
    }

    public E pop(){
        if(isEmpty()) System.out.println("The stack is empty!");
        top=(top-1+capacity)%capacity;
        E itemPop=array[top];
        array[top]=null;
        size--;
        return itemPop;
    }

    public E peek(){
        if(isEmpty()) System.out.println("The stack is empty!");
        int i=(top-1+capacity)%capacity;
        return array[i];
    }

    public static void main(String[] args) {
        LeakyStack<Integer> stack= new LeakyStack<>(5);
        for(int i=1;i<=5;i++){
            stack.push(i);
        }
        System.out.println("Size: "+stack.size());
        System.out.println("Is the stack empty: "+stack.isEmpty());
        System.out.println("Peek: "+stack.peek());
        System.out.println("Pop: "+stack.pop());
        System.out.println("New size: "+stack.size());
    }

}
