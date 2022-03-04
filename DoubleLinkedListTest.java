//CSDS 132 Yingyu Zhu
import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Test;

public class DoubleLinkedListTest {

	@Test
	public void testGetCurNode() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		assertEquals("Testing getCurNode() when list is empty", null, (DLNode<Integer>)testList.getCurNode());
		DoubleLinkedList<String> testStringList = new DoubleLinkedList<String>();
		assertEquals("Testing getCurNode() with String type when list is empty", null, (DLNode<String>)testStringList.getCurNode());
	}
	
	@Test
	public void testSetCurNode() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		DLNode<Integer> node = new DLNode<Integer>(1, null, null);
		testList.setCurNode(node);
		assertEquals("Testing setCurNode()", 1, (int)((DLNode<Integer>)testList.getCurNode()).getElement());
	}
	
	@Test
	public void testIsEmpty() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		assertEquals("Testing isEmpty() when list is empty", true, testList.isEmpty());
		DLNode<Integer> node = new DLNode<Integer>(1, null, null);
		testList.setFront(node);
		assertEquals("Testing isEmpty() when list is not empty", false, testList.isEmpty());
	}
	
	@Test
	public void testGetFront() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		assertEquals("Testing getFront() when list is empty", null, (DLNode<Integer>)testList.getFront());
		
		DLNode<Integer> node = new DLNode<Integer>(2, null, null);
		testList.setFront(node);
		assertEquals("Testing getFront() when front is not empty", 2, (int)((DLNode<Integer>)testList.getFront()).getElement());
	}
	
	@Test
	public void testSetFront() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		DLNode<Integer> node = new DLNode<Integer>(2, null, null);
		testList.setFront(node);
		assertEquals("Testing setFront() when front is not empty", 2, (int)((DLNode<Integer>)testList.getFront()).getElement());
	}
	
	@Test
	public void testGetBack() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		assertEquals("Testing getBack() when list is empty", null, (DLNode<Integer>)testList.getBack());
		
		DLNode<Integer> node = new DLNode<Integer>(3, null, null);
		testList.setBack(node);
		assertEquals("Testing getBack() when back is not empty", 3, (int)((DLNode<Integer>)testList.getBack()).getElement());
	}
	
	@Test
	public void testSetBack() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		DLNode<Integer> node = new DLNode<Integer>(4, null, null);
		testList.setBack(node);
		assertEquals("Testing setBack() when back is not empty", 4, (int)((DLNode<Integer>)testList.getBack()).getElement());
	}
	
	@Test
	public void testAddToFront() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToFront(5);
		assertEquals("Testing addToFront()", 5, (int)((DLNode<Integer>)testList.getFront()).getElement());
	}
	
	@Test
	public void testAddToBack() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToBack(6);
		assertEquals("Testing addToBack()", 6, (int)((DLNode<Integer>)testList.getBack()).getElement());
	}
	
	@Test
	public void testRemoveFromFront() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToFront(6);
		testList.addToFront(7);
		testList.removeFromFront();
		assertEquals("Testing addToBack()", 6, (int)((DLNode<Integer>)testList.getFront()).getElement());
	}
	
	@Test
	public void testRemoveFromBack() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToBack(8);
		testList.addToBack(9);
		testList.removeFromBack();
		assertEquals("Testing addToBack()", 8, (int)((DLNode<Integer>)testList.getBack()).getElement());
	}
	
	@Test
	public void testIteratorAdd() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		ListIterator<Integer> iter = (ListIterator<Integer>)testList.iterator();
		iter.add(5);
		assertEquals("Testing add()", 5, (int)((DLNode<Integer>)testList.getBack()).getElement());
		assertEquals("Testing add()", 5, (int)((DLNode<Integer>)testList.getFront()).getElement());
	}
	
	@Test
	public void testIteratorHasNext() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		ListIterator<Integer> iter = (ListIterator<Integer>)testList.iterator();
		assertEquals("Testing hasNext() with empty list", false, iter.hasNext());
		testList.addToFront(5);
		iter = (ListIterator<Integer>)testList.iterator();
		assertEquals("Testing hasNext()", true, iter.hasNext());
	}
	
	@Test
	public void testIteratorHasPrevious() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		ListIterator<Integer> iter = (ListIterator<Integer>)testList.iterator();
		assertEquals("Testing hasPrevious() with empty list", false, iter.hasPrevious());
		testList.addToFront(5);
		testList.addToFront(6);
		iter = (ListIterator<Integer>)testList.iterator();
		iter.next();
		assertEquals("Testing hasPrevious()", true, iter.hasPrevious());
	}
	
	@Test
	public void testIteratorNext() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToFront(5);
		testList.addToFront(6);
		ListIterator<Integer> iter = (ListIterator<Integer>)testList.iterator();
		assertEquals("Testing next()", 6, (int)iter.next());
		assertEquals("Testing next()", 5, (int)iter.next());
	}
	
	@Test
	public void testIteratorPrevious() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToFront(5);
		testList.addToFront(6);
		ListIterator<Integer> iter = (ListIterator<Integer>)testList.iterator();
		iter.next();
		iter.next();
		assertEquals("Testing previous()", 5, (int)iter.previous());
		assertEquals("Testing previous()", 6, (int)iter.previous());
	}
	
	@Test
	public void testIteratorRemove() {
		DoubleLinkedList<Integer> testList = new DoubleLinkedList<Integer>();
		testList.addToFront(5);
		testList.addToFront(6);
		ListIterator<Integer> iter = (ListIterator<Integer>)testList.iterator();
		iter.next();
		iter.remove();
		assertEquals("Testing remove()", 5, (int)testList.getFront().getElement());
	}
	
}
