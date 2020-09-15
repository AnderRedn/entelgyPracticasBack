package entelgyPracticasBack.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Weather implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;
	private Current current;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return "Weather [location=" + location + ", current=" + current + "]";
	}

}
