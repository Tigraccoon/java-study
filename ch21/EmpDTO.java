package ch21;

import java.sql.Date;

//Data Transfer Object
public class EmpDTO {
	private int empno; 
	private String ename; 
	private Date hiredate;
	private int sel;
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSel() {
		return sel;
	}
	public void setSel(int sel) {
		this.sel = sel;
	}
	
	
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", hiredate=" + hiredate + ", sel=" + sel + "]";
	}
	
	
	public EmpDTO() {
	}
	
	
	public EmpDTO(int empno, String ename, Date hiredate, int sel) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sel = sel;
	}
	
	
}
