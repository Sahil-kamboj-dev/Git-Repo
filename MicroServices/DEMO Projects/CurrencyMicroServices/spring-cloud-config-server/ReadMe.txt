Added Spring Cloud Config Server.
Used to pass the config. to MicroServices at run time.
This makes the MicroServices Architecture loosely coupled.
As the configurations can be changed in here.

In this we are defined a path of local git repo. to fetch the config.
Config. files are defined on the basis of application name of MicroService.
But we can configure the name of config. file with our desired name and mention the name in MicroService application file.