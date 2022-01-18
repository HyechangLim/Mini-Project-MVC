package financial.model.dto;

public class ETFManager {
	/** 판매자 이름 */
	private String Name;
	/** 판매자 나이 */
	private int Age;
	/** 판매자 직급 */
	private String rank;
	/** 판매자 휴대폰 번호 */
	private String PhoneNumber;
	
	public ETFManager() {
		super();
	}

	public ETFManager(String name, int age, String rank, String phoneNumber) {
		super();
		Name = name;
		Age = age;
		this.rank = rank;
		PhoneNumber = phoneNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ETFManager [Name=" + Name + ", Age=" + Age + ", rank=" + rank + ", PhoneNumber=" + PhoneNumber + "]";
	}
	
	
}
