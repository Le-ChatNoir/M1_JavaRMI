// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

public final class HelloServeur_Stub
    extends java.rmi.server.RemoteStub
    implements Hello, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("java.lang.String lireMessage()")
    };
    
    private static final long interfaceHash = 2938206153180985982L;
    
    private static final long serialVersionUID = 2;
    
    private static boolean useNewInvoke;
    private static java.lang.reflect.Method $method_lireMessage_0;
    
    static {
	try {
	    java.rmi.server.RemoteRef.class.getMethod("invoke",
		new java.lang.Class[] {
		    java.rmi.Remote.class,
		    java.lang.reflect.Method.class,
		    java.lang.Object[].class,
		    long.class
		});
	    useNewInvoke = true;
	    $method_lireMessage_0 = Hello.class.getMethod("lireMessage", new java.lang.Class[] {});
	} catch (java.lang.NoSuchMethodException e) {
	    useNewInvoke = false;
	}
    }
    
    // constructors
    public HelloServeur_Stub() {
	super();
    }
    public HelloServeur_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of lireMessage()
    public java.lang.String lireMessage()
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_lireMessage_0, null, -8455060421940265551L);
		return ((java.lang.String) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
		ref.invoke(call);
		java.lang.String $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (java.lang.String) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
