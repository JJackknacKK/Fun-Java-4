//CSDS 132 Yingyu Zhu
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked linked list.
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    /**
     * a reference to the first node of the double linked list
     */
    private DLNode<T> front;

    /**
     * a reference to the last node of a double linked list
     */
    private DLNode<T> back;

    DLNode<T> curNode;

    protected DLNode<T> getCurNode() {
        return curNode;
    }
    public void setCurNode(DLNode<T> node) {
        curNode = node;
    }

    /**
     * Create an empty double linked list.
     */
    public DoubleLinkedList() {
        front = back = null;
    }

    /**
     * Returns true if the list is empty.
     *
     * @return true if the list has no nodes
     */
    public boolean isEmpty() {
        return (getFront() == null);
    }

    /**
     * Returns the reference to the first node of the linked list.
     *
     * @return the first node of the linked list
     */
    protected DLNode<T> getFront() {
        return front;
    }

    /**
     * Sets the first node of the linked list.
     *
     * @param node the node that will be the head of the linked list.
     */
    protected void setFront(DLNode<T> node) {
        front = node;
    }

    /**
     * Returns the reference to the last node of the linked list.
     *
     * @return the last node of the linked list
     */
    protected DLNode<T> getBack() {
        return back;
    }

    /**
     * Sets the last node of the linked list.
     *
     * @param node the node that will be the last node of the linked list
     */
    protected void setBack(DLNode<T> node) {
        back = node;
    }

    /*----------------------------------------*/
    /* METHODS TO BE ADDED DURING LAB SESSION */
    /*----------------------------------------*/

    /**
     * Add an element to the head of the linked list.
     *
     * @param element the element to add to the front of the linked list
     */
    public void addToFront(T element) {
        DLNode<T> node = new DLNode<T>(element,null,getFront());
        if (!isEmpty()){
			setFront(node);
		}
		else {
			setFront(node);
			setBack(node);
		}
    }

    /**
     * Add an element to the tail of the linked list.
     *
     * @param element the element to add to the tail of the linked list
     */
    public void addToBack(T element) {
        DLNode<T> node = new DLNode<T>(element,getBack(),null);
        if (isEmpty()) {
            setFront(node);
			setBack(node);
        } else {
            setBack(node);
        }
    }

    /**
     * Remove and return the element at the front of the linked list.
     *
     * @return the element that was at the front of the linked list
     * @throws NoSuchElementException if attempting to remove from an empty list
     */
    public T removeFromFront() {
        if (isEmpty()){
			throw new NoSuchElementException();
		}
		else {
            T element = front.getElement();
            if (front.getNext() != null) {
                front.getNext().setPrevious(null);
				setFront(front.getNext());
            } else {
				setFront(null);
				setBack(null);
			}
			return element;
		}
    }

    /**
     * Remove and return the element at the back of the linked list.
     *
     * @return the element that was at the back of the linked list
     * @throws NoSuchElementException if attempting to remove from an empty list
     */
    public T removeFromBack() {
        if (isEmpty()) {
            throw new NoSuchElementException();            
        }
        else {
            T element = back.getElement();
            if (back.getPrevious() != null) {
                setBack(back.getPrevious());
                back.setNext(null);
            } else {
                setFront(null);
                setBack(null);
            }
            return element;
        }
    }

    /**
     * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
     *
     * @return the iterator that runs through the list from the head to the tail
     */
    @Override
    public Iterator<T> iterator() {
        setCurNode(null);
        return new ListIterator<T>(){

            boolean flag = false;

            @Override
            public void add(T element) {
                DLNode<T> node = new DLNode<T>(element, null, null);
                if(hasPrevious() && hasNext()) {
                    node = new DLNode<T>(element, getCurNode(), getCurNode().getNext());
                    node.getPrevious().setNext(node);
                    node.getNext().setPrevious(node);
                }
                else if(hasPrevious()) {
                    addToBack(element);
                    next();
                }
                else {
                    addToFront(element);
                    next();
                }
            }

            @Override
            public boolean hasNext() {
            	if (curNode == null) return front != null;
                return curNode != null && curNode.getNext() != null;
            }

            /*
             * Checks if there is a node before this one
             *
             * @see java.util.ListIterator#hasPrevious()
             */
            public boolean hasPrevious() {
                return curNode != null;
            }

            /*
             * Advances the pointer node by one link in the list
             * If previous() was not called before this, advances cursor by one link
             *
             * @see java.util.ListIterator#next()
             */
            @Override
            public T next() {
                if (curNode == null) {
                    curNode = front;
                    flag = true;
                    return curNode.getElement();
                } else if (hasNext()) {
                    flag = true;
                    curNode = curNode.getNext();
                    return curNode.getElement();
                }
                else {
                    throw new NoSuchElementException();
                }
            }

            /*
             * Legacy. Ignore.
             *
             * @see java.util.ListIterator#nextIndex()
             */
            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException();
            }

            /*
             * Retreats the pointer node by one link in the list
             * If next() was not called before this, retreats cursor by one link
             *
             * @see java.util.ListIterator#previous()
             */
            @Override
            public T previous() {
                if(hasPrevious()) {
                    flag = true;
                    T element = curNode.getElement();
                    setCurNode(curNode.getPrevious());
                    return element;
                } else if(curNode == front) {
                    flag = true;
                    setCurNode(null);
                    return front.getElement();
                }
                else {
                    throw new NoSuchElementException();
                }
            }

            /*
             * Legacy. Ignore.
             *
             * @see java.util.ListIterator#previousIndex()
             */
            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException();
            }

            /*
             * Removes the node at the point of the cursor from the list
             * Alters the pointers of nearby nodes to accommodate the change
             * Fails if called twice without changing position of cursor
             *
             * @see java.util.ListIterator#remove()
             */
            @Override
            public void remove() {

                if(!flag) {
                    throw new IllegalStateException();
                }
                flag = false;
                if(curNode == front){
                    removeFromFront();
                }
                else if(hasPrevious() && hasNext()) {
                    curNode.getPrevious().setNext(curNode.getNext());
                    curNode.getNext().setPrevious(curNode.getPrevious());
                    previous();
                }
                else if(curNode == back) {
                    removeFromBack();
                }
            }

            /*
             * Legacy. Ignore.
             *
             * @see java.util.ListIterator#set(java.lang.Object)
             */
            @Override
            public void set(T e) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
