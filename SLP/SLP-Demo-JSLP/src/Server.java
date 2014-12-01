import java.util.Hashtable;
import java.util.Locale;

import ch.ethz.iks.slp.Advertiser;
import ch.ethz.iks.slp.ServiceLocationException;
import ch.ethz.iks.slp.ServiceLocationManager;
import ch.ethz.iks.slp.ServiceURL;

public class Server
{

	public static void main(String[] args) throws ServiceLocationException
	{

		Server myServer = new Server();
		myServer.registerService();
	}

	private void registerService() throws ServiceLocationException
	{
		// get Advertiser instance
		Advertiser advertiser = ServiceLocationManager.getAdvertiser(new Locale("en"));

		// the service has lifetime 60, that means it will only persist for one minute
		ServiceURL myService = new ServiceURL("service:test:myService://", 60);

		// some attributes for the service
		Hashtable<String, Object> attributes = new Hashtable<String, Object>();
		attributes.put("persistent", Boolean.TRUE);
		attributes.put("cool", "yes");
		attributes.put("max-connections", new Integer(5));

		advertiser.register(myService, attributes);
		System.out.println("Server successfully registered");
	}
}
