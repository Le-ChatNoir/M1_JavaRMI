
import java.rmi.*;


public class Client 
{
	double montant;

	// Port permettant d'acceder a rmiregistry
	//
	static String portRmiregistry;


	public Client (String Machine)
	{
		try
		{
			String nomService = "//" + Machine + ":" + portRmiregistry + "/CompteServeur";
			System.out.println (" Connexion au service : " + nomService);

			// Se connecter à un objet de type compte et invoquer les methodes
			//		- debiter/crediter
			//		- lire_solde
			Compte obj = (Compte) Naming.lookup(nomService);
			montant = obj.lire_solde();
			System.out.println("Montant actuel: " + montant + "€");
			obj.crediter(23.50);
			montant = obj.lire_solde();
			System.out.println("Montant actuel: " + montant + "€");
			obj.debiter(10.25);
			montant = obj.lire_solde();
			System.out.println("Montant actuel: " + montant + "€");
				
		}

		catch (RemoteException e)
		{
			System.out.println ("RemoteException: " + e.getMessage ());
			e.printStackTrace ();
		}
		catch (Exception e)
		{
			System.out.println ("Exception: " + e.getMessage ());
			e.printStackTrace ();
		}

	}



	public static void main (String args[])
	{
		if (args.length != 2)
		{
			System.out.println ("Deux arguments : port-rmiregistry machine  ! ");
			System.exit (2);
		}

		portRmiregistry=args[0];

		MyHostName machine = new MyHostName(args[1]);
		new Client (machine.QualifiedHost());
	}


}
