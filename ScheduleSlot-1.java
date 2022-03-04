/**
 * @author CSDS 132 Yingyu Zhu
 *
 */
public class ScheduleSlot {
	// the job that is scheduled in this slot
	private Job job;
	// the start time of this slot
	private int startTime;

	/**
	 * Constructor
	 * 
	 * @param job
	 * @param startTime
	 */
	public ScheduleSlot(Job job, int startTime) {
		this.job = job;
		this.startTime = startTime;
	}

	/**
	 * @return
	 */
	public Job getJob() {
		return job;
	}

	/**
	 * @return
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
}