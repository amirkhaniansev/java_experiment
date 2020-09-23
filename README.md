# Experiment with Java Spring Boot
## Brief Description

During this assignment
- Java 8 is used a platform for the REST API
- MySQL 14.14 Distrib 5.7.31 is used as a storage database.

There are 2 endpoints in the API 

**POST** /api/v1/user 

```json
{
    "name": "{NAME}",
    "age": "{AGE}"
}
```
**GET**  /api/v1/user?name={NAME}&page={PAGE_NUMBER}&count={COUNT_NUMBER} \
_**PAGE_NUMBER**_ and _**COUNT**_ parameters are optional. In case of not providing the values, the API will return the first user with the given _**NAME**_ parameter if such a record exists. This parameter is _mandatory_.
```json
[
    {
        "id":  1, 
        "name": "Matt", 
        "age": 45
    }, 
    {
        "id": 2, 
        "name": "Matt", 
        "age": 68
    }
]
```

The following database tables are used for the purposes described above:
id | INT            
--- | --- 
age | INT
name | VARCHAR(2000)

_**id**_ is an auto increment integer which is a primary key. In the context of database storage engine it would be a _unique clustered index_. It is important to note that in the scopes of _relational algebra_ and _relational model_ this attribute is an artificial and surrogate identificator. It is called surrogate because it does not describe the real-life properties of the user model and instead it is a value assigned by the storage engine. Nonetheless this approach is very well-known and used widely, because it is simple and efficient in the context of indexing and searching.

_**age**_ is an integer. In the context of optimization and more efficient occupation of database memory, it could hypothetically be useful to use structures with a smaller size like 2-bytes or even 1-byte integers. In addition to that this column does not need to be a signed one, because the concept of age does not include the idea of sign.

_**name**_ is a string value with a variable size and the maximal value of its size is _255_ characters. Note that, this column has utf_8 character set. 

## How to run
This API is tested on **Ubuntu 18**  machine however the same thing can be done on other POSIX-based operating systems, and on Windows and MacOS machines as well. \
To be able to run you need to install at least Java 8, Spring Boot, MySQL and maven. Note that gradle can theoretically used as well. \
For maven lovers:
- Go to **./users_api**
- Type **mvn spring-boot:run** and hit _Enter_.

## Some notes
The initial task was to have just an API for returning all the users, nevertheless I expanded the idea and added the concept of pagination as returning all the users is not very practical assuming that the number of users is probably going to increase in a very fast fashion.