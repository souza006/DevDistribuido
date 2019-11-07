 


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

package soapmodels.dao;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import soapserver.models.Pokemon;
/**
 *
 * @author elvis
 */
public class pokemonDAO {
    private static Map<Long, Pokemon> POKEMONS = new LinkedHashMap<>();

    private static Long counter;
    
    public pokemonDAO(){
        counter = 0L ;
    }
    
    public List<Pokemon> listaPokemon(){
        return new ArrayList<>(POKEMONS.values());
    }
    
    public void inserePokemon(String nome, String nick, int numDex){
        counter += 1L;
        POKEMONS.put(counter, new Pokemon(counter,nome,nick,numDex));
    }
}

