/**
 * Created by ashvinlohiya on 05-01-2017.
 */
public class Decompression {

    Compression cp = new Compression();

    public void decompression(Node root) {
        Node cur = root;
        String lol = "1101100011010101011111001110101011111010010110010011110110110010000110111101110011100110011010010001000101000111110110101101100001100101000011111110111111000011111001111110001101001010100000000";
        for (int i = 0; i < lol.length(); i++) {
            if (lol.charAt(i) == '0') {
                cur = cur.left;
                if (cp.isLeaf(cur)) {
                    System.out.print(cur.character);
                    cur = root;
                }
            }
            if (lol.charAt(i) == '1') {
                cur = cur.right;

                if (cp.isLeaf(cur)) {

                    System.out.print(cur.character);
                    cur = root;
                }
            }
        }
    }
}
