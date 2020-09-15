package entelgyPracticasBack.model;

import java.io.Serializable;

public class Current implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String observation_time;
	private int temperature;
	private int wind_speed;
	private String wind_dir;
	private int precip;
	private int humidity;

	public String getObservation_time() {
		return observation_time;
	}

	public void setObservation_time(String observation_time) {
		this.observation_time = observation_time;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(int wind_speed) {
		this.wind_speed = wind_speed;
	}

	public String getWind_dir() {
		return wind_dir;
	}

	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}

	public int getPrecip() {
		return precip;
	}

	public void setPrecip(int precip) {
		this.precip = precip;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "Current [observation_time=" + observation_time + ", temperature=" + temperature + ", wind_speed="
				+ wind_speed + ", wind_dir=" + wind_dir + ", precip=" + precip + ", humidity=" + humidity + "]";
	}

}
