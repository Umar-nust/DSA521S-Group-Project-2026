public class Queue {

    private Student[] students;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        students = new Student[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        students[rear] = student;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println(student.getName() + " joined the queue.");
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        Student student = students[front];
        students[front] = null;
        front = (front + 1) % capacity;
        size--;
        System.out.println(student.getName() + " was served.");
        return student;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return students[front];
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue (front to rear):");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println((i + 1) + ". " + students[index].getName());
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
