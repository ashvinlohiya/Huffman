import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import edu.princeton.cs.algs4.*;

/**
 * Created by ashvinlohiya on 04-01-2017.
 */

public class Compression {
    public static final int sizeOfExtendedASCII = 256;


    //Get the frequency of individual characters in the file
    int[] temp;

    public PriorityQueue frequency(byte[] bytes) throws IOException {


        temp = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            temp[i] = (bytes[i] & 0xff);
        }

        int[] frequency = new int[sizeOfExtendedASCII];
        for (int i = 0; i < temp.length; i++) {
            frequency[temp[i]]++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for (int i = 0; i < 256; i++) {
            Node nod = new Node((char) i, frequency[i], null, null);
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

    public Node hufTrie(PriorityQueue pq) {

        while ((pq.size() > 1)) {

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

    public boolean isLeaf(Node sh) {
        return (sh.right == null && sh.left == null);
    }


    public void codeFinal(String[] codes, Node sh, String temp) {

        if (!isLeaf(sh)) {
            codeFinal(codes, sh.left, temp + "0");
            codeFinal(codes, sh.right, temp + "1");
        } else
            codes[sh.character] = temp;

    }

//    public void writewrite(String[] codes) {
//        for (int i = 0; i < temp.length; i++) {
//            String code = codes[temp[i]];
//            for (int j = 0; j < code.length(); j++) {
//                if (code.charAt(j) == '0') {
//                    BinaryStdOut.write(false);
//                } else if (code.charAt(j) == '1') {
//                    BinaryStdOut.write(true);
//                } else throw new IllegalStateException("Illegal state");
//            }
//        }
//        BinaryStdOut.close();
//    }

    public void writeOutput(String[] codes) {
        try {
            File file = new File("output10.txt");

            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < temp.length; i++) {
                fw.write(String.valueOf(codes[temp[i]]));
            }


//
//            ArrayList<String> arraylist = new ArrayList<String>();
//            for (int i = 0; i < temp.length; i++) {
//                String[] arr = codes[temp[i]].split("");
//                for (int j = 0; j < arr.length; j++) {
//                    arraylist.add(arr[j]);
//                }
//            }
//
//            while (arraylist.size() > 8) {
//                String a = "";
//                for (int i = 0; i < 8; i++) {
//
//                    a += arraylist.remove(0);
//                }
//                int check = Integer.parseInt(a);
//                System.out.println(a);
//                ps.write(check);
//
//            }
//
//
//            int padding = 8-arraylist.size();
//            String b = "";
//            for (int i = 0; i < arraylist.size(); i++) {
//                b += arraylist.remove(0);
//            }
//            for (int i = 0; i < padding; i++) {
//                b+=2;
//            }
//            int check1 = Integer.parseInt(b);
//            System.out.println(check1);
//            ps.write(check1);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}



