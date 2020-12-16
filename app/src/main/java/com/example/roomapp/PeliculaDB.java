package com.example.roomapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//entities = {clases}
@Database(entities = {Pelicula.class},version = 1)
abstract class PeliculaDB extends RoomDatabase {

    public abstract PeliculaDAO peliculaDAO();

}
