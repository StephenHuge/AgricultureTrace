package agriculture.ljd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {
	
	private int userid;
	private String username;
	private String password;
	
	@SequenceGenerator(name = "bloguser_sequence",allocationSize=1,initialValue=1,sequenceName="bloguser_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bloguser_sequence")
	@Id
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	
	@NotEmpty(message="Username can not be null")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotEmpty(message="Password can not be null")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
