package br.com.taskcontroller.Excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> tratarErro(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of(
                        "sucesso", false,
                        "mensagem", ex.getMessage()
                ));
    }
    // 2. Trata Regras de Negócio / Sobreposição / Fim de Semana -> 400 BAD REQUEST
    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessRule(BusinessRuleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of(
                        "sucesso", false,
                        "mensagem", ex.getMessage()
                ));
    }

    // 3. (Opcional) Captura erros genéricos de código não esperados -> 500 INTERNAL SERVER ERROR
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericError(Exception ex) {
        // Dica: Logar o erro aqui para o desenvolvedor investigar
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "sucesso", false,
                        "mensagem", "Ocorreu um erro interno inesperado no servidor."
                ));
    }
}