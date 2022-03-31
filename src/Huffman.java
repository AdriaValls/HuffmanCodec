import java.util.HashMap;

public class Huffman {

    public static void main(String[] args) {

        HashMap<String,String> codeTable;
        HashMap<String,Float> symbolFreqTable;
        HuffTree huffmanTree;

        //generating the Symbol/Frequency table.
        HuffTables tables = new HuffTables();
        symbolFreqTable = tables.getFreqTable();
        System.out.print("Symbol/Frequency table: "+symbolFreqTable+"\n"+"\n");

        //Number of bits for symbol without compressing and Entropy.
        int bitsBfCompression = numBitsForDecoding(symbolFreqTable);
        System.out.print("Bits needed to encode each character without compression: "+bitsBfCompression+"\n");
        float entropy = entropyFromFrequencyTable(symbolFreqTable);
        System.out.print("Entropy of this table: "+entropy+"\n"+"\n");

        //Creating a tree and a Symbol/Code table
        System.out.print("We are now Creating a Tree from the frequency table!\n");
        huffmanTree = new HuffTree(symbolFreqTable);
        System.out.print("Those are the nodes of our tree:\n");
        huffmanTree.printNodes();
        codeTable = huffmanTree.getCodeTable();
        System.out.print("\n"+"Resulting Code table of our tree: "+codeTable+"\n");
        float bitsNeed = bitsFromCodeTable(codeTable,symbolFreqTable);
        System.out.print("\n"+"Bits needed after compression: "+bitsNeed+"\n"+"\n"+"\n");

        int numSequences = 6;
        for(int i=0; i<numSequences; i++){
            String sequence = tables.generateRandomSymbols(1200);
            System.out.print("Sequence number "+i+": "+sequence+"\n");
            float bitsNoComp = sequence.length() * bitsBfCompression ;
            System.out.print("Total bits needed before compression: "+bitsNoComp+"\n");
            String bits = symbolsToBits(codeTable,sequence);
            System.out.print("New Sequence: "+bits+"\n");
            float newLength = bits.length();
            System.out.print("Total bits after compression: "+newLength+"\n");
            float compRatio =  bitsNoComp/newLength;
            System.out.print("Compression Ratio: "+compRatio+"\n"+"\n"+"\n");
        }
        //String sequence = "DQTD9"
        //String sequence = "00110100000101";

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

    public static float bitsFromCodeTable(HashMap<String,String> codeTable,HashMap<String,Float> freqTable){
        float bitsNeeded = 0;
        for(String key : freqTable.keySet()){
            float prob = freqTable.get(key);
            String bitsCode = codeTable.get(key);
            bitsNeeded += prob*bitsCode.length();
        }
        return bitsNeeded;
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
