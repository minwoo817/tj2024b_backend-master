package studentservice.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;

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
		String sql = "insert into student(sname, kscore, escore, mscore) values(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, studentDto);
	}
}
