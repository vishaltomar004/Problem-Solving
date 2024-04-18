package HomeWork.Tries_1;

public class LongestCommonSuffixQueries {
    
}
import java.util.*; 

class TrieNode {
    public TrieNode[] children;
    public boolean isEndOfWord;
    public int index;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
        this.index = -1;
    }

    public void insert(String word, int index) {
        TrieNode node = this;
        
        char [] words = word.toCharArray();
        for (int i = 0; i < words.length / 2; i++) { 
            char t = words[i]; 
            words[i] = words[words.length - i - 1]; 
            words[words.length - i - 1] = t; 
        }

        for (char c : words) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
        node.index = index;
    }
    
    public int minLength(TrieNode node, String [] words){
        boolean [] found = new boolean[1];
        int [] soln = new int[1];
        found[0] = false;
        findMin(node, found, soln, words);
        // System.out.println(soln[0]);
        return soln[0];
    }

    public void findMin(TrieNode node, boolean [] found, int [] soln, String [] words){
        if(node == null) return;
        if(node.isEndOfWord){
            // System.out.println(words[node.index]);
            if(found[0]){
                // System.out.println(words[soln[0]] + " " + words[node.index]);
                if((words[soln[0]].length() == words[node.index].length())){
                    soln[0] = Math.min(soln[0], node.index);
                    return;
                }

                if(words[soln[0]].length() > words[node.index].length()) soln[0] = node.index;

            } else {
                soln[0] = node.index;
                found[0] = true;
            }
            return;
        }
        for(int i=0; i<26; i++){
            if(node.children[i] != null) findMin(node.children[i], found, soln, words);
        }
        return;
    }
}

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int [] res = new int[wordsQuery.length];
        TrieNode root = new TrieNode();
        
        for(int i=wordsContainer.length-1; i >= 0; i--){
            root.insert(wordsContainer[i], i);
        }

        int count = 0;
        for(String w: wordsQuery){
            char [] words = w.toCharArray();
            for (int i = 0; i < words.length / 2; i++) { 
                char t = words[i]; 
                words[i] = words[words.length - i - 1]; 
                words[words.length - i - 1] = t; 
            }
            TrieNode curr = root;
            for(int i=0; i<words.length; i++){
                if(curr.children[words[i] - 'a'] == null) break;
                // System.out.println(words[i]);
                curr = curr.children[words[i] - 'a'];
            }
            // System.out.println();
            res[count] = root.minLength(curr, wordsContainer);
            count += 1;
        }
        return res;
    }
}