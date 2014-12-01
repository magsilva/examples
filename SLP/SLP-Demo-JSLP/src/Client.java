import java.util.Locale;

import ch.ethz.iks.slp.Locator;
import ch.ethz.iks.slp.ServiceLocationEnumeration;
import ch.ethz.iks.slp.ServiceLocationException;
import ch.ethz.iks.slp.ServiceType;
import ch.ethz.iks.slp.ServiceURL;
import ch.ethz.iks.slp.impl.ServiceLocationManager;

/**
 * TODO javadoc:What is the function of Client class?
 * 
 * @since 1.0
 * @version $Id$
 */
public class Client
{

	/**
	 * TODO javadoc:Document method.
	 * 
	 * @param args
	 * @throws ServiceLocationException
	 */
	public static void main(String[] args) throws ServiceLocationException
	{

		// get Locator instance
		Locator locator = ServiceLocationManager.getLocator(new Locale("en"));

		// find all services of type "test" that have attribute "cool=yes"
		ServiceLocationEnumeration sle = locator.findServices(new ServiceType("service:test"),
						null, "(cool=yes)");

		System.out.println("Service location enum found");
		// iterate over the results
		while (sle.hasMoreElements()) {
			ServiceURL foundService = (ServiceURL) sle.nextElement();
			System.out.println(foundService);
		}

		System.exit(0);
	}

}
