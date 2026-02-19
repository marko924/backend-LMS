package lms.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
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

 // 2. NOVO: Hvatanje greške "Zabranjen pristup" (403 Forbidden)
    // Ovo se aktivira kada @PreAuthorize vrati 'false'
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<OdgovrNaGresku> handleAccessDeniedException(AccessDeniedException ex) {
        OdgovrNaGresku error = new OdgovrNaGresku(
                HttpStatus.FORBIDDEN.value(),
                "Forbidden",
                "Nemate privilegije za pristup ovom resursu."
        );
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    // 3. Hvatanje svih ostalih neočekivanih grešaka (500 Internal Server Error)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<OdgovrNaGresku> handleGlobalException(Exception ex) {
        // Logovanje stvarne greške u konzoli servera da bi ti mogao da je popraviš
        ex.printStackTrace(); 
        
        OdgovrNaGresku error = new OdgovrNaGresku(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Došlo je do neočekivane greške na serveru: " + ex.getLocalizedMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
