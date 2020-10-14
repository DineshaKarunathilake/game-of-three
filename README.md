#Game Of Three instructions

#Prerequisites

Java and docker should be installed

#Run RabbitMq docker
````
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
````

#How to build:

```
mvn clean install 
```
#How to run:

````
java -jar ./target/game-1.0-SNAPSHOT-jar-with-dependencies.jar <player-name> <opponent-name> <optional-initial-move-value-integer>
````

Player 1 - with manual input of starting number

````
java -jar ./target/game-1.0-SNAPSHOT-jar-with-dependencies.jar player1 player2 56
````

Player 2

````
java -jar ./target/game-1.0-SNAPSHOT-jar-with-dependencies.jar player2 player1
````

#Assumptions

Names of players will always be different
First player will be selected on lexicographical order of their names 
    eg: In lexicographical order 'player1' comes first 'player2' comes second  - player 1 will start
If the first player has input a initial move, the input value will be played


#Design Decisions

Algorithm has been abstracted out so that if the Game algorithm changes, it can be done easily
Abstraction done for the player class to use AutomaticPlayer or ManualPlayer
Remote Connection Service in abstracted so that a different service can be integrated
