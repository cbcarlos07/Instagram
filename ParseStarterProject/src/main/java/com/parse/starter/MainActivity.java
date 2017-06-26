/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ParseObject pontuacao = new ParseObject("Pontuacao");
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
    });
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
