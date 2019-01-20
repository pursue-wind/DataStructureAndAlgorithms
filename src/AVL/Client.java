package AVL;

import SetAndMap.BSTMap;
import SetAndMap.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());
            Collections.sort(wordlist);//进行一次排序?
            AVLTree<String, Integer> avlTree = new AVLTree<>();
            long startTime = System.nanoTime();
            for (String word : wordlist) {
                if (avlTree.contains(word))
                    avlTree.set(word, avlTree.get(word) + 1);
                else
                    avlTree.add(word, 1);
            }
            System.out.println("Time: " + (System.nanoTime() - startTime) / 1000000000.0);
            System.out.println("Total different words: " + avlTree.getSize());
            System.out.println("freq of pride: " + avlTree.get("pride"));
            System.out.println("freq of prejudice: " + avlTree.get("prejudice"));
            System.out.println("is BST: " + avlTree.isBST());
            System.out.println("is Balanced: " + avlTree.isBalanced());
            System.out.println("----------------pride-and-prejudice----------------");
        }
    }

    @Test
    public void testBST() {
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());
            Collections.sort(wordlist);//进行一次排序?
            BSTMap<String, Integer> map = new BSTMap<>();
            long startTime = System.nanoTime();
            for (String word : wordlist) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Time: " + (System.nanoTime() - startTime) / 1000000000.0);
            System.out.println("Total different words: " + map.getSize());
            System.out.println("freq of pride: " + map.get("pride"));
            System.out.println("freq of prejudice: " + map.get("prejudice"));
            System.out.println("----------------pride-and-prejudice----------------");
        }
    }
}