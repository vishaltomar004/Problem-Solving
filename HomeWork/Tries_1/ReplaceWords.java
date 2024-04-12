package HomeWork.Tries_1;

public class ReplaceWords {
    
}
// Brute force easy

// class Solution {
//     public String replaceWords(List<String> dictionary, String sentence) {
//         String[] arr = sentence.split(" ");

// 		for (int i = 0; i < arr.length; i++) {
// 			for (String st : dictionary) {
// 				if (arr[i].startsWith(st)) {
// 					arr[i] = st;
// 				}
// 			}
// 		}

// 		sentence = "";

// 		for (String s : arr) {
// 			sentence += s + " ";
// 		}

// 		return sentence.stripTrailing();
//     }
// }

class Solution {

    public static class Node
    {
        Node[] children;
        boolean isEnding;

        Node()
        {
            children = new Node[26];
        }
    }

    public static void insert(String word , Node root)
    {
        Node curr = root;

        for(int i = 0 ; i < word.length() ; ++i)
        {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)curr.children[ch-'a'] = new Node();

            curr = curr.children[ch-'a'];
        }

        curr.isEnding = true;
    }


    public static String startWith(String word , Node root)
    {
        Node curr = root;
        StringBuilder pre = new StringBuilder();

        for(int i = 0 ; i < word.length() ; ++i)
        {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null)return null;
            pre.append(ch);
            if(curr.children[ch-'a'].isEnding)return pre.toString();
            curr = curr.children[ch-'a'];
        }

        return word;
    }

    public static String replaceWords(List<String> dictionary , String sentence)
    {
        Node root = new Node();

        for(String word : dictionary)
        {
            insert(word , root);
        }

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words)
        {
            String pre = startWith(word , root);

            if(pre != null)ans.append(pre).append(" ");
            else ans.append(word).append(" ");
        }

        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}

