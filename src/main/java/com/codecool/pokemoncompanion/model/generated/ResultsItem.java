package com.codecool.pokemoncompanion.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	@JsonProperty("id")
	private long id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
		setId(getIdFromUrl(this.url));
	}

	public String getUrl(){
		return url;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public long getIdFromUrl(String url){
		String[] array = url.split("/");
		return Long.parseLong(array[array.length-1]);
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}