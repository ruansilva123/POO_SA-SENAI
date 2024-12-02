package com.soccerapi.footbapi.player;

import com.soccerapi.footbapi.responses.errors.ErrorMessageResponse;
import com.soccerapi.footbapi.responses.success.SuccessObjectAndMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                    .body(new ErrorMessageResponse("Erro to create player, "+e.getMessage()));
        }
    }
}
