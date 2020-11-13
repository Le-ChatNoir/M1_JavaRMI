JAVAC           = javac
RMIC		= rmic -vcompat


.SUFFIXES:
.SUFFIXES:	.java .class 
.SUFFIXES:	.java _Stub.class

.java.class:
	$(JAVAC)  $<

.java_Stub.class:
	$(RMIC)   $*


#####################################################


CLASSES    = Pile.java UsinePile.java Client.java MyHostName.java PileImpl.java UsinePileImpl.java
REMOTEOBJ  = PileImpl.java UsinePileImpl.java


all:  class rmic


rmic:	$(REMOTEOBJ:.java=_Stub.class)


class:	$(CLASSES:.java=.class) 

	
clean:
	rm -rf *.class *.bak *~ core




