package br.com.api.ysw.exception;

public class ErroAutenticacao extends RuntimeException {

    public ErroAutenticacao(String mensagem){
        super(mensagem);
    }
}
