# Experiment with Java Spring Boot
Java Spring REST API Experiment

During this assignment
- Java 8 is used a platform for the REST API
- MySQL 14.14 Distrib 5.7.31 is used as a storage database.

There are 2 endpoints in the API \

**POST** /api/v1/user 

```json
{
"name": "{NAME}",
"age": "{AGE}"
}
```
**GET**  /api/v1/user?name={NAME}&page={PAGE_NUMBER}&count={COUNT_NUMBER}

The following database tables are used for the purposes described above:
id | INT            
--- | --- 
age | INT
name | VARCHAR(2000)

_**id**_ is an auto increment integer which is a primary key. In the context of database storage engine it would be a _unique clustered index_. It is important to note that in the scopes of _relational algebra_ and _relational model_ this attribute is an artificial and surrogate identificator. It is called surrogate because it does not describe the real-life properties of the user model and instead it is a value assigned by the storage engine. Nonetheless this approach is very well-known and used widely, because it is simple and efficient in the context of indexing and searching.

_**name**_ is a string value with a variable size and the maximal value of its size is _2000_ characters. Note that, this column has utf_8 character set. 