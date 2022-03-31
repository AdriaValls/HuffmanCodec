public class Huffman {


    public static void main(String[] args) {

        HuffTables tables = new HuffTables();

        String sequence = "DQTD9";

        String bits= tables.symbolsToBits(sequence);
        System.out.print(bits);
        //assert bits.equals("00110100000101");

    }


}
