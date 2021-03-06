
import java.rmi.*;


public class Affiche
{


	// Port permettant d'acceder a rmiregistry
	//
	static String portRmiregistry;


	public Affiche (String Machine)
	{
		try
		{
			String nomService = "//" + Machine + ":" + portRmiregistry + "/mapile";
			System.out.println (" Connexion au service : " + nomService);
			Pile p = (Pile) Naming.lookup (nomService);


			// Invocations de la pile
			//
			//Puisque Creation.java a ete active avant sur le meme serveur qui n'a pas ete coupe, alors les donnees inserees sont toujours dedans. Le .haut() recupere est alors la derniere donnee inseree par Creation.java, ici, le chien. Preuve que les resultats restent sur le serveur, les clients se connectant juste
			System.out.println ("Taille courante = " + p.lire_taille_courante() + "; Taille max = " + p.lire_taille_max() );
			PileDonnee d=p.haut();
			d.affiche();
				
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
		new Affiche (machine.QualifiedHost());
	}


}
