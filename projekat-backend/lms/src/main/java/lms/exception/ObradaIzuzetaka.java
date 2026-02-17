package lms.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ObradaIzuzetaka {
	
	// 1. Hvatanje greške kada entitet nije pronađen (404 Not Found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<OdgovrNaGresku> handleEntityNotFound(EntityNotFoundException ex) {
    	OdgovrNaGresku error = new OdgovrNaGresku(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // 2. Hvatanje svih ostalih neočekivanih grešaka (500 Internal Server Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<OdgovrNaGresku> handleGlobalException(Exception ex) {
    	OdgovrNaGresku error = new OdgovrNaGresku(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Došlo je do neočekivane greške na serveru."
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
