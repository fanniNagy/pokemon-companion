package com.codecool.pokemoncompanion.model.generated;

import com.codecool.pokemoncompanion.model.MyPokemon;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Generated("com.robohorse.robopojogenerator")
@Entity
public class Ability{

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	MyPokemon myPokemon;

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Ability{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}