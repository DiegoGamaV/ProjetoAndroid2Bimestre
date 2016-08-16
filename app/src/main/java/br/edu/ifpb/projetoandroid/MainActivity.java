package br.edu.ifpb.projetoandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;
import android.app.AlertDialog.Builder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util.ValidadorCPF;
import br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util.ValidadorEmail;
import br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util.ValidadorTelefone;
import br.edu.ifpb.projetoandroid.br.edu.ifpb.projetoandroid.util.ValidadorURL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {
        EditText url = (EditText) findViewById(R.id.editTextURL);
        EditText nome = (EditText) findViewById(R.id.editTextNome);
        EditText cpf = (EditText) findViewById(R.id.editTextCPF);
        EditText email = (EditText) findViewById(R.id.editTextEmail);
        String emailValidar= email.getText().toString();
        EditText senha = (EditText) findViewById(R.id.editTextSenha);
        EditText idade = (EditText) findViewById(R.id.editTextIdade);
        EditText telefone = (EditText) findViewById(R.id.editTextTelefone);
        String telefoneValidar = telefone.getText().toString();
        RadioGroup rg = (RadioGroup) findViewById(R.id.sexoOpcoes);
        int op = rg.getCheckedRadioButtonId();
        CheckBox ler = (CheckBox) findViewById(R.id.checkBoxLer);
        CheckBox filmesSeries = (CheckBox) findViewById(R.id.checkBoxFilmesSeries);
        CheckBox viajar = (CheckBox) findViewById(R.id.checkBoxViajar);
        CheckBox dormir = (CheckBox) findViewById(R.id.checkBoxDormir);
        CheckBox comer = (CheckBox) findViewById(R.id.checkBoxComer);
        CheckBox outros = (CheckBox) findViewById(R.id.checkBoxOutros);
        ValidadorEmail validarEmail = new ValidadorEmail();
        ValidadorTelefone validarTelefone = new ValidadorTelefone();
        ValidadorCPF validarCPF = new ValidadorCPF();
        String cpfValidar = cpf.getText().toString();
        String urlValidar = url.getText().toString();
        ValidadorURL validadorURL = new ValidadorURL();
        if (nome.length() == 0 && cpf.length() == 0 && senha.length() == 0 && idade.length() == 0 && email.length() == 0 && telefone.length() == 0 && url.length() == 0) {
            Toast.makeText(getApplicationContext(), "Todos os campos estão vazios", Toast.LENGTH_SHORT).show();
            vibrar();
        } else {
            if (nome.length() == 0){
                nome.setError("Campo vazio");
            }
            if (cpf.length() == 0){
                cpf.setError("Campo vazio");
            }
            else if(!(validarCPF.validadorCPF(cpfValidar))){
                cpf.setError("Campo inválido");
            }
            else if(!(validarEmail.isValidEmail(emailValidar))){
                email.setError("Email Inválido");
            }
            if (idade.length() == 0){
                idade.setError("Campo vazio");
            }
            if (telefone.length() == 0){
                telefone.setError("Campo vazio");
            }
            else if (!(validarTelefone.TelefoneValido(telefoneValidar))){
                telefone.setError("Telefone inválido");
            }
            if (senha.length() == 0){
                senha.setError("Campo vazio");
            }
            else if (senha.length() < 6){
                senha.setError("Senha inválida");
            }
            if (url.length() == 0){
                url.setError("Campo vazio");
            }
            else if(!(validadorURL.isValidURL(urlValidar))){
                url.setError("Campo inválido");
            }
            if((op == R.id.radioButFeminino || op == R.id.radioButMasculino) && nome.length() > 0 && cpf.length() == 11 && email.length() > 0 && senha.length() >= 6
                    && (ler.isChecked() || filmesSeries.isChecked() || viajar.isChecked() || dormir.isChecked() || comer.isChecked() || outros.isChecked()) && url.length() > 0){
                if (validarEmail.isValidEmail(emailValidar) && validarCPF.validadorCPF(cpfValidar)
                        && validarTelefone.TelefoneValido(telefoneValidar) && validadorURL.isValidURL(urlValidar)){
                    Intent intent = new Intent(this, SegundaActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Dados Inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void vibrar() {
        Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milissegundos = 100;
        rr.vibrate(milissegundos);
    }
}