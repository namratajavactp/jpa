package example.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Movie
 *
 */
@Entity
@Table(name="Movie_Details")
public class Movie implements Serializable {

	
	private int code;
	private String name;
	private String type;
	private static final long serialVersionUID = 1L;

	public Movie() {
		super();
	}   
	@Id
	@Column(name = "movie_code")
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}   
	@Column(name = "movie_name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	@Column(name = "movie_type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
