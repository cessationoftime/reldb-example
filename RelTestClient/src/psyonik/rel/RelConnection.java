package psyonik.rel;

import java.io.IOException;

import ca.mb.armchair.rel3.client.Connection;
import ca.mb.armchair.rel3.client.Response;
import ca.mb.armchair.rel3.client.Tuple;
import ca.mb.armchair.rel3.client.Tuples;
import ca.mb.armchair.rel3.client.stream.CrashHandler;

public class RelConnection {

	public static void main(String[] args) {
		
		Connection c = new Connection("localhost:5514");
		
		
		
		try {
			UseConnection(c);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		while(true) {
			
		}
		
	}

	private static CrashHandler ch = new CrashHandler() {

		@Override
		public void process(Throwable arg0) {
			arg0.printStackTrace();
			
		}
	};

	
	public static void UseConnection(Connection c) throws IOException {
		Response r = c.evaluate("sys.Catalog", ch);
		
		String s = c.getServerAnnouncement();
		System.out.println(s);
		
		Tuples v = (Tuples)r.awaitResult(1000);

		for (Tuple t : v) {
			System.out.println(t.toString());
			System.out.println(t.get("Name").toString() + " " + t.get("Definition").toString());
		}
		

	}
	
}
