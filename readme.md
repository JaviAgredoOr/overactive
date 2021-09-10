# Back End Java Developer 
## Overactive Assessment
### Purchases and rewards
The description of the requested exercise is in the `BackEndJavaDeveloper.pdf` file in the `Docs` directory in the repository.

#### Entities
For the solution of the exercise I propose 3 entities in the database.
- **Customers**, which stores customer information
- **Purchases**, which stores purchase information
- **Strategies**, which stores strategies for calculating scores. This entity is created in the database in order to allow an easy extension of new strategies or remove one of them.



# Requirements
For building and running the application you need:
* [JDK 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/)

# Initial settings
The application has an automatic data load file when starting the application in  `resources/import.sql`.
This file loads 6 customers, 2 reward strategies, and 11 purchases.

The application is using **h2** as the database. By default the application initializes with the configuration described in `resources/application.properties`. This file is configured to run on `port 8001`.

There is a configuration file `resources/application.properties.postgres` prepared with the configuration if you want to use the **Postgres database engine**. If you want to use such settings, you can rename the file to `application.properties` or copy those settings into the current `application.properties` file.

#### Postgres as database engine
To use the application with Postgres, you must import the commented dependencies of `jdbc` and `postgresql` into the POM file and remove the dependency from `h2`.

Additionally, run the `creabas.sql` script with the postgres database structure found in the `Docs` directory of the repository.

# Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.overactive.javier.assessment.AssessmentApplication` class from your IDE.

Alternatively you can use in the root of the project:
```bash
mvn spring-boot:run
```

# Main endpoint
When the application is running, customer consultation services and reward points are available.

```bash
http://localhost:8001/api/customer/last-quarter
```