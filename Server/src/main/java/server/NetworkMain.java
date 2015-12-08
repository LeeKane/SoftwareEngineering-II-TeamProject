package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import DataServiceTxtFileImpl.InquireDataServiceTxtImpl;
import DataServiceTxtFileImpl.logindataserviceimpl;
import dataservice.inquiredataservice.InquireDataService;
import dataservice.logindataservice.LoginDataService;

public class NetworkMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InquireDataService id=new InquireDataServiceTxtImpl();
			LoginDataService ld=new logindataserviceimpl();
			LocateRegistry.createRegistry(6600);
			Naming.rebind("rmi://127.0.0.1:6600/InquireDataService", id);
			Naming.rebind("rmi://127.0.0.1:6600/LoginDataService", ld);
			System.out.println("Service Start!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
