package HomeWork.Tree_1_and_2;

public class Vertical LevelOrder {
    
}

class Pairs {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col) {
        node = node;
        row = row;
        col = col;
    }
    }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
     // We have assumed the tree to be a x-y horizon with vertical level and horizontal level , horizontal level increasing on downside
     // We made a tree map to store x axis as key
     // inside this tree map another tree map with y axis as key and a list with values
     // every time we reach same vertical level we add in list and sort it
   TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Pairs(root, 0, 0));
        while (!q.isEmpty()) {
            Pairs p = q.poll();
            TreeNode node = p.node;
            int x = p.row;
            int y = p.col;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}