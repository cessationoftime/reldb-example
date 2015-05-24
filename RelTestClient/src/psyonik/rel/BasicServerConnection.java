package psyonik.rel;

import java.io.IOException;

import ca.mb.armchair.rel3.client.stream.CrashHandler;
import ca.mb.armchair.rel3.client.string.ClientFromURL;
import ca.mb.armchair.rel3.client.string.ClientNetwork;
import ca.mb.armchair.rel3.client.string.StringReceiverClient;
import ca.mb.armchair.rel3.shared.Defaults;

public class BasicServerConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {

	//Close DBrowser on Server PC. And run RelServer.bat in a cmd admin window.  Server should startup on port 5514  
	StringReceiverClient cli = ClientFromURL.openConnection("localhost:5514");
receiveMessage(cli);
System.out.println("------------!FirstCommand!------------");
cli.sendEvaluate("3 + 4", new CrashHandler() {

	@Override
	public void process(Throwable arg0) {
		arg0.printStackTrace();
		
	}
	
});
receiveMessage(cli);

cli.close();

} catch (Exception ex) {
	System.out.println(ex.toString());
	ex.printStackTrace();
}
	}
	
	public static void receiveMessage(StringReceiverClient cli) throws IOException {
		String s;
		while ((s = cli.receive()) != null)
		System.out.println(s);
	}

}
