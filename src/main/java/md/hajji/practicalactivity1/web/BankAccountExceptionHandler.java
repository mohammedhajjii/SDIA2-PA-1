package md.hajji.practicalactivity1.web;

import md.hajji.practicalactivity1.exceptions.NegativeBalanceException;
import md.hajji.practicalactivity1.exceptions.NullFieldException;
import md.hajji.practicalactivity1.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankAccountExceptionHandler {

    @ExceptionHandler({NegativeBalanceException.class, NullFieldException.class})
    public ResponseEntity<?> handlerNegativeBalanceAndNullFieldException
            (final RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> handleResourceNotFoundException
            (final ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
