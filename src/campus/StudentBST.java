package campus;

public class StudentBST {

    private Node root;

    // Node for the Binary Search Tree
    private class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    // Add a student to the BST
    public boolean insertStudent(Student student) {

        if (root == null) {
            root = new Node(student);
            return true;
        }

        return insertRecursive(root, student);
    }

    private boolean insertRecursive(Node current, Student student) {

        int comparison = student.getStudentId()
                .compareTo(current.student.getStudentId());

        // Duplicate Student ID
        if (comparison == 0) {
            return false;
        }

        // Insert into left subtree
        if (comparison < 0) {

            if (current.left == null) {
                current.left = new Node(student);
                return true;
            }

            return insertRecursive(current.left, student);
        }

        // Insert into right subtree
        if (current.right == null) {
            current.right = new Node(student);
            return true;
        }

        return insertRecursive(current.right, student);
    }

    // Search for a student by Student ID
    public Student searchStudent(String studentId) {

        Node current = root;

        while (current != null) {

            int comparison = studentId
                    .compareTo(current.student.getStudentId());

            if (comparison == 0) {
                return current.student;
            }

            if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Display students using in-order traversal
    public void displayStudents() {

        if (root == null) {
            System.out.println("No students in BST.");
            return;
        }

        System.out.println("=== STUDENTS IN BST ===");

        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        System.out.println(node.student);

        inOrderTraversal(node.right);
    }
}