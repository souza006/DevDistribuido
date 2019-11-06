/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapserver.models;

/**
 *
 * @author elvis
 */

public class Pokemon {
    private Long cod;
    private int numDex;
    private String nome;
    private String nick;

    /* Construtor vazio que é requisito do JAX-8, para o binding*/
    public Pokemon(){
        
    }
    
    public Pokemon(Long cod, String nome, String nick,int numDex){
       super();
       this.nome = nome;
       this.numDex = numDex;
       this.nick = nick;
       this.cod = cod;

    }
    public int getNumDex(){
        return numDex;
    }
    public void setNumDex(int numDex){
        this.numDex = numDex;
    }
    public Long getCod(){
        return cod;
    }
    public void setCod(Long numCod){
        this.cod = cod;
    }
    public String getNome(){
        return nome;
    }
    
    public void setNumDex(String nome){
        this.nome = nome;
    }
    public String getNick(){
        return nick;
    }
    public void setNick(String nick){
        this.nick = nick;
    }
    
    @Override
    public int hashCode(){
        final int primo = 31;
        int result = 1;
        result = primo * result + ((cod == null)? 0 : cod.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(this == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Pokemon other = (Pokemon) obj;
        if(cod == null){
            if(other.cod != null){
                return false;
            }
        }
        else if (!cod.equals(other.cod)){
            return false;
        }
        return true;
    }
}
