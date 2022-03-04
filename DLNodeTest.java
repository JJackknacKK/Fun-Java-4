//CSDS 132 Yingyu Zhu
import static org.junit.Assert.*;

import org.junit.Test;

public class DLNodeTest {

	@Test
	public void testGetElement() {
		DLNode<Integer> intNode = new DLNode<Integer>(0, null, null);
		assertEquals("Testing getElement() when element is 0", 0, (int)intNode.getElement());
		DLNode<String> stringNode = new DLNode<String>("string", null, null);
		assertEquals("Testing getElement() when element is 'string'", "string", (String)stringNode.getElement());
	}
	
	@Test
	public void testGetPrevious() {
		DLNode<Integer> prevNode = new DLNode<Integer>(1, null, null);
		DLNode<Integer> node = new DLNode<Integer>(0, prevNode, null);
		DLNode<Integer> testNode = node.getPrevious();
		assertEquals("Testing getPrevious() when previous element is 1", 1, (int)testNode.getElement());
	}
	
	@Test
	public void testGetNext() {
		DLNode<Integer> nextNode = new DLNode<Integer>(2, null, null);
		DLNode<Integer> node = new DLNode<Integer>(0, null, nextNode);
		DLNode<Integer> testNode = node.getNext();
		assertEquals("Testing getNext() when next element is 2", 2, (int)testNode.getElement());
	}
	
	@Test
	public void testSetElement() {
		DLNode<Integer> node = new DLNode<Integer>(0, null, null);
		node.setElement(3);
		assertEquals("Testing setElement() when setting element to 3", 3, (int)node.getElement());
	}
	
	@Test
	public void testSetNext() {
		DLNode<Integer> nextNode = new DLNode<Integer>(4, null, null);
		DLNode<Integer> node = new DLNode<Integer>(0, null, null);
		node.setNext(nextNode);
		DLNode<Integer> testNode = node.getNext();
		assertEquals("Testing setNext() when setting next element to 4", 4, (int)testNode.getElement());
	}
	
	@Test
	public void testSetPrevious() {
		DLNode<Integer> prevNode = new DLNode<Integer>(5, null, null);
		DLNode<Integer> node = new DLNode<Integer>(0, null, null);
		node.setPrevious(prevNode);
		DLNode<Integer> testNode = node.getPrevious();
		assertEquals("Testing setPrevious() when setting next element to 5", 5, (int)testNode.getElement());
	
	}
}
