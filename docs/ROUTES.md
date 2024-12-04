## Rotas da API
 
Tutorial sobre as rotas e requisiões da API
 
### TEAM
 
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

---

### PLAYER
 
- **Método:** `POST`
- **Endpoint:** `/api/v1/players/`
- **Corpo da Requisição:**
    ```json
    {
      "nameTeam": "player_name",
      "team": 1
    }
    ```
- **Resposta:**
    ```json
    {
      "message": "Player player_name",
      "object": {
          "id": 1,
          "namePlayer": "player_name",
          "team": 3
      }
    }
    ```


- **Método:** `GET`
- **Endpoint:** `/api/v1/players/`
- **Resposta:**
    ```json
    {
      "objects": [
          {
              "id": 1,
              "namePlayer": "name_player"
              "team": {
                  "id": 3
                  "nameTeam": "name_team"
              }
          },
          {
              "id": 2,
              "namePlayer": "other_palyer"
              "team": {
                  "id": 5
                  "nameTeam": "other_team"
              }
          },
       ]
    }
    ```

- **Método:** `GET`
- **Endpoint:** `/api/v1/players/1`
- **Resposta:**
    ```json
    {
      "message": "Success to get player: name_palyer",
      "object": {
          "id": 3,
          "namePlayer": "team_name",
          "team": 3
      }
    }
    ```

- **Método:** `PUT`
- **Endpoint:** `/api/v1/players/edit/8/`
- **Corpo da Requisição:**
    ```json
    {
      "namePlayer": "other_name_player",
      "team": 5
    }
    ```
- **Resposta:**
    ```json
    {
      "message": "Succes to edit: other_name_player!",
      "object": {
          "id": 1,
          "namePlayer": "other_name_player",
          "team": 24
      }
    }
    ```


- **Método:** `DELETE`
- **Endpoint:** `/api/v1/players/1/`
- **Resposta:**
    ```json
    {
      "message": "Player deleted successfully!"
    }
    ```
