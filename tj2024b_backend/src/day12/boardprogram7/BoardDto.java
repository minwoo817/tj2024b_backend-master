package day12.boardprogram7;

public class BoardDto {
	private String title;
	private String content;
	private String writer;
	
	public BoardDto() {}
	public BoardDto(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public String gerTitle() {return this.title;}
	public String gerContent() {return this.content;}
	public String gerWriter() {return this.writer;}
	
	public void setTitle(String title) {this.title = title;}
	public void setContent(String content) {this.content = content;}
	public void setWriter(String writer) {this.writer = writer;}
	
}
