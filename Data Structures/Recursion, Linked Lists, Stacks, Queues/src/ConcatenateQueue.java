import linear_structures.LinkedQueue;

//Exercise 11
public class ConcatenateQueue<E> {
    //I have solved this exercise inside LinkedQueue class in the linear_structures package.
    /** This is the solution:
     public void concatenate(LinkedQueue<T> Q2) {
        if (Q2.isEmpty()){
            return;
        }
        if (this.isEmpty()){
            this.list.head = Q2.list.head;
            this.list.tail = Q2.list.tail;
        }
        else{
            this.list.tail.setNext(Q2.list.head);
            this.list.tail = Q2.list.tail;
        }
        this.list.size += Q2.size();

        Q2.list.head = null;
        Q2.list.tail = null;
        Q2.list.size = 0;
    }
     **/
    //Now to test it:
    public static void main(String[] args) {
        LinkedQueue<Integer> Q1= new LinkedQueue<>();
        LinkedQueue<Integer> Q2= new LinkedQueue<>();

        for(int i=1;i<=3;i++){
            Q1.enqueue(i);
        }

        for(int i=4;i<=6;i++){
            Q2.enqueue(i);
        }

        System.out.println("Q1 before: ");
        printQ(Q1);
        System.out.println("Q2 before: ");
        printQ(Q2);
        Q1.concatenate(Q2);
        System.out.println("Q1 after: ");
        printQ(Q1);
        System.out.println("Q2 after: ");
        printQ(Q2);
    }
    private static void printQ(LinkedQueue<Integer> queue) {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }

        LinkedQueue<Integer> temp = new LinkedQueue<>();
        while (!queue.isEmpty()) {
            Integer element = queue.dequeue();
            temp.enqueue(element);
            System.out.print(element + " ");
        }
        System.out.println();

        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }
    }



}