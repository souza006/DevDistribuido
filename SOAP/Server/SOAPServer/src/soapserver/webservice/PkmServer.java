/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapserver.webservice;


/** SEI~ServerParty **/

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author 20172014040027
 */

@WebService

@SOAPBinding(style = Style.RPC)

public interface PkmServer {
    
    
    /**Chama o metodo retornaParty e os pokemons na party para o client **/
    @WebMethod 
   public List<Pokemon> retornaParty();
   /**Chama o metodo inserePokemon e insere os dados lidos no client **/
   @WebMethod
   public void inserePokemon(String nome, String nick, int numDex );
}
