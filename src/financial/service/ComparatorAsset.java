package financial.service;

import java.util.Comparator;

import financial.model.dto.ETFProject;

public class ComparatorAsset implements Comparator<ETFProject>{

	@Override
	public int compare(ETFProject o1, ETFProject o2) {
		
		int result = 1;
		if(Integer.parseInt(o1.getProjectEtfCustomer().getAsset().replaceAll("[^\\d]", ""))
			>= Integer.parseInt(o2.getProjectEtfCustomer().getAsset().replaceAll("[^\\d]", "")))
				result = -1;
			return result;
	}

	}

