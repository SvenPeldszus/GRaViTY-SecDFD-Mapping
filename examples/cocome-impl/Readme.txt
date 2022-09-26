This text file gives a short introduction on how to use the given implementation.

You can either use Eclipse to start the Trading System or just use the console.
If you use the console, please set fork=true in the tradingsystem.properties,
otherwise set fork=false.
The implementation comes as Eclipse-project. So if you use Eclipse, just import
this project and execute the targets as described below.

--------------------------------------------------------------------------------
                              PREREQUISITES:                                  
--------------------------------------------------------------------------------

* Java 1.5 environment and compiler
* Apache Ant
* Eclipse (optional, but recommended)

--------------------------------------------------------------------------------
                               COMPILATION:                                   
--------------------------------------------------------------------------------

The following ant targets can be used: (found under rsc/build.xml)

* "ant compile" on the build.xml : compiles the java source files
* "ant doc" : generates the javadoc
* "ant rmic" : (optional) stub generation for RMI

--------------------------------------------------------------------------------
                               DEPLOYMENT:                                   
--------------------------------------------------------------------------------

The following ant targets can be used: (found under rsc/build.xml)
If the targets are executed from within eclipse, the fork parameter in the 
tradingsystem.properties file can be set to false (which allows a smaller number
of JVM's to be started).

INFRASTRUCTURE

* "ant runInfrastructure" : starts RMI, message broker, and database
* "ant stopInfrastructure" : stops the database and message broker
  Note: In order to properly close the database manager / broker, it is 
  important to use this target, and not kill the runInfrastructure process.
  To kill the RMI process, you need to kill the runInfrastructure process 
  afterwards.
* "ant fillDB" : starts script to fill the database with dummy data
  We use automatic schema generation from our annotated persistent objects.
  This target must be executed once.
* "ant deleteDB" : deletes the directory the database entries are saved in. This
  is used to start from scratch. The database manager must be shut down before 
  executing this target.

INVENTORY

The components to start are configured in the rsc/tradingsystem.properties file 
in the runInventorySystem and runInventorySystemGUIs sections.

* "ant runInventorySystem" : starts the inventory components defined in 
  rsc/tradingsystem.properties.
* "ant runInventorySystemGUIs" : starts the inventory gui components defined in 
  rsc/tradingsystem.properties.
  
CASHDESK  

The components to start are configured in the rsc/tradingsystem.properties file 
in the runCashDeskLines section. It is important to keep 
rsc/tradingsystem.properties consistent to the rsc/jndi.properties file.

* "ant runCashDeskLines" : starts the cashdeskline components defined in 
  rsc/tradingsystem.properties.
  
  
--------------------------------------------------------------------------------
                        PROCESSING USE CASES:	
--------------------------------------------------------------------------------
In order to simulate the Use Cases, just execute the following targets in the 
following order:
1.deleteDB
2.runInfrastructure
3.fillDB
4.runInventorySystem
5.runCashDeskLines
6.runInventorySystemGUIs (not relevant for all Use Cases)

For stopping the Trading System, execute the target: stopInfrastructure

In order to simulate the Use Cases, you need some standard values like:
Valid Product Barcodes are among others: 900, 1000 (Used during UC1:Process Sale)
Valid Credit Card PIN: 7777 (Used during UC1:Process Sale for card payment)
Store Id: can be defined/found in the file tradingsystem.properties


--------------------------------------------------------------------------------
                               ISSUES:                                   
--------------------------------------------------------------------------------

* The INSTALL PATH of the system should not contain whitespaces.


--------------------------------------------------------------------------------
Last update: 17.01.07 by Yannick Welsch