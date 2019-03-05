
import java.util.Arrays;

/**
 * This class is an array based implemntilaton of HeadTailListInterface
 *
 * @author Michael Vincent Rayo
 * @author Thomas Lynn Jessop
 * @author Kurt Wahlberg
 *
 * @since 2019-02-28
 *
 * @version 2.0
 *
 */

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {

    //Instance data
        private T[] listArray;
        private int numberOfElements;
        private static int defaultSize = 25;

    /**
     * Constructs an ArrayHeadTailList of a given size
     * @param initialCapacity the desired stating size of the list
     */
    public ArrayHeadTailList(int initialCapacity){
            if (initialCapacity < 1) {
                 initialCapacity = defaultSize;
            }
            listArray = (T[]) new Object[initialCapacity];
            numberOfElements = 0;
        }

    /**
     *Constructs an ArrayHeadTailList of the default size
     */
    public ArrayHeadTailList(){
           this(defaultSize);
        }

    /**
     * Adds a new element to the font of the list.
     * The list's size is incermented.
     *
     * @param newEntry The object to be added as a new element in the list.
     */
        @Override
        public void addFront(T newEntry) {

            if(listArray[0] != null ){
                this.shiftBack();
            }
            numberOfElements++;
            listArray[0] = newEntry;
        }

    /**
     * Adds a new element to the end of the list.
     * The list's size is incermented.
     *
     * @param newEntry The object to be added as a new element in the list.
     */
        @Override
        public void addBack(T newEntry) {
            if(isEmpty()){
                listArray[0] = newEntry;
            } else {
                if(listArray[listArray.length-1] != null){
                makeRoom(); }
                listArray[numberOfElements] = newEntry;
            }

            numberOfElements++;

        }

    /**
     * Removes an element from the front of the list.
     * The list's  number of elements is decermented.
     *
     * @return The removed element or null if the list is empty.
     */
        @Override
        public T removeFront() {
          if(numberOfElements>0){
          T temp = listArray[0];
          shiftUp();
          numberOfElements--;
          return temp;
          }
            return null;
        }
    /**
     * Removes an element from the end of the list.
     * The list's  number of elements is decermented.
     *
     * @return The removed element or null if the list is empty.
     */
        @Override
        public T removeBack() {
          if(numberOfElements>0){
            T temp = listArray[numberOfElements-1];
            listArray[numberOfElements - 1] = null;
            numberOfElements--;
            return temp;
            }
            return null;
        }
    /**
     * Retrieves the element at a the given position in this list.
     *
     * @param position An integer that indicates the index of the desired entry.
     * @return The element at the given index or null if the index is out of bounds.
     */
        @Override
        public T getEntry(int position) {
            if (!isEmpty() && (position > -1 && position <= numberOfElements)) {
                return listArray[position]; // reference to the indicated entry
            } else {
                return null; // according to interface specification, return null if index is out of bounds
            }
        }

    /**
     * Prints the contents of the list to the screen
     */
    @Override
        public void display() {
            System.out.printf("capacity: %s  Elements: %s", String.valueOf(listArray.length), String.valueOf(numberOfElements));

          for(T item : listArray){
            if(item != null){
              System.out.println(item);
            }
          }
        }

    /**
     * Checks whether this list contains a given entry.
     *
     * @param anEntry the object to search for in the list.
     * @return the position of the entry that was found or -1 if the object is not found.
     */
        @Override
        public int contains(T anEntry) {
            for (int i = 0; i < numberOfElements; i++) {
                if (listArray[i].equals(anEntry)) {
                        return i;
                }
            }
            return -1;
        }

    /**
     * Tests to see if the list is empty
     * @return The boolean result of the test for emptyness
     */
    @Override
        public boolean isEmpty() {
            return (numberOfElements == 0);
        }

    /**
     * Gets the size of the list
     * @return a count of the elements in the list
     */
    @Override
        public int size() {
            return numberOfElements;
        }

    /**
     * Removes all elements from the list
     */
        @Override
        public void clear() {
            for (int i = 0; i < numberOfElements; i++) {
                listArray[i] = null;
            }
            numberOfElements = 0;

        }

        //Private helper methods

        //Shifts elements backward in the list
        private void shiftBack(){

            if (numberOfElements + 1 > listArray.length){
                makeRoom();
            }
            for (int i = numberOfElements -1; i > -1; i--) {
                listArray[i + 1] = listArray[i];
            }

        }

        //Shifts elements forward in the list
        private void shiftUp(){
            if (numberOfElements + 1 > listArray.length){
                makeRoom();
            }
            for (int i = 0; i < numberOfElements -1; i++) {
                listArray[i] = listArray[i+1];
            }
        }

        //Increases the size of the list
        private int makeRoom(){
            T[] newArray = (T[]) new Object[listArray.length * 2];

            for (int i = 0; i < listArray.length; i++){
                newArray[i] = listArray[i];
            }
            listArray = newArray;
            return listArray.length;
        }

}
