//CSDS 132 Yingyu Zhu
import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleSlotTest {

	@Test
	public void testGetJob() {
		Job j = new Job(1,2,3,4,5);
		ScheduleSlot slot = new ScheduleSlot(j, 10);
		Job test = slot.getJob();
		assertEquals("Testing getJob() for ScheduleSlot", true, j.equals(test));
	}
	
	@Test
	public void testgetStartTime() {
		Job j = new Job(1,2,3,4,5);
		ScheduleSlot slot = new ScheduleSlot(j, 10);
		assertEquals("Testing getStartTime() for Job", 10, slot.getStartTime());
	}
	
	@Test
	public void testsetStartTime() {
		Job j = new Job(1,2,3,4,5);
		ScheduleSlot slot = new ScheduleSlot(j, 10);
		slot.setStartTime(20);
		assertEquals("Testing getStartTime() for Job", 20, slot.getStartTime());
	}

}
