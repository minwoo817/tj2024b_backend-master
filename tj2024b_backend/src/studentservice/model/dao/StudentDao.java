package studentservice.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.util.ArrayList;

import boardservice10.model.dto.MemberDto;
import studentservice.model.dto.StudentDto;

public class StudentDao {
	private static StudentDao instance = new StudentDao();
	protected Connection conn;	// DB와 연동 결과를 조작하는 인터페이스
	private String dburl = "jdbc:mysql://localhost:3306/studentservice" ; // 연동할 DB 서버의 URL
	private String dbuser = "root" ; // 연동할 DB 서버의 계정명
	private String dbpwd = "1234" ; // 연동할 DB 서버의 비밀번호
	private StudentDao() {
		try {
		// 1. JDBC 클래스 드라이버 로드, Class.forName() * 예외처리 try{}catch{}
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. 설정한 경로/계정/비밀번호로 DB 서버 연동 시도하고 결과를 (구현체) 반환
		conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		}catch (Exception e) {
			System.out.println("[DB 연동 실패]" + e);
		}
	}
	public static StudentDao getInstance() {return instance;}
	
	public boolean regist(StudentDto studentDto) {
		try {
		String sql = "insert into student(sname, kscore, escore, mscore) values(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, studentDto.getSname());
		ps.setInt(2, studentDto.getKscore());
		ps.setInt(3, studentDto.getEscore());
		ps.setInt(4, studentDto.getMscore());
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public ArrayList<StudentDto> print(){
		ArrayList<StudentDto> list = new ArrayList<StudentDto>();
		try {
		String sql = "select * from student";
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int sno = rs.getInt("sno");
			String sname = rs.getString("sname");
			int kscore = rs.getInt("kscore");
			int escore = rs.getInt("escore");
			int mscore = rs.getInt("mscore");
			StudentDto studentServiceDto = new StudentDto(sno, sname, kscore, escore, mscore);
			list.add(studentServiceDto);
		}
		}catch (Exception e) {System.out.println(e);}
		return list;
	}
	public boolean delete(int choose1) {
		try {
		String sql = "delete from student where sno = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, choose1);
		int count = ps.executeUpdate();
		if(count == 1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	public boolean update(int choose2, StudentDto studentDto) {
		try {
		String sql = "update student set kscore = ?, escore = ?, mscore = ? where sno = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, studentDto.getKscore());
		ps.setInt(2, studentDto.getEscore());
		ps.setInt(3, studentDto.getMscore());
		ps.setInt(4, choose2);
		int count = ps.executeUpdate();
		if(count ==1) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}
