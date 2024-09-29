package com.cloud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cloud.entity.Citizen;
import com.cloud.entity.RequiredResponse;
import com.cloud.model.VaccinationCenter;
import com.cloud.repo.VaccinationCenterRepo;


@RestController
@RequestMapping("/vaccination")
public class VaccinationCenterController {
	@Autowired
	private RestTemplate resttemplate;
	@Autowired
	private VaccinationCenterRepo repo;
	@GetMapping("/test")
	public String testmethod() {
		return "welcome to vaccination-center-service";
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter>addcenter(@RequestBody VaccinationCenter newcenter) {
		VaccinationCenter center=repo.save(newcenter);
		
		
		return  new ResponseEntity<>(center,HttpStatus.OK);
	}
	@GetMapping("id/{id}")
	public VaccinationCenter getvaccinationRecord(@PathVariable int id) {
		VaccinationCenter getone=repo.findById(id).get();
		return getone;
	}
	@GetMapping("getData/{id}")
	public ResponseEntity<RequiredResponse> getdata(@PathVariable int id) {
		RequiredResponse requiredResponse =new RequiredResponse();
		VaccinationCenter center=repo.findById(id).get();
		requiredResponse.setCenter(center);
		List<Citizen>citizens=resttemplate.getForObject("Http://CITIZENSERVICE/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(citizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
	}
	
	

}
