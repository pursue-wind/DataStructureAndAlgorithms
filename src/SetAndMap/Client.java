package SetAndMap;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 测试类
 * @author: mirrorming
 * @create: 2019-01-03 11:19
 **/

public class Client {
    public static void main(String[] args) {
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : wordlist)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
            System.out.println("----------------pride-and-prejudice----------------");
        }
        System.out.println();
        ArrayList<String> wordlist2 = new ArrayList<>();
        if (FileOperation.readFile("src/a-tale-of-two-cities.txt", wordlist2)) {
            System.out.println("----------------a-tale-of-two-cities----------------");
            System.out.println("Total words: " + wordlist2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : wordlist2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
            System.out.println("----------------a-tale-of-two-cities----------------");
        }
    }

    public static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();
        ArrayList<String> wordlist = new ArrayList<>();
        if (FileOperation.readFile(fileName, wordlist)) {
            System.out.println("Total words:" + wordlist.size());
            for (String word : wordlist)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testTime() {
        BSTSet<String> bstSet = new BSTSet<>();
        LinkedListSet<String> linkedListSet = new LinkedListSet<>();

        System.out.println(testSet(bstSet, "src/pride-and-prejudice.txt"));
        System.out.println(testSet(linkedListSet, "src/pride-and-prejudice.txt"));
    }

    public static double testMap(Map<String, Integer> map, String fileName) {
        long startTime = System.nanoTime();
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile(fileName, wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());
            for (String word : wordlist) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("freq of pride: " + map.get("pride"));
            System.out.println("freq of prejudice: " + map.get("prejudice"));
            System.out.println("----------------pride-and-prejudice----------------");
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testMapTime() {
        Map<String, Integer> bstMap = new BSTMap<>();
        Map<String, Integer> linkedListMap = new LinkedListMap<>();
        double d1 = testMap(bstMap, "src/pride-and-prejudice.txt");
        double d2 = testMap(linkedListMap, "src/pride-and-prejudice.txt");
        System.out.println(d1);
        System.out.println(d2);
    }

    @Test
    public void test2() {
        ArrayList<String> wordlist = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist.size());

            BSTMap<String, Integer> set1 = new BSTMap<>();
            for (String word : wordlist) {
                if (set1.contains(word))
                    set1.set(word, set1.get(word) + 1);
                else
                    set1.add(word, 1);
            }
            System.out.println("Total different words: " + set1.getSize());
            System.out.println("freq of pride: " + set1.get("pride"));
            System.out.println("freq of prejudice: " + set1.get("prejudice"));
            System.out.println("----------------pride-and-prejudice----------------");
        }
        ArrayList<String> wordlist2 = new ArrayList();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", wordlist2)) {
            System.out.println("----------------pride-and-prejudice----------------");
            System.out.println("Total words: " + wordlist2.size());

            LinkedListMap<String, Integer> set1 = new LinkedListMap<>();
            for (String word : wordlist2) {
                if (set1.contains(word))
                    set1.set(word, set1.get(word) + 1);
                else
                    set1.add(word, 1);
            }
            System.out.println("Total different words: " + set1.getSize());
            System.out.println("freq of pride: " + set1.get("pride"));
            System.out.println("freq of prejudice: " + set1.get("prejudice"));
            System.out.println("----------------pride-and-prejudice----------------");
        }
    }

}