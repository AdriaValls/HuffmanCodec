import java.util.HashMap;

public class Huffman {

    public static void main(String[] args) {
        HashMap<String,String> codeTable;
        HashMap<String,String> inverseCodeTable;
        HashMap<String,Float> symbolFreqTable;
        HuffTree hTree;

        //generating the Symbol/Frequency table.
        HuffTables tables = new HuffTables();
        symbolFreqTable = tables.getFreqTable();

        //Number of bits for symbol without compressing and Entropy.
        int bitsBfCompression = numBitsForDecoding(symbolFreqTable);
        float entropy = entropyFromFrequencyTable(symbolFreqTable);
        System.out.print(entropy);

        //Creating a tree and a Symbol/Code table
        hTree = new HuffTree(symbolFreqTable);
        codeTable = hTree.getCodeTable();
        System.out.print(codeTable +"\n");

        //String sequence = "DQTD9"
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

    public static float entropyFromFrequencyTable(HashMap<String,Float> freqTable){
        float entropy = 0;

        for(String key : freqTable.keySet()){
            float prob = freqTable.get(key);
            double bitNeeded =  prob * (Math.log(prob) / Math.log(2));
            entropy += bitNeeded;
        }

        return -1*entropy;
    }

    public static int numBitsForDecoding(HashMap<String,Float> freqTable){
        int totalElements = freqTable.size();
        double bitNeeded =  Math.round(Math.log(totalElements) / Math.log(2));
        return (int) bitNeeded;
    }


}
