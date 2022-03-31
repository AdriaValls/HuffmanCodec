import java.util.HashMap;

public class Huffman {

    public static void main(String[] args) {
        HashMap<String,String> codeTable;
        HashMap<String,String> inverseCodeTable;
        HashMap<String,Float> symbolFreqTable;
        HuffTree hTree;

        //generating the Symbol/Frequency table
        HuffTables tables = new HuffTables();
        symbolFreqTable = tables.getFreqTable();

        hTree = new HuffTree(symbolFreqTable);
        codeTable = hTree.getCodeTable();
        System.out.print(codeTable +"\n");


        //String sequence = "DQTD9";
        String sequence = "00110100000101";

        String bits= bitsToSymbols(hTree, sequence);
        System.out.print(bits);

    }


    public static String bitsToSymbols(HuffTree tree, String bits){
        return  tree.symbolsFromBits(bits);
    }

    public static String symbolsToBits(HashMap<String,String> codeTable, String squence){
        String bits = "";
        for(int i = 0; i<squence.length(); i++) {
            char a = squence.charAt(i);
            String symbol = "" + a;
            bits = bits+codeTable.get(symbol);        }
        return bits;
    }



}
