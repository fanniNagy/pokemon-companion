package com.codecool.pokemoncompanion.util;

public class Util {

    public static long getIdFromUrl(String url){
        String[] array = url.split("/");
        return Long.parseLong(array[array.length-1]);
    }

}
