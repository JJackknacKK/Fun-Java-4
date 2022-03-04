//CSDS 132 Yingyu Zhu
import java.util.Comparator;

/**
 * @author authorname
 * Job class
 *
 */
public class Job implements Comparable<Job>{
	private int id;
	private int earliestStart;
	private int deadline;
	private int duration;
	private int profit;

	/**
	 * Constructor for Job
	 * 
	 * @param id
	 * @param earliestStart
	 * @param deadline
	 * @param duration
	 * @param profit
	 */
	public Job(int id, int earliestStart, int deadline, int duration, int profit) {
		this.id = id;
		this.earliestStart = earliestStart;
		this.deadline = deadline;
		this.duration = duration;
		this.profit = profit;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public int getEarliestStart() {
		return earliestStart;
	}

	/**
	 * @param earliestStart
	 */
	public void setEarliestStart(int earliestStart) {
		this.earliestStart = earliestStart;
	}

	/**
	 * @return
	 */
	public int getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline
	 */
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return
	 */
	public int getProfit() {
		return profit;
	}

	/**
	 * @param profit
	 */
	public void setProfit(int profit) {
		this.profit = profit;
	}

	/* 
	 * Checks if two jobs are equal
	 * @param obj other job
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Job other = (Job) obj;

		if(deadline != other.deadline ||
				duration != other.duration ||
				earliestStart != other.earliestStart ||
				id != other.id || profit != other.profit) {
			return false;
		}

		return true;
	}

	/* 
	 * Compare this and obj
	 * @param obj other job
	 */
	@Override
	public int compareTo(Job obj) {
		if(this.getEarliestStart() > obj.getEarliestStart()) {
			return 1;
		}
		else if(this.getEarliestStart() < obj.getEarliestStart()) {
			return -1;
		}
		else {
			return 0;
		}
	}

	/**
	 * compare jobs
	 * 
	 * @return
	 */
	public static Comparator<Job> getStartComparator() {
		return new Comparator<Job>() {

			@Override
			public int compare(Job a, Job b) {
				return ((Integer) a.getEarliestStart()).compareTo(b.getEarliestStart());
			}

		};
	}


	/**
	 * Orders by profit
	 * 
	 * @return
	 */
	public static Comparator<Job> getProfitComparator() {
		return new Comparator<Job>() {
			@Override
			public int compare(Job a, Job b) {
				return ((Integer) a.getProfit()).compareTo(b.getProfit());
			}

		};
	}
}