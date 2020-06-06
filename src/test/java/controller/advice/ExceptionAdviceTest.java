package controller.advice;

import com.crm.clientfieldsmanagement.controller.advice.ExceptionAdvice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionAdviceTest {

    private ExceptionAdvice advice = new ExceptionAdvice();

    @Test
    public void notFoundHandler() {
        assertEquals("Erro inesperado mensagem", advice.exceptionHandler(new Exception("mensagem")));
    }

}
