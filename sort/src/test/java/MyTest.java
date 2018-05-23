import org.junit.Test;

import java.util.Comparator;

/**
 * Created by kecen on 10/5/18.
 */
public class MyTest {
    @Test
    public void MyTest() throws Exception {

        System.out.println(new Integer(5).equals(new Integer(5)));
        System.out.println(new Integer(500) == new Integer(500));

        System.out.println(Integer.valueOf(5) == Integer.valueOf(5));
        System.out.println(Integer.valueOf(500) == Integer.valueOf(500));
    }
}