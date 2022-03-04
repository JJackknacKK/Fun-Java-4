//CSDS 132 Yingyu Zhu
import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleAsEarlyAsPossibleTest {

	@Test
	public void testScheduleJob() {
		Schedule scheduler = new Schedule();
		Job job = new Job(1,2,3,4,5);
		ScheduleAsEarlyAsPossible earlyScheduler = new ScheduleAsEarlyAsPossible();
		assertEquals("Testing testScheduleJob() for ScheduleAsLateAsPossibleTest", false, earlyScheduler.scheduleJob(scheduler, job));
	}

}
