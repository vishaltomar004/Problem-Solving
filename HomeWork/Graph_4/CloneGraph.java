package HomeWork.Graph_4;

public class CloneGraph {
    Node[] nodes = new Node[101];

    public Node cloneGraph(Node node) {
      if (node == null) return null;
  
      nodes[node.val] = new Node(node.val);
  
      for (var neighbor : node.neighbors) {
        if (nodes[neighbor.val] == null)
          cloneGraph(neighbor);
  
        nodes[node.val].neighbors.add(nodes[neighbor.val]);
      }
      return nodes[node.val];
    }
}
