package studentservice.model.dto;

public class StudentDto {
	private int sno;
	private String sname;
	private int kscore;
	private int escore;
	private int mscore;
	public StudentDto() {}
	public StudentDto(int sno, String sname, int kscore, int escore, int mscore) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.kscore = kscore;
		this.escore = escore;
		this.mscore = mscore;
	}
	
	public StudentDto(String sname, int kscore, int escore, int mscore) {
		super();
		this.sname = sname;
		this.kscore = kscore;
		this.escore = escore;
		this.mscore = mscore;
	}
	@Override
	public String toString() {
		return "StudentDto [sno=" + sno + ", sname=" + sname + ", kscore=" + kscore + ", escore=" + escore + ", mscore="
				+ mscore + "]";
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getKscore() {
		return kscore;
	}
	public void setKscore(int kscore) {
		this.kscore = kscore;
	}
	public int getEscore() {
		return escore;
	}
	public void setEscore(int escore) {
		this.escore = escore;
	}
	public int getMscore() {
		return mscore;
	}
	public void setMscore(int mscore) {
		this.mscore = mscore;
	}
	
}