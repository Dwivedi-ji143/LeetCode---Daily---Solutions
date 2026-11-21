class Solution {
    private List<Integer>[] adjacencyList;
    private List<Integer>[] charToNodeStack;
    private char[] characters;
    private int[] subtreeSizes;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = s.length();

        adjacencyList = new List[n];
        charToNodeStack = new List[26];
        characters = s.toCharArray();

        Arrays.setAll(adjacencyList, i -> new ArrayList<>());
        Arrays.setAll(charToNodeStack, i -> new ArrayList<>());

        for (int i = 1; i < n; i++)
            adjacencyList[parent[i]].add(i);

        subtreeSizes = new int[n];
        dfs(0, -1);

        return subtreeSizes;
    }

    private void dfs(int node, int parentNode) {
        subtreeSizes[node] = 1;
        int c = characters[node] - 'a';

        charToNodeStack[c].add(node);

        for (int child : adjacencyList[node])
            dfs(child, node);

        int size = charToNodeStack[c].size();
        int ancestor = size > 1
                ? charToNodeStack[c].get(size - 2)
                : parentNode;

        if (ancestor != -1)
            subtreeSizes[ancestor] += subtreeSizes[node];

        charToNodeStack[c].remove(size - 1);
    }
}