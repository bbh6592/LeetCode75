class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Create a boolean array to track visited rooms
        boolean[] visited = new boolean[rooms.size()];
        
        // Start DFS from room 0
        dfs(0, rooms, visited);
        
        // Check if all rooms have been visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        // Mark the current room as visited
        visited[room] = true;
        
        // Go through all keys in this room
        for (int key : rooms.get(room)) {
            // Visit the room if it hasn't been visited yet
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
