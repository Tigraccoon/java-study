package ch21.oracle;

public class ProfessorDTO {
	private int profno;
	private String name;
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProfessorDTO [profno=" + profno + ", name=" + name + "]";
	}
	public ProfessorDTO() {

	}
	public ProfessorDTO(int profno, String name) {
		this.profno = profno;
		this.name = name;
	}
}
