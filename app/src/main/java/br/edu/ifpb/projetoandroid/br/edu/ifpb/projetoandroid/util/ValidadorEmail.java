package br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mateus on 30/07/2016.
 */
public class ValidadorEmail {
    public boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }
}
