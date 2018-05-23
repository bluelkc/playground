import org.junit.Test;
import sort.MergeSorter;
import sort.Sorter;

import java.util.Comparator;

/**
 * Created by kecen on 10/5/18.
 */
public class MergeSorterTest {
    @Test
    public void sort() throws Exception {


        MyNumber[] arr = {new MyNumber(11),
                new MyNumber(1),
                new MyNumber(6),
                new MyNumber(13),
                new MyNumber(2),
                new MyNumber(8),
                new MyNumber(65),
                new MyNumber(21),
                new MyNumber(18),};
        Sorter s = new MergeSorter();
        Comparator c = new MyComparator();
        s.sort(arr, c);

        for(MyNumber m : arr) {
            m.print();
        }
    }
}