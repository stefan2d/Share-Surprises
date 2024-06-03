import java.util.Arrays;

class MyIntArrayList {

    // TO DO: define fields
    int[] elements;
    int size;


    public MyIntArrayList () {
        this (10);
        this.size = 0;
    }

    public MyIntArrayList (MyIntArrayList c) {

        if (null != c){

            this.elements = new int[c.elements.length];
            this.size = c.elements.length;

            for (int i = 0; i < c.elements.length; i++){

                this.elements[i] = c.elements[i];
            }

        } else {
            throw new IllegalArgumentException ("Invalid object");
        }
    }

    public MyIntArrayList (int initialCapacity) {
        this.size = 0;
        this.elements = new int[ initialCapacity ];
    }

    public  int[] increaseSizeArray (int[] arr,int length) {

        if (0 == length){
            elements = Arrays.copyOf (arr, arr.length * 2);
        } else {
            elements = Arrays.copyOf (arr, arr.length + length);
        }

        return elements;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the
     * right (adds one to their indices).
     *
     * @param index   - index at which the specified element is to be inserted
     * @param element - element to be inserted
     */
    public void add (int index, int element) {

        if (index > elements.length) {
            System.out.println ("Invalid index, OutOfBounds Exception");
        } else if (0 == elements[ index ]) {
            elements[ index ] = element;
        } else {

            boolean foundEmptySlot = false;
            int emptySpot = -1;

            for (int i = index + 1; i < elements.length; i++) {

                if (0 == elements[ i ]) {
                    foundEmptySlot = true;
                    emptySpot = i;
                }
            }
            if (foundEmptySlot) {

                for (int i = emptySpot; i > index; i--) {

                    elements[ i ] = elements[ i - 1 ];
                }
                elements[ index ] = element;
            }
        }
    }


    /**
     * Appends the specified element to the end of this list.
     *
     * @param e - element to be appended to this list
     * @return true
     */
    public boolean add (int e) {

        if (!Character.isDigit (e)) {
            System.out.println ("Invalid literal, enter a digit");
        } else {

            if (this.size == elements.length - 1){
                this.elements = increaseSizeArray (elements, 0);
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size () {
        return elements.length;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param e - element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains (int e) {

        if (!Character.isDigit (e)) {
            System.out.println ("Invalid literal, enter a digit");
        } else {
            for (int i = 0; i < elements.length; i++) {

                if (e == elements[ i ]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get (int index) {

        if (elements.length < index || 0 > index) {
            System.out.println ("Invalid index, OutOfBounds Exception");
        } else {
            return elements[ index ];
        }
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not
     * contain the element.
     *
     * @param e - element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does
     * not contain the element
     */
    public int indexOf (int e) {

        if (!Character.isDigit (e)) {

            System.out.println ("Invalid literal, enter a digit");
        } else {

            for (int i = 0; i < elements.length; i++) {

                if (e == elements[ i ]) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not
     * contain the element.
     *
     * @param e - element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf (int e) {

        if (!Character.isDigit (e)) {
            System.out.println ("Invalid literal ,enter a digit");
        } else {

            for (int i = elements.length -1 ; i >= 0; i--) {

                if (e == elements[ i ]) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present. If the list does not
     * contain the element, it is unchanged.
     *
     * @param e - element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove (int e) {

        boolean removedElement = false;

        if (!Character.isDigit (e)) {
            System.out.println ("Invalid literal, enter a digit");
        } else {

            for (int i = 0; i < elements.length; i++) {

                if (e == elements[ i ]) {

                    elements[ i ] = 0;
                    removedElement = true;
                    break;
                }
            }
        }
        return removedElement;
    }

    /**
     * Removes the element at the specified position in this list. Shifts any subsequent elements to the
     * left (subtracts one from their indices).
     *
     * @param index - the index of the element to be removed
     * @return the element that was removed from the list
     */
    public int removeElementAtIndex (int index) {

        int removedElement = -1;

        if (elements.length < index || 0 > index) {
            System.out.println ("Invalid index, OutOfBounds Exception");
            removedElement = elements[index];
        } else {
            for (int i = index; i < elements.length - 1; i++) {

                elements[i] = elements [i + 1];

            }
            elements[elements.length -1] = 0;
        }
        return removedElement;
    }

    /**
     * Removes all  the elements from this list. The list will be empty after this call returns.
     */
    public void clear () {

        Arrays.fill (elements, 0);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index - index of the element to replace
     * @param e     - element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public int set (int index, int e) {
        int beforeReplace = -1;
        if (elements.length < index || 0 > index || !Character.isDigit (e)){
            System.out.println ("Invalid");
        } else {
            beforeReplace = elements[index];
            elements[index] = e;
        }
        return beforeReplace;
    }

    /**
     * Appends all  the elements in the specified collection to the end of this list, in the order that they are
     * returned by the specified collection's Iterator.
     *
     * @param c - collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    public boolean addAll (MyIntArrayList c) {

        if (null == c){
            return false;
        } else {

            int sumOfSizes = c.elements.length + size;

            if (sumOfSizes > elements.length) {
                elements = increaseSizeArray (elements, c.elements.length);
            } else {
                int counterElements = 0;
                for (int i = 0; i < elements.length; i++){

                    if (0 != elements[i]){
                        counterElements++;
                    }
                }
                for (int i = counterElements; i < sumOfSizes; i++){
                    elements[i] = c.elements[i];
                }
            }
        }
        return true;
    }

    /**
     * Inserts all  the elements in the specified collection into this list, starting at the specified position.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases
     * their indices). The new elements will appear in the list in the order that they are returned by the specified
     * collection's iterator.
     *
     * @param index - index at which to insert the first element from the specified collection
     * @param c     - collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    public boolean addAll (int index, MyIntArrayList c) {

        if (null == c || elements.length < index){
            return false;
        } else {

            if (elements.length < c.elements.length){
                elements = increaseSizeArray (elements,c.elements.length);
            }
            int[] tempArr = new int[elements.length + c.elements.length];

            for (int i = 0 ; i < elements.length; i++){

                tempArr[i] = elements[i];
            }
            for (int i = elements.length; i < tempArr.length;i++){

                tempArr[i] = c.elements[i];
            }
        }
        return true;
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing the elements of the list
     */
    public int[] toArray () {
        return Arrays.copyOf (this.elements, this.size);
    }

    /**
     * Increases the capacity of this instance, if necessary, to ensure that it can hold at least the number of
     * elements specified by the minimum capacity argument.
     *
     * @param minCapacity - the desired minimum capacity
     */
    public void ensureCapacity (int minCapacity) {

        if (elements.length < minCapacity){

            elements = increaseSizeArray (elements, minCapacity);
        }
    }

    /**
     * Trims the capacity of this instance to be the list's current size.
     */
    public void trimToSize () {


        for (int i = 0; i < elements.length; i++){

            if (0 != elements[i]){

            }
        }
    }
}
