/**
 * @author CSDS132 Yingyu Zhu
 *
 *
 */
public class CompoundJob extends Job{

	// job array
	Job[] subJobs;

	/**
	 * Constructor
	 * 
	 * @param profit
	 * @param subJobs
	 */
	public CompoundJob(int profit, Job... subJobs) {
		super(subJobs[0].getId(), subJobs[0].getEarliestStart(),
				subJobs[subJobs.length - 1].getDeadline(), durationSum(subJobs),  0);
		this.subJobs = subJobs;

		for(int i = 0; i < subJobs.length; i++) {
			int sum = 0;
			for(int j = i + 1; j < subJobs.length; j++) {
				sum += subJobs[j].getDuration();
			}
			subJobs[i].setDeadline(subJobs[subJobs.length - 1].getDeadline() - sum);
		}

		for(int i = 0; i < subJobs.length; i++) {
			int sum = 0;
			for(int j = subJobs.length - (i + 1); j > 0; j--) {
				sum += subJobs[j].getDuration();
			}
			subJobs[i].setEarliestStart(this.getEarliestStart() + sum);
		}
	}

	/**
	 * get the summary of duration of jobs
	 * 
	 * @param subJobs
	 * @return
	 */
	private static int durationSum(Job[] subJobs) {
		int sum = 0;
		for(int i = 0; i < subJobs.length; i++) {
			sum += subJobs[i].getDuration();
		}
		return sum;
	}

	/**
	 * @return
	 */
	public Job[] getSubJobs() {
		return subJobs;
	}

}
