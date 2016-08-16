package br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Rayla on 15/08/2016.
 */
public class ValidadorURL {
    public boolean isValidURL(String url) {
        URL u = null;

        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }

        try {
            u.toURI();
        } catch (URISyntaxException e) {
            return false;
        }

        return true;
    }
}