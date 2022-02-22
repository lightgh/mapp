package com.mediaapp.mapp.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediaapp.mapp.model.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<?> playlistNotFound(PlaylistNotFoundException ex) {
        return ResponseEntity.badRequest().body(new ResponseStatusError(ErrorCodes.PLAYLIST_NOT_FOUND.code(), ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> songNotFound(SongNotFoundException ex) {
        return ResponseEntity.badRequest().body(new ResponseStatusError(ErrorCodes.SONG_NOT_FOUND.code(), ex.getMessage()));
    }

}

@Data
@AllArgsConstructor
class ResponseStatusError {

    @JsonProperty("status_code")
    private int status;

    @JsonProperty("status_message")
    private String message;

}

