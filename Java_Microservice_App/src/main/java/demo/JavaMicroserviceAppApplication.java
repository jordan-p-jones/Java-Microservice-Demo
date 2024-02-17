package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class to handle running the application.
 */
@SpringBootApplication
public class JavaMicroserviceAppApplication 
{
	/**
	 * Main method to run the application.
	 * 
	 * @param args contains any runtime arguments.
	 */
	public static void main( String[] args ) 
	{
		SpringApplication.run( JavaMicroserviceAppApplication.class, args );
	}
	
	// In-memory data (represents the application "database")
	List<Airport> airports;
	
	/**
	 * Initialize the database when the application starts.
	 */
	public JavaMicroserviceAppApplication()
	{
		this.airports = new ArrayList<>();
		this.airports.add( new Airport( "PDX", "Portland", 200 ) );
		this.airports.add( new Airport( "SMF", "Sacramento", 100 ) );
		this.airports.add( new Airport( "LAX", "Los Angeles", 250 ) );
	}
	
	/**
	 * Function as a web service endpoint to retrieve information 
	 * about a given airport.
	 * 
	 * @return the <code>Airport</code> related to the airport code
	 *         given in the request.
	 */
	@Bean
	public Function<String, Airport> retrieveAirport()
	{
		return value -> 
		{
			System.out.println( "Received request for airport: " + value );
			
			return this.airports.stream()
				.filter( airport -> value.equals( airport.getAirportCode() ) )
				.findAny()
				.orElse( null );
		};
	}
	
	/**
	 * Consumer as a web service endpoint to process flight arrivals.
	 */
	@Bean
	public Consumer<Arrival> processArrival()
	{
		return value ->
		{
			System.out.println( "Received arrival of flight " + value.getFlightNumber() + " at " + value.getAirportCode() );
		};
	}
	
	/**
	 * Flight arrival consumer implemented in a "reactive" style as a Function.
	 */
	@Bean
	public Function<Arrival, Mono<Void>> processArrivalReactive()
	{
		return value ->
		{
			System.out.println( "Received reactive arrival of flight " + value.getFlightNumber() + " at " + value.getAirportCode() );
			return Mono.empty();
		};
	}
	
	/**
	 * Consume a list of flight arrivals in a "reactive" style.
	 */
	@Bean
	public Consumer<Flux<Arrival>> processListOfArrivalsReactive()
	{
		return value ->
		{
			value.subscribe( arrival -> System.out.println( arrival.getFlightNumber() ) );
		};
	}
	
	/**
	 * Supplier as a web service endpoint to retrieve all airport data.
	 * 
	 * @return all airports.
	 */
	@Bean
	public Supplier<Flux<Airport>> getAirports()
	{
		return () -> Flux.fromIterable( this.airports );
	}
}

/**
 * Controller to map web service requests.
 */
@RestController
class MyController
{
	@GetMapping("/api/greeting")
	public String offerGreeting()
	{
		return "Hello there!";
	}
}