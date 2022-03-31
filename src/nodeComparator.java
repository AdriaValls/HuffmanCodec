import java.util.Comparator;

class nodeComparator  implements Comparator<HuffNode> {

    @Override
    public int compare(HuffNode o1, HuffNode o2) {
        return (o1.getFrequency() <  o2.getFrequency() ? -1 : 1);
    }
}
