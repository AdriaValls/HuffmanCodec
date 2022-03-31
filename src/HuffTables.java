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
        this.symbolFreqTable = symbolFreqTable;
    }

    public String generateRandomSymbols(int numSymbols){
        String sequencia = "";
        for(int i=0; i<numSymbols;i++){
            double random = Math.random(); //0-1
            float sumFreq = 0;
            for(String key : symbolFreqTable.keySet()){
                sumFreq += symbolFreqTable.get(key);
                if(sumFreq>random){
                    sequencia = sequencia+key;
                    break;
                }
            }
        }
        return sequencia;
    }

    public HashMap<String,Float> getFreqTable(){
        return symbolFreqTable;
    }



}
