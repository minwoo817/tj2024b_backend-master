package day13.example.model.dao;

import day13.example.model.dto.WaitingDto;

public class WaitingDao {
	private WaitingDao() {}
	private static WaitingDao instance = new WaitingDao();
	public static WaitingDao getInstance() {
		return instance;
	}
	private WaitingDto[] waitingDtos = new WaitingDto[100];
	public boolean regist(WaitingDto waitingDto) {
		for(int i = 0; i <waitingDtos.length; i++) {
			if(waitingDtos[i] == null) {
				waitingDtos[i] = waitingDto;
				return true;
			}
		}
		return false;
	}
	public WaitingDto[] print() {
		return waitingDtos;
	}
	
}
