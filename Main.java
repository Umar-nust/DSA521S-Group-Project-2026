import java.util.Scanner;
import java.util.Random;

public class Main {

    // --- Simple Queue Implementation (for Options 1-3) ---
    static class QueueNode {
        String data;
        QueueNode next;
        QueueNode(String data) { this.data = data; this.next = null; }
    }

    static class ServiceQueue {
        QueueNode front = null, rear = null;
        int size = 0;

        void enqueue(String student) {
            QueueNode newNode = new QueueNode(student);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
            System.out.println("-> Enqueued: " + student);
        }

        void dequeue() {
            if (front == null) {
                System.out.println("-> Queue is empty! No student to serve.");
                return;
            }
            System.out.println("-> Served (Dequeued): " + front.data);
            front = front.next;
            if (front == null) rear = null;
            size--;
        }

        void peek() {
            if (front == null) {
                System.out.println("-> Queue is empty.");
            } else {
                System.out.println("-> Next student in line: " + front.data);
            }
        }
    }

    // --- Simple Singly Linked List Implementation (for Options 4-7) ---
    static class Node {
        String record;
        Node next;
        Node(String record) { this.record = record; this.next = null; }
    }

    static class StudentLinkedList {
        Node head = null;

        void insert(String record) {
            Node newNode = new Node(record);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) current = current.next;
                current.next = newNode;
            }
            System.out.println("-> Added record: " + record);
        }

        void delete(String target) {
            if (head == null) {
                System.out.println("-> List is empty.");
                return;
            }
            if (head.record.equals(target)) {
                head = head.next;
                System.out.println("-> Deleted record: " + target);
                return;
            }
            Node current = head;
            while (current.next != null && !current.next.record.equals(target)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
                System.out.println("-> Deleted record: " + target);
            } else {
                System.out.println("-> Record not found.");
            }
        }

        void search(String target) {
            Node current = head;
            int pos = 1;
            while (current != null) {
                if (current.record.equals(target)) {
                    System.out.println("-> Found '" + target + "' at position " + pos);
                    return;
                }
                current = current.next;
                pos++;
            }
            System.out.println("-> Record '" + target + "' not found.");
        }

        void display() {
            Node current = head;
            if (current == null) {
                System.out.println("-> Student record list is empty.");
                return;
            }
            System.out.println("-> Current Student Records:");
            int i = 1;
            while (current != null) {
                System.out.println("   " + i + ". " + current.record);
                current = current.next;
                i++;
            }
        }
    }

    // --- MAIN PROGRAM ENTRY ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceQueue queue = new ServiceQueue();
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n==============================================");
            System.out.println(" NUST SERVICE CENTRE SIMULATION - MAIN MENU ");
            System.out.println("==============================================");
            System.out.println("1. Queue: Add Student (Enqueue)");
            System.out.println("2. Queue: Serve Student (Dequeue)");
            System.out.println("3. Queue: View Next Student (Peek)");
            System.out.println("4. Linked List: Add Student Record");
            System.out.println("5. Linked List: Delete Student Record");
            System.out.println("6. Linked List: Search Student Record");
            System.out.println("7. Linked List: Display All Records");
            System.out.println("8. Array Statistics (Service Times Summary)");
            System.out.println("9. Run Sorting Demos (Selection, Insertion, Merge, Quick)");
            System.out.println("10. Run Performance Experiment (nanoTime Benchmarks)");
            System.out.println("11. Exit Program");
            System.out.print("Enter your choice (1-11): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to enqueue: ");
                    String name = scanner.nextLine();
                    queue.enqueue(name);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    System.out.print("Enter student record details: ");
                    String rec = scanner.nextLine();
                    list.insert(rec);
                    break;
                case 5:
                    System.out.print("Enter record to delete: ");
                    String del = scanner.nextLine();
                    list.delete(del);
                    break;
                case 6:
                    System.out.print("Enter record to search: ");
                    String searchStr = scanner.nextLine();
                    list.search(searchStr);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("\n--- Array Statistics Execution ---");
                    ArrayStats.main(new String[]{});
                    break;
                case 9:
                    System.out.println("\n--- Running Sorting Algorithms Demo ---");
                    int[] demoArr = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

                    System.out.println("\n-> Selection Sort Demo:");
                    SelectionSort.main(new String[]{});

                    System.out.println("\n-> Insertion Sort Demo:");
                    InsertionSort.main(new String[]{});

                    System.out.println("\n-> Merge Sort Demo on sample array:");
                    int[] mergeCopy = demoArr.clone();
                    MergeSort.sort(mergeCopy, 0, mergeCopy.length - 1);
                    printArray(mergeCopy);

                    System.out.println("\n-> Quick Sort Demo on sample array:");
                    int[] quickCopy = demoArr.clone();
                    QuickSort.sort(quickCopy, 0, quickCopy.length - 1);
                    printArray(quickCopy);
                    break;
                case 10:
                    runPerformanceExperiment();
                    break;
                case 11:
                    System.out.println("\nExiting program. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter a number between 1 and 11.");
            }
        } while (choice != 11);

        scanner.close();
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println("]");
    }

    // --- Option 10: Performance Experiment Benchmark ---
    private static void runPerformanceExperiment() {
        System.out.println("\n=======================================================");
        System.out.println(" PERFORMANCE EXPERIMENT (Execution Time in Nanoseconds)");
        System.out.println("=======================================================");
        int[] sizes = {20, 50, 100, 500};

        System.out.printf("%-10s | %-15s | %-15s | %-15s | %-15s%n",
                "Size", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort");
        System.out.println("---------------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] baseArray = generateRandomArray(size);

            // Selection Sort Time
            int[] arr1 = baseArray.clone();
            long start1 = System.nanoTime();
            runSelectionSortSilent(arr1);
            long time1 = System.nanoTime() - start1;

            // Insertion Sort Time
            int[] arr2 = baseArray.clone();
            long start2 = System.nanoTime();
            runInsertionSortSilent(arr2);
            long time2 = System.nanoTime() - start2;

            // Merge Sort Time
            int[] arr3 = baseArray.clone();
            long start3 = System.nanoTime();
            MergeSort.sort(arr3, 0, arr3.length - 1);
            long time3 = System.nanoTime() - start3;

            // Quick Sort Time
            int[] arr4 = baseArray.clone();
            long start4 = System.nanoTime();
            QuickSort.sort(arr4, 0, arr4.length - 1);
            long time4 = System.nanoTime() - start4;

            System.out.printf("%-10d | %-15d | %-15d | %-15d | %-15d%n",
                    size, time1, time2, time3, time4);
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random(42); // fixed seed for consistent benchmark runs
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

    private static void runSelectionSortSilent(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    private static void runInsertionSortSilent(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
