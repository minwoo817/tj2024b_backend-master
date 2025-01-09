package boardservice10.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import boardservice10.model.dto.MemberDto;

public class MemberDao extends SuperDao{
				
	// + 싱글톤
		private static MemberDao instance = new MemberDao();
		private MemberDao() {}
		public static MemberDao getInstance() {return instance;}
		// 1. 회원가입 SQL 처리 메소드
		public boolean signup(MemberDto memberDto) {
			try {
			// [1] SQL 작성한다
			String sql = "insert into member(mid, mpwd, mname, mphone) values('"+memberDto.getMid()+"', '"+memberDto.getMpwd()+"', '"+memberDto.getMname()+"', '"+memberDto.getMphone()+"')";
			// [2] DB와 연동된 곳에 SQL 기재한다.		- 연동된 db에 sql 기재하는 방법 : conn.prepareStatement(SQL)
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL를 실행하고 결과를 받는다		- 기재된 sql를 실행하는 방법 : ps.executeUpdate() -> INSERT , UPDATE, DELETE에 사용
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환을 한다
			if(count == 1) {return true;}
			}catch (Exception e) {
				System.out.println(e);
			}
			return false;
		}
		// 2. 로그인 SQL 처리 메소드
		public int login(MemberDto memberDto) {
			try {
			// int : SQL로 조회된 회원번호를 반환하기 위해서
			// [1] SQL 작성한다.
			String sql = "select mno from member where mid = ? and mpwd = ? ";
			// [2] DB와 연동된 곳에 SQL 기재한다. - 연동된 db에 sql 기재하는 방법 : conn.prepareStatement(SQL)
			PreparedStatement ps = conn.prepareStatement(sql);
			// [*] 기재된 SQL에 매개변수 값 대입한다. 
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMpwd());
			// [3] 기재된 SQL를 실행하고 결과를 받는다. - 기재된 sql를 실행하는 방법 : ps.executeQuery()
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다.
			if(rs.next()) {
				int mno = rs.getInt("mno");
				return mno;
			}
			}catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}
		// 3. 아이디찾기 SQL 처리 메소드
		public String findId(MemberDto memberDto) {
			try {
			// [1] SQL 작성한다	// mname = '유재석' ---> mname = ? mname에는 어떤 값이 들어갈지 정해져 있지 않다. 매개변수
			String sql = "select mid from member where mname = ? and mphone = ? ";
			// [2] DB와 연동된 곳에 SQL 기재한다. + ?매개변수값 대입		- 연동된 db에 sql 기재하는 방법 : conn.prepareStatement(sql)
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, memberDto.getMname());
				ps.setString(2, memberDto.getMphone());
			// [3] 기재된 SQL를 실행하고 결과를 받는다		- 기재된 sql를 실행하는 방법 : ps.executeQuery()
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다
			if(rs.next()) {
				String findMid = rs.getString("mid");
				return findMid;
			}
			}
			catch (Exception e) {System.out.println(e);}
			return null;
		}
		
		// 4. 비밀번호찾기 SQL 처리 메소드
		public String findPwd(MemberDto memberDto) {
			try {
			// [1] SQL 작성한다
			String sql = "select * from member where mid = ? and mphone = ? ";
			// [2] DB와 연동된 곳에 SQL 기재한다.		- 연동된 db에 sql 기재하는 방법 : conn.prepareStatement(sql)
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberDto.getMid());
			ps.setString(2, memberDto.getMphone());
			// [3] 기재된 SQL를 실행하고 결과를 받는다		- 기재된 sql를 실행하는 방법 : ps.executeUpdate()
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다
			if(rs.next()) {
				String findPwd = rs.getString("mpwd");
				return findPwd;
			}
			}catch (Exception e) {System.out.println(e);}
			return null;
		}
	
		// 6. 내정보 보기 SQL 처리 메소드
		public MemberDto myInfo(int loginMno) {
			try {
			// [1] SQL 작성한다.
			String sql = "select * from member where mno = ?";
			// [2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [*] 기재된 SQL에 매개변수 값 대입한다.
			ps.setInt(1, loginMno);
			// [3] 기재된 SQL를 실행하고 결과를 받는다
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환을 한다
			if(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMid(rs.getString("mid"));
				memberDto.setMname(rs.getString("mname"));
				memberDto.setMphone(rs.getString("mphone"));
				memberDto.setMdate(rs.getString("mdate"));
				return memberDto; // 조회된 회원정보를 반환한다
			}
			}catch (Exception e) {System.out.println(e);}
			return null; // 조회된 회원정보가 없을때, null 반환한다.
		}
		// 7. 회원탈퇴 SQL 처리 메소드
		public void delete(int loginMno) {
			try {
			String sql = "delete from member where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, loginMno);
			int count = ps.executeUpdate();
			}catch (Exception e) {System.out.println(e);}
			return;
			
		}
		
		// 8. 회원수정 SQL 처리 메소드
		public boolean update(MemberDto memberDto) {
			try {
			// [1] SQL 작성한다.
			String sql = "update member set mpwd = ?, mname = ?, mphone = ? where mno = ?";
			// [2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement(sql);
			// [*] 기재된 SQL에 매개변수 값 대입한다.
			ps.setString(1, memberDto.getMpwd());
			ps.setString(2, memberDto.getMname());
			ps.setString(3, memberDto.getMphone());
			ps.setInt(4, memberDto.getMno());
			// [3] 기재된 SQL를 실행하고 결과를 받는다
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환을 한다 
			if(count == 1) {return true;}		
			}catch (Exception e) {System.out.println(e);}
			return false;
		}
}

