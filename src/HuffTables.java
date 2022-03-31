import java.util.HashMap;

public class HuffTables {
    private HashMap<String,Integer> originalCountTable;
    private HashMap<String,Float> symbolFreqTable;


    public HuffTables(){
        HashMap<String, Float> symbolFreqTable = new HashMap<>();

        symbolFreqTable.put("D", (float) 0.3);
        symbolFreqTable.put("K", (float) 0.2);
        symbolFreqTable.put("Q", (float) 0.2);
        symbolFreqTable.put("J", (float) 0.15);
        symbolFreqTable.put("T", (float) 0.1);
        symbolFreqTable.put("9", (float) 0.05);
        HuffTree hTree = new HuffTree(symbolFreqTable);
        hTree.printNodes();

        HashMap<String,String> codeTable =hTree.codeTableFromTree();
        System.out.print(codeTable);
    }
}
