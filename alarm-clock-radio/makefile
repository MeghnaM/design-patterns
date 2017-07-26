JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Alarm.java \
        Clock.java \
        Radio.java \
        AlarmClockRadio.java 

default: clean classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

run: 
	java AlarmClockRadio
