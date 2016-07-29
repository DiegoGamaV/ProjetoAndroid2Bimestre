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
        EditText senha = (EditText) findViewById(R.id.editTextSenha);
        EditText idade = (EditText) findViewById(R.id.editTextIdade);
        EditText telefone = (EditText) findViewById(R.id.editTextTelefone);
        RadioGroup rg = (RadioGroup) findViewById(R.id.sexoOpcoes);
        int op = rg.getCheckedRadioButtonId();
        CheckBox ler = (CheckBox) findViewById(R.id.checkBoxLer);
        CheckBox filmesSeries = (CheckBox) findViewById(R.id.checkBoxFilmesSeries);
        CheckBox viajar = (CheckBox) findViewById(R.id.checkBoxViajar);
        CheckBox dormir = (CheckBox) findViewById(R.id.checkBoxDormir);
        CheckBox comer = (CheckBox) findViewById(R.id.checkBoxComer);
        CheckBox outros = (CheckBox) findViewById(R.id.checkBoxOutros);

        if (nome.length() == 0 && cpf.length() == 0 && senha.length() == 0 && idade.length() == 0 && email.length() == 0 && telefone.length() == 0) {
            Toast.makeText(getApplicationContext(), "Todos os campos estão vazios", Toast.LENGTH_SHORT).show();
            vibrar();
        } else {
            if (nome.length() == 0){
                nome.setError("Campo vazio");
            }
            if (cpf.length() == 0){
                cpf.setError("Campo vazio");
            }
            else if (cpf.length() < 14){
                cpf.setError("Campo inválido");
            }
            if (email.length() == 0){
                email.setError("Campo vazio");
            }
            if (idade.length() == 0){
                idade.setError("Campo vazio");
            }
            if (telefone.length() == 0){
                telefone.setError("Campo vazio");
            }
            if (senha.length() == 0){
                senha.setError("Campo vazio");
            }
            else if (senha.length() < 6){
                senha.setError("Campo inválido");
            }
            if (url.length() == 0){
                url.setError("Campo vazio");
            }
            if((op == R.id.radioButFeminino || op == R.id.radioButMasculino) && nome.length() > 0 && cpf.length() == 14 && email.length() > 0 && senha.length() >= 6
                    && (ler.isChecked() || filmesSeries.isChecked() || viajar.isChecked() || dormir.isChecked() || comer.isChecked() || outros.isChecked()) && url.length() > 0){
                Intent intent = new Intent(this, SegundaActivity.class);
                startActivity(intent);
            }
        }
    }

    public void vibrar() {
        Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milissegundos = 100;
        rr.vibrate(milissegundos);
    }
}

