class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Fill the graph with edges from equations
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);        // a / b = val
            graph.get(b).put(a, 1.0 / val);  // b / a = 1 / val
        }

        // Prepare results array
        double[] results = new double[queries.size()];

        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, src, dst, 1.0, visited);
        }

        return results;
    }

    // DFS to find path from src to dst with cumulative product
    private double dfs(Map<String, Map<String, Double>> graph, String src, String dst, double product, Set<String> visited) {
        // If either variable is missing
        if (!graph.containsKey(src) || !graph.containsKey(dst)) {
            return -1.0;
        }

        // If source and destination are same
        if (src.equals(dst)) {
            return product;
        }

        visited.add(src);

        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            String nextNode = neighbor.getKey();
            double value = neighbor.getValue();

            if (!visited.contains(nextNode)) {
                double result = dfs(graph, nextNode, dst, product * value, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0; // No valid path
    }
}
