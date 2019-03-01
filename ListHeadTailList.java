import java.util.*;

/**
 * This class is an list based implemntilaton of HeadTailListInterface
 *
 * @author Michael Vincent Rayo
 *
 * @since 2019-02-28
 *
 * @version 1.2
 *
 */

public class ListHeadTailList<T> implements HeadTailListInterface<T> {

    private List<T> list;


    /**
     * Constructs an ArrayHeadTailList of a given size
     * @param initialCapacity the desired stating size of the list
     */
    public ListHeadTailList(int initialCapacity) {
        if (initialCapacity < 1) {
            initialCapacity = 1;
        }
        list = new ArrayList<T>(initialCapacity);
    }

    /**
     * Adds a new element to the font of the list.
     * The list's size is incermented.
     *
     * @param newEntry The object to be added as a new element in the list.
     */
    public void addFront(T anEntry) {
        list.add(0, anEntry);
    }

    /**
     * Adds a new element to the end of the list.
     * The list's size is incermented.
     *
     * @param newEntry The object to be added as a new element in the list.
     */
    public void addBack(T anEntry) {
        list.add(anEntry);
    }

    /**
     * Removes an element from the front of the list.
     * The list's  number of elements is decermented.
     *
     * @return The removed element or null if the list is empty.
     */
    @Override
    public T removeFront() {
        if (!isEmpty()) {
            return list.remove(0);
        } else {
            return null;
        }
    }

    /**
     * Removes an element from the end of the list.
     * The list's  number of elements is decermented.
     *
     * @return The removed element or null if the list is empty.
     */
    @Override
    public T removeBack() {
        if (!isEmpty()) {
            return list.remove(list.size()-1);
        } else {
            return null;
        }
    }

    /**
     * Removes all elements from the list
     */
    @Override
    public void clear() {
            list.clear();
    }

    /**
     * Retrieves the element at a the given position in this list.
     *
     * @param position An integer that indicates the index of the desired entry.
     * @return The element at the given index or null if the index is out of bounds.
     */
    @Override
    public T getEntry(int givenPosition) {
        if (!isEmpty() && givenPosition > -1 && givenPosition <= list.size()) {
            return list.get(givenPosition);
        } else {
            return null;
        }
    }

    /**
     * Prints the contents of the list to the screen
     */
    @Override
    public void display() {
        System.out.println(Arrays.toString(list.toArray()));

    }

    /**
     * Checks whether this list contains a given entry.
     *
     * @param anEntry the object to search for in the list.
     * @return the position of the entry that was found or -1 if the object is not found.
     */
    @Override
    public int contains(T anEntry) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(anEntry)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Gets the size of the list
     * @return a count of the elements in the list
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Tests to see if the list is empty
     * @return The boolean result of the test for emptyness
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
