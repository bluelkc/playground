package sort;

import java.util.Comparator;
import java.util.List;

/**
 * Created by kecen on 3/5/18.
 */
public interface Sorter {

    public abstract void sort(Object[] list, Comparator c);
    public void sort(Object[] list);
}
