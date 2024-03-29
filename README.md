### Task Management Application

## Overview

Task Management Application is designed to help you organize the tasks for each property and user. The
application also allows to filter tasks based on Property and the User.

![Task Page](./images/taskpage.png)

## Technologies used

1. **Java 21**
2. **Apache Wicket 9**
3. **Postgresql**
4. **Hibernate**
5. **Bootstrap**

## Run Locally

1. Clone the Repository:
   ```bash
   git clone git@github.com:rauf/wicket-todos.git
   cd wicket-todos
    ```
2. Setup Local database
    1. Create a database named `tasks` in your local postgresql server
    2. Create a user named `sylvain` with password ``
    3. Grant all privileges to the user `sylvain` on the database `tasks`
3. Build and Run:
   ```bash
    mvn clean install
    mvn jetty:run
    ```
4. Access the Application
   Open your web browser and navigate to https://localhost:8443.

## Improvements

1. Ability to edit tasks can be added.
2. Add a dependency injection framework like Guice or Spring when the application grows.
3. Add ability to add/edit users and properties.
4. Add ability to paginate tasks instead of showing the full list of tasks.

