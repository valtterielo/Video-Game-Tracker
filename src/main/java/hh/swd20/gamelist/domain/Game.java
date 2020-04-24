package hh.swd20.gamelist.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.sql.Date;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@NotBlank(message = "Cannot be empty!")
	private String name;
	@NotBlank(message = "Cannot be empty!")
	@Size(max = 255, message = "Description cannot exceed 255 characters")
	private String desc;
	private Date releasedate;
	private String releasedateString;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "categoryid")
	private Category category;

	public Game(String name, String desc, String strReleasedate, Category category) {
		super();
		this.name = name;
		this.desc = desc;
		this.releasedate = Date.valueOf(strReleasedate);
		this.category = category;
	}
	
	public Game(String name, String desc, String strReleasedate) {
		super();
		this.name = name;
		this.desc = desc;
		this.releasedate = Date.valueOf(strReleasedate);
	}

	public Game() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String strReleasedate) {
		this.releasedate = Date.valueOf(strReleasedate);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getReleasedateString() {
		return releasedateString;
	}

	public void setReleasedateString(String releasedateString) {
		this.releasedateString = releasedateString;
	}

	/*@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", desc=" + desc + ", releasedate=" + releasedate + ", category="
				+ category + "]";
	}*/
	
	
	
	
}
