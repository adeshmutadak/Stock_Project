# Stock_Project
 

# Framework Used
* Spring Boot

# Language 
* Java
# Data Flow
  
 In this project, we have four layers-

* Controller-The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views ie, frontend part.

 *  Repository - Here database is stored, for which I have used arrayList. In the database layer, CRUD (create, read, update, delete) operations are performed.

* Service-The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers. • DataBase Class - Here the class user is defined and the whatever a user class will load, eg-stockld, stockName,

pirce, stockType etc.
# Data Structure used in my project


# project Summary 
Our project basically maintains the upcoming user information which includes

* id

*  stock 

* stockName

* Type

* stockPrice

You can read, read by specific id, update userName of specific userid, delete a user by their userld by api calls
