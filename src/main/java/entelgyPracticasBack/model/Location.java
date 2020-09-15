package entelgyPracticasBack.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String country;
	private String name;
	private String localtimeC;

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

	public String getLocaltime() {
		return localtimeC;
	}

	public void setLocaltime(String localtimeC) {
		this.localtimeC = localtimeC;
	}

	@Override
	public String toString() {
		return "Location [country=" + country + ", name=" + name + ", localtime=" + localtimeC + "]";
	}
	

}
