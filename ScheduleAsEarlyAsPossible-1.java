import java.util.ListIterator;

/**
 * @author CSDS 132 Yingyu Zhu
 * The ScheduleAsEarlyAsPossible class
 *
 */

public class ScheduleAsEarlyAsPossible implements ScheduleMetric {

	/* scheduleJob
	 *
	 */
	public boolean scheduleJob(Schedule schedule, Job job) {

		int optStop = job.getEarliestStart() + job.getDuration();

		int start = 0;
		int stop = 0;
		int nextStart = 0;

		if(optStop > job.getDeadline()) {
			return false;
		}
		else if(schedule.isEmpty()) {
			schedule.addToFront(new ScheduleSlot(job, job.getEarliestStart()));
			return true;
		}
		ListIterator<ScheduleSlot> iter = (ListIterator<ScheduleSlot>)schedule.iterator();
		schedule.setCurNode(schedule.getFront());

		// Loops through schedule
		while(schedule.getCurNode() != schedule.getBack()) {
			ScheduleSlot slot = schedule.getCurNode().getElement();
			start = slot.getStartTime();
			stop = start + slot.getJob().getDuration();
			nextStart = slot.getStartTime();
			if(start >= optStop) {
				iter.add(new ScheduleSlot(job, job.getEarliestStart()));
				return true;
			}
			else if(nextStart - stop >= job.getDuration() &&
					stop + job.getDuration() <= job.getDeadline()) {
				iter.add(new ScheduleSlot(job, stop));
				return true;
			}
			iter.previous();
		}
		return false;
	}
}