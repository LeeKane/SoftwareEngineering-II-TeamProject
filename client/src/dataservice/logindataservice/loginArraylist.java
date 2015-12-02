package dataservice.logindataservice;

import java.io.Serializable;
import java.util.ArrayList;

import po.*;
import util.Permission;

public class loginArraylist implements Serializable {

	ArrayList<AccountPO> list;
	
	public void creat(){
		ArrayList<AccountPO> list=new ArrayList<AccountPO>();
		this.list=list;
	}
	public void destroy(){
		list.clear();
	}
	public void insert(AccountPO po){
		list.add(po);
	}
	public void delete(AccountPO po){
		list.remove(po);
	}
public boolean login(String username,String password){

	int i=0;
	while(i<list.size()){
	AccountPO po=list.get(i);
	if(po.getUsername().equals(username)&&po.getPassword().equals(password)){
		System.out.println("login success");
		return true;
		
}
	else{
		i++;
	}
	}
	if(i==list.size()){
		System.out.println("login failure");
		
		}
	return false;


	
	
}
	public boolean find(AccountPO po){
		if(list.contains(po)){
			System.out.println("find success");
		return true;
		}
		else{
			System.out.println("find failure");
			return false;
		}
		
		
		
	}
	public static void main(String[] args){
		loginArraylist list=new loginArraylist();
		list.creat();
		AccountPO po=new AccountPO(15516, Permission.COUNTER, "lin","fu");
		AccountPO p=new AccountPO(155161, Permission.COUNTER, "lin2","fu");
		list.insert(po);
		list.insert(p);
		list.insert(p);
		System.out.println(list.login("lin2","fu"));
		
	}
}
