class MyCircularQueue {
    private int[] queue;
    private int size;
    private int front;
    private int back;
    private int used;
    
    
    public MyCircularQueue(int k) {
        queue = new int[k];
        size = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[back] = value;
        back =  (back+1) % size;
        used++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        used--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[(back-1+size)%size];
    }
    
    public boolean isEmpty() {
        return used == 0;
    }
    
    public boolean isFull() {
        return size == used;
    }
}
