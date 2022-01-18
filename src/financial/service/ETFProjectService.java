package financial.service;

import java.util.ArrayList;
import java.util.Collections;

import financial.exception.DuplicationProjectException;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class ETFProjectService {
	private static ETFProjectService instance = new ETFProjectService();

	/** 진행중인 Project를 저장하는 배열 */
	private ArrayList<ETFProject> etfProjectList = new ArrayList<ETFProject>();

	private ETFProjectService() {
	}
//	 전체 출력 메소드
	public static ETFProjectService getInstance() {
		return instance;
	}
	
	/** project 입력 기능 호출 */
	public void etfProjectInsert(ETFProject etf) throws DuplicationProjectException {
		for(ETFProject e : etfProjectList) {
			if(e.getEtfName().equals(etf.getEtfName())) {
				throw new DuplicationProjectException("이미 존재하는 프로젝트입니다.");
			}
		}
		etfProjectList.add(etf);
	}

	// 전체 project 반환
	public ArrayList<ETFProject> getetfProjectsList() {
		return etfProjectList;
		
	}
	
//	하나의 project를 조회하여 반환
	public ETFProject getetfProject(String e) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		return null;
		
	}
	
// 수정 메소드 
	public boolean etfCustomerUpdate(String s, ETFCustomer etfcustomer) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return true;
			}
		}
		return false;
	}
//수정 메소드
	public boolean etfManagerUpdate(String s, ETFManager manger) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return true;
			}
		}
		return false;
	}
// 삭제 메소드 
	public boolean etfProjectDelete(String s)  {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				return true;
			}
		}
		return false;
	}
// 정렬 메소드 . .
	public ArrayList<ETFProject> RanketfProjectList() {
		Collections.sort(etfProjectList,new ComparatorAsset());
		return etfProjectList;
		}
}
