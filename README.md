# SpringBootUserTestApi

This is a demo java api server implementing basic CRUD operations with SpringBoot.
Default port is 8080 and the server runs intially with an empty MockDB and data persistence is only for the livetime of the server.

Subsequently the project would be refactored with JPA to support a MySQL database.

## Endpoints
----------------------------------------------------------------------------------

## GET: /users
returns list of all users (returns an empty list at first).

## GET: /user/**{id}**
returns a user with the particular id if the user exists

## POST: /user/search
searches the MockDB for user with similar userName to the search text

| BODY PARAMS | DESCRIPTION |
| ------------- |:-------------:|
| text     |  the search keyword |

## POST: /user
adds a new user

| BODY PARAMS | DESCRIPTION |
| ------------- |:-------------:|
| id       |  the search keyword |
| userName | name of the user |
| age      | the user age |
| gender   | the user gender |

## PUT: /user/**{id}**
updates the details of an existing user

| BODY PARAMS | DESCRIPTION |
| ------------- |:-------------:|
| id       |  the search keyword |
| userName | name of the user |
| age      | the user age |
| gender   | the user gender |

## DELETE: /user/**{id}**
deletes a user entirely



