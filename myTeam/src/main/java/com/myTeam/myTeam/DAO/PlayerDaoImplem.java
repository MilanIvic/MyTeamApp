package com.myTeam.myTeam.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myTeam.myTeam.Entity.Player;



@Repository
public class PlayerDaoImplem implements PlayerDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Player> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Player> theQuery = currentSession.createQuery("from Player",Player.class);
		
		List<Player> lista = theQuery.getResultList();
		
		return lista;
		
	}

	@Override
	public Player findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Player thePlayer = currentSession.get(Player.class, id);
		
		return thePlayer;
	}

	@Override
	public void save(Player thePlayer) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(thePlayer);
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Player where id=:theId");
		
		theQuery.setParameter("theId", id);
		
		theQuery.executeUpdate();
		
	}

}
