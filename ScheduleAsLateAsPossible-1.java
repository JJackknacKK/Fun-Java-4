//CSDS 132 Yingyu Zhu
import java.util.ListIterator;

/**
 * @author authorname
 * 
 * The scheduleJob method attempts to place the job into the schedule such that the job will be completed at as late a time as possible given the job's deadline and the other jobs in the schedule
 */
public class ScheduleAsLateAsPossible implements ScheduleMetric{

	/*
	 * scheduleJob
	 */
	public boolean scheduleJob(Schedule schedule, Job job) {

		int optStart = job.getDeadline() - job.getDuration();

		int start = 0;
		int stop = 0;
		int lastStop = 0;

		if(optStart < job.getEarliestStart()) {
			return false;
		}
		else if(schedule.isEmpty()) {
			schedule.addToFront(new ScheduleSlot(job, optStart));
			return true;
		}
		ListIterator<ScheduleSlot> it = (ListIterator<ScheduleSlot>)schedule.iterator();
		schedule.setCurNode(schedule.getBack());

		// Loops through schedule
		while(it.hasPrevious()) {
			ScheduleSlot slot = schedule.getCurNode().getElement();
			start = slot.getStartTime();
			stop = start + slot.getJob().getDuration();
			lastStop = slot.getJob().getDuration() + slot.getStartTime();
			if(stop <= optStart) {
				it.add(new ScheduleSlot(job, optStart));
				return true;
			}
			else if(start - lastStop >= job.getDuration() &&
					start - job.getDuration() >= job.getEarliestStart()) {
				it.add(new ScheduleSlot(job, start - job.getDuration()));
				return true;
			}
			else if(schedule.getCurNode() == schedule.getFront() &&
					start - job.getDuration() >= job.getEarliestStart()) {
				it.add(new ScheduleSlot(job, start - job.getDuration()));
				return true;
			}
			it.previous();
		}
		return false;
	}
}