JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Beverage.java \
        BeverageWithIngredient.java \
        Chocolate.java \
        CoffeeBased.java \
        CoffeeBeverage.java \
        Decaf.java \
        Espresso.java \
        Ginger.java \
        GreenTea.java \
        HouseBlend.java \
        Jasmine.java \
        Milk.java \
        RedTea.java \
        SizeFactor.java \
	StarBuzzClient.java \
	TeaBased.java \
	TeaBeverage.java \
	WhipCream.java \
	WhiteTea.java

default: clean classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
