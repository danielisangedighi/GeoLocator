### Requirement
- Install JDK 17 0n the computer to be used for running the packaged build.
---
### Compiling and Running the source code on VSCode IDE
---
1. Download the folder from this Repository.
2. Open the extracted folder on VS Code IDE
3.  Run `./mvnw clean spring-boot:run` on the Terminal to clean the target folder, compile, and run the web server for the application.
4.  You may then access the web application from `https://<IP_Address_of_Host_Machine>:9090/login`.
---
### Building a package
- Run `./mvnw package` on the Terminal to build and packages the compiled classes into a JAR file.
- Run or double-click the `Advisor-0.0.1-SNAPSHOT` file at `C:\Users\<your_user_account>\Downloads\GeoLocator-master\target\` path
- You may then access the web application from `https://<IP_Address_of_Host_Machine>:9090/login`.
