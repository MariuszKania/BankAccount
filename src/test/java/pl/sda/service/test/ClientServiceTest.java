package pl.sda.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.sda.model.Client;
import pl.sda.service.ClientService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	
	@Test
	public void shouldGetHelloById() {
		Client client = clientService.getById(1L);
		Assert.assertNotNull(client);
	}
	
	@Test
	public void shouldGetHelloList() {
		List<Client> list = clientService.getAll();
		Assert.assertNotNull(list);
	}
}
