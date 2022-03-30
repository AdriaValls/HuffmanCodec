public class HuffNode {
    private String symbol;
    private int nodeId;
    private float value;

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
        this.value = val;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = false;
    }


    public HuffNode(int id, float val, String sy) {
        this.nodeId = id;
        this.value = val;
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

    public float getValue(){
        return this.value;
    }


}
