import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class EtudiantImpl extends UnicastRemoteObject 
		implements Etudiant
{
	private String nom = "";
	private String prenom = "";
	private int numero_etudiant;
	private ArrayList<Epreuve> epreuves = new ArrayList<Epreuve>;
	
	public String nom() throws java.rmi.RemoteException{
		return this.nom;
	}
	
	public String prenom() throws java.rmi.RemoteException{
		return this.prenom;
	}
	
	public int numero_etudiant() throws java.rmi.RemoteException{
		return this.numero_etudiant;
	}
	

	public String afficher_liste_des_epreuves() throws java.rmi.RemoteException{
		String res = "";
		for(Epreuve e : this.epreuves){
			res += e.afficher() + "\n";
		} 
		return res;
	}
	
	public void ajouter_une_epreuve(Epreuve e) throws java.rmi.RemoteException{
		this.epreuves.add(e);
	}
	
	public double calculer_la_moyenne() throws java.rmi.RemoteException{
		double total = 0.0;
		for(Epreuve e : this.epreuves){
			total += e.note();
		} 
		return total;
	}
	
	
}


