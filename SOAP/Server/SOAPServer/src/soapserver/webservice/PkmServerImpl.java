/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapserver.webservice;


import java.util.List;
import javax.jws.WebService;
import soapmodels.dao.pokemonDAO;
import soapserver.models.Pokemon;


@WebService(endpointInterface = "soapserver.webService.PkmServer")
public class PkmServerImpl implements PkmServer {
   
    /* chama a classe pokemonDAO e instancia novo objeto*/
    private pokemonDAO pokemonDAO = new pokemonDAO();
   
    /* chama o metodo retornaParty para chamar a lista de objetos*/

    /* chama a classe pokemonDAO e chama a lista de objetos*/
   @Override
   public void inserePokemon(String nome, String nick, int numDex){
    pokemonDAO.inserePokemon(nome , nick , numDex);   
   }

    @Override
    public List<Pokemon> retornaParty(){
        return pokemonDAO.listaPokemon();
    }
}