package hh.swd20.gamelist.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String desc;
	private String releasedate;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "categoryid")
	private Category category;

	public Game(String name, String desc, String releasedate, Category category) {
		super();
		this.name = name;
		this.desc = desc;
		this.releasedate = releasedate;
		this.category = category;
	}
	
	public Game(String name, String desc, String releasedate) {
		super();
		this.name = name;
		this.desc = desc;
		this.releasedate = releasedate;
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

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", desc=" + desc + ", releasedate=" + releasedate + ", category="
				+ category + "]";
	}
	
	
	
	
}
