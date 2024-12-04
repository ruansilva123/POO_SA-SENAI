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

---

### MATCH
 
- **Método:** `POST`
- **Endpoint:** `/api/v1/matches/`
- **Corpo da Requisição:**
    ```json
    {
      "dateMatch": "2024-12-03",
      "homeTeamGoals": 2,
      "awayTeamGoals": 1,
      "competition": 2,
      "homeTeam": 5,
      "awayTeam": 6
    }
    ```
- **Resposta:**
    ```json
    {
      "message": "Match created successfully!",
      "object": {
          "id": 1,
          "dateMatch": "2024-12-03T00:00:00.000+00:00",
          "homeTeamGols": 2,
          "awayTeamGols": 1,
          "competition": 2,
          "homeTeam": 5,
          "awayTeam": 6
      }
    }
    ```


- **Método:** `GET`
- **Endpoint:** `/api/v1/matches/`
- **Resposta:**
    ```json
    {
      "objects": [
        {
            "id": 1,
            "dateMatch": "2024-12-03T00:00:00.000+00:00",
            "homeTeamGols": 2,
            "awayTeamGols": 1,
            "competition": {
                "idCompetition": 1,
                "nameCompetition": "name_competition"
            },
            "homeTeam": {
                "id": 1,
                "nameTeam": "name_team"
            },
            "awayTeam": {
                "id": 2,
                "nameTeam": "other_team"
            }
        },
        {
            "id": 2,
            "dateMatch": "2024-12-03T00:00:00.000+00:00",
            "homeTeamGols": 3,
            "awayTeamGols": 3,
            "competition": {
                "idCompetition": 1,
                "nameCompetition": "name_competition"
            },
            "homeTeam": {
                "id": 4,
                "nameTeam": "name_team"
            },
            "awayTeam": {
                "id": 6,
                "nameTeam": "other_team"
            }
        }
      ]
    }
    ```

- **Método:** `GET`
- **Endpoint:** `/api/v1/matches/1`
- **Resposta:**
    ```json
    {
      "message": "Success to get match!",
      "object": {
          "id": 1,
          "dateMatch": "2024-12-03T00:00:00.000+00:00",
          "homeTeamGols": 2,
          "awayTeamGols": 1,
          "competition": 2,
          "homeTeam": 5,
          "awayTeam": 6
      }
    }
    ```

- **Método:** `PUT`
- **Endpoint:** `/api/v1/matches/1`
- **Corpo da Requisição:**
    ```json
    {
      "dateMatch": "2024-12-03",
      "homeTeamGoals": 2,
      "awayTeamGoals": 1,
      "competition": 2,
      "homeTeam": 1,
      "awayTeam": 2
    }
    ```
- **Resposta:**
    ```json
    {
      "message": "Success to edit!",
      "object": {
          "id": 1,
          "dateMatch": "2024-12-03T00:00:00.000+00:00",
          "homeTeamGols": 2,
          "awayTeamGols": 1,
          "competition": 2,
          "homeTeam": 3,
          "awayTeam": 10
      }
    }
    ```


- **Método:** `DELETE`
- **Endpoint:** `/api/v1/matches/1/`
- **Resposta:**
    ```json
    {
      "message": "Match deleted successfully!"
    }
    ```
