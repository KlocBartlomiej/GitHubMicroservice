package com.kloc.atipera;

import com.kloc.atipera.responses.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/github")
public class AtiperaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtiperaApplication.class, args);
	}

	@RequestMapping(value = "/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getUserRepos(@PathVariable(value="user") String usr){
		SuccessfulResponse sr = new SuccessfulResponse();
		Repository r = new Repository("5g_ran",usr);
		r.addBranch(new Branch("master","8sjvu3hv8"));
		r.addBranch(new Branch("bug5","jksud3378"));
		sr.addRepository(r);
		Repository r2 = new Repository("graJakaś","Bartku");
		r2.addBranch(new Branch("master","aocisuwjd"));
		r2.addBranch(new Branch("release","8sjchdywue"));
		r2.addBranch(new Branch("dupaBranch","0sid7fy23"));
		sr.addRepository(r2);
		return sr;
	}

}
