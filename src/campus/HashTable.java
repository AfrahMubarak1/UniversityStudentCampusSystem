package campus;

public class HashTable {

    private Student[] table;
    private int size;

    public HashTable() {
        size = 10;
        table = new Student[size];
    }

    // Hash function
    private int hash(String studentId) {

        int hashValue = 0;

        for (int i = 0; i < studentId.length(); i++) {
            hashValue = (hashValue * 31 + studentId.charAt(i)) % size;
        }

        return hashValue;
    }

    // Add a student to the hash table
    public boolean addStudent(Student student) {

        int index = hash(student.getStudentId());

        for (int i = 0; i < size; i++) {

            int currentIndex = (index + i) % size;

            // Empty position
            if (table[currentIndex] == null) {
                table[currentIndex] = student;
                return true;
            }

            // Duplicate ID
            if (table[currentIndex].getStudentId()
                    .equals(student.getStudentId())) {
                return false;
            }
        }

        return false;
    }

    // Search for a student using Student ID
    public Student searchStudent(String studentId) {

        int index = hash(studentId);

        for (int i = 0; i < size; i++) {

            int currentIndex = (index + i) % size;

            // Empty position means student does not exist
            if (table[currentIndex] == null) {
                return null;
            }

            if (table[currentIndex].getStudentId()
                    .equals(studentId)) {
                return table[currentIndex];
            }
        }

        return null;
    }

    // Display the hash table
    public void displayHashTable() {

        System.out.println("=== HASH TABLE ===");

        for (int i = 0; i < size; i++) {

            System.out.print("Index " + i + ": ");

            if (table[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}