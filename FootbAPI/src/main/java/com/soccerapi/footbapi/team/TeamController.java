package com.soccerapi.footbapi.team;

import com.soccerapi.footbapi.utils.responses.errors.ErrorMessageResponse;
import com.soccerapi.footbapi.utils.responses.success.SuccessListObjectsResponse;
import com.soccerapi.footbapi.utils.responses.success.SuccessMessageResponse;
import com.soccerapi.footbapi.utils.responses.success.SuccessObjectAndMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teams/")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public ResponseEntity<?> postTeam(@RequestBody TeamDTO teamDTO){
        try{
            TeamDTO team = teamService.createTeam(teamDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessObjectAndMessageResponse("Team created successfully!", team));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to create team!"));
        }
    }

    @GetMapping
    public ResponseEntity<?> getTeams(){
        try{
            List<TeamDTO> teamDTO = teamService.readTeams();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessListObjectsResponse<>(teamDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Erro to list teams!"));
        }
    }

    @GetMapping("search/")
    public ResponseEntity<?> searchTeamByName(@RequestBody String nameTeam){
        try{
            System.out.println("Time: "+nameTeam);
            List<TeamDTO> teams = teamService.readTeamByName(nameTeam);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessListObjectsResponse<>(teams));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to get this team, "+e.getMessage()));
        }
    }

    @PutMapping("edit/{id}/")
    public ResponseEntity<?> putTeam(@PathVariable Long id, @RequestBody TeamDTO teamDTO){
        try{
            TeamDTO team = teamService.editTeam(id, teamDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectAndMessageResponse("Team edited successfully!", team));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to edit this team, "+e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id){
        try{
            teamService.deleteTeam(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessMessageResponse("Team delete successfully!"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to delete this team, "+e.getMessage()));
        }
    }

}
