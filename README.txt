Instructions of install and run:

WINDOWS: 
1. Install GIT
2. Install JDK (recommended version 15.0.2)
3. Install MAVEN (recommended version 3.6.3)
4. Add system enviroments: MAVEN_HOME, M2_HOME, JAVA_HOME and update PATH with MAVEN_HOME, JAVA_HOME
5. Install Chrome browser (required version 88)
6. Download project from GitHub
7. Run tests from CMD (console should run from the main catalog of project) with commands:
mvn clean install -Dsurefire.suiteXmlFiles=testngAPI.xml - API tests
mvn clean install -Dsurefire.suiteXmlFiles=testngUI.xml - UI tests


LINUX:
1. Install GIT
2. Install JDK
3. Install MAVEN
4. Add system enviroments: MAVEN_HOME, M2_HOME, JAVA_HOME and update PATH with M2_HOME
5. Install Chrome browser (required version 88)
6. Download project from GitHub
7. Run tests from terminal (terminal should run from the main catalog of project) with commands:
mvn clean install -Dsurefire.suiteXmlFiles=testngAPI.xml - API tests
mvn clean install -Dsurefire.suiteXmlFiles=testngUI.xml - UI tests
Helpful links:
https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-20-04/
https://linuxize.com/post/how-to-install-git-on-ubuntu-18-04/


MAC OS:
1. Install GIT
2. Install JDK
3. Install MAVEN
4. Add system enviroments: MAVEN_HOME, M2_HOME, JAVA_HOME and update PATH with M2_HOME
5. Install Chrome browser (required version 88)
6. Download project from GitHub
7. Run tests from console (console should run from the main catalog of project) with commands:
mvn clean install -Dsurefire.suiteXmlFiles=testngAPI.xml - API tests
mvn clean install -Dsurefire.suiteXmlFiles=testngUI.xml - UI tests

