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
import javax.jws.WebService;
import java.util.List;
import soapmodels.dao.pokemonDAO;
import soapserver.models.Pokemon;


@WebService(endpointInterface = "soapserver.webService.PkmServer")
public class Party_ServerImpl implements PkmServer {
   
    /* chama a classe pokemonDAO e instancia novo objeto*/
    private pokemonDAO pokemonDAO = new pokemonDAO();
   
    /* chama o metodo retornaParty para chamar a lista de objetos*/

   @Override
   public List<Pokemon> retornaPokemons(){
       return pokemonDAO.listaPokemons();
   }
    /* chama a classe pokemonDAO e chama a lista de objetos*/
   @Override
   public void inserePokemon(String nome, String nick, int numDex){
    pokemonDAO.inserePokemon(nome , nick , numDex);   
   }
}
