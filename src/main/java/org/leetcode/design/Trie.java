package org.leetcode.design;

public class Trie {

  //create the node structure
  class TrieNode {

    Character ch;
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
      children = new TrieNode[26];
    }
  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    addCharacter(0, word.toCharArray(), root);
  }

  private void addCharacter(int index, char[] chars, TrieNode node) {
    char currentChar = chars[index];
    int position = currentChar - 'a';

    if (node.children[position] == null) {
      TrieNode nodeToAdd = new TrieNode();
      node.children[position] = nodeToAdd;
      nodeToAdd.ch = currentChar;

      if (index == chars.length - 1) {
        nodeToAdd.isWord = true;
        return;
      }
      addCharacter(index + 1, chars, nodeToAdd);

    }
    else {
      TrieNode child = node.children[position];
      if (index < chars.length - 1) {
        addCharacter(index + 1, chars, child);
      }
      else {
        child.isWord = true;
        return;
      }
    }
  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {
    return isWordPresent(0, word.toCharArray(), root, true);
  }

  private boolean isWordPresent(int index, char[] chars, TrieNode node, boolean checkWord) {
    char currentChar = chars[index];
    int position = currentChar - 'a';

    TrieNode child = node.children[position];
    if (child == null) {
      return false;
    }
    else {
      //check if last character is word flag sent
      if (index == chars.length - 1) {
        if(checkWord) {
          return child.isWord;
        }

        return true;
      }
      else {
        return isWordPresent(index + 1, chars, child, checkWord);
      }
    }
  }

  public boolean startsWith(String prefix){
    return isWordPresent(0, prefix.toCharArray(), root, false);
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
//    trie.insert("ar");
//    trie.insert("ar");
//    trie.insert("ab");
//    trie.insert("a");
//
//    System.out.println(trie.search("ab"));
//    System.out.println(trie.search("ar"));
//    System.out.println(trie.search("a"));
//    System.out.println(trie.search("arka"));
//    System.out.println(trie.startsWith("ac"));
//    System.out.println(trie.startsWith("a"));
//    System.out.println(trie.startsWith("ab"));
//    System.out.println(trie.startsWith(""));


    trie.insert("apple");
    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.startsWith("app"));
    trie.insert("app");
    System.out.println(trie.search("app"));


  }
}
