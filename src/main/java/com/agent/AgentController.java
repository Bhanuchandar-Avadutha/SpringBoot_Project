package com.agent;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class AgentController {
	@Autowired
	AgentService service;

	@GetMapping("/hi")
	public String Hi() {
		return "Hello, Spring boot project!!";
	}

	@PostMapping("/save")
	public void saveAgent(@RequestBody Agent agent) {
		System.out.println(agent.getAgentName() + " " + agent.getPassword());
		service.saveAgent(agent);
	}

	@GetMapping("/getagentdata/{id}")
	public Agent getAgentData(@PathVariable Integer id) {
		System.out.println("get agent!!");
		Agent agentData = service.getAgentData(id);
		return agentData;

	}

	@GetMapping("/getallagents")
	public List<Agent> getAllAgents() {
		List<Agent> list = service.getAllAgents();
		return list;
	}
	@GetMapping("/getallagentspage")
	public Page<Agent> getAllAgentsByPagination() {
		Page<Agent> pageRequset = service.getAllAgentsByPagination();
		return pageRequset;
	}

	@PutMapping("/updateagent")
	public String updateAgent(@RequestBody Agent agent) {
		System.out.println("update Agent!!");

		service.updateAgent(agent);

		return "success";
	}

	@DeleteMapping("/deleteallagents")
	public String deleteAllAgents() {
		System.out.println(" Delete All Agents!!");

		service.deleteAllAgents();

		return "success";
	}

	@DeleteMapping("/deleteagentdata/{id}")
	public String deleteAgentData(@PathVariable Integer id) {
		System.out.println("delete agent data!!");
		service.deleteAgentData(id);
		return "success";

	}
}
