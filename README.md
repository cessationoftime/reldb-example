# reldb-example
Example connection to reldb (https://github.com/DaveVoorhis/Rel)

This was done using Rel version 1.0.12 Beta.

### Setup Rel Server on Windows

**Install Rel from Admin cmd window:**
```
java -jar RelInstall-1.0.12.jar
```
**Launch Rel Server** (make sure DBrowser is closed or it wont launch because of file lock).
```
cd C:\Program Files\Rel>
RelServer.bat
```
Rel should now be listening on port 5514

### Connect to Rel via Client
I simply referenced all the jars in C:\Program Files\Rel for my client, this might be overkill

**Connect with:**
```
import ca.mb.armchair.rel3.client.Connection;
Connection c = new Connection("localhost:5514");
```

**Query with:**
```
	private static CrashHandler ch = new CrashHandler() {
		@Override
		public void process(Throwable arg0) {
			arg0.printStackTrace();
		}
	};

Response r = c.evaluate("sys.Catalog", ch);
```

**Read response:**
```
Tuples v = (Tuples)r.awaitResult(1000);

		for (Tuple t : v) {
			System.out.println(t.toString());
			System.out.println(t.get("Name").toString() + " " + t.get("Definition").toString());
		}
```

# Client API Improvement, Strong Typing for Nullable/[Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html) values
I'd like to see optional values be strongly typed in the rel client.
```
Value v = t.get("NameOption"); //should throw an exception when used on Nullable/[Optional](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html) types.
```
instead one would use
```
ValueOption vo = t.option("NameOption");
```

And then when we call the toInt,toString functions we get an [Optional<T>](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html) type back.
```
Optional<String> nameOption = vo.toString();
```



```
