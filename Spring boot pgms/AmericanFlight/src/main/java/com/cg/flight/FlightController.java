package com.cg.flight;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.flight.beans.Flight;
@RequestMapping("api/v1/")
@RestController
@CrossOrigin(origins="*")
public class FlightController {
	{
		System.out.println("helloooooooo");
	}
	@RequestMapping(value="flight", method=RequestMethod.POST)
	public Flight save(@RequestBody Flight flight){
		return FlightStub.create(flight);
	}
	
	@RequestMapping(value="flight",method=RequestMethod.GET)
	public List<Flight> list(){
		System.out.println("hello");
		return FlightStub.list();
	}
	@RequestMapping(value="flight/{id}",method=RequestMethod.GET)
	public Flight get(@PathVariable("id") int id){
		return FlightStub.get(id);
	}
	@RequestMapping(value="flight/{id}",method=RequestMethod.DELETE)
	public Flight delete(@PathVariable("id") int id){
		return FlightStub.delete(id);
	}
	@RequestMapping(value="flight/{id}",method=RequestMethod.PUT)
	public Flight get(@PathVariable("id") int id,@RequestBody Flight flight){
		return FlightStub.update(id, flight);
	}
}
