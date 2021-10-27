package com.myTeam.myTeam.DAO;

import java.util.List;

import com.myTeam.myTeam.Entity.Player;


public interface PlayerDAO {
	
	public List<Player> findAll();
	
	public Player findById(int id);
	
	public void save(Player thePlayer);
	
	public void deleteById(int id);

}
