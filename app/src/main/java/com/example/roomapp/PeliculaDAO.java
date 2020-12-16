package com.example.roomapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PeliculaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void InsertarPelicula(Pelicula ... peliculas);

    @Query("SELECT * FROM Pelicula")
    public List<Pelicula> peliculasTodas();

    @Update
    public void ActualizarPelicula(Pelicula ... peliculas);

    @Delete
    public void BorrarPelicula(Pelicula ... peliculas);
}
