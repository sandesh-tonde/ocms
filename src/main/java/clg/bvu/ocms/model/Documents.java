package clg.bvu.ocms.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Documents {
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="documents_id")
	private Integer documentsId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="path")
	private String path;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Integer getDocumentsId() {
		return documentsId;
	}

	public void setDocumentsId(Integer documentsId) {
		this.documentsId = documentsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
