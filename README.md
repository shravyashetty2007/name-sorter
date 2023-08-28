# name-sorter

Clone the repository

git clone https://github.com/shravyashetty2007/name-sorter

## Running the program as a maven-project

1. Run the below command inside the name-sorter folder

mvn clean package

2. This creates a executable jar in the below path 

target\name-sorter-0.0.1-SNAPSHOT.jar

4. Run the jar 

java -jar target\name-sorter-0.0.1-SNAPSHOT.jar ./unsorted-names-list.txt

## Running the program as a standalone java application 

1. Run the below command inside the name-sorter folder to compile the classes

mkdir classes

javac -d classes src\main\java\model\PersonName.java src\main\java\helper\*.java src\main\java\interfaces\*.java src\main\java\implementation\*.java  src\main\java\NameSorter.java

2. Run the below command to run the main class

java -cp classes NameSorter ./unsorted-names-list.txt


## Roadmap

Create a build pipeline like Travis or AppVeyor that execute build and test steps.
