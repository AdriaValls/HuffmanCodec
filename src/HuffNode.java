public class HuffNode {
    private String symbol;
    private int nodeId;
    private float value;

    private int nextZero;
    private int nextOne;
    private boolean hasZero;
    private boolean hasOne;
    private boolean hasSymbol;

    private HuffNode(int id, float val){
        this.nodeId = id;
        this.value = val;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = false;
    }

    private HuffNode(int id, int val, String sy) {
        this.nodeId = id;
        this.value = val;
        this.symbol = sy;
        this.hasSymbol = true;
    }

    private void setZeroNode(int id){
        this.nextZero = id;
        this.hasZero = true;
    }
    private void setOneNode(int id){
        this.nextOne = id;
        this.hasOne = true;
    }

    private boolean isHasSymbol(){
        return hasSymbol;
    }

    private boolean isHasZero(){
        return hasZero;
    }

    private boolean isHasOne(){
        return hasOne;
    }

    private int getNextZero(){
        return this.nextZero;
    }

    private int getNextOne(){
        return this.nextOne;
    }

    private float getValue(){
        return this.value;
    }


}
