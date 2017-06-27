/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.parse.starter.R;

import java.util.List;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      /* Cadastro de Usuário */
      /*ParseUser usuario = new ParseUser();
      usuario.setUsername( "carlos" );
      usuario.setPassword("123456");
      usuario.setEmail( "carlos@gmail.com" );

      //Cadastrar
      usuario.signUpInBackground(new SignUpCallback() {
          @Override
          public void done(ParseException e) {

              if( e == null ){//deu certo

                  Log.i("cadastroUsuario","Sucesso ao cadatrar usuario");

              }else{
                  Log.i("cadastroUsuario", "Erro ao cadastrar usuario "+e.getMessage());
              }

          }
      });*/
      //Deslogar
      //ParseUser.logOut();


      /***
       * Verificar usuário logado
       */
/*
      if( ParseUser.getCurrentUser() != null ){//logado

          Log.i("loginUsuario", "Usuario está logado ");


      }else{//não está logado

          Log.i("loginUsuario", "Usuario não está logado ");

      }*/

       /*
       Fazer login do uusario
        */
       ParseUser.logInInBackground("carlos", "123456", new LogInCallback() {
         @Override
         public void done(ParseUser user, ParseException e) {

             if( e ==  null ){//deu certo
               Log.i("verificaLoginUsuario", "Login realizado com sucesso ");

             }else{//nao deu certo
               Log.i("verificaLoginUsuario", "Erro ao fazer login do usuario. "+e.getMessage());
             }

         }
       });


 /*   ParseObject pontuacao = new ParseObject("Pontuacao");
    pontuacao.put("nome", "Maria");
    pontuacao.put("pontos", 150);
    pontuacao.saveInBackground(new SaveCallback() {
        @Override
        public void done(ParseException e) {
            if( e == null ){ // não temos erros, pois o objeto está nulo
                Log.i("salvarPontos", "Dados salvos com sucesso");

            }else{
                Log.i("salvarPontos", "Erro ao salvar dados");
            }
        }
    });*/
  //  ParseAnalytics.trackAppOpenedInBackground(getIntent());

      /*ParseQuery<ParseObject> consulta = ParseQuery.getQuery( "Pontuacao" );
      consulta.getInBackground("plzSqneXsz", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {

              if( e == null ){ // não temos erros, pois o objeto está nulo
                  object.put("pontos", 1200);
                  object.saveInBackground();

              }else{
                  Log.i("consultaObjeto", "Erro ao consultar objeto");
              }

          }
      });*/


    // ParseQuery<ParseObject> filtro = ParseQuery.getQuery( "Pontuacao" );

      //Aplicando filtros na listagem de objetos
      //filtro.whereGreaterThan("pontos",800);
      //filtro.whereGreaterThanOrEqualTo("pontos",800);
      //filtro.whereLessThan("pontos",500);
      //filtro.whereEndsWith("nome","ia");
      //filtro.whereStartsWith("nome","Ca");
      //filtro.addAscendingOrder("pontos");
      //filtro.addDescendingOrder("pontos");
      /*filtro.setLimit(1);


      //Listar os dados
      filtro.findInBackground(new FindCallback<ParseObject>() {
          @Override
          public void done(List<ParseObject> objects, ParseException e) {

              if( e == null ){ //efetua a listagem sem erros

                  //Log.i("ListarDados", "Sucesso ao listar os objetos - "+objects.size());
                  for( ParseObject object : objects ){

                      Log.i("ListarDados", "objetos - Nome: "+object.get("nome") + " ponto: "+object.get("pontos"));

                  }

              }else{
                  Log.i("Listardados", "Erro ao listar os objetos - "+e.getMessage());

              }

          }
      });*/


  }
/*
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }*/
}
