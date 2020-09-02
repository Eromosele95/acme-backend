# acme-backend

## Setup Instructions (INTELLIJ specific)
- Clone the repository into an empty folder
- cd into this newly created folder and open within any IDE (Tested with IntelliJ and Eclipse)
- Set the Java SDK to 1.8
- **Important** ensure to import both sub-folders (inventoryservice and inventoryservice-persistence) separately as modules within the created folder. i.e click on File > Project Structure > Modules > '+' > Import Module >  then select the inventoryservice-persistence folder and repeat process with inventoryservice folder.
-  Build the inventoryservice-persistence **first** by clicking View > Tool window > Maven Project > Lifecycle > package 
- After the Build is complete, the application layer(inventoryservice) can then be run via the InventoryserviceApplication file.
- **Importnant** This would only run on Java 8, ensure that the compiler for the build as well as the target build are set to Javs 8.


## Development Summary
-  The backend architecture was divided into a persistence layer and an application layer. As I used a simple datbase engine (h2), I felt it was better to abstract it that way 


![AGif.gif]()
