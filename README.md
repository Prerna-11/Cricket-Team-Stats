# Cricket-Team-Stats

## Overview

This project is a Cricket Team Stats that allows users to manage players, matches, and related operations.

## Technologies Used

- Java
- Spring Boot
- HSQLDB (In-Memory Database)

## How to Run

1. Clone the repository:

```bash
git https://github.com/Prerna-11/Cricket-Team-Stats.git
cd cricket-team-stats



### Instructions

- `Player.java`: `Player` class should contain the following attributes.

    | Attribute    | Type   |
    | ------------ | ------ |
    | Id           | int    |
    | name         | String |
    | dateOfBirth  | Date   |
    | country      | String |
    | average      | double |
    | match        | Match  |

- `Match.java`: `Match` class should contain 

    | Attribute    | Type   |
    | ------------ | ------ |
    | id           | Long   |
    | score        | int    |
    | stadium      | String |
   

Project Structure
com.project.cricketteam.controller: Contains REST controllers.
com.project.cricketteam.entity: Defines JPA entities (e.g., Players, Match).
com.project.cricketteam.repository: Provides Spring Data JPA repositories.
com.project.cricketteam.service: Implements business logic.

Implement the following APIs.

### API 1

#### Path: `api/players`

#### Method: `POST`

#### Description:

Creates a new player in the `team`. The `playerId` is auto-incremented.

#### Response

```
[
    {
        "id": 1,
        "name": "Virat Kohli",
        "dateOfBirth": "1988-12-05",
        "country": "India",
        "average": "53.1",
        "match": "15"
    },
   ...
]
```

### API 2

#### Path: `api/players/all`

#### Method: `GET`

#### Description:

Returns the list of all players.

#### Request

```
[
  {
    "id": 1,
    "name": "Virat Kohli",
    "dateOfBirth": "1988-12-05",
    "country": "India",
    "average": "53.1",
    "match": "15"
  }
]
```

#### Response

```
{
    "id": 2,
    "name": "Steve Smith",
    "dateOfBirth": "1989-06-02",
    "country": "Australia",
    "average": 43.5,
    "match" : "11"
}
```

### API 3

#### Path: `api/players/{id}`

#### Method: `GET`

#### Description:

Returns a player based on the `playerId`. If the given `playerId` is not found in the `team`, 
raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.


#### Success Response

```
{
    "id": 2,
    "name": "Steve Smith",
    "dateOfBirth": "1989-06-02",
    "country": "Australia",
    "average": 43.5,
    "match" : "11"
}
```

### API 4

#### Path: `/players/{playerId}`

#### Method: `PUT`

#### Description:

Updates the details of a player in the team based on the `playerId`. 
If the given `playerId` is not found in the `team`, raise `ResponseStatusException` 
with `HttpStatus.NOT_FOUND`.

#### Request

```
{
    "id": 2,
    "name": "Steve Smith",
    "dateOfBirth": "1989-06-02",
    "country": "Australia",
    "average": 44.5,
    "match" : "11"
}
```

#### Success Response

```
{
    "id": 2,
    "name": "Steve Smith",
    "dateOfBirth": "1989-06-02",
    "country": "Australia",
    "average": 43.5,
    "match" : "11"
}
```

### API 5

#### Path: `api/players/{playerId}`

#### Method: `DELETE`

#### Description:

Deletes a player from the team  based on the `playerId`. If the given `playerId` is not found in the `team`,
raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

Rest Of the APIs are :
1. Get Players with Average Greater Than:
  Method: GET
  URL: http://localhost:8080/api/players/averageGreaterThan/{average}

2. Get Players by Country:
  Method: GET
  URL: http://localhost:8080/api/players/country/{country}

3. Get Players Sorted by Average:
  Method: GET
  URL: http://localhost:8080/api/players/sortedByAverage/{average}

4. Get All Players:
  Method: GET
  URL: http://localhost:8080/api/players/all

5. Create Match:
  Method: POST
  URL: http://localhost:8080/api/matches

6. Get Match by ID:
  Method: GET
  URL: http://localhost:8080/api/matches/{id}

7. Get All Matches:
  Method: GET
  URL: http://localhost:8080/api/matches/all

8. Get Players in a Specific Match:
  Method: GET
  URL: http://localhost:8080/api/players/byMatch/{matchId}


```
> After: | mvn spring-boot:run | in Terminal to start poject.
> Go to the Postman website for CRUD Operations & (Provide the api link). 
> For POST/PUT Operations in POSTMAN check for (body > raw > json).
> <a href="https://www.postman.com/"> POSTMAN </a>
```
 
