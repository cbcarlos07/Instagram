package com.parse.starter.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.starter.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos.bruno on 05/07/2017.
 */

public class UsuariosAdapter extends ArrayAdapter<ParseUser>{
    private Context context;
    private ArrayList<ParseUser> usuarios;
    public UsuariosAdapter(@NonNull Context c,  @NonNull ArrayList<ParseUser> objects) {
        super(c, 0, objects);
        this.context = c;
        this.usuarios = objects;
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
            view = inflater.inflate(R.layout.lista_usuarios, parent, false );

        }

        //Recuperar elementos para exibição
        TextView username = (TextView) view.findViewById( R.id.text_username );

        //Configura o textview para exibir usuario
        ParseUser parseUser = usuarios.get( position );
        username.setText( parseUser.getUsername() );

        return view;
    }
}
