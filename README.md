# University Student & Campus Route Management System

## Project Overview

The University Student & Campus Route Management System is a Java console-based application developed for the CIT300 Data Structures and Algorithms module.

The system manages university student records, service requests, recent system actions, and campus locations and connections using different data structures.

## Data Structures Implemented

The system demonstrates the following data structures:

- Linked List – Student record management
- Stack – Recent actions/history
- Queue – Student service requests
- Binary Search Tree (BST) – Student records organized by Student ID
- Hash Table – Fast student searching using Student ID
- Graph – Campus locations and connections
- BFS – Traversal of campus locations

## Main Features

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Student Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS
16. Exit

## Team Members and Contributions

### 1. A.F.A.A. Umar Ali
**Student ID:** 23DA2-0550

**Contribution:**
- Implemented `Student.java`
- Implemented `StudentLinkedList.java`
- Created student record structure
- Implemented adding, updating, deleting and displaying student records
- Implemented duplicate Student ID validation

### 2. M.M.F. Afra
**Student ID:** 23DA2-0941

**Contribution:**
- Implemented `ActionStack.java`
- Implemented `ServiceQueue.java`
- Implemented stack operations for recent system actions
- Implemented queue operations for service requests
- Integrated the data structures into the main application

### 3. W.H.N. Sanduni Prarthana
**Student ID:** 23DA2-1119

**Contribution:**
- Implemented `StudentBST.java`
- Implemented `HashTable.java`
- Implemented BST insertion, searching and traversal
- Implemented hashing-based student searching
- Tested BST and hashing functionality

### 4. M.M.F. Azra
**Student ID:** 23DA2-1087

**Contribution:**
- Implemented `CampusGraph.java`
- Implemented campus location management
- Implemented campus connection/road management
- Implemented adjacency-list based graph
- Implemented BFS campus traversal
- Tested graph functionality

## Technologies Used

- Java
- Eclipse IDE
- Git
- GitHub

## Project Structure

```text
UniversityStudentCampusSystem
│
└── src
    └── campus
        ├── Student.java
        ├── StudentLinkedList.java
        ├── ActionStack.java
        ├── ServiceQueue.java
        ├── StudentBST.java
        ├── HashTable.java
        ├── CampusGraph.java
        └── Main.java