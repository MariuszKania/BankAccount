package pl.sda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "deposit")
public class Deposit implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Long number;
private Long amount;
private String end_date;
@ManyToOne
@JoinColumn(name="client_account_id")
private ClientAccount clientAccount;

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getNumber() {
	return number;
}
public void setNumber(Long number) {
	this.number = number;
}
public Long getAmount() {
	return amount;
}
public void setAmount(Long amount) {
	this.amount = amount;
}
public String getEnd_date() {
	return end_date;
}
public void setEnd_date(String end_date) {
	this.end_date = end_date;
}
public ClientAccount getClientAccount() {
	return clientAccount;
}
public void setClientAccount(ClientAccount clientAccount) {
	this.clientAccount = clientAccount;
}

}