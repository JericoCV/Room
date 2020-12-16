package com.example.roomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText Titulo, Descripcion, Genero, Director;
    PeliculaDB db;
    TextView tvpelicula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Titulo= findViewById(R.id.titulo);
        Descripcion= findViewById(R.id.descripcion);
        Genero = findViewById(R.id.genero);
        Director = findViewById(R.id.director);
        db = Room.databaseBuilder(getApplicationContext(),PeliculaDB.class,"peliculas.db").allowMainThreadQueries().build();
        tvpelicula = findViewById(R.id.tvpeliculas);
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = db.peliculaDAO().peliculasTodas();
        tvpelicula.setText("");
        for(Pelicula item : peliculas){
            tvpelicula.append("Titulo: "+item.titulo+"\n"+
                              "Descripcion: "+item.descripcion+"\n"+
                              "Genero: "+item.genero+"\n"+
                              "Director: "+item.director+"\n");
        }
    }

    public void GuardarInfo(View view){

        String titulo = Titulo.getText().toString();
        String descripcion = Descripcion.getText().toString();
        String genero = Genero.getText().toString();
        String director = Director.getText().toString();

        Pelicula pelicula = new Pelicula();
        pelicula.titulo = titulo;
        pelicula.genero = genero;
        pelicula.descripcion = descripcion;
        pelicula.director = director;
        db.peliculaDAO().InsertarPelicula(pelicula);
        Toast.makeText(getApplicationContext(),"Pelicula Guardada", Toast.LENGTH_LONG).show();
    }
}