//CSDS132 Yingyu Zhu
import static org.junit.Assert.*;

import org.junit.Test;

public class CompoundJobTest {

	@Test
	public void testgetSubJobs() {
		Job a = new Job(1,2,3,4,5);
		Job b = new Job(6,7,8,9,10);
		CompoundJob compoundJob = new CompoundJob(10, a, b);
		assertEquals("Testing getSubJobs() for Job", 11, compoundJob.getSubJobs()[0].getEarliestStart());
		assertEquals("Testing getSubJobs() for Job", 2, compoundJob.getSubJobs()[1].getEarliestStart());
	}

}
