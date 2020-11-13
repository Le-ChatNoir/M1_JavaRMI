JAVAC           = javac
RMIC		= rmic -vcompat -keep


.SUFFIXES:
.SUFFIXES:	.java .class 
.SUFFIXES:	.java _Stub.class

.java.class:
	$(JAVAC)  $<

.java_Stub.class:
	$(RMIC)   $*


#####################################################


CLASSES    = Hello.java HelloClient.java MyHostName.java  HelloServeur.java
REMOTEOBJ = HelloServeur.java


all:  class rmic


rmic:	$(REMOTEOBJ:.java=_Stub.class)


class:	$(CLASSES:.java=.class) 

	
clean:
	rm -rf *.class *.bak *~ core




