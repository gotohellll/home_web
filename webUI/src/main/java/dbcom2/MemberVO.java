package dbcom2;

public class MemberVO {

	private int no; 
	private String userid; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String email; // 이메일
	private String address; // 주소
	private String birth; // 생일
	private String gender; // M(남자) : F(여자)
	private String comments; // 코멘트
	
	public MemberVO() {
	}

	public MemberVO(int no, String userid, String password, String name, String email, String address, String birth,
			String gender, String comments) {
		this.no = no;
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
		this.comments = comments;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", userid=" + userid + ", password=" + password + ", name=" + name + ", email="
				+ email + ", address=" + address + ", birth=" + birth + ", gender=" + gender + ", comments=" + comments
				+ "]";
	}

}
