package campus;

public class ServiceQueue {

    private Node front;
    private Node rear;

    // Node for the queue
    private class Node {
        String request;
        Node next;

        Node(String request) {
            this.request = request;
            this.next = null;
        }
    }

    // Add a service request to the queue
    public void addRequest(String request) {
        Node newNode = new Node(request);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Process and remove the first service request
    public String processRequest() {
        if (front == null) {
            return null;
        }

        String request = front.request;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return request;
    }

    // View the first request without removing it
    public String peekRequest() {
        if (front == null) {
            return null;
        }

        return front.request;
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display all pending requests
    public void displayRequests() {
        if (front == null) {
            System.out.println("No pending service requests.");
            return;
        }

        Node current = front;

        System.out.println("=== PENDING SERVICE REQUESTS ===");

        while (current != null) {
            System.out.println(current.request);
            current = current.next;
        }
    }
}