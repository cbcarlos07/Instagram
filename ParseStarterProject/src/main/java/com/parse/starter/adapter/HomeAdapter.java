package com.parse.starter.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.parse.ParseObject;
import com.parse.starter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos.bruno on 04/07/2017.
 */

public class HomeAdapter extends ArrayAdapter<ParseObject> {
    private Context context;
    private ArrayList<ParseObject> postagens;
    public HomeAdapter(@NonNull Context c, @NonNull ArrayList<ParseObject> objects) {
        super(c, 0, objects);
        this.context = c;
        this.postagens = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        /*
        Verifica se não existe o objeto view criado
        pois a view utilzada é armazenado no cache do android e fica na variável
        convertView
         */

        if( view == null ){

            //Inicializa objeto para montagem do layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );

            //monta a view a partir do xml
            view = inflater.inflate(R.layout.lista_postagem, parent, false );

        }

        //verifica se existe postagens
        if( postagens.size() > 0 ){

            //recupera componentes da tela
            ImageView imagemPostagem = (ImageView) view.findViewById( R.id.image_lista_postagem );

            ParseObject parseObject = postagens.get( position );
            /*parseObject.getParseFile( "nomeDaColuna" );
              parseObject.getParseFile( "imagem" );
              http://square.github.io/picasso/
            */
            Picasso.with( context )
                    .load( parseObject.getParseFile( "imagem" ).getUrl() )
                    .fit()
                    .into( imagemPostagem );
        }


        return view;
    }
}
