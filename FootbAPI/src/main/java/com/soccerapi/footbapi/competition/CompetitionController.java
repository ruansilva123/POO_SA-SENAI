package com.soccerapi.footbapi.competition;

import com.soccerapi.footbapi.utils.responses.errors.ErrorMessageResponse;
import com.soccerapi.footbapi.utils.responses.success.SuccessListObjectsResponse;
import com.soccerapi.footbapi.utils.responses.success.SuccessObjectAndMessageResponse;
import com.soccerapi.footbapi.utils.responses.success.SuccessObjectResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("competitions/")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<?> postCompetition(@RequestBody CompetitionDTO competitionDTO){
        try {
            CompetitionDTO competition = competitionService.createCompetition(competitionDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessObjectAndMessageResponse("Competition created successfully!", competition));
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to create competition!"));
        }
    }

    @GetMapping
    public ResponseEntity<?> getCompetitions(){
        try{
            List<CompetitionDTO> competitionDTOS = competitionService.readCompetitions();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessListObjectsResponse<>(competitionDTOS));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to list competitions!"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompetition(@PathVariable Long id){
        try{
            CompetitionDTO competitionDTO = competitionService.readCompetition(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectResponse(competitionDTO));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessageResponse(exception.getMessage()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to find competition!"));
        }
    }

    @GetMapping("/search/")
    public ResponseEntity<?> getCompetitionByName(@RequestBody String competitionName){
        try{
            List<CompetitionDTO> competitionDTOS = competitionService.searchByCompetitionName(competitionName);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessListObjectsResponse<>(competitionDTOS));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to find competition!"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompetition(@PathVariable Long id){
        try{
            competitionService.deleteCompetition(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessageResponse(exception.getMessage()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to delete competition!"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCompetition(@PathVariable Long id, @RequestBody CompetitionDTO competitionDTO){
        try{
            CompetitionDTO currentCompetition = competitionService.updateCompetition(id, competitionDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectResponse(currentCompetition));
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessageResponse(exception.getMessage()));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to delete competition!"));
        }
    }
}
