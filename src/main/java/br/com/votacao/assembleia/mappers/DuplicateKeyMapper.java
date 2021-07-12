package br.com.votacao.assembleia.mappers;

import br.com.votacao.assembleia.modelo.ErrorInfo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class DuplicateKeyMapper extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateKeyException.class)
    private @ResponseBody ErrorInfo handleConflict(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(HttpStatus.CONFLICT.value(), ex.getMessage());
    }

}
