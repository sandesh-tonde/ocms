package clg.bvu.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preference")
public class Preference {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="preference_id")
	private Integer preferenceId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(targetEntity=Branch.class,cascade=CascadeType.ALL)
	@JoinColumn(name="option1",referencedColumnName="branch_id")
	private Branch option1;
	
	@OneToOne(targetEntity=Branch.class,cascade=CascadeType.ALL)
	@JoinColumn(name="option2",referencedColumnName="branch_id")
	private Branch option2;
	
	@OneToOne(targetEntity=Branch.class,cascade=CascadeType.ALL)
	@JoinColumn(name="option3",referencedColumnName="branch_id")
	private Branch option3;
	
	@Column(name="status")
	private String status;
	
	@Column(name="result")
	private String result;

	public Integer getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Integer preferenceId) {
		this.preferenceId = preferenceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Branch getOption1() {
		return option1;
	}

	public void setOption1(Branch option1) {
		this.option1 = option1;
	}

	public Branch getOption2() {
		return option2;
	}

	public void setOption2(Branch option2) {
		this.option2 = option2;
	}

	public Branch getOption3() {
		return option3;
	}

	public void setOption3(Branch option3) {
		this.option3 = option3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	
}
