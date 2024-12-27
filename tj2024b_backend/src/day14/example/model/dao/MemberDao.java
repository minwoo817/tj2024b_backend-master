package day14.example.model.dao;

import java.util.ArrayList;

import day14.example.model.dto.MemberDto;


public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	private ArrayList<MemberDto> members = new ArrayList<>();
	
	public boolean memberAdd(MemberDto memberDto) {
		
		members.add(memberDto);
		return true;
	}
	
	public boolean memberLogin(String id, String pw) {
		for(int index=0;index<=members.size()-1;index++) {
			if(members.get(index).getId().equals(id)&&members.get(index).getPw().equals(pw)) {
				System.out.println( id );
				System.out.println( pw );
				return true;
			}
		}
		return false;
	}
	
	public boolean memberUpdate(MemberDto memberDto) {
		for(int index=0;index<=members.size()-1;index++) {
			members.set(index, memberDto);
		}
		return true;
	}
		
	public boolean memberDelete(String id,String pw) {
		System.out.println( id );
		System.out.println( pw );
		for(int index=0;index<=members.size()-1;index++) {
			if(members.get(index).getId().equals(id)&&members.get(index).getPw().equals(pw)){
				members.remove(index);
				return true;
			}
		}
		return false;
	}
		
}

