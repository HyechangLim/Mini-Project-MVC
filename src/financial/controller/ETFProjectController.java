package financial.controller;

import java.util.ArrayList;

import financial.exception.DuplicationProjectException;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;
import financial.service.ETFProjectService;
import financial.view.FailView;
import financial.view.SuccessView;

public class ETFProjectController {

	private static ETFProjectController instance = new ETFProjectController();
	
	
	private ETFProjectService service = ETFProjectService.getInstance();

	private ETFProjectController() {} // private로 생성자 태클걸어서 생성못하게 막기.  instance만 하게
	
	public static ETFProjectController getInstance() {
		return instance;
	}

	//service에 있는 project 입력 기능 호출
	public void etfProjectInsert(ETFProject etf) {
		if(etf != null) {
			try {
				service.etfProjectInsert(etf);
			} catch (DuplicationProjectException e) {
				e.printStackTrace();
				FailView.failView(e.getMessage());
			}
		}else {
			FailView.failView("null 값이 입력되었습니다.");
		}
	}

	// Project 전체 출력 , Project가 비어있을 때 예외처리
	public void getetfProjectsList() {
		ArrayList<ETFProject> e = service.getetfProjectsList();
		if(e != null) {  //null이면 아직 안걸러짐.
			SuccessView.projectListView(e);
		}else {
			FailView.failView("Project가 비었습니다.");
		}
		
		
	}
	// Project 한개 출력하기 위한 메소드 , 대입값이 null일 경우 예외처리
	public void getetfProject(String etf) {
		if(service.getetfProject(etf) != null) {
		SuccessView.projectView(service.getetfProject(etf));
		}else {
			FailView.failView("해당 프로젝트는 존재하지않습니다.");
		}
	}

/*
 * 	Project customer 수정하기 위한 메소드 
 * 1. s 혹은 customer가 null 일 경우 예외처리
 * 2. 수정할 project의 이름이 미존재 시 예외처리
 * 3. true면 성공 false면 실패 
 */
	public void etfCustomerUpdate(String s, ETFCustomer customer) {
		if (s == null || customer == null) {
			FailView.failView("Update메소드에 null값이 입력되었습니다.");
		} else {
			boolean tf = service.etfCustomerUpdate(s, customer);
			if (tf == true) {
				SuccessView.successView("Update가 완성되었습니다.");
			} else {
				FailView.failView("Update가 실패했습니다.");
			}
		}
	}
	/*
	 * 	Project manager 수정하기 위한 메소드 
	 * 1. s 혹은 manager가 null 일 경우 예외처리
	 * 2. 수정할 project의 이름이 미존재 시 예외처리
	 * 3. true면 성공 false면 실패 
	 */
	public void etfManagerUpdate(String s, ETFManager manger) {
		if (s == null || manger == null) {
			FailView.failView("Update메소드에 null값이 입력되었습니다.");
		} else {
			boolean tf = service.etfManagerUpdate(s, manger);
			if (tf == true) {
				SuccessView.successView("Update가 완성되었습니다.");
			} else {
				FailView.failView("Update가 실패했습니다.");
			}
		}
	}
/* 프로젝트를 삭제하기 위한 메소드
 * 1. s에 null 입력 시 실패
 * 2. s에 대응하는 project 없을 시 실패
 * 3. true면 성공 false면 실패
 * 
 */
	public void etfProjectDelete(String s) {
		if (s == null) {
			FailView.failView("Delete메소드에 null값이 입력되었습니다.");
		} else {
			boolean b = service.etfProjectDelete(s);
			if(b == true) {
				SuccessView.successView("삭제가 성공하였습니다.");
			}else {
				FailView.failView("삭제가 실패했습니다.");
			}
		}
	}
	
	//등수 정렬
		public void RanketfProjectList() {
			SuccessView.projectRankView(service.RanketfProjectList());
			
		}

}
