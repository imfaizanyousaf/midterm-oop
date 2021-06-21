
public class StaffMember {


	public static String csvFile = "D:\\staffmembers.csv";

	
	private int STAFFMEMBER_ID;
	
	private String STAFFMEMBER_NAME;

	private String STAFFMEMBER_QUALIFICATION;
	
	private String STAFFMEMBER_ROLE;

	public int getSTAFFMEMBER_ID() {
		return STAFFMEMBER_ID;
	}

	public void setSTAFFMEMBER_ID(int sTAFFMEMBER_ID) {
		STAFFMEMBER_ID = sTAFFMEMBER_ID;
	}

	public String getSTAFFMEMBER_NAME() {
		return STAFFMEMBER_NAME;
	}

	public void setSTAFFMEMBER_NAME(String sTAFFMEMBER_NAME) {
		STAFFMEMBER_NAME = sTAFFMEMBER_NAME;
	}

	public String getSTAFFMEMBER_QUALIFICATION() {
		return STAFFMEMBER_QUALIFICATION;
	}

	public void setSTAFFMEMBER_QUALIFICATION(String sTAFFMEMBER_QUALIFICATION) {
		STAFFMEMBER_QUALIFICATION = sTAFFMEMBER_QUALIFICATION;
	}

	public String getSTAFFMEMBER_ROLE() {
		return STAFFMEMBER_ROLE;
	}

	public void setSTAFFMEMBER_ROLE(String sTAFFMEMBER_ROLE) {
		STAFFMEMBER_ROLE = sTAFFMEMBER_ROLE;
	}

	public String toString() {
		String str = null;
		
		str = this.STAFFMEMBER_ID
				+ "," + this.STAFFMEMBER_NAME
				+ "," + this.STAFFMEMBER_QUALIFICATION
				+ "," + this.STAFFMEMBER_ROLE;
		
		return str;
	}
	
}
