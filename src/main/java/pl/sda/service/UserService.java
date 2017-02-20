package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sda.dao.UserDao;
import pl.sda.model.RoleType;
import pl.sda.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User getById(Long id) {
		return userDao.getById(id);
	}

	public void save(User user) {
		userDao.save(user);
	}
	
	public String login(String username, String password) {
		User user = userDao.getUserByUsernameAndPassword(username, password);
		
		if (RoleType.ADMIN.equals(user.getRole())) {
			return "admin";
		} else {
			return "user";
		}
	}
}
