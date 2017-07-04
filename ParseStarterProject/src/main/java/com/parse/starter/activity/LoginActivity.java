package com.parse.starter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.util.ParseErros;

public class LoginActivity extends AppCompatActivity {
    private EditText editLoginUsuario;
    private EditText editLoginSenha;
    private Button   botaoLogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editLoginUsuario = (EditText) findViewById( R.id.edit_login_usuario );
        editLoginSenha   = (EditText) findViewById( R.id.edit_login_senha );
        botaoLogar       = (Button)   findViewById( R.id.button_logar );

        //ParseUser.logOut();

        //Verificar se o usuário está logaddo
        verificarUsuarioLogado();

        //adicionar evento de click no botao logar
        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editLoginUsuario.getText().toString();
                String senha   = editLoginSenha.getText().toString();

                verificarLogin( usuario, senha );
            }
        });
    }

    private void verificarLogin(String usuario, String senha){

        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if( e == null ){ //sucesso ao login
                    Toast.makeText( LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT ).show();
                    abrirAreaPrincipal();
                }else{//erro ao logar
                    ParseErros erros = new ParseErros();
                    String erro = erros.getErro(e.getCode());
                    Toast.makeText( LoginActivity.this, erro
                                    , Toast.LENGTH_SHORT ).show();
                }
            }
        });

    }

    public void abrirCadastroUsuario(View view){

        Intent intent = new Intent( LoginActivity.this, CadastroActivity.class );
        startActivity( intent );


    }

    private void verificarUsuarioLogado(){

        if(ParseUser.getCurrentUser() != null ) {
            //Enviar Usuario ára a tela principal
            abrirAreaPrincipal();

        }

    }

    private void abrirAreaPrincipal(){
        Intent intent = new Intent( LoginActivity.this, MainActivity.class );
        startActivity( intent );
        finish();

    }
}
