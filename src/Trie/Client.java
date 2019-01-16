package Trie;

import BinarySearchTree.BST;
import SetAndMap.BSTSet;
import SetAndMap.FileOperation;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试
 * @author: mirrorming
 * @create: 2019-01-14 13:54
 **/

public class Client {
    public static void main(String[] args) {
        System.out.println("----------------pride-and-prejudice----------------");
        long startTime = System.nanoTime();
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("Total words: " + wordlist.size());
            HashSet<String> set1 = new HashSet<>();
            for (String word : wordlist)
                set1.add(word);
            for (String word : wordlist)
                set1.contains(word);
            System.out.println("Total different words: " + set1.size());

        }
        System.out.println("BSTSet_time: " + (System.nanoTime() - startTime) / 1000000000.0);
        System.out.println("----------------pride-and-prejudice----------------");

        System.out.println();

        System.out.println("----------------pride-and-prejudice----------------");
        long startTime2 = System.nanoTime();
        ArrayList<String> wordlist2 = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("Total words: " + wordlist.size());

            Trie trie = new Trie();
            for (String word : wordlist)
                trie.add(word);
            for (String word : wordlist)
                trie.contains(word);
            System.out.println("Total different words: " + trie.getSize());
        }
        System.out.println("Trie_time: " + (System.nanoTime() - startTime2) / 1000000000.0);
        System.out.println("----------------pride-and-prejudice----------------");
    }
}