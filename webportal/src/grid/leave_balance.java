package grid;

public class leave_balance {
	private String leaveId;
	private String empName;
	private String leaveType;
	private String leaveTaken;
	private String leavePending;
	private String year;
	public String getLeaveId() {
		return leaveId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveTaken() {
		return leaveTaken;
	}
	public void setLeaveTaken(String leaveTaken) {
		this.leaveTaken = leaveTaken;
	}
	public String getLeavePending() {
		return leavePending;
	}
	public void setLeavePending(String leavePending) {
		this.leavePending = leavePending;
	}
}
