package day13.example.model.dto;

public class WaitingDto {
	private String phone;
	private int people;
	public WaitingDto() {}
	public WaitingDto(String phone, int people) {
		this.phone = phone;
		this.people = people;
	}
	public String getPhone() {return this.phone;}
	public int getPeople() {return this.people;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setPeople(int people) {this.people = people;}
	
}
