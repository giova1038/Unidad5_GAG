package com.lds.soap;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lds.soap.GlobalWeatherStub.GetCitiesByCountry;
import com.lds.soap.GlobalWeatherStub.GetCitiesByCountryResponse;
import com.lds.soap.GlobalWeatherStub.GetWeather;
import com.lds.soap.GlobalWeatherStub.GetWeatherResponse;

@Path("/servlet")
public class Endpoint {

	@GET
	@Path("/pais/{pais}")
	@Produces("text/plain")
	public String servlet3(@PathParam("pais") String identificador) throws RemoteException {
		
		GlobalWeatherStub globalWeatherStub=new  GlobalWeatherStub();
		GetCitiesByCountry getCitiesByCountry=new GetCitiesByCountry();
		getCitiesByCountry.setCountryName(identificador);
		 
		GetCitiesByCountryResponse getCitiesByCountryResponse= globalWeatherStub
				.getCitiesByCountry (getCitiesByCountry);
		
		
				
		return getCitiesByCountryResponse.getGetCitiesByCountryResult();

	}
}


