package day13.example.view;

import java.util.Scanner;

import day13.example.controller.WaitingController;
import day13.example.model.dto.WaitingDto;

public class WaitingView {
	private WaitingView() {}
	private static WaitingView instance = new WaitingView();
	public static WaitingView getInstance() {
		return instance;
	}
	private Scanner scan = new Scanner(System.in);
	public void index() {
		while(true) {
			System.out.println("1.등록 2.출력 ");
			int choose = scan.nextInt();
			if(choose == 1) {
				regist();
			}
			else if(choose == 2) {
				print();
			}
		}
	}
	public void regist() {
		System.out.println("전화번호 "); String phone = scan.next();
		System.out.println("인원수 "); int people = scan.nextInt();
		WaitingDto waitingDto = new WaitingDto(phone, people);
		boolean result = WaitingController.getInstance().regist(waitingDto);
		if(result == true) {
			System.out.println("등록 성공");
		}
		else {
			System.out.println("등록 실패");
		}
	}
	
	public void print() {
		WaitingDto[] result = WaitingController.getInstance().print();
		for(int i = 0; i < result.length; i++) {
			WaitingDto waiting = result[i];
			if(waiting != null) {
				System.out.printf("순번 : %d , 전화번호 : %s , 인원수 : %d \n", i+1, waiting.getPhone(), waiting.getPeople() );
			}
		}
	}
	
}
