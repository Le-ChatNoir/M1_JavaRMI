
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;


// On specifie dans la definition de la classe que 
// celle-ci implante l'interface Hello et que ses
// instances seront des objets repartis
//
public class UsinePileServeur extends UnicastRemoteObject     
	  implements UsinePile
{

	// Attribut qui stocke le message qui sera renvoye 
	// aux clients 
	//
	String portNum = "";
  
	//Les methodes de UsinePile.java
	public Pile creation_pile(String nom, int max_size) throws java.rmi.RemoteException{
		//Puisque la pile est distante, il faut l'inserer dans le serveur de noms RMI
		//On cree donc l'objet MaPile, on lui affecte ses attributs, puis on "serialise" son nom et on le place dans le service de noms RMI avec le Naming.rebind, afin qu'il soit trouvable par son nom par un client 
		try 
		{
			PileServeur MaPile = new PileServeur();
			
			//Affectation des valeurs des attributs de la pile
			MaPile.name = nom;
			MaPile.stackSize = max_size;

			MyHostName machine = new MyHostName();

			//Construction de la chaine avec le nom de l'objet a envoyer au serveur de nom RMI
			//Le nom est necessaire pour lui donner un identifiant unique
            String nomService = "//" + machine.QualifiedHost() + ":" + this.portNum + "/" + nom;

			//Envoi au service de noms
			try{
				Naming.rebind(nomService, MaPile);
			} catch (MalformedURLException e) {
				System.out.println("MalformedURLException err: " + e.getMessage());
				e.printStackTrace();
			}

			System.out.println("PileServeur enregistre : " + nomService);
			return MaPile;
		} 
		catch (RemoteException e) 
		{
			System.out.println("PileServeur err: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}


	// Le constructeur pour la classe 
	//
	public UsinePileServeur() throws RemoteException {}


	// Methode principale
	//
	public static void main(String args[]) throws IOException
	{
     
		if (args.length != 1)
		{
			System.out.println("Un argument : port-rmiregistry ! ");
			System.exit(1);
		}
      

		// Creation et installation du security manager
		//
		if (System.getSecurityManager() == null) 
			System.setSecurityManager(new RMISecurityManager());
 

		try 
		{

			// Creation de l'objet qui va etre invoque par les clients 
			//
			UsinePileServeur MonServeur = new UsinePileServeur();

			// On publie le service au serveur de nom de JAVA : rmiregistry.
			// On utilise pour cela un nom symbolique que l'on va associer 
			// a l'objet.
			//
			// La structure d'un nom est :  //machine:port/nom
			// "machine" est le nom de la machine ou tourne le serveur
			// et "nom" correspond au nom du service.
			// "port" est le numero de port utilise par 
			// rmiregistry pour attendre les requetes destine au
			// service de noms.
			//
			MyHostName machine = new MyHostName();
			
			//Mise du port en variable pour pouvoir le reutiliser sur le meme port pour la creation et serialisation des piles
			MonServeur.portNum = args[0];

            String nomService = "//" + machine.QualifiedHost() + ":" + MonServeur.portNum + "/UsinePileServeur";

			Naming.rebind(nomService, MonServeur);

			System.out.println("UsinePileServeur enregistre : " + nomService);
		} 
		catch (RemoteException e) 
		{
			System.out.println("UsinePileServeur err: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
