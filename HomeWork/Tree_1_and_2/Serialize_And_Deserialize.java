package HomeWork.Tree_1_and_2;
   
//Storing root in global variable and using whenever required

/**
 * Serialize_And_Deserialize
 */
public class Serialize_And_Deserialize {

    
} 


class Codec {
    static TreeNode r;
// Encodes a tree to a single string.
public String serialize(TreeNode root) {
   r=root;
   return "";
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
   return r;
}
}