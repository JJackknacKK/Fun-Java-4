//CSDS 132 Yingyu Zhu
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class JobTest {

	@Test
	public void testGetId() {
		Job j = new Job(1,2,3,4,5);
		assertEquals("Testing getId() for Job", 1, j.getId());
	}
	
	@Test
	public void testSetId() {
		Job j = new Job(1,2,3,4,5);
		j.setId(5);
		assertEquals("Testing setId() for Job", 5, j.getId());
	}
	
	@Test
	public void testGetEarliestStart() {
		Job j = new Job(1,2,3,4,5);
		assertEquals("Testing getEarliestStart() for Job", 2, j.getEarliestStart());
	}
	
	@Test
	public void testSetEarliestStart() {
		Job j = new Job(1,2,3,4,5);
		j.setEarliestStart(6);
		assertEquals("Testing setEarliestStart() for Job", 6, j.getEarliestStart());
	}

	@Test
	public void testgetDeadline() {
		Job j = new Job(1,2,3,4,5);
		assertEquals("Testing getDeadline() for Job", 3, j.getDeadline());
	}
	
	@Test
	public void testsetDeadline() {
		Job j = new Job(1,2,3,4,5);
		j.setDeadline(7);
		assertEquals("Testing setDeadline() for Job", 7, j.getDeadline());
	}

	@Test
	public void testgetDuration() {
		Job j = new Job(1,2,3,4,5);
		assertEquals("Testing getDuration() for Job", 4, j.getDuration());
	}
	
	@Test
	public void testsetDuration() {
		Job j = new Job(1,2,3,4,5);
		j.setDuration(8);
		assertEquals("Testing setDuration() for Job", 8, j.getDuration());
	}

	@Test
	public void testgetProfit() {
		Job j = new Job(1,2,3,4,5);
		assertEquals("Testing getProfit() for Job", 5, j.getProfit());
	}
	
	@Test
	public void testsetProfit() {
		Job j = new Job(1,2,3,4,5);
		j.setProfit(9);
		assertEquals("Testing setDuration() for Job", 9, j.getProfit());
	}
	
	@Test
	public void testEquals() {
		Job a = new Job(1,2,3,4,5);
		Job b = new Job(6,7,8,9,10);
		Job c = new Job(1,2,3,4,5);
		assertEquals("Testing equals() for Job", false, a.equals(b));
		assertEquals("Testing equals() for Job", true, a.equals(c));
	}

	@Test
	public void testCompareTo() {
		Job a = new Job(1,2,3,4,5);
		Job b = new Job(6,7,8,9,10);
		Job c = new Job(1,2,3,4,5);
		assertEquals("Testing compareTo() for Job", -1, a.compareTo(b));
		assertEquals("Testing compareTo() for Job", 0, a.compareTo(c));
		assertEquals("Testing compareTo() for Job", 1, b.compareTo(c));
	}
	
	@Test
	public void testStartComparator() {
		Job a = new Job(1,9,3,4,5);
		Job b = new Job(6,7,8,9,10);
		Job[] list = new Job[2];
		list[0] = a;
		list[1] = b;
		Arrays.sort(list, Job.getStartComparator());
		assertEquals("Testing getStartComparator() for Job", 7, list[0].getEarliestStart());
		assertEquals("Testing getStartComparator() for Job", 9, list[1].getEarliestStart());
	}
	
	@Test
	public void testProfitComparator() {
		Job a = new Job(1,9,3,4,5);
		Job b = new Job(6,7,8,9,10);
		Job[] list = new Job[2];
		list[0] = a;
		list[1] = b;
		Arrays.sort(list, Job.getProfitComparator());
		assertEquals("Testing getProfitComparator() for Job", 5, list[0].getProfit());
		assertEquals("Testing getProfitComparator() for Job", 10, list[1].getProfit());
	}
}
