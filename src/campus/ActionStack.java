package campus;

public class ActionStack {

    private Node top;

    // Node for the stack
    private class Node {
        String action;
        Node next;

        Node(String action) {
            this.action = action;
            this.next = null;
        }
    }

    // Push a new action onto the stack
    public void push(String action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
    }

    // Remove and return the most recent action
    public String pop() {
        if (top == null) {
            return null;
        }

        String action = top.action;
        top = top.next;

        return action;
    }

    // View the most recent action without removing it
    public String peek() {
        if (top == null) {
            return null;
        }

        return top.action;
    }

    // Check whether the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display recent actions
    public void displayActions() {
        if (top == null) {
            System.out.println("No recent actions.");
            return;
        }

        Node current = top;

        System.out.println("=== RECENT ACTIONS ===");

        while (current != null) {
            System.out.println(current.action);
            current = current.next;
        }
    }
}