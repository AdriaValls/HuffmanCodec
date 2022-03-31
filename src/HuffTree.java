import java.util.*;

public class HuffTree {
    private HuffNode initialNode;
    private List<HuffNode> huffmanTree;
    private HashMap<String,Float> freqTable;
    private  HashMap<String,String> codeTable;
    private  HashMap<String,String> inverseCodeTable;

    public HuffTree(HashMap<String,Float> freqTable){
        this.freqTable = freqTable;
        treeFromTable(freqTable);
        codeTableFromTree();
        invertCodeTable();
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
    public void invertCodeTable(){
        HashMap<String,String> newCodeT = new HashMap<String,String>();

        for(String key : codeTable.keySet()){
            newCodeT.put(codeTable.get(key), key);
        }
        this.inverseCodeTable = newCodeT;
    }

    public HashMap<String,String> getInverseCodeTable(){
        return this.inverseCodeTable;
    }

    public String symbolsFromBits(String bits){

        Queue<String> bitList = new LinkedList<>();
        for(int i = 0; i<bits.length(); i++) {
            char b = bits.charAt(i);
            String nextBit = "" + b;
            bitList.add(nextBit);
        }
        String sequence = "";
        String nextBit = "";
        String nextSeq = "";
        while (!bitList.isEmpty()){
            nextBit = bitList.poll();
            nextSeq = nextSeq+nextBit;
            if(inverseCodeTable.containsKey(nextSeq)){
                sequence = sequence + inverseCodeTable.get(nextSeq);
                nextSeq = "";
            }
        }

        return sequence;
    }

/*
    boolean gotSymbol;
        while (!bitList.isEmpty()){
        gotSymbol = false;
        String nextSymbol = "";
        HuffNode nextNode = initialNode;
        String nextBit = bitList.poll();

        while(!gotSymbol){

            if(nextNode.isHasSymbol()){
                nextSymbol = nextNode.getSymbol();
                sequence = sequence+nextSymbol;
                gotSymbol = true;
            }else{
                if (nextBit.equals("0")){
                    nextNode = huffmanTree.get(nextNode.getNextZero());
                    nextBit = bitList.poll();
                }else{
                    nextNode = huffmanTree.get(nextNode.getNextOne());
                    nextBit = bitList.poll();
                }
            }
        }
    }
*/


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
    public void codeTableFromTree(){
        HashMap<String,String> symbolCodeTable = new HashMap<String,String>();
        HashMap<String,String>  codeTable = generateTable(symbolCodeTable, initialNode.getId(),"");
        this.codeTable = codeTable;
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

    public HashMap<String,String> getCodeTable(){
        return this.codeTable;
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
