package financial.view;

import java.util.ArrayList;

import financial.model.dto.ETFProject;

public class SuccessView {

	public static void projectListView(ArrayList<ETFProject> getetfProjectsList) {
		int index = 1;
		for (ETFProject list : getetfProjectsList) {
			System.out.println("[진행 중인 project : " + index + "] " + list);
			index++;
		}

	}

	public static void projectView(ETFProject getetfProject) {

		System.out.println(getetfProject);

	}

	public static void successView(String s) {
			System.out.println("Issue : " + s);
	}
	
	public static void projectRankView(ArrayList<ETFProject> getetfProjectsList) {
		int index = 1;
		for (ETFProject list : getetfProjectsList) {
			System.out.println("[ 개인 자산 등수 : " + index + "등] " + list.getEtfName());
			index++;
		}
		}

}
