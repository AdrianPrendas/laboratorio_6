package com.example.esteban.text_appcompat.Adaptador;

import android.support.v7.widget.PopupMenu;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esteban.text_appcompat.R;
import com.example.esteban.text_appcompat.domain.Usuario;

import java.util.ArrayList;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder> {

    ArrayList<Usuario> listaUsuarios;
    Context mContext;

    public AdaptadorUsuario(Context mContext,ArrayList<Usuario> listaUsuarios){
        this.listaUsuarios=listaUsuarios;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public AdaptadorUsuario.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlistusuario,parent, false );
        return new UsuarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUsuario.UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.tv_id.setText(String.valueOf(usuario.getId()));
        holder.tv_nombreUsuario.setText(usuario.getNombre());
        holder.tv_apellido.setText(usuario.getApellido());
        holder.tv_email.setText(String.valueOf(usuario.getEmail()));
        holder.tv_ocup.setText(String.valueOf(usuario.getOcupacion()));
        holder.tv_tel.setText(String.valueOf(usuario.getNumeroTelefono()));
        holder.tv_direccion.setText(String.valueOf(usuario.getDireccion()));

        holder.iv_imagen.setImageResource(mContext.getResources().getIdentifier(usuario.getImageUrl(),"drawable",mContext.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    };

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{
        TextView tv_nombreUsuario,tv_id,tv_email,tv_apellido,tv_direccion,tv_ocup,tv_tel;
        ImageView iv_imagen;
        public UsuarioViewHolder(View itemView){
            super(itemView);
            tv_id= (TextView) itemView.findViewById(R.id.tv_id);
            tv_nombreUsuario= (TextView) itemView.findViewById(R.id.tv_nombre);
            tv_apellido=(TextView) itemView.findViewById(R.id.tv_apellido);
            tv_email= (TextView) itemView.findViewById(R.id.tv_correo);
            tv_ocup=(TextView) itemView.findViewById(R.id.tv_ocupacion);
            tv_tel=(TextView) itemView.findViewById(R.id.tv_telefono);
            tv_direccion=(TextView) itemView.findViewById(R.id.tv_direccion);
            iv_imagen = (ImageView) itemView.findViewById(R.id.iv_imagen);

        }
    }




    }


