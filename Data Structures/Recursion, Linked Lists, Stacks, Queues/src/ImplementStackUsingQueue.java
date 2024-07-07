import linear_structures.LinkedQueue;
import linear_structures.Queue;
import linear_structures.SinglyLinkedList;

//Exercise 7
public class ImplementStackUsingQueue<E> {
    private Queue<E> q1;
    private Queue<E> q2;

    public ImplementStackUsingQueue(){
        q1=new LinkedQueue<>();
        q2=new LinkedQueue<>();
    }

    public boolean empty(){
        return q1.isEmpty();
    }

    public E peek(){
        if(!q1.isEmpty()){
            return q1.peek();
        }
        else{
            System.out.println("The stack is empty!");
            return null;
        }
    }

    public E pop(){
        if(!q1.isEmpty()){
            return q1.dequeue();
        }
        else{
            System.out.println("The stack is empty!");
            return null;
        }
    }

    public E push(E item){
        q2.enqueue(item);
        while(!q1.isEmpty()){
            q2.enqueue(q1.dequeue());
        }
        Queue<E> temp=q1;
        q1=q2;
        q2=temp;
        return item;
    }
    public int size(){
        return q1.size();
    }
    public int search(Object object){
        int n=q1.size();
        int index=1;
        boolean isFound=false;

        for(int i=0;i<n;i++){
            E item = q1.dequeue();
            if(item.equals(object)){
                isFound=true;
                break;
            }
            q1.enqueue(item);
            index++;
        }

        for(int i=0;i<index-1;i++){
            q1.enqueue(q1.dequeue());
        }

        if(isFound) return index;
        else return -1;

    }


}
