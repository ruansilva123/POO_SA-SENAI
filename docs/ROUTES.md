## Rotas da API
 
Tutorial sobre as rotas e requisiões da API
 
### Team
 
- **Método:** `POST`
- **Endpoint:** `/api/v1/teams/`
- **Corpo da Requisição:**
    ```json
    {
      "nameTeam": "team_name"
    }
    ```
- **Resposta:**
    ```json
    {
      "message": "Team created successfully!",
      "object": {
          "id": 1,
          "nameTeam": "team_name"
      }
    }
    ```


- **Método:** `GET`
- **Endpoint:** `/api/v1/teams/`
- **Resposta:**
    ```json
    {
      "objects": [
          {
              "id": 1,
              "nameTeam": "team_name"
          },
          {
              "id": 2,
              "nameTeam": "other_team"
          }
       ]
    }
    ```

- **Método:** `GET`
- **Endpoint:** `/api/v1/teams/1`
- **Resposta:**
    ```json
    {
      "message": "Success to get team_name",
      "object": {
          "id": 3,
          "nameTeam": "team_name"
      }
    }
    ```

- **Método:** `PUT`
- **Endpoint:** `/api/v1/teams/edit/8/`
- **Corpo da Requisição:**
    ```json
    {
      "nameTeam": "other_name_team"
    }
    ```
- **Resposta:**
    ```json
    {
      "message": "Team edited successfully!",
      "object": {
          "id": 1,
          "nameTeam": "other_name_team"
      }
    }
    ```


- **Método:** `DELETE`
- **Endpoint:** `/api/v1/teams/1/`
- **Resposta:**
    ```json
    {
      "message": "Team deleted successfully!"
    }
    ```