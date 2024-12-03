package com.soccerapi.footbapi.match;

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
@RequestMapping("matches/")
public class MatchController {

    @Autowired
    MatchService matchService;

    @PostMapping
    public ResponseEntity<?> postMatch(@RequestBody MatchDTO matchDTO){
        try{
            MatchDTO match = matchService.createMatch(matchDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessObjectAndMessageResponse(
                            "Match created successfully!", match)
                    );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to create player, "+e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> getMatches(){
        try{
            List<Match> players = matchService.readMatches();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessListObjectsResponse<>(players));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to read matches, "+e.getMessage()));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMatch(@PathVariable Long id){
        try{
            MatchDTO match = matchService.readMatch(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectAndMessageResponse(
                            "Success to get match! ", match));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to get match, "+e.getMessage()));
        }
    }

    @PutMapping("edit/{id}/")
    public ResponseEntity<?> putMatch(@PathVariable Long id, @RequestBody MatchDTO matchDTO){
        try{
            MatchDTO match = matchService.editMatch(id, matchDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectAndMessageResponse(
                            "Success to edit!", match));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to edit match, "+e.getMessage()));
        }
    }

    @DeleteMapping("{id}/")
    public ResponseEntity<?> deleteMatch(@PathVariable Long id){
        try{
            matchService.deleteMatch(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessMessageResponse("Match deleted successfully!"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to delete match, "+e.getMessage()));
        }
    }
}
