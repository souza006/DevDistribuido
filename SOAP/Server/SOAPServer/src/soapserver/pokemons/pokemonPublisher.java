/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapserver.pokemons;

import javax.xml.ws.Endpoint;
import soapserver.webservice.PkmServerImpl;

/**
 *
 * @author elvis
 */
public class pokemonPublisher {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8082/pokemon?wsdl", new PkmServerImpl());
    }
}
