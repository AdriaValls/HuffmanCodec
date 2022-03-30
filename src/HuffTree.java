import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class HuffTree {
    private HuffNode initialNode;
    private List<HuffNode> huffmanTree;

    public void treeFromTable(HashMap<String,Float> freqTable){




    }

    public PriorityQueue<HuffNode> nodeListFromTable(HashMap<String,Float> freqTable){
        PriorityQueue<HuffNode> nodes = new PriorityQueue<>();
        for(String key : freqTable.keySet()){
            HuffNode newNode = new HuffNode(freqTable.get(key));
            nodes.add(newNode);
        }

        return nodes;


    }

    public HashMap<String,String> tableFromTree(){
        HashMap<String,String> symbolCodeTable = new HashMap<String,String>();


        return symbolCodeTable;
    }

}
