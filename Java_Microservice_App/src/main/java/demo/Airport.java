package demo;

/**
 * Class representing static airport information.
 */
public class Airport 
{
	private String airportCode;
	private String city;
	private int maxAircraftCapacity;
	
	public Airport( String airportCode, String city, int maxAircraftCapacity ) 
	{
		this.airportCode = airportCode;
		this.city = city;
		this.maxAircraftCapacity = maxAircraftCapacity;
	}
	
	/**
	 * @return the airportCode
	 */
	public String getAirportCode() 
	{
		return airportCode;
	}
	
	/**
	 * @param airportCode the airportCode to set
	 */
	public void setAirportCode( String airportCode ) 
	{
		this.airportCode = airportCode;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() 
	{
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity( String city ) 
	{
		this.city = city;
	}
	
	/**
	 * @return the maxAircraftCapacity
	 */
	public int getMaxAircraftCapacity() 
	{
		return maxAircraftCapacity;
	}
	
	/**
	 * @param maxAircraftCapacity the maxAircraftCapacity to set
	 */
	public void setMaxAircraftCapacity( int maxAircraftCapacity ) 
	{
		this.maxAircraftCapacity = maxAircraftCapacity;
	}
}
