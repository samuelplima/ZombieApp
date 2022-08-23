# Zombie App - By Samuel 

### Basic Instructions
The application is running on port 8181.

### Database 
The database is running on port 8181 too, address: http://localhost:8181/h2-console 
on your browser 

Obs: The database is being seed everytime the programs run.

user:sa

password: sa

### Swagger
The application is documented with swagger,
to access it first run the application then access through this address: http://localhost:8181/swagger-ui.html#/

You can test the endpoints from there too, otherwise below there is a postman collection to help with the tests.

### Postman Collection
Collection link: https://www.getpostman.com/collections/189e95faebeb2bd85c39

You have to import this collection to  your postman by clicking in IMPORT, LINK, "paste the link", CONTINUE.


### How to run
It is recommended to run the application using an IDE (e.g. IntelliJ).

Otherwise, you can run manually too
Go into the root directory of the application (Zombie folder)
Run `java -jar ./build/libs/test-0.0.1-SNAPSHOT.jar`
- You should see the application running in your terminal.

### How the program works 

After you run the projects there are two ways to test it, one is using the postman collection and tho other is accessing through swagger.

We have 3 Controllers or 3 folders in the postman collection.

1 - Zombie (where the action happens)
- endpoint POST - startChasing
- it will start the chasing, the zombie will search and find every creature and in the final will show 
some information.
- in the final if you go to the creture controller and get all creatures there will be none
- so you will have to add more to continue the chasing

2 - Creature (in this controller you can add more cretures or update their position)
- endpoint GET getAllCreatures, it will bring all the creatures that still are alive
- enpoint POST createCreature, it will create another creature that will be the zombies meal yummy.
- enpoint PUT editCreature, it allows you to change the creatures position and their number in that position.

3 - Board (the board size is also editable, but you have to be careful and also give the right coordinate to the zombies)
Obs: you cant create more boards , only edit the one that already exists
- endpoint GET getBoard , it will bring the configured board
- endpoint PUT editBoard, it will allow to edit the board size
- 

### Points that i would like to describe

- My program allows to change the board, the number of creatures per position, cause i thought if i were in an zombie apocalipse i wouldnt be alone, its more likely to survive living in a community haha.

- I would develop the unit tests too but i had no more time.

- I tried to cover and think the most number of scenarios possible, I really hope you like it.

