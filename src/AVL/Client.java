package AVL;

import SetAndMap.FileOperation;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : wordlist) {
                if (avlTree.contains(word))
                    avlTree.set(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }
            System.out.println("Total different words: " + avlTree.getSize());
            System.out.println("freq of pride: " + avlTree.get("pride"));
            System.out.println("freq of prejudice: " + avlTree.get("prejudice"));
            System.out.println("is BST : " + avlTree.isBST());
            System.out.println("is Balanced : " + avlTree.isBalanced());
            System.out.println("----------------pride-and-prejudice----------------");
        }
    }
}