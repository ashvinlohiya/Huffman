import java.io.*;
import java.util.PriorityQueue;

/**
 * Created by ashvinlohiya on 04-01-2017.
 */

public class Compression {
    public static final int sizeOfExtendedASCII = 256;


    //Get the frequency of individual characters in the file
    public PriorityQueue frequency(String filename,byte[] bytes) throws IOException {

//        char[] freq = new char[sizeOfExtendedASCII];
//        File file = new File(filename);
//        byte[] bytes = new byte[(int) file.length()];
//        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
//        dataInputStream.readFully(bytes);
//        dataInputStream.close();



        int[] temp = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            temp[i] = (bytes[i] & 0xff);
        }

        int[] frequency = new int[sizeOfExtendedASCII];
        for (int i = 0; i < temp.length; i++) {
            frequency[temp[i]]++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (int i = 0; i < 256; i++) {
            Node nod = new Node((char)i, frequency[i], null, null);
            if (nod.frequency > 0) {
                pq.add(nod);
            }
        }
//
//        for (int i = 0; i < 256; i++) {
//            Node nod = pq.remove();
//            System.out.println(nod.frequency);
//        }


        //iterate till end of file
        //add to respective component each time
        return pq;
    }

    public Node hufTrie(PriorityQueue pq){

        while((pq.size() > 1)){

            Node left = (Node) pq.remove();

            Node right = (Node) pq.remove();

            Node cur = new Node(right.frequency + left.frequency, left, right);
            pq.add(cur);

        }

        // System.out.println("size--> " + pq.size());
        //Node temp = (Node) pq.remove();
        //System.out.println(temp.right.right.left.frequency);
        return (Node) pq.remove();
    }

    public boolean isLeaf(Node sh){

        return (sh.right == null && sh.left == null);

    }
    public void codeFinal(String[] codes, Node sh, String temp){

        if(!isLeaf(sh)){
            codeFinal(codes,sh.left,temp + "0");
            codeFinal(codes,sh.right,temp + "1");
        }

        else
            codes[sh.character] = temp;

    }

}
