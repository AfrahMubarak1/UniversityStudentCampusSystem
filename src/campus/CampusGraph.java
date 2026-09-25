package campus;

import java.util.*;

public class CampusGraph {

    // Adjacency list for the campus graph
    private Map<String, List<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a new campus location
    public boolean addLocation(String location) {

        if (location == null || location.trim().isEmpty()) {
            return false;
        }

        location = location.trim();

        // Check for duplicate location
        if (adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.put(location, new ArrayList<>());
        return true;
    }

    // Remove a campus location
    public boolean removeLocation(String location) {

        if (!adjacencyList.containsKey(location)) {
            return false;
        }

        // Remove the location
        adjacencyList.remove(location);

        // Remove connections to this location
        for (List<String> connections : adjacencyList.values()) {
            connections.remove(location);
        }

        return true;
    }

    // Add a road/connection between two locations
    public boolean addConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        if (location1.equals(location2)) {
            return false;
        }

        // Check for duplicate connection
        if (adjacencyList.get(location1).contains(location2)) {
            return false;
        }

        // Undirected graph: add connection both ways
        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        return true;
    }

    // Remove a road/connection
    public boolean removeConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        if (!adjacencyList.get(location1).contains(location2)) {
            return false;
        }

        adjacencyList.get(location1).remove(location2);
        adjacencyList.get(location2).remove(location1);

        return true;
    }

    // Display all campus locations and their connections
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("=== CAMPUS CONNECTIONS ===");

        for (String location : adjacencyList.keySet()) {

            System.out.print(location + " -> ");

            List<String> connections = adjacencyList.get(location);

            if (connections.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", connections));
            }
        }
    }

    // Breadth First Search (BFS)
    public void bfs(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Starting location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println("=== BFS TRAVERSAL ===");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (String neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {

                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }
}