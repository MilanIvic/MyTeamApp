package com.myTeam.myTeam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myTeam.myTeam.DAO.PlayerDAO;
import com.myTeam.myTeam.Entity.Player;

@Service
public class PlayerServiceImplem implements PlayerService {
	
	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public List<Player> findAll() {
		
		return playerDAO.findAll();
	}

	@Override
	@Transactional
	public Player findById(int id) {
		
		return playerDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Player thePlayer) {
		playerDAO.save(thePlayer);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		playerDAO.deleteById(id);
		
	}

}
