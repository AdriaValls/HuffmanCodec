import java.util.*;

public class HuffTree {
    private HuffNode initialNode;
    private List<HuffNode> huffmanTree;

    private HashMap<String,Float> freqTable;

    public HuffTree(HashMap<String,Float> freqTable){
        this.freqTable = freqTable;
        treeFromTable(freqTable);
    }

    public void treeFromTable(HashMap<String,Float> freqTable){
        Queue<HuffNode> nodesQ = nodeListFromTable(freqTable);
        List<HuffNode> tree = new ArrayList<HuffNode>();

        HuffNode x = nodesQ.poll();
        HuffNode y = nodesQ.poll();
        float currentFreq = x.getFrequency() + y.getFrequency();

        while(!nodesQ.isEmpty()){
            HuffNode newNode = new HuffNode(currentFreq);
            x.setId(tree.size());
            tree.add(x);
            y.setId(tree.size());
            tree.add(y);
            newNode.setOneNode(x.getId());
            newNode.setZeroNode(y.getId());
            nodesQ.add(newNode);

            x = nodesQ.poll();
            y = nodesQ.poll();
            currentFreq = x.getFrequency() + y.getFrequency();
        }

        HuffNode newNode = new HuffNode(currentFreq);
        x.setId(tree.size());
        tree.add(x);
        y.setId(tree.size());
        tree.add(y);
        newNode.setOneNode(x.getId());
        newNode.setZeroNode(y.getId());
        newNode.setId(tree.size());
        tree.add(newNode);
        this.initialNode = newNode;
        this.huffmanTree = tree;
    }



    /**
     * Creates nodes and adds them to a priority queue ordered by frequencies.
     * @Queue<HuffNode>
     */
    public Queue<HuffNode> nodeListFromTable(HashMap<String,Float> freqTable){
        Queue<HuffNode> nodes = new PriorityQueue<HuffNode>(new nodeComparator());
        for(String key : freqTable.keySet()){
            HuffNode newNode = new HuffNode(freqTable.get(key), key);
            nodes.add(newNode);
        }
        return nodes;
    }

    /**
     * It calculates the total sum of the frequencies (It should be 1 always).
     * @return Float
     */
    public float frequencySumFromTable(HashMap<String,Float> freqTable){
        float freqSum = 0;
        for(String key : freqTable.keySet()){
            freqSum += freqTable.get(key);
        }
        return freqSum;
    }

    /**
     * It creates a table with Symbols and it's respective nodes from the tree.
     * @return HashMap<String,String>
     */
    public HashMap<String,String> codeTableFromTree(){
        HashMap<String,String> symbolCodeTable = new HashMap<String,String>();
        HashMap<String,String>  codeTable = generateTable(symbolCodeTable, initialNode.getId(),"");
        return codeTable;
    }
    public HashMap<String,String> generateTable(HashMap<String,String> table, int nodeId, String code) {
        HuffNode nextNode = huffmanTree.get(nodeId);
        if (nextNode.isHasSymbol()) {
            table.put(nextNode.getSymbol(), code);
            return table;
        }
        if (nextNode.isHasOne()) {
            String newCode = code + "1";
            table = generateTable(table, nextNode.getNextOne(), newCode);
        }
        if(nextNode.isHasZero()){
            String newCode = code + "0";
            table = generateTable(table, nextNode.getNextZero(), newCode);
        }
        return table;
    }

    /**
     * Prints all the nodes and their values of the tree,
     */
    public void printNodes(){
        for(int i = 0; i < huffmanTree.size(); i++){
            String nodes = huffmanTree.get(i).nodeToString();
            System.out.print(nodes + "\n");
        }
    }

}
