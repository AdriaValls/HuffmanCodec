import org.junit.Test;

public class HuffNodesTest {

    @Test
    public void symbolToBitsTest(){
        String sequence = "DQTD9";
        HuffTables tables = new HuffTables();

        String bits= tables.symbolsToBits(sequence);
        System.out.print(bits);
        assert bits.equals("00110100000101");
    }
}