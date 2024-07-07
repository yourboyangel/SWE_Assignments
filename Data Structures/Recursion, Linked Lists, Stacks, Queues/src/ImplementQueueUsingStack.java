import linear_structures.LinkedStack;
import linear_structures.Queue;
import linear_structures.Stack;

//Exercise 8
public class ImplementQueueUsingStack<E> implements Queue<E> {
    private Stack<E> stack1=new LinkedStack<>();
    private Stack<E> stack2=new LinkedStack<>();

    public int size(){
        return stack1.size()+stack2.size();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void enqueue(E e){
        stack1.push(e);
    }

    public E peek(){
        if(isEmpty()){
            System.out.println("The queue is empty!");
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public E dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty!");
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
