#author Courtney Dixon

JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_XML = style.xml
CKSTYLE_COMMAND = -jar checkstyle-5.5-all.jar
FIB_RUNNER = @java FibonacciHeapDriver
HOLLOW_RUNNER = @java HollowHeapDriver
PROG_RUNNER = @java HeapDriver

default:
	@echo "7 available targets:"	
	@echo "____________________ check - runs checkstyle"
	@echo "____________________ compile - compiles all .java files"
	@echo "____________________ test - builds JUnit5 tests"
	@echo "____________________ fib - runs the Fibonacci Heap driver program"
	@echo "____________________ hollow - runs the Hollow Heap driver program"
	@echo "____________________ run - executes the combined driver program"
	@echo "____________________ clean - removes editor tmpfiles and .class files"

fib:
	$(FIB_RUNNER)
	
hollow:
	$(HOLLOW_RUNNER)
	
run:
	$(PROG_RUNNER)

compile: HeapDriver.java HeapDriverTest.java $(JUNIT5_JAR)
	javac Node.java
	javac FibonacciNode.java
	javac HollowNode.java
	javac FibonacciHeap.java
	javac HollowHeap.java
	javac FibonacciHeapDriver.java
	javac HollowHeapDriver.java
	javac HeapDriver.java
	@javac -cp .:$(JUNIT5_JAR) HeapDriverTest.java

test: $(JUNIT5_JAR)
	@java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

check: 
	@java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) *.java

clean:
	@rm -f *.class


# MAKEFILE SYNTAX:
# #target-name: files dependent on (can use multiple lines by ending
# #             lines with \
# #<TAB char>Unix command-line command
# #<TAB char>Unix command-line command
# #etc.
# #Essential that command lines start with single TAB character


