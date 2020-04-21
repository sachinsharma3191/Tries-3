

// Time Complexity :O(M * N ) to Build Trie for M Words of N size,O(N) to search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes Both Approaches Worked
// 

/*
Store the words in the trie with reverse order, and check the query string from the end
*/


class TrieNode {

	TrieNode[] children;
	String word;
	boolean isEnd;

	public TrieNode() {
		children = new TrieNode[26];
		word = "";
		isEnd = false;
	}
 }


public class StreamChecker {

    TrieNode root;
	String words[];
	StringBuilder sb;

	public StreamChecker(String[] words) {
		this.words = words;
		this.root = new TrieNode();
		this.sb = new StringBuilder();
		this.buildTrie();
	}

	public void insert(String word) {
		TrieNode current = root;
		int size = word.length();

		for (int i = size -1;  i >= 0 ; i--) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isEnd = true;
	}

	public void buildTrie() {
		for (String word : this.words) {
			this.insert(word);
		}
		System.out.print(root);
	}

	public boolean search(char letter) {
		sb.append(letter);
		TrieNode current = root;
		for (int i = sb.length() - 1; i >= 0 && current != null; i--) {
			int index = sb.charAt(i) - 'a';
			current = current.children[index];

			if (current != null && current.isEnd) {
				return true;
			}
		}
        return false;
        
	}

	public boolean query(char letter) {
		return this.search(letter);
    }
    
    public static void main(String args[]){
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd","f","kl"}); // init the dictionary.
        System.out.println(streamChecker.query('a'));          // return false
        System.out.println(streamChecker.query('b'));          // return false
        System.out.println(streamChecker.query('c'));          // return false
        System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e'));          // return false
        System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g'));          // return false
        System.out.println(streamChecker.query('h'));          // return false
        System.out.println(streamChecker.query('i'));          // return false
        System.out.println(streamChecker.query('j'));          // return false
        System.out.println(streamChecker.query('k'));          // return false
        System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
    }
}

 