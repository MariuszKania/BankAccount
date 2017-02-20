package pl.sda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.dao.ClientDao;
import pl.sda.model.Client;

@Service
public class ClientService {
	
	@Autowired
	private ClientDao clientDao;
	
	public List<Client> getAll() {
		return clientDao.getAll();
	}
	
	public Client getById(Long id) {
		return clientDao.getById(id);
	}
	public void save(Client client){
		clientDao.save(client);
	}
	
	
	public Client getByUsername(String username) {
		return clientDao.getByUsername(username);
	}
}
