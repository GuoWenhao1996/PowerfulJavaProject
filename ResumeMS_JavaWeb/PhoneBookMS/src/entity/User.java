package entity;

/**
 * 用户实体
 * 
 * @author gwh
 *
 */
public class User {
	private int uid;
	private String username;
	private String password;
	private String nickname;
	private String telephone;
	private String email;
	private String address;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public User() {
		super();
	}

	public User(int uid, String username, String password, String nickname, String telephone, String email,
			String address) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
	}

}
