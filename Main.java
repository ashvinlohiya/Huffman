import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ashvinlohiya on 04-01-2017.
 */


public class Main {
        public static final int sizeOfExtendedASCII = 256;

    public static void main(String[] args) throws IOException {


        String filename = "C:\\Users\\FLEX-2\\IdeaProjects\\Huffman\\src\\Hello.txt";
        char[] freq = new char[sizeOfExtendedASCII];
        File file = new File(filename);
        byte[] bytes = new byte[(int) file.length()];
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        dataInputStream.readFully(bytes);
        dataInputStream.close();

        Compression hf = new Compression();

        //Node root = hf.hufTrie(hf.frequency("C:/Users/admin/Desktop/SigmaPi.jpg"));
        Node root = hf.hufTrie(hf.frequency(filename,bytes));
        String[] codeFinal = new String[sizeOfExtendedASCII];
        hf.codeFinal(codeFinal, root, "");

        for (int i = 0; i < sizeOfExtendedASCII; i++) {
            System.out.println(i + " " + codeFinal[i]);
        }

    }

}
