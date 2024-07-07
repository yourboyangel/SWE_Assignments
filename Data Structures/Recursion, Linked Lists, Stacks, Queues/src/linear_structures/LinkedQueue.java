package linear_structures;


public class LinkedQueue<T> implements Queue<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();
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

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(T element) {
        list.append(element);
    }

    @Override
    public T dequeue() {
        return list.popFirst(); // Retrieves and removes the head (first element) of this list, null if empty
    }

    @Override
    public T peek() {
        return list.head(); // Returns the head of this list, or null if this list is empty
    }

}