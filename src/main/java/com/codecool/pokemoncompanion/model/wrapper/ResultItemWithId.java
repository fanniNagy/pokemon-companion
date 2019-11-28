package com.codecool.pokemoncompanion.model.wrapper;

import com.codecool.pokemoncompanion.model.generated.ResultsItem;

public class ResultItemWithId extends ResultsItem {

    public ResultItemWithId(ResultsItem item) {
        this.setName(item.getName());
        this.setUrl(item.getUrl());
    }

    public long getId() {
        return getIdFromUrl(this.getUrl());
    }

    private long getIdFromUrl(String url){
        String[] array = url.split("/");
        return Long.parseLong(array[array.length-1]);
    }
}
