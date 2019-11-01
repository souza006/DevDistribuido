/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapserver.webservice;
/* SIB~ServerParty*/
/**
 *
 * @author 20172014040027
 */

import java.util.List;


@WebService(endpointInterface = "soapserver.webService.PkmServer")
public class Party_ServerImpl implements PkmServer {
   
    /* chama a classe pokemonDAO e instancia novo objeto*/
    private PokemonDAO pokemonDAO = new PokemonDAO();
   
    /* chama o metodo retornaParty para chamar a lista de objetos*/

   @Override
   public List<Pokemon> retornaParty(){
       return pokemonDAO.listaPokemons();
   }
    /* chama a classe pokemonDAO e chama a lista de objetos*/
   @Override
   public void inserePokemon(String nome, String nick, int numDex){
    pokemonDAO.inserePokemon(nome , nick , numDex);   
   }
}
