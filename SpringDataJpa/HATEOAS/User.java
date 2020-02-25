package SpringDataJpa.HATEOAS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DynamicUpdate
@Table(name="userspringdata")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User extends ResourceSupport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int userid;
	@Column(name="country")
	String country;
	String name;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", country=" + country + ", name=" + name + "]";
	}
	
	}
