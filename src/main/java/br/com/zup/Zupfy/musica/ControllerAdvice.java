package br.com.zup.Zupfy.musica;

import br.com.zup.Zupfy.musica.exceptions.MensagemDeErro;
import br.com.zup.Zupfy.musica.exceptions.MusicaNaoEcontradaExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private List<MensagemDeErro> tratarExcessaoDeValidacao(MethodArgumentNotValidException exception) {
        List<MensagemDeErro> erros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemDeErro mensagemErro = new MensagemDeErro(fieldError.getDefaultMessage());
            erros.add(mensagemErro);
        }

      return erros;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity enumInvalidoException(HttpMessageNotReadableException excecao) {
        return ResponseEntity.status(422).build();
    }
}
