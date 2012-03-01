package com.sqlandbi.pumperapp.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sqlandbi.pumperapp.dao.StopDAO;
import com.sqlandbi.pumperapp.domain.StopDetails;

@Controller
public class StopController {
	@Autowired
	private StopDAO stopDAO;
	/*
	@RequestMapping("/pumperapp/{name}")
    public String hello(@PathVariable String name, Model model) {
            model.addAttribute("name", name);
            return "pumperapp/pumperWeb";
    }*/
	
	@RequestMapping("/pumperapp/hello")
    public String hello(Model model) {
            //model.addAttribute("name", name);
            return "pumperapp/pumperWeb";
    }
	
	/*
	@RequestMapping(value="/availability", method=RequestMethod.GET)
	public @ResponseBody AvailabilityStatus getAvailability(@RequestParam String name) {
	    for (Account a : accounts.values()) {
	        if (a.getName().equals(name)) {
	            return AvailabilityStatus.notAvailable(name);
	        }
	    }
	    return AvailabilityStatus.available();
	}*/
	
	@RequestMapping(value="/pumperapp/create", method=RequestMethod.POST)
	public @ResponseBody StopDetails create(@RequestBody  StopDetails stopDetails, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
	    StopDetails details = stopDAO.addStopDetails(stopDetails);
	    return details;
	}
	
	@RequestMapping(value="/pumperapp/update", method=RequestMethod.POST)
	public void updateStopDetails (@RequestBody  StopDetails stopDetails, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
	   stopDAO.updateStopDetails(stopDetails.getStopId(), stopDetails);
	}
	
	@RequestMapping(value="/pumperapp/getStopDetails", method=RequestMethod.GET)	
	public @ResponseBody Collection<StopDetails> getStopDetails(HttpServletResponse response) throws Exception {
		//ObjectMapper mapper = new ObjectMapper();
		//StopDetails user = mapper.readValue(account, StopDetails.class);
//		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		response.setContentType("application/json");
	    Collection<StopDetails> details = stopDAO.getStopDetailsList();
	    return details;
	}


}
