#Author: Timothy Schultz

JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	  AbstractClassSpaceShip.java \
	  CargoShip.java \
	  PirateShip.java \
	  canMove.java \
	  Project3.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
