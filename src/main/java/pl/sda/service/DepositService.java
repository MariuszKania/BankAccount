package pl.sda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.dao.DepositDao;
import pl.sda.model.Deposit;

@Service
public class DepositService {
@Autowired
private DepositDao depositDao;
public List<Deposit> getDepositsByAccountId(Long clientId){
	return depositDao.getDepositsByAccountId(clientId);
	}
}
