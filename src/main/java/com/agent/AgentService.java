package com.agent;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
	@Autowired
	IAgentRepository repo;

	public void saveAgent(Agent agent) {
		System.out.println("save Service!");
		System.out.println(agent.getMobile() + " " + agent.getCity());
		repo.save(agent);
		System.out.println("sucessfully completed!!");

	}

	public Agent getAgentData(Integer id) {
		Optional<Agent> optional = repo.findById(id);
		Agent agent = new Agent();
		if (optional.isPresent()) {
			agent = optional.get();
		}
		return agent;

	}

	public List<Agent> getAllAgents() {
		System.out.println("getAllAgents");
		Sort sortOrder = Sort.by("agentName");
		List<Agent> list = repo.findAll(sortOrder);
		return list;

	}
	
	public Page<Agent> getAllAgentsByPagination() {
		System.out.println("getAllAgents");
		PageRequest paging = PageRequest.of(0, 5, Sort.by("agentName").ascending());
		Page<Agent> pageResult=repo.findAll(paging);
		return pageResult;

	}

	public void updateAgent(Agent agent) {
		System.out.println(agent.getCity() + " " + agent.getAgentName());
		repo.save(agent);
		System.out.println("completed successfully");

	}

	public void deleteAllAgents() {
		System.out.println("delete all agents!!");
		repo.deleteAll();
	}

	public void deleteAgentData(Integer id) {
		repo.deleteById(id);

		
	}

}
