package com.codecool.pokemoncompanion.model;

import com.codecool.pokemoncompanion.model.generated.Type;
import com.codecool.pokemoncompanion.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TypeWithIdAndPokemonEntity extends Type {

    @Id
    private long id;

    @ManyToMany
    Set<PokemonEntity> pokemonEntity = new HashSet<>();

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TypeWithIdAndPokemonEntity that = (TypeWithIdAndPokemonEntity) o;
        return pokemonEntity.equals(that.pokemonEntity) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pokemonEntity, name);
    }

    public TypeWithIdAndPokemonEntity(Type type){
        this.setName(type.getName());
        this.setUrl(type.getUrl());
        this.id = Util.getIdFromUrl(type.getUrl());
    }

}

