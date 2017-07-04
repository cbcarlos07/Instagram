package com.parse.starter.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.parse.starter.R;
import com.parse.starter.fragments.HomeFragment;
import com.parse.starter.fragments.UsuariosFragment;

/**
 * Created by carlos.bruno on 04/07/2017.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {
    private Context context;
   // private String[] abas = new String[]{"HOME", "USUÁRIOS"};
    private int[] icones = new int[]{R.drawable.ic_action_home, R.drawable.ic_people };
    private int tamanhoIcone;
    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
        double escala = this.context.getResources().getDisplayMetrics().density; //tamanho do dispositivo
        tamanhoIcone = (int) (36 * escala);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new UsuariosFragment();
                break;
        }

        return fragment;

    }

    @Override
    public int getCount() {

        //return abas.length;
        return icones.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

       // return abas[ position ];
        Drawable drawable = ContextCompat.getDrawable( this.context, icones[ position ] );
        drawable.setBounds( 0, 0, tamanhoIcone, tamanhoIcone );

        //Permite colocar uma imagemm dentro de um texto
        ImageSpan imageSpan = new ImageSpan( drawable ); //ImageSpan = coloca imagem dentro de texto

        //Classe utilizada para retornar CharSequence
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan( imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

        return spannableString;

    }
}
