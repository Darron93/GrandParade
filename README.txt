Do poprawnego uruchomienia projektu należy wykonać poniższe kroki:
1. Instalacja JDK (rekomendowana wersja 15.0.2)
2. Instalacja Maven (rekomendowana wersja 3.6.3)
3. Utworzenie zmiennych środowiskowych: JAVA_HOME, MAVEN_HOME (odnoszących się kolejno do lokalizacji JDK oraz Maven) oraz dodanie lokalizacji MAVEN_HOME do zmiennej Path
4. Instalacja przeglądarki Chrome (wymagana wersja 88.0.4324.150). W przypadku innej wersji przeglądarki wymagana jest podmiana pliku chromedriver.exe w głównym katalogu programu na wersję zgodną z przeglądarką.
Po wykonaniu powyższych kroków, projekt można uruchomić z konsoli, w której należy przejść do głównego katalogu programu, a następnie użyć polecenia: "mvn clean install" (w razie problemów alternatywnie można użyć: "mvn clean install -Dtestng.dtd.http=true")
5. W głównym katalogu projektu, w pliku testng.xml zawarta jest lista wszystkich testów. Aby uruchomić konkretny test case, należy go odkomentować. (do poprawnego działania projektu, powinien być odkomentowany maksymalnie jeden test case, domyślnie uruchomi się test: "UI automation TC 1").

Linux: 
1. instalacja git
2. instalacja jdk
3. instalacja maven
 
