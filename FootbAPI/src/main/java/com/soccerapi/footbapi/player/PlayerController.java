package com.soccerapi.footbapi.player;

import com.soccerapi.footbapi.responses.errors.ErrorMessageResponse;
import com.soccerapi.footbapi.responses.success.SuccessListObjectsResponse;
import com.soccerapi.footbapi.responses.success.SuccessObjectAndMessageResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("players/")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<?> postPlayer(@RequestBody PlayerDTO playerDTO){
        try{
            PlayerDTO player = playerService.createPlayer(playerDTO);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new SuccessObjectAndMessageResponse(
                            "Player "+playerDTO.getNamePlayer(), player)

                    );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to create player, "+e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> getPlayers(){
        try{
            List<Player> players = playerService.readPlayers();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessListObjectsResponse<>(players));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to read players, "+e.getMessage()));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPlayer(@PathVariable Long id){
        try{
            PlayerDTO player = playerService.readPlayer(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectAndMessageResponse(
                            "Success to get player: "+player.getNamePlayer(), player));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to get player, "+e.getMessage()));
        }
    }

    @PutMapping("edit/{id}/")
    public ResponseEntity<?> putPlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO){
        try{
            PlayerDTO player = playerService.editPlayer(id, playerDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new SuccessObjectAndMessageResponse(
                            "Success to edit: "+player.getNamePlayer(), player));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessageResponse("Error to edit player, "+e.getMessage()));
        }
    }
}
