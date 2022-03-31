public class HuffNode implements Comparable<HuffNode>{
    private char symbol;
    private int nodeId;
    private float frequency;

    private int nextZero;
    private int nextOne;
    private boolean hasZero;
    private boolean hasOne;
    private boolean hasSymbol;


    public HuffNode(float val) {
        this.value = val;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = false;

    }
    public HuffNode(int id, float val){
        this.nodeId = id;
        this.frequency = val;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = false;
    }



    public HuffNode(int id, float val, String sy) {
        this.nodeId = id;
        this.frequency = val;
        this.symbol = sy;
        this.hasSymbol = true;
    }

    public void setId(int id){
        this.nodeId = id;
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

    private float getFrequency(){
        return this.frequency;



    @Override
    public int compareTo(HuffNode otherNode) {
        return (int) (this.frequency - otherNode.frequency);
    }
}
