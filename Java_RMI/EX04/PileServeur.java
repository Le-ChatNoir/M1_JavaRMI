
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;


// On specifie dans la definition de la classe que 
// celle-ci implante l'interface Pile et que ses
// instances seront des objets repartis
//
public class PileServeur extends UnicastRemoteObject     
	  implements Pile
{

	// Attribut qui stocke le message qui sera renvoye 
	// aux clients 
	//
	String name;
	//Instancier pour eviter le NullPointerException sur l'appel de .size()
	ArrayList<PileDonnee> stack = new ArrayList<PileDonnee>();
	int stackSize;
  

	// Ceci est l'implantation de la methode qui 
	// sera invoquee de facon (eventuellement) 
	// distante par les clients
	//
	public void empiler(PileDonnee data) throws java.rmi.RemoteException{
		if(this.lire_taille_courante() == this.stackSize){
			throw new RemoteException("Pile pleine");
		} else {
			this.stack.add(0,data);
		}
	}

	public PileDonnee haut() throws java.rmi.RemoteException{
		if(this.lire_taille_courante() == 0){
			throw new RemoteException("Pile vide");
		} else {
			return (PileDonnee)this.stack.get(0);
		}
	}

	public void depiler() throws java.rmi.RemoteException{
		if(this.lire_taille_courante() == 0){
			throw new RemoteException("Pile vide");
		} else {
			this.stack.remove(0);
		}
	}

	public void vider() throws java.rmi.RemoteException{
		this.stack.clear();
	}
		
	public int lire_taille_courante() throws java.rmi.RemoteException{
		return this.stack.size();
	}

	public int lire_taille_max() throws java.rmi.RemoteException{
		return this.stackSize;
	}


	// Le constructeur pour la classe 
	//
	public PileServeur() throws RemoteException {
	}
}
