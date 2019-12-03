JUNIT5_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_XML = cs_appstate_checks.xml
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
PROG_RUNNER = @java HeapDriver

# makefile syntax
# #target-name: files dependent on (can use multiple lines by ending
# #             lines with \
# #<TAB char>Unix command-line command
# #<TAB char>Unix command-line command
# #etc.
# #Essential that command lines start with single TAB character

default:
	@echo "5 available targets:"	
	@echo "____________________ check - runs checkstyle"
	@echo "____________________ compile - compiles all .java files"
	@echo "____________________ test - builds JUnit5 tests"
	@echo "____________________ run - executes the driver program"
	@echo "____________________ clean - removes editor tmpfiles and .class files"

run:
	$(PROG_RUNNER)

compile: HeapDriver.java HeapDriverTest.java $(JUNIT5_JAR)
	javac FibonacciHeap.java
	javac HollowHeap.java
	javac HeapDriver.java
	javac -cp .:$(JUNIT5_JAR) HeapDriverTest.java

clean:
	rm -f *.class

test: $(JUNIT5_JAR)
	java -cp .:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

check: FibonacciHeap.java style.xml
	java $(CKSTYLE_COMMAND) -c style.xml FibonacciHeap.java
	java $(CKSTYLE_COMMAND) -c style.xml HollowHeap.java
	java $(CKSTYLE_COMMAND) -c style.xml HeapDriver.java

