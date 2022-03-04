//CSDS 132 Yingyu Zhu
import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleAsLateAsPossibleTest {

	@Test
	public void testScheduleJob() {
		Schedule scheduler = new Schedule();
		Job job = new Job(1,2,3,4,5);
		ScheduleAsLateAsPossible lastScheduler = new ScheduleAsLateAsPossible();
		assertEquals("Testing testScheduleJob() for ScheduleAsLateAsPossibleTest", false, lastScheduler.scheduleJob(scheduler, job));
	}

}
