package campus;

public class StudentLinkedList {

    private Node head;

    // Node class
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    // Add a student
    public boolean addStudent(Student student) {

        if (head == null) {
            head = new Node(student);
            return true;
        }

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(student.getStudentId())) {
                return false; // Duplicate ID
            }

            if (current.next == null) {
                break;
            }

            current = current.next;
        }

        current.next = new Node(student);
        return true;
    }

    // Find a student by ID
    public Student findStudent(String studentId) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId().equals(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update student details
    public boolean updateStudent(String studentId, String name,
                                 String programme, double marks) {

        Student student = findStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        return true;
    }

    // Delete a student
    public boolean deleteStudent(String studentId) {

        if (head == null) {
            return false;
        }

        // If the student is the first node
        if (head.student.getStudentId().equals(studentId)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId().equals(studentId)) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display all students
    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}