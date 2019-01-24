package RedBlackTree;

import SetAndMap.FileOperation;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());
//            Collections.sort(wordlist);//进行一次排序?
            RBTree<String, Integer> rbTree = new RBTree<>();
            long startTime = System.nanoTime();
            for (String word : wordlist) {
                if (rbTree.contains(word))
                    rbTree.set(word, rbTree.get(word) + 1);
                else
                    rbTree.add(word, 1);
            }
            System.out.println("Time: " + (System.nanoTime() - startTime) / 1000000000.0);
            System.out.println("Total different words: " + rbTree.getSize());
            System.out.println("freq of pride: " + rbTree.get("pride"));
            System.out.println("freq of prejudice: " + rbTree.get("prejudice"));

            System.out.println("----------------pride-and-prejudice----------------");
        }
    }
}