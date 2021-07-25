package com.tl.interview.string;



/**
 * 前缀树
 *
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root=new TrieNode();
    }

    /**
     * 前缀树插入单词
     * @param word
     */
    public void insert(String word) {

        TrieNode parent=root;
        for (int i = 0; i < word.length(); i++) {
            int index=word.charAt(i)-'a';
            TrieNode current=parent.child[index];
            if(current==null){
                current= new TrieNode();
                parent.child[index]=current;
            }
            parent=current;
        }
        parent.setEnd(true);
    }

    /**
     * 前缀树查找单词
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode parent=root;
        for (int i = 0; i < word.length(); i++) {
            int index=word.charAt(i)-'a';
            if(parent.child[index]==null){
                return false;
            }else{
                parent=parent.child[index];
            }
        }
        return parent.isEnd;
    }


    /**
     * 前缀树查找单词前缀
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode parent=root;
        for (int i = 0; i < prefix.length(); i++) {
            int index=prefix.charAt(i)-'a';
            if(parent.child[index]==null){
                return false;
            }else{
                parent=parent.child[index];
            }
        }
        return true;
    }


    class TrieNode{
        private TrieNode child[];
        private int R=26;
        boolean isEnd;
        public TrieNode (){
            child=new TrieNode[R];
            isEnd=false;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
