The following is a demonstration of the application.

From Eclipse, I can use the Boot Dashboard to run the application, and I get this console output:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/53cfd539-b4d3-49b8-b1f3-c8e774cf30a0)

The application uses a concept of a simple airport database, where some static airport data exists and could be associated to arrival or departure data.

A no-argument constructor on the main class is called when the application runs which instantiates some basic airport data:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/1edc94b9-d069-4490-a5ba-d9b29b15cf36)

I will use Postman to validate the API behavior.
If I send a GET request to "localhost:8080/api/greeting" I receive this response:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/4712a50c-ba26-408e-98f5-261aa360bdb8)

The URL is mapped by this Spring RestController:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/21d4e4bc-71df-43b6-80c2-b788d86b40a6)

Next, the "spring-cloud-starter-function-web" dependency is used to have Functions annotated with @Bean act as web service endpoints. I will demonstrate the use of each.

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/49aa001f-3f2f-4aea-a48e-b3d04699ca27)

The retrieveAirport endpoint can be accessed with a GET or POST request with the airport code included in the request. When using GET the value can be appended to the URL, and when using POST the value goes into the request body. The contents of the Airport object is returned:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/a100c0bd-96e7-47bc-ba5a-d3cb0ccfe005)

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/1355f979-bc73-44fa-bc11-fcbcfea83aa4)

This is implemented with the following Function, which searches for and returns an Airport with the given airportCode:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/3f6accbf-e117-4e12-b0bb-3de724099952)

The processArrival endpoint can be accessed with a POST request with JSON provided in the request body specifying an Arrival object:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/10313f80-b7ec-421d-b168-2f489eb7e25e)

Nothing is returned, but we can see the Consumer printing the values provided to the console:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/dd0be5a8-db30-4617-8902-8d29ccb2e15a)

The processArrivalReactive endpoint is the same thing as processArrival, except it is implemented with a Function instead of a Consumer:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/ed032736-ffd8-4629-8653-e7e5ab78a003)

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/50c9ba46-3d2d-4382-a07b-be78c52ddb0b)

The processListOfArrivalsReactive endpoint is also similar, except it processes a list of arrivals given in the request instead of just one:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/695e870d-5309-408f-9123-e17ba4d4496f)

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/1f09de57-e35e-48de-898f-3354cc4dbc15)

Finally, the getAirports endpoint can be accessed with a GET request and uses a Supplier to return all of the Airport object data:

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/71a0fee8-7ade-4242-a6a8-1c09dc5ff9e4)

![image](https://github.com/jordan-p-jones/Java-Microservice-Demo/assets/20289004/8525ebaa-a322-48a4-8628-300d6161addd)

That's all for now!
