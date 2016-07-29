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

public class MainActivity extends AppCompatActivity {
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {
        EditText nome = (EditText) findViewById(R.id.editTextNome);
        EditText idade = (EditText) findViewById(R.id.editTextIdade);
        EditText url = (EditText) findViewById(R.id.editTextURL);
        EditText telefone = (EditText) findViewById(R.id.editTextTelefone);
        EditText cpf = (EditText) findViewById(R.id.editTextCPF);
        EditText email = (EditText) findViewById(R.id.editTextEmail);
        RadioGroup rg = (RadioGroup) findViewById(R.id.generoOpcoes);
        int op = rg.getCheckedRadioButtonId();

// verificação de campos vazios
        if ((nome.getText().length() == 0) && (cpf.getText().length() == 0) && (email.getText().length() == 0) && (idade.getText().length() == 0)) {
            Toast.makeText(getApplicationContext(), "Todos os campos estão vazios", Toast.LENGTH_SHORT).show();
            vibrar();
        }
// verificação de campo nome
        if (nome.getText().length() == 0) {
            nome.setError("Campo vazio");
        } else if (nome.getText().length() < 5) {
            nome.setError("Minimo 5 letras");

        }
// verificação de campo email
        if (email.getText().length() == 0) {
            email.setError("Campo vazio");
        } else if (email.getText().length() < 8) {
            email.setError("Minimo 8 digitos");
        }
//verificação de campo cpf
        if (cpf.getText().length() == 0) {
            cpf.setError("Campo vazio");
        } else if (cpf.getText().length() < 11) {
            cpf.setError("Minimo 11 digitos");

        }
//verificação de campo idade
        if (idade.getText().length() == 0) {
            idade.setError("Campo vazio");
        }
//verificação de campo telefone
        if (telefone.getText().length() == 0) {
            telefone.setError("Campo vazio");
        }
//verificação de campo url
        if (url.getText().length() == 0) {
            url.setError("Campo vazio");
        }


    }

    //verificação de idade

    // String idadeString = idade.toString();
    // int idadeInt=Integer.parseInt(idadeString);


   /* if (idade == 0)    {
        idade.setError("Idade não aceita");
    }
    */

// Vibrar
          public void vibrar() {
              Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
              long milissegundos = 100;
              rr.vibrate(milissegundos);
          }


}

