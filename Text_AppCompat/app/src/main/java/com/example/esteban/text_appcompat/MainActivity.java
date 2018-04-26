package com.example.esteban.text_appcompat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esteban.text_appcompat.bl.UsuarioBL;
import com.example.esteban.text_appcompat.domain.Usuario;

public class MainActivity extends AppCompatActivity {
    TextView nombre,apellido,ced,ocupacion,direccion,correo,telefono;
    public static UsuarioBL usuarioBL = UsuarioBL.Companion.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button usuarios = (Button) findViewById(R.id.verUsu);
        usuarios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),CatalogoUsuarios.class);
                startActivityForResult(intent,0);

            }
        });

    }
    public void registrar(View v){
        ced=(TextView)findViewById(R.id.id);
        nombre = (TextView)findViewById(R.id.nom);
        apellido =(TextView)findViewById(R.id.ape);
        ocupacion=(TextView)findViewById(R.id.ocup);
        telefono=(TextView)findViewById(R.id.tel);
        correo=(TextView)findViewById(R.id.email);
        direccion=(TextView)findViewById(R.id.dir);
        Usuario user=new Usuario(Integer.parseInt(ced.getText().toString()),nombre.getText().toString(),apellido.getText().toString(),ocupacion.getText().toString(),Integer.parseInt(telefono.getText().toString()),"user",correo.getText().toString(),direccion.getText().toString());
        usuarioBL.create(user);
        Toast.makeText(this,"usuario registrado",Toast.LENGTH_LONG).show();

        ced.setText("");
        //ced.invalidate();
        nombre.setText("");
        //nombre.invalidate();
        apellido.setText("");
        //apellido.invalidate();
        ocupacion.setText("");
        telefono.setText("");
        //ocupacion.invalidate();
        correo.setText("");
        //correo.invalidate();
        direccion.setText("");
        //direccion.invalidate();
    }
}
