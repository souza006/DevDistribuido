package OlaApp;


/**
* OlaApp/OlaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Test.idl
* quinta-feira, 17 de outubro de 2019 10:18:17 Hor�rio da Guiana Francesa
*/

public abstract class OlaPOA extends org.omg.PortableServer.Servant
 implements OlaApp.OlaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_msg", new java.lang.Integer (0));
    _methods.put ("_set_msg", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // OlaApp/Ola/_get_msg
       {
         String $result = null;
         $result = this.msg ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // OlaApp/Ola/_set_msg
       {
         String newMsg = in.read_string ();
         this.msg (newMsg);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:OlaApp/Ola:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Ola _this() 
  {
    return OlaHelper.narrow(
    super._this_object());
  }

  public Ola _this(org.omg.CORBA.ORB orb) 
  {
    return OlaHelper.narrow(
    super._this_object(orb));
  }


} // class OlaPOA
