package Interface_Project_C;

import java.util.Arrays;

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {

        private T[] listArray;
        private int numberOfElements;
        private static int defaultSize = 25;


        public ArrayHeadTailList(int initialCapacity){
            if (initialCapacity < 1) {
                 initialCapacity = defaultSize;
            }
            listArray = (T[]) new Object[initialCapacity];
            numberOfElements = 0;
        }

        public ArrayHeadTailList(){
           this(defaultSize);
        }


        @Override
        public void addFront(T newEntry) {

            System.out.println(Arrays.toString(listArray));
            if(listArray[0] != null ){
                this.shiftBack();
            }
            numberOfElements++;
            listArray[0] = newEntry;
            System.out.println(Arrays.toString(listArray));
            System.out.println();
        }

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
            System.out.println(Arrays.toString(listArray));

        }

        @Override
        public T removeFront() {
          private T temp = listArray[0];
          shiftUp();
            return temp;
        }

        @Override
        public T removeBack() {
            private T temp = listArray[numberOfElements-1];
            listArray[numberOfElements - 1] = null;
            return temp;
        }

        @Override
        public T getEntry(int position) throws IndexOutOfBoundsException {
            if(listArray[position] != null) {
                return listArray[position];
            }
           else {
               throw new IndexOutOfBoundsException("There is no element at position :" + position);
            }
        }

        @Override
        public T getEntry(int position) {
            // Check if array is empty first
            if (!isEmpty() && (position > -1 && position <= numberOfElements)) {
                return listArray[position];
            } else {
                return null; // according to interface specification
            }
        } // end getEntry()

        @Override
        public void display() {
          for(T item : listArray){
            if(!item == null){
              System.out.printf("%s", item);
              System.out.println();
            }
          }

        }

        @Override
        public int contains(T anEntry) {
            for (int i = 0; i < numberOfElements; i++) {
                if (listArray[i].equals(anEntry)) {
                        return i;
                }
            }
            return -1;
        }

        @Override
        public boolean isEmpty() {
            return (numberOfElements == 0);
        }

        @Override
        public int size() {
            return numberOfElements;
        }

        @Override
        public void clear() {
            for (int i = 0; i < numberOfElements; i++) {
                listArray[i] = null;
            }
            numberOfElements = 0;
            /*
            for (T element : listArray) {
                element = null;
            }
            numberOfElements = 0;
            */
        }

        private void shiftBack(){

            if (numberOfElements + 1 > listArray.length){
                makeRoom();
            }
            for (int i = numberOfElements -1; i > -1; i--) {
                listArray[i + 1] = listArray[i];
            }

        }

        private void shiftUp(){
            if (numberOfElements + 1 > listArray.length){
                makeRoom();
            }
            for (int i = 0; i < numberOfElements -1; i++) {
                listArray[i] = listArray[i+1];
            }
        }

        private int makeRoom(){
            T[] newArray = (T[]) new Object[listArray.length * 2];

            for (int i = 0; i < listArray.length; i++){
                newArray[i] = listArray[i];
            }
            listArray = newArray;
            return listArray.length;
        }

}
