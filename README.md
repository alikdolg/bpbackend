#BigPanda Backend task exercise

##The goal is implement a Non Blocking Producer/Consumer stream processing service that exposes an HTTP api.

###The blackbox executable that spits out an infinite stream of lines of event data encoded in JSON:
* Linux    - https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-linux-amd64
* Mac OS X - https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-macosx-amd64
* Windows  - https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-windows-amd64.exe

##Service Requirements

It should consume the output of the generator and gather the following stats:
A count of events by event type.
A count of words encountered in the data field of the events. (e.g. “the” → 32, “me” → 5)
It should expose these stats in an HTTP interface.
Stream may encounter corrupt JSON lines and should handle such events well and without interruption.


##Build:
Edit "exec_path" property in src/main/resources/application.properties file, update it with path to generator.
Run `mvn clean` and then `mvn install`

##Run
In project target directory run following command:
`java -jar application-0.0.1-SNAPSHOT.jar`

Use http://localhost:8080/countTypes URL for retrieve Event types counters
Use http://localhost:8080/countWords URL for retrieve Words counters

##Improvements:
Implement logger
HTML based client
Support sorted output for counters
 