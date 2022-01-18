package financial.service;

import java.util.ArrayList;
import java.util.Collections;

import financial.exception.DuplicationProjectException;
import financial.model.dto.ETFCustomer;
import financial.model.dto.ETFManager;
import financial.model.dto.ETFProject;

public class ETFProjectService {
	private static ETFProjectService instance = new ETFProjectService();

	/** �������� Project�� �����ϴ� �迭 */
	private ArrayList<ETFProject> etfProjectList = new ArrayList<ETFProject>();

	private ETFProjectService() {
	}
//	 ��ü ��� �޼ҵ�
	public static ETFProjectService getInstance() {
		return instance;
	}
	
	/** project �Է� ��� ȣ�� */
	public void etfProjectInsert(ETFProject etf) throws DuplicationProjectException {
		for(ETFProject e : etfProjectList) {
			if(e.getEtfName().equals(etf.getEtfName())) {
				throw new DuplicationProjectException("�̹� �����ϴ� ������Ʈ�Դϴ�.");
			}
		}
		etfProjectList.add(etf);
	}

	// ��ü project ��ȯ
	public ArrayList<ETFProject> getetfProjectsList() {
		return etfProjectList;
		
	}
	
//	�ϳ��� project�� ��ȸ�Ͽ� ��ȯ
	public ETFProject getetfProject(String e) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(e)) {
				return etf;
			}
		}
		return null;
		
	}
	
// ���� �޼ҵ� 
	public boolean etfCustomerUpdate(String s, ETFCustomer etfcustomer) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etf.setProjectEtfCustomer(etfcustomer);
				return true;
			}
		}
		return false;
	}
//���� �޼ҵ�
	public boolean etfManagerUpdate(String s, ETFManager manger) {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etf.setProjectEtfManager(manger);
				return true;
			}
		}
		return false;
	}
// ���� �޼ҵ� 
	public boolean etfProjectDelete(String s)  {
		for(ETFProject etf : etfProjectList) {
			if(etf.getEtfName().equals(s)) {
				etfProjectList.remove(etf);
				return true;
			}
		}
		return false;
	}
// ���� �޼ҵ� . .
	public ArrayList<ETFProject> RanketfProjectList() {
		Collections.sort(etfProjectList,new ComparatorAsset());
		return etfProjectList;
		}
}
