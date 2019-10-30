/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbadistri;

import java.util.Exceptions.*;
import corbadistri.OlaApp.*;
import OlaApp.OlaHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;


/**
 *
 * @author 20172014040027
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        ORB orb = null;
        POA rootPOA = null;
    try{ 
        orb= ORB.init(args, null);
        rootPOA= POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        
        
        OlaServo olaObj= new OlaServo();
        olaObj.setORB(orb);
        
        org.omg.CORBA.Object ref= rootPOA.servant_to_reference(olaObj);
        Ola href = OlaHelper.narrow(ref); 
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        
        
        org.omg.CosNaming.NamingContextExt ncRef= NamingContextExtHelper.narrow(objRef);
        org.omg.CosNaming.NameComponent path[] = ncRef.to_name("ABC");
        
        ncRef.rebind(path, href);
        System.out.println("Servidor pronto e esperando...");
        
        rootPOA.the_POAManager().activate();
        for(;;) orb.run();
    
    }  catch(Exception exception){}
        System.out.println("Error");
    }   
}
