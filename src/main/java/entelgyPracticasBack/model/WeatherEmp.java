package entelgyPracticasBack.model;

import java.io.Serializable;

public class WeatherEmp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nDIEmp;
	private String country;
	private String name;
	private String localtimeC;
	private String observation_time;
	private int temperature;
	private int wind_speed;
	private String wind_dir;
	private int precip;
	private int humidity;

	public WeatherEmp() {
		super();
	}

	public WeatherEmp(String nDIEmp, String country, String name, String localtimeC, String observation_time,
			int temperature, int wind_speed, String wind_dir, int precip, int humidity) {
		super();
		this.nDIEmp = nDIEmp;
		this.country = country;
		this.name = name;
		this.localtimeC = localtimeC;
		this.observation_time = observation_time;
		this.temperature = temperature;
		this.wind_speed = wind_speed;
		this.wind_dir = wind_dir;
		this.precip = precip;
		this.humidity = humidity;
	}

	public WeatherEmp(Weather weather) {
		this.country = weather.getLocation().getCountry();
		this.name = weather.getLocation().getName();
		this.localtimeC = weather.getLocation().getLocaltime();
		this.observation_time = weather.getCurrent().getObservation_time();
		this.temperature = weather.getCurrent().getTemperature();
		this.wind_speed = weather.getCurrent().getWind_speed();
		this.wind_dir = weather.getCurrent().getWind_dir();
		this.precip = weather.getCurrent().getPrecip();
		this.humidity = weather.getCurrent().getHumidity();
	}

	public String getnDIEmp() {
		return nDIEmp;
	}

	public void setnDIEmp(String nDIEmp) {
		this.nDIEmp = nDIEmp;
	}

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

	public String getLocaltimeC() {
		return localtimeC;
	}

	public void setLocaltimeC(String localtimeC) {
		this.localtimeC = localtimeC;
	}
}
