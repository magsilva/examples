import java.util.Locale;

import ch.ethz.iks.slp.Locator;
import ch.ethz.iks.slp.ServiceLocationEnumeration;
import ch.ethz.iks.slp.ServiceLocationException;
import ch.ethz.iks.slp.ServiceLocationManager;
import ch.ethz.iks.slp.ServiceType;
import ch.ethz.iks.slp.ServiceURL;

public class DeviceDiscovery
{
	public static void main(String[] args)
	{
		System.setProperty("net.slp.traceMsg", "true");
		try {
			Locator locator = ServiceLocationManager.getLocator(new Locale("en"));
			ServiceLocationEnumeration sle = locator.findServices(new ServiceType("service:x-hpnp-discover"), null, null);
			while (sle.hasMoreElements()) {
				ServiceURL foundService = (ServiceURL) sle.nextElement();
				System.out.println(foundService);
				System.out.println("Port : " + foundService.getPort());
				System.out.println("toString : " + foundService.toString());
			}
		} catch (ServiceLocationException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
}
