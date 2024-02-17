package demo;

/**
 * Class representing a flight arrival at an airport.
 */
public class Arrival 
{
	private String airportCode;
	private String flightNumber;
	private String arrivalTime;
	
	public Arrival( String airportCode, String flightNumber, String arrivalTime ) 
	{
		this.airportCode = airportCode;
		this.flightNumber = flightNumber;
		this.arrivalTime = arrivalTime;
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
	 * @return the flightNumber
	 */
	public String getFlightNumber() 
	{
		return flightNumber;
	}

	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber( String flightNumber ) 
	{
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() 
	{
		return arrivalTime;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime( String arrivalTime ) 
	{
		this.arrivalTime = arrivalTime;
	}
	
	
}
