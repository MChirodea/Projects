package jnt;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.junit.Test;

import accounts.Account;
import accounts.SavingAccount;
import accounts.SpendingAccount;
import bankM.Bank;
import clients.Person;

public class Tester {

	@Test
	public void testAddPerson() {
		Bank b = new Bank();
		Person p = new Person(b.getAutoINCP(), "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		b.addPerson(p);
		LinkedHashSet<Person> tst = b.getClients();
		int flag  = 0;
		Iterator<Person> itp = tst.iterator();
		while(itp.hasNext()){
			if(itp.next().getId() == p.getId()){
				flag = 1;
			}
		}
		if(flag == 0){
			fail("The person wasn't added succesfully!");
		}
		
	}
	
	@Test
	public void testRemPerson(){
		Bank b = new Bank();
		Person p = new Person(b.getAutoINCP(), "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		b.addPerson(p);
		b.removePerson(p.getId());
		LinkedHashSet<Person> tst = b.getClients();
		int flag  = 0;
		Iterator<Person> itp = tst.iterator();
		while(itp.hasNext()){
			if(itp.next().getId() == p.getId()){			
				flag = 1;
			}
		}
		if(flag == 1){
			fail("The person wasn't removed succesfully!");
		}	
	}
	
	@Test
	public void testEditPerson(){
		Bank b = new Bank();
		Person p = new Person(b.getAutoINCP(), "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		Person p2 = new Person(b.getAutoINCP(), "Mihai Chirodea", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		b.addPerson(p);
		b.editClient(p2, p);
		LinkedHashSet<Person> tst = b.getClients();
		int flag  = 0;
		Iterator<Person> itp = tst.iterator();
		while(itp.hasNext()){
			Person tse = itp.next();
			if(tse.getId() == p2.getId()){	
				if(tse.getHolderName().equals("Mihai Chirodea")){
					flag = 1;
				}	
			}
		}
		if(flag == 0){
			fail("The person wasn't edited succesfully!");
		}	
	}
	
	@Test
	public void testAddAccount(){
		Bank b = new Bank();
		Person p = new Person(b.getAutoINCP(), "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		SavingAccount sav = new SavingAccount(p.getId(), b.getAutoINCA(), 20, 0);
		b.addPerson(p);
		b.addHolderAccount(sav, p);
		LinkedHashSet<Object> tst = b.readAcc(p.getId());
		int flag  = 0;
		Iterator<Object> itp = tst.iterator();
		while(itp.hasNext()){
			SavingAccount tse = (SavingAccount) itp.next();
			if(tse.getAccType() == sav.getAccType() && tse.getHolder() == p.getId()){	
					flag = 1;
				}	
			}
		
		if(flag == 0){
			fail("The account wasn't added succesfully!");
		}	
	}
	@Test
	public void testRemAccount(){
		Bank b = new Bank();
		Person p = new Person(b.getAutoINCP(), "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		SavingAccount sav = new SavingAccount(p.getId(), b.getAutoINCA(), 20, 0);
		b.addPerson(p);
		b.addHolderAccount(sav, p);
		b.remHolderAccount(sav.getID(), p.getId());
		LinkedHashSet<Object> tst = b.readAcc(p.getId());
		int flag  = 0;
		Iterator<Object> itp = tst.iterator();
		while(itp.hasNext()){
			SavingAccount tse = (SavingAccount) itp.next();
			if(tse.getAccType() == sav.getAccType() && tse.getHolder() == p.getId()){	
					flag = 1;
				}	
			}
		
		if(flag == 1){
			fail("The account wasn't removed succesfully!");
		}	
	}
	
	@Test
	public void testEditAccount(){
		Bank b = new Bank();
		Person p = new Person(b.getAutoINCP(), "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		SavingAccount sav = new SavingAccount(p.getId(), b.getAutoINCA(), 20, 0);
		SavingAccount sav2 = new SavingAccount(p.getId(),sav.getID(),0,0);
		b.addPerson(p);
		b.addHolderAccount(sav, p);
		b.writeAcc(p.getId(), sav2);
		LinkedHashSet<Object> tst = b.readAcc(p.getId());
		int flag  = 0;
		Iterator<Object> itp = tst.iterator();
		while(itp.hasNext()){
			SavingAccount tse = (SavingAccount) itp.next();
			if(tse.getAccType() == sav.getAccType() && tse.getHolder() == p.getId() && tse.getSavings() == sav2.getSavings()){	
					flag = 1;
				}	
			}
		
		if(flag == 0){
			fail("The account wasn't edited succesfully!");
		}	
	}
	
	@Test
	public void testPersonCL(){
		Person p = new Person(1, "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		int flag = 0;
		if(p.getId() == 1 && p.getHolderName().equals("Mijai") && p.getpID().equals("1970627055098") && p.getAddress().equals("Str. Doina, Nr.30") && p.getPhoneNr().equals("0740429211")){
			flag = 1;
		}
		
		if(flag == 0){
			fail("Person does not function correctly");
		}
	}
	
	@Test
	public void testAccountSCL(){
		Person p = new Person(1, "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		SavingAccount sav = new SavingAccount(p.getId(), 1, 20, 0);
		int flag = 0;
		if(p.getId() == 1 && sav.getID() == 1 && sav.getInterest() == 20 && sav.getSavings() == 0){
			flag = 1;
		}
		
		if(flag == 0){
			fail("Person does not function correctly");
		}
	}
	
	@Test
	public void testAccountSPCL(){
		Person p = new Person(1, "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		SpendingAccount sav = new SpendingAccount(p.getId(), 1, 20);
		int flag = 0;
		if(p.getId() == 1 && sav.getID() == 1 && sav.getTotal() == 20 ){
			flag = 1;
		}
		
		if(flag == 0){
			fail("Person does not function correctly");
		}
	}
	
	@Test
	public void testAccountCL(){
		Person p = new Person(1, "Mijai", "1970627055098", "Str. Doina, Nr.30", "0740429211");
		Account sav = new Account(p.getId(), 1, 1);
		int flag = 0;
		if(p.getId() == 1 && sav.getID() == 1 && sav.getAccType() == 1){
			flag = 1;
		}
		
		if(flag == 0){
			fail("Person does not function correctly");
		}
	}

}
