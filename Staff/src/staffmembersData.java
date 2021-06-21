import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class staffmembersData {

	private String csvFile = "D:\\staffmembers.csv";

	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	public static  List<StaffMember> findAll(){
		List<StaffMember> staffMembers = new ArrayList<StaffMember>();
		String line;
		
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StaffMember.csvFile));

			while((line = bufferreader.readLine()) != null) {
				StaffMember staffMember = new StaffMember();
				
				String[] staffMemberRow = line.split(",");
				
				staffMember.setSTAFFMEMBER_ID(Integer.parseInt(staffMemberRow[0]));
				staffMember.setSTAFFMEMBER_NAME(staffMemberRow[1]);
				staffMember.setSTAFFMEMBER_QUALIFICATION(staffMemberRow[2]);
				staffMember.setSTAFFMEMBER_ROLE(staffMemberRow[3]);
				
				staffMembers.add(staffMember);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staffMembers;
	}
	
	
	public static StaffMember findOne(int staffmember_id)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StaffMember.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				StaffMember staffmember = new StaffMember();
				
				String[] staffMemberRow = line.split(",");
				
				if (Integer.parseInt(staffMemberRow[0]) == staffmember_id) {
					staffmember.setSTAFFMEMBER_ID(Integer.parseInt(staffMemberRow[0]));
					staffmember.setSTAFFMEMBER_NAME(staffMemberRow[1]);
					staffmember.setSTAFFMEMBER_QUALIFICATION(staffMemberRow[2]);
					staffmember.setSTAFFMEMBER_ROLE(staffMemberRow[3]);
					
					return staffmember;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static StaffMember Save(StaffMember staffmember) {
		FileWriter filewriter;
		
		List<StaffMember> staffmembers = findAll();

		try {
			filewriter = new FileWriter(StaffMember.csvFile);

			for (int i=0; i<staffmembers.size(); i++) {
				filewriter.append(staffmembers.get(i).toString());
				filewriter.append("\n");
			}
			if (staffmembers.size()>0)
				staffmember.setSTAFFMEMBER_ID(staffmembers.get(staffmembers.size()-1).getSTAFFMEMBER_ID()+1);
			else
				staffmember.setSTAFFMEMBER_ID(1);
			filewriter.append(staffmember.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return staffmember;
	}
	
	public static StaffMember deleteOne(int staffmember_ID)  {
		FileWriter filewriter;

		List<StaffMember> staffmemebers = findAll();
		StaffMember staffmemeber = findOne(staffmember_ID);

		try {
			filewriter = new FileWriter(StaffMember.csvFile);

			for (int i=0; i<staffmemebers.size(); i++) {
				if (staffmemebers.get(i).getSTAFFMEMBER_ID() != staffmember_ID) {
					filewriter.append(staffmemebers.get(i).toString());
					filewriter.append("\n");
				}
			}
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staffmemeber;
	}
	
	public static List<StaffMember> search(String search)  {
		List<StaffMember> staffmembers = new ArrayList<StaffMember>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StaffMember.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				StaffMember staffmember = new StaffMember();
				
				String[] staffMemberRow = line.split(",");
				
				if (staffMemberRow[1].contains(search) == true) {
					staffmember.setSTAFFMEMBER_ID(Integer.parseInt(staffMemberRow[0]));
					staffmember.setSTAFFMEMBER_NAME(staffMemberRow[1]);
					staffmember.setSTAFFMEMBER_QUALIFICATION(staffMemberRow[2]);
					staffmember.setSTAFFMEMBER_ROLE(staffMemberRow[3]);
					
					staffmembers.add(staffmember);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staffmembers;
	}
	
	public static void showAll() {

		List<StaffMember> staffmembers = findAll();
		System.out.println(staffmembers);
	}
	public static void showOne(int staffmember_ID) {

		StaffMember staffmemeber = findOne(staffmember_ID);
		System.out.println(staffmemeber.toString());
	}

	public static void showSearch(String search) {

		List<StaffMember> staffmembers = search(search);
		System.out.println(staffmembers);
	}
}
