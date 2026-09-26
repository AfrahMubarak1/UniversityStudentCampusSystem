package campus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentLinkedList studentList = new StudentLinkedList();
        ActionStack actionStack = new ActionStack();
        ServiceQueue serviceQueue = new ServiceQueue();
        StudentBST studentBST = new StudentBST();
        HashTable hashTable = new HashTable();
        CampusGraph campusGraph = new CampusGraph();

        boolean running = true;

        while (running) {

            System.out.println("\n==============================================");
            System.out.println("   UNIVERSITY STUDENT & CAMPUS SYSTEM");
            System.out.println("==============================================");

            System.out.println("1.  Add Student Record");
            System.out.println("2.  Update Student Record");
            System.out.println("3.  Delete Student Record");
            System.out.println("4.  Display All Records using Linked List");
            System.out.println("5.  Add Service Request to Queue");
            System.out.println("6.  Process Next Service Request");
            System.out.println("7.  Display Recent Actions using Stack");
            System.out.println("8.  Display Students using BST");
            System.out.println("9.  Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection/Road");
            System.out.println("13. Remove Campus Connection/Road");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus Locations using BFS");
            System.out.println("16. Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {

                // ==========================================
                // 1. ADD STUDENT
                // ==========================================
                case "1":

                    System.out.println("\n=== ADD STUDENT RECORD ===");

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    if (studentList.findStudent(studentId) != null) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine().trim();

                    double marks;

                    try {
                        System.out.print("Enter Marks (0-100): ");
                        marks = Double.parseDouble(scanner.nextLine());

                        if (marks < 0 || marks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks.");
                        break;
                    }

                    Student newStudent =
                            new Student(studentId, name, programme, marks);

                    if (studentList.addStudent(newStudent)) {

                        studentBST.insertStudent(newStudent);
                        hashTable.addStudent(newStudent);

                        actionStack.push(
                                "Added student: " + studentId
                        );

                        System.out.println(
                                "Student record added successfully."
                        );

                    } else {
                        System.out.println(
                                "Failed to add student record."
                        );
                    }

                    break;

                // ==========================================
                // 2. UPDATE STUDENT
                // ==========================================
                case "2":

                    System.out.println("\n=== UPDATE STUDENT RECORD ===");

                    System.out.print("Enter Student ID: ");
                    String updateId = scanner.nextLine().trim();

                    if (studentList.findStudent(updateId) == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine().trim();

                    System.out.print("Enter New Programme: ");
                    String newProgramme = scanner.nextLine().trim();

                    double newMarks;

                    try {
                        System.out.print("Enter New Marks (0-100): ");
                        newMarks = Double.parseDouble(scanner.nextLine());

                        if (newMarks < 0 || newMarks > 100) {
                            System.out.println(
                                    "Marks must be between 0 and 100."
                            );
                            break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks.");
                        break;
                    }

                    if (studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks)) {

                        actionStack.push(
                                "Updated student: " + updateId
                        );

                        System.out.println(
                                "Student record updated successfully."
                        );

                    } else {
                        System.out.println(
                                "Failed to update student."
                        );
                    }

                    break;

                // ==========================================
                // 3. DELETE STUDENT
                // ==========================================
                case "3":

                    System.out.println("\n=== DELETE STUDENT RECORD ===");

                    System.out.print("Enter Student ID: ");
                    String deleteId = scanner.nextLine().trim();

                    if (studentList.deleteStudent(deleteId)) {

                        actionStack.push(
                                "Deleted student: " + deleteId
                        );

                        System.out.println(
                                "Student record deleted successfully."
                        );

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // ==========================================
                // 4. DISPLAY LINKED LIST
                // ==========================================
                case "4":

                    System.out.println(
                            "\n=== STUDENT RECORDS (LINKED LIST) ==="
                    );

                    studentList.displayStudents();

                    break;

                // ==========================================
                // 5. ADD SERVICE REQUEST
                // ==========================================
                case "5":

                    System.out.println(
                            "\n=== ADD SERVICE REQUEST ==="
                    );

                    System.out.print("Enter service request: ");
                    String request = scanner.nextLine().trim();

                    if (request.isEmpty()) {
                        System.out.println(
                                "Request cannot be empty."
                        );
                        break;
                    }

                    serviceQueue.addRequest(request);

                    actionStack.push(
                            "Added service request: " + request
                    );

                    System.out.println(
                            "Service request added to queue."
                    );

                    break;

                // ==========================================
                // 6. PROCESS QUEUE
                // ==========================================
                case "6":

                    System.out.println(
                            "\n=== PROCESS SERVICE REQUEST ==="
                    );

                    String processedRequest =
                            serviceQueue.processRequest();

                    if (processedRequest == null) {

                        System.out.println(
                                "No pending service requests."
                        );

                    } else {

                        System.out.println(
                                "Processed request: "
                                        + processedRequest
                        );

                        actionStack.push(
                                "Processed service request: "
                                        + processedRequest
                        );
                    }

                    break;

                // ==========================================
                // 7. STACK
                // ==========================================
                case "7":

                    System.out.println(
                            "\n=== RECENT ACTIONS ==="
                    );

                    actionStack.displayActions();

                    break;

                // ==========================================
                // 8. BST
                // ==========================================
                case "8":

                    System.out.println(
                            "\n=== STUDENTS USING BST ==="
                    );

                    studentBST.displayStudents();

                    break;

                // ==========================================
                // 9. HASHING SEARCH
                // ==========================================
                case "9":

                    System.out.println(
                            "\n=== SEARCH STUDENT USING HASHING ==="
                    );

                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine().trim();

                    Student foundStudent =
                            hashTable.searchStudent(searchId);

                    if (foundStudent != null) {

                        System.out.println(
                                "Student found:"
                        );
                        System.out.println(foundStudent);

                    } else {

                        System.out.println(
                                "Student not found."
                        );
                    }

                    break;

                // ==========================================
                // 10. ADD CAMPUS LOCATION
                // ==========================================
                case "10":

                    System.out.println(
                            "\n=== ADD CAMPUS LOCATION ==="
                    );

                    System.out.print("Enter location name: ");
                    String location =
                            scanner.nextLine().trim();

                    if (campusGraph.addLocation(location)) {

                        actionStack.push(
                                "Added campus location: "
                                        + location
                        );

                        System.out.println(
                                "Campus location added successfully."
                        );

                    } else {

                        System.out.println(
                                "Location already exists or is invalid."
                        );
                    }

                    break;

                // ==========================================
                // 11. REMOVE CAMPUS LOCATION
                // ==========================================
                case "11":

                    System.out.println(
                            "\n=== REMOVE CAMPUS LOCATION ==="
                    );

                    System.out.print("Enter location name: ");
                    String removeLocation =
                            scanner.nextLine().trim();

                    if (campusGraph.removeLocation(
                            removeLocation)) {

                        actionStack.push(
                                "Removed campus location: "
                                        + removeLocation
                        );

                        System.out.println(
                                "Campus location removed successfully."
                        );

                    } else {

                        System.out.println(
                                "Campus location not found."
                        );
                    }

                    break;

                // ==========================================
                // 12. ADD CONNECTION
                // ==========================================
                case "12":

                    System.out.println(
                            "\n=== ADD CAMPUS CONNECTION ==="
                    );

                    System.out.print("Enter first location: ");
                    String location1 =
                            scanner.nextLine().trim();

                    System.out.print("Enter second location: ");
                    String location2 =
                            scanner.nextLine().trim();

                    if (campusGraph.addConnection(
                            location1,
                            location2)) {

                        actionStack.push(
                                "Added campus connection: "
                                        + location1
                                        + " - "
                                        + location2
                        );

                        System.out.println(
                                "Campus connection added successfully."
                        );

                    } else {

                        System.out.println(
                                "Unable to add connection."
                        );
                        System.out.println(
                                "Check that both locations exist "
                                        + "and the connection is not duplicated."
                        );
                    }

                    break;

                // ==========================================
                // 13. REMOVE CONNECTION
                // ==========================================
                case "13":

                    System.out.println(
                            "\n=== REMOVE CAMPUS CONNECTION ==="
                    );

                    System.out.print("Enter first location: ");
                    String removeLocation1 =
                            scanner.nextLine().trim();

                    System.out.print("Enter second location: ");
                    String removeLocation2 =
                            scanner.nextLine().trim();

                    if (campusGraph.removeConnection(
                            removeLocation1,
                            removeLocation2)) {

                        actionStack.push(
                                "Removed campus connection: "
                                        + removeLocation1
                                        + " - "
                                        + removeLocation2
                        );

                        System.out.println(
                                "Campus connection removed successfully."
                        );

                    } else {

                        System.out.println(
                                "Connection not found."
                        );
                    }

                    break;

                // ==========================================
                // 14. DISPLAY GRAPH
                // ==========================================
                case "14":

                    System.out.println(
                            "\n=== CAMPUS CONNECTIONS ==="
                    );

                    campusGraph.displayConnections();

                    break;

                // ==========================================
                // 15. BFS
                // ==========================================
                case "15":

                    System.out.println(
                            "\n=== BFS CAMPUS TRAVERSAL ==="
                    );

                    System.out.print(
                            "Enter starting location: "
                    );

                    String startLocation =
                            scanner.nextLine().trim();

                    campusGraph.bfs(startLocation);

                    break;

                // ==========================================
                // 16. EXIT
                // ==========================================
                case "16":

                    running = false;

                    System.out.println(
                            "\nThank you for using the "
                                    + "University Student & Campus System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please enter a number "
                                    + "between 1 and 16."
                    );
            }
        }

        scanner.close();
    }
}