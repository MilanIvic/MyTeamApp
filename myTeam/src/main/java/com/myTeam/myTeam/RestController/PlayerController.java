package com.myTeam.myTeam.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myTeam.myTeam.Entity.Player;
import com.myTeam.myTeam.Service.PlayerService;

@RestController
@RequestMapping("/myTeam")
public class PlayerController {
	
	@Autowired
	private PlayerService service;
	
	@GetMapping("/players")
	public List<Player> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/players/{playerId}")
	public Player getPlayerById(@PathVariable int playerId) {
		
		Player thePlayer = service.findById(playerId);
		
		if(thePlayer == null) {
			throw new RuntimeException("Player not found/" + playerId);
		}
		
		return thePlayer;
		
	}
	@PostMapping("/players")
	public Player addPlayer(@RequestBody Player myNewPlayer) {
		myNewPlayer.setId(0);
		
		service.save(myNewPlayer);
		
		return myNewPlayer;
	}
	
	@PutMapping("/players")
	public Player updatePlayer(@RequestBody Player thePlayer) {
		
		service.save(thePlayer);
		
		return thePlayer;
	}
	
	@DeleteMapping("/players/{playerId}")
	public String deletePlayer(@PathVariable int playerId) {
		
		Player testPlayer = service.findById(playerId);
		if(testPlayer == null) {
			throw new RuntimeException("Player id not found: "+playerId);
		}
		
		service.deleteById(playerId);
		
		return "Player deleted!" + playerId;
	}

}
