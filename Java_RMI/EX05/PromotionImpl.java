import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class PromotionImpl extends UnicastRemoteObject 
		implements Promotion
{

	String portNum = "";
	
	public Etudiant ajouter_un_etudiant(int numero_etudiant, String nom, String prenom) throws java.rmi.RemoteException{
		try 
		{
			EtudiantImpl NewEtudiant = new EtudiantImpl();
			
			//Affectation des valeurs des attributs de la pile
			NewEtudiant.numero_etudiant = numero_etudiant;
			NewEtudiant.nom = nom;
			NewEtudiant.prenom = prenom;

			MyHostName machine = new MyHostName();

			//Construction de la chaine avec le nom de l'objet a envoyer au serveur de nom RMI
			//Le nom est necessaire pour lui donner un identifiant unique
            String nomService = "//" + machine.QualifiedHost() + ":" + this.portNum + "/" + numero_etudiant;

			//Envoi au service de noms
			try{
				Naming.rebind(nomService, NewEtudiant);
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException err: " + e.getMessage());
				e.printStackTrace();
			}

			System.out.println("EtudiantImpl enregistre : " + nomService);
			return NewEtudiant;
		} 
		catch (RemoteException e) 
		{
			System.out.println("EtudiantImpl err: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public Etudiant rechercher_un_etudiant(int numero_etudiant) throws java.rmi.RemoteException{
		
	}
	

	public double calculer_moyenne_de_la_promotion() throws java.rmi.RemoteException{
		
	}
	
	
	
}


