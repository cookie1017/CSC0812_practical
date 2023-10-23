import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MyClass {
    public static void main(String[] args) throws FileNotFoundException
    {
    /*    Scanner inFile = new Scanner(new FileReader("D:\\360MoveData\\Users\\HP\\Desktop\\data.txt"));
        PrintWriter outFile = new PrintWriter("D:\\360MoveData\\Users\\HP\\Desktop\\results.txt");
// Other declarations
// Reading and processing the input data
// Printing out the results
        outFile.close();*/
        Scanner scanner = new Scanner(new FileReader("D:\\360MoveData\\Users\\HP\\Desktop\\data.txt")); // Reading from input file
        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[,;:.!?\"]", "").toLowerCase();
            if (word.matches("[a-z]+")) {//这个表达式使用正则表达式检查word是否只包含一个或多个小写字母。
                words.add(word);
            }
        }

        Collections.sort(words);
        ArrayList<String> dictionary = new ArrayList<>(new HashSet<>(words));

        try (PrintWriter writer = new PrintWriter("D:\\360MoveData\\Users\\HP\\Desktop\\results.txt")) { // Writing to output file
            for (String word : dictionary) {
                writer.println(word);
            }
            /*在Java中，使用PrintWriter时，你通常不需要显式地调用writer.close()方法来关闭流。
            这是因为在使用try-with-resources语句块时，会自动确保在程序退出时关闭资源。
            在这种语法下，PrintWriter会在try语句块结束时自动关闭。
            当程序执行离开try块时，不论是因为正常结束还是由于异常，PrintWriter都会被关闭。
            这种方式可以确保资源被正确关闭，避免了忘记手动调用close()方法可能引发的问题。
            所以，在使用try-with-resources语句块时，通常不需要手动调用writer.close()。
            系统会自动帮你管理文件的关闭操作。*/
        } catch (IOException e) {
            e.printStackTrace();

        }

        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        /*这行代码将word作为键，它的频率加1作为值，放入wordFrequency中。
        如果word已经存在于wordFrequency中，它的频率就会加1，如果不存在，就将word加入wordFrequency并设置频率为1。
        * */
        int maxWordLength = 30;
        for (String word : dictionary) {
            System.out.printf("%-" + maxWordLength + "s %d\n", word, wordFrequency.get(word));
        }

    }

    }

