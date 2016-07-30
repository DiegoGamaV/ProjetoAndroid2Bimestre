package br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util;

/**
 * Created by Mateus on 30/07/2016.
 */
public class ValidadorTelefone {
    public boolean TelefoneValido(String numeroTelefone) {
        return numeroTelefone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}") ||
                numeroTelefone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
    }
}
