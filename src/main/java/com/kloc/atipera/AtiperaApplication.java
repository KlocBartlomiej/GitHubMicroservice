package com.kloc.atipera;

import com.kloc.atipera.models.*;
import com.kloc.atipera.responses.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@RestController
@RequestMapping("/github")
public class AtiperaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtiperaApplication.class, args);
	}

	private static String getGitResponse(String uri){
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(uri))
				.build();
		return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.join();
	}

	@RequestMapping(value = "/{user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getUserRepos(@PathVariable(value="user") String usr){
		SuccessfulResponse successfulResponse = new SuccessfulResponse();
		Repository repository;
		String repositoryName;
		JSONArray repositories;
		try {
			repositories = new JSONArray(getGitResponse("https://api.github.com/users/" + usr + "/repos"));
		} catch(JSONException e){
			return new ErrorResponse("404", "Not Found");
		}
		for(int i = 0; i < repositories.length(); i++){
			JSONObject jsonRepository = (JSONObject) repositories.get(i);
			if(jsonRepository.get("fork").equals("true")){
				continue;
			}
			repositoryName = (String) jsonRepository.get("name");
			repository = new Repository(repositoryName,usr);

			JSONArray branches = new JSONArray(getGitResponse("https://api.github.com/repos/" + usr + "/" + repositoryName + "/branches"));
			for(int j = 0; j < branches.length(); j++){
				JSONObject jsonBranch = (JSONObject) branches.get(j);
				JSONObject commit = (JSONObject) jsonBranch.get("commit");
				repository.addBranch(new Branch((String) jsonBranch.get("name"),(String) commit.get("sha")));
			}
			successfulResponse.addRepository(repository);
		}
		return successfulResponse;
	}

}
