/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.parse.starter.R;
import com.parse.starter.adapter.TabsAdapter;
import com.parse.starter.fragments.HomeFragment;
import com.parse.starter.util.SlidingTabLayout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbarPrincipal;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      //configura toolbar
      toolbarPrincipal = (Toolbar) findViewById( R.id.toolbar_principal );
      toolbarPrincipal.setLogo( R.drawable.instagramlogo );
      setSupportActionBar( toolbarPrincipal );

      //Configura abas
      slidingTabLayout = (SlidingTabLayout) findViewById( R.id.sliding_tab_main );
      viewPager = (ViewPager) findViewById( R.id.view_page_main );

      //configura adapter
      TabsAdapter tabsAdapter = new TabsAdapter( getSupportFragmentManager(), this );
      viewPager.setAdapter( tabsAdapter );
      //https://github.com/google/iosched/blob/master/android/src/main/java/com/google/samples/apps/iosched/ui/widget/SlidingTabLayout.java
      slidingTabLayout.setCustomTabView( R.layout.tab_view, R.id.text_item_tab );
      slidingTabLayout.setDistributeEvenly( true );
      slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor( this, R.color.cinzaEscuro ));
      slidingTabLayout.setViewPager( viewPager );



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
  /*     ParseUser.logInInBackground("carlos", "123456", new LogInCallback() {
         @Override
         public void done(ParseUser user, ParseException e) {

             if( e ==  null ){//deu certo
               Log.i("verificaLoginUsuario", "Login realizado com sucesso ");

             }else{//nao deu certo
               Log.i("verificaLoginUsuario", "Erro ao fazer login do usuario. "+e.getMessage());
             }

         }
       });*/


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_main, menu );
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ){

            case R.id.action_sair:
                deslogarUsuario();
                return true;
            case R.id.action_configuracoes:
                return true;
            case R.id.action_compartilhar:
                compartilharFoto();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void compartilharFoto(){

        Intent intent = new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
        startActivityForResult( intent, 1 );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Log.i("onActivityResult", "onActivityResult");
        //Testar processo de retorno dos dados
        if( requestCode == 1 && resultCode == RESULT_OK && data != null){

            //recuperar loclal do recurso
            Uri localImagemSelecionada = data.getData();

            //recupera a imagem do local que foi selecionada
            try {
                Bitmap imagem = MediaStore.Images.Media.getBitmap( getContentResolver(), localImagemSelecionada );

                //comprimir no formato PNG
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                imagem.compress( Bitmap.CompressFormat.PNG, 75,  stream );

                //Cria um array de bytes da imagem
                byte[] byteArray = stream.toByteArray();

                //Criar um arquivo com formato próprio do parse
                SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmaaaaahhmmss");
                String nomeImagem = dateFormat.format( new Date() );
                ParseFile arquivoParse = new ParseFile( nomeImagem+"imagem.png", byteArray );

                //Monta objeto para salvar no parse
                ParseObject parseObject = new ParseObject( "Imagem" );
                parseObject.put( "username", ParseUser.getCurrentUser().getUsername() );
                parseObject.put( "imagem", arquivoParse);

                //salvar os dados
                parseObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {

                        if( e == null ){

                            Toast.makeText( getApplicationContext(), "Sua imagem foi postada!", Toast.LENGTH_SHORT ).show();
                           // Log.i("Foto","Sua imagem foi postada!");
                            //Atualizar a listagem de Itens do Fragmento HomeFragment
                            TabsAdapter adapterNovo = ( TabsAdapter ) viewPager.getAdapter();
                            HomeFragment homeFragmentNovo = (HomeFragment) adapterNovo.getFragment( 0 );
                            homeFragmentNovo.atualizaPostagens();

                        }else{

                            Toast.makeText( getApplicationContext(), "Erro ao postar sua imagem - Tente novamente",
                                            Toast.LENGTH_SHORT  ).show();
                           // Log.i("Foto","Erro ao postar sua imagem - Tente novamente");


                        }

                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void deslogarUsuario() {
        ParseUser.logOut();
        Intent intent = new Intent( this, LoginActivity.class );
        startActivity( intent );
    }



}
