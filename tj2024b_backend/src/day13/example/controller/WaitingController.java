package day13.example.controller;

import day13.example.model.dao.WaitingDao;
import day13.example.model.dto.WaitingDto;

public class WaitingController {
	private WaitingController() {}
	private static WaitingController instance = new WaitingController();
	public static WaitingController getInstance() {
		return instance;
	}
	public boolean regist(WaitingDto saveDto) {
		boolean result = WaitingDao.getInstance().regist(saveDto);
		return result;
	}
	public WaitingDto[] print() {
		WaitingDto[] result = WaitingDao.getInstance().print();
		return result;
	}
}
