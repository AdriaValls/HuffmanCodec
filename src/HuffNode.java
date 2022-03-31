public class HuffNode implements Comparable<HuffNode>{
    private char symbol;
    private int nodeId;
    private float frequency;

    private int nextZero;
    private int nextOne;
    private boolean hasZero;
    private boolean hasOne;
    private boolean hasSymbol;

    private HuffNode(int id, float val){
        this.nodeId = id;
        this.frequency = val;
        this.hasZero = false;
        this.hasOne = false;
        this.hasSymbol = false;
    }

    private HuffNode(int id, int val, char sy) {
        this.nodeId = id;
        this.frequency = val;
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

    private float getFrequency(){
        return this.frequency;
    }


    @Override
    public int compareTo(HuffNode otherNode) {
        return (int) (this.frequency - otherNode.frequency);
    }
}
