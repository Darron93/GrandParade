Instrukcje instalacji oraz uruchomienia:

WINDOWS: 
1. Instalacja GIT
2. Instalacja JDK (rekomendowana wersja 15.0.2)
3. Instalacja MAVEN (rekomendowana wersja 3.6.3)
4. Dodać zmienne systemowe MAVEN_HOME, M2_HOME, JAVA_HOME oraz zaktualizować PATH o MAVEN_HOME, JAVA_HOME
5. Instalacja przeglądarki Chrome (wymagana wersja 88)
6. Pobrać projekt z repozytorium
7. Testy można uruchomić z konsoli (konsola uruchomiona z poziomu głównego katalogu projektu) za pomocą komend:
mvn clean install -Dsurefire.suiteXmlFiles=testngAPI.xml - testy API
mvn clean install -Dsurefire.suiteXmlFiles=testngUI.xml - testy UI


LINUX:
1. Instalacja GIT
2. Instalacja JDK
3. Instalacja MAVEN
4. Dodać zmienne systemowe MAVEN_HOME, M2_HOME, JAVA_HOME oraz zaktualizować PATH o M2_HOME
5. Instalacja przeglądarki Chrome (wymagana wersja 88)
6. Pobrać projekt z repozytorium
7. Testy można uruchomić z terminala (terminal uruchomiony z poziomu głównego katalogu projektu) za pomocą komend:
mvn clean install -Dsurefire.suiteXmlFiles=testngAPI.xml - testy API
mvn clean install -Dsurefire.suiteXmlFiles=testngUI.xml - testy UI
Pomocne linki:
https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-20-04/
https://linuxize.com/post/how-to-install-git-on-ubuntu-18-04/


MAC OS:
1. Instalacja GIT
2. Instalacja JDK
3. Instalacja MAVEN
4. Dodać zmienne systemowe MAVEN_HOME, M2_HOME, JAVA_HOME oraz zaktualizować PATH o M2_HOME
5. Instalacja przeglądarki Chrome (wersja 88)
6. Pobrać projekt z repozytorium
7. Testy można uruchomić z konsoli (konsola uruchomionq z poziomu głównego katalogu projektu) za pomocą komend:
mvn clean install -Dsurefire.suiteXmlFiles=testngAPI.xml - testy API
mvn clean install -Dsurefire.suiteXmlFiles=testngUI.xml - testy UI

