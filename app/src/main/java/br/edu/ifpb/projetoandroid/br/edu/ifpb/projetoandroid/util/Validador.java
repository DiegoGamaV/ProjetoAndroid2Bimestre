package br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diego A. Gama on 29/07/2016.
 */
public class Validador {

    private boolean checarPadraoCPF(String cpf){
        Pattern padrao =  Pattern.compile("^([0-9]{3}\\.?){3}-?[0-9]{2}$");
        Matcher analizador = padrao.matcher(cpf);

        return analizador.matches();
    }

    private boolean checarNumeroCPF(String cpf){
        int n = 10;
        String cpfTratado = cpf.replaceAll(".","").replace("-","");

        int soma = 0;
        for(char c : cpfTratado.toCharArray()){
           soma += Integer.parseInt(Character.toString(c)) * n--;
            if (n == 1){
                break;
            }
        }
        int penultimoNumeroCpf = Integer.parseInt(cpf.substring(cpf.length() - 2, cpf.length() - 1));

        if (soma%11 != penultimoNumeroCpf){
            return false;
        }

        n = 11;
        int soma2 = 0;
        for(char c : cpfTratado.toCharArray()){
            soma2 += Integer.parseInt(Character.toString(c)) * n--;
            if (n == 2){
                soma2 += penultimoNumeroCpf * n;
                n--;
                break;
            }
        }
        int ultimoNumeroCpf = Integer.parseInt(cpf.substring(cpf.length() - 1, cpf.length() - 0));

        if (soma2%11 != ultimoNumeroCpf){
            return false;
        }

        return true;
    }

    public boolean validarCPF(String cpf){
        //etapa 1
        if (checarNumeroCPF(cpf) && checarPadraoCPF(cpf)){
            return true;
        }
        //etapa 2
        return false;
    }
}
