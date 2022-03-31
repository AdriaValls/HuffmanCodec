public class HuffNode{
    private String symbol;
    private int nodeId;
    private float frequency;

    private int nextZero;
    private int nextOne;
    private boolean hasZero;
    private boolean hasOne;
    private boolean hasSymbol;


    public HuffNode(float frequency) {
        this.frequency = frequency;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = false;
    }

    public HuffNode(float frequency, String symbol){
        this.symbol = symbol ;
        this.frequency = frequency;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = true;
    }

    public void setId(int id){
        this.nodeId = id;
    }

    public int getId(){
        return nodeId;
    }

    public void setZeroNode(int id){
        this.nextZero = id;
        this.hasZero = true;
    }
    public void setOneNode(int id){
        this.nextOne = id;
        this.hasOne = true;
    }

    public boolean isHasSymbol(){
        return hasSymbol;
    }

    public boolean isHasZero(){
        return hasZero;
    }

    public boolean isHasOne(){
        return hasOne;
    }

    public int getNextZero(){
        return this.nextZero;
    }

    public int getNextOne(){
        return this.nextOne;
    }

    public float getFrequency(){
        return this.frequency;
    }
    public String getSymbol(){
        return this.symbol;
    }


    public String nodeToString(){
        String toS = "Node "+nodeId+ ", amb frequencia: "+frequency;
        if(isHasSymbol()){
            toS = toS +", i Simbol "+symbol;
        }
        return toS;
    }
}
