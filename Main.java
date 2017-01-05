import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ashvinlohiya on 04-01-2017.
 */


public class Main {
    public static final int sizeOfExtendedASCII = 256;


    public static void main(String[] args) throws IOException {
        //File file = new File("C:/Users/FLEX-2/IdeaProjects/Huffman/src/Hello.txt");
        File file = new File("C:/Users/FLEX-2/Desktop/CSS/CSS-Images/bbc_pollution.jpg");
        byte[] bytes = new byte[(int) file.length()];
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        dataInputStream.readFully(bytes);
        dataInputStream.close();
        //System.out.println(Arrays.toString(bytes));
        //System.out.println("BR");
        int[] temp = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            temp[i] = (bytes[i] & 0xff);
        }
        //System.out.println(Arrays.toString(temp));


        int[] frequency = new int[sizeOfExtendedASCII];
        for (int i = 0; i < temp.length; i++) {
            frequency[temp[i]]++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        for (int i = 0; i < 256; i++) {
            Node nod = new Node((char)i, frequency[i], null, null);
            pq.add(nod);
        }

        for (int i = 0; i < 256; i++) {
            Node nod = pq.remove();
            System.out.println(nod.frequency);


        }

    }








}
