package com.codecool.pokemoncompanion.model.generated;

import com.codecool.pokemoncompanion.model.PokemonEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Generated("com.robohorse.robopojogenerator")
@Entity
public class Ability{

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
    PokemonEntity pokemonEntity;

	@JsonProperty("name")
	private String name;

	@JsonProperty("url")
	private String url;

	@Override
 	public String toString(){
		return 
			"Ability{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}