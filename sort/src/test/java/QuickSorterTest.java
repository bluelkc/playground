import java.util.Comparator;
import org.junit.Test;
import sort.QuickSorter;
import sort.Sorter;

/**
 * Created by kecen on 3/5/18.
 */
public class QuickSorterTest {

    @Test
    public void sort() {

        MyNumber[] arr = {new MyNumber(11),
                            new MyNumber(1),
                            new MyNumber(6),
                            new MyNumber(13),
                            new MyNumber(2),
                            new MyNumber(8),
                            new MyNumber(65),
                            new MyNumber(21),
                            new MyNumber(18),};
        Sorter s = new QuickSorter();
        Comparator c = new MyComparator();
        s.sort(arr, c);

        for(MyNumber m : arr) {
            m.print();
        }
    }

}

class MyNumber {

    private int value;
    public MyNumber(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public void print() {
        System.out.println(value);
    }
}

class MyComparator implements Comparator<MyNumber> {

    public int compare(MyNumber num1, MyNumber num2) {
        if (num1.getValue() > num2.getValue()) {
            return 1;
        } else if (num1.getValue() < num2.getValue()) {
            return -1;
        }
        return 0;
    }
}