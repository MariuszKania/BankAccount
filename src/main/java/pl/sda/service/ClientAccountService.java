package pl.sda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.dao.ClientAccountDao;
import pl.sda.dao.ClientDao;
import pl.sda.model.Client;
import pl.sda.model.ClientAccount;

@Service
public class ClientAccountService {
	@Autowired
	private ClientAccountDao clientAccountDao;
	
	@Autowired
	private ClientDao clientDao;
	
	public List<ClientAccount> getAccountsByClientId(Long clientId){
		return clientAccountDao.getAccountsByClientId(clientId);
		}
	public void save(ClientAccount clientAccount){
		clientAccountDao.save(clientAccount);
	}
	
	public void createAccount(Long clientId) {
		Client client = clientDao.getById(clientId);
    	ClientAccount newAccount = new ClientAccount();
        newAccount.setAccount_number(System.currentTimeMillis());
        newAccount.setAmount(0.0);
        newAccount.setClient(client);
        clientAccountDao.save(newAccount);
	}
}
