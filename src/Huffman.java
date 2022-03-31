public class Huffman {


    public static void main(String[] args) {

        HuffTables tables = new HuffTables();

        //String sequence = "DQTD9";
        String sequence = "00110100000101";

        String bits= tables.bitsToSymbols(sequence);
        System.out.print(bits);

    }


}
