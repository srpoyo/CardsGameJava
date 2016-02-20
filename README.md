# CardsGameJava
There we go, my first repository. A simple Java project to simulate cards games (actually only a solitaire one).
The project has been made to study the % of win ratio the game has. It's not a skill game, so I could make an algorithm for it.

<strong>ALGORITHM</strong>
The algorithm is simple. We have a spanish deck, 40 cards with 4 different suits and numbers 1 to 7 plus "Sota", "Caballo" and "Rey" for
each of them. So we randomize the deck and since the first card to the last one check if the n-2 card (n is the actual card position in
the deck) has the same suit or the same number. In this case, we put the n-1 card(s) above the n-2 card(s).

An example:
If we have next randomized deck where the suits are "espadas" (swords), "copas" (cups), "oros" (golds) and "bastos" (clubs):

A-espadas, 2-copas, 7-oros, 2-espadas

First move will be put 7-oros card above 2-opas because our last card played (2-espadas) in the position n (4) has the same
number that the n-2 posticion card (2-copas) so we put 7-oros card above 2-copas card:

A-espadas, 7-oros, 2-espadas

The next move will be the same, check if the last card played has the same number or suit that the 2 position less. We have
a lo tof luck and both have the same suit ("espadas") so we put 7-oros card above A-espadas card:

7-oros, 2-espadas

We win when we play all the deck and at the end we have only 2 "columns" of cards. Like I said before is not a skill game and 
we can see the win ratio of it.


<strong>USE</strong>

To execute it we have to write the number of tries we want.
An example of use and output:

Compile:  javac JuegoCartasJava.java
Run:      java JuegoCartasJava 10000000
Output:   
(Spanish)
El numero de victorias en 10.000.000 intentos es: 46.064
El de derrotas: 9.953.936
En esta simulacion sale una media de 1 victoria cada 217,082 intentos.
--
(English)
The number of wins in 10.000.000 tries is: 46.064
The number of losses: 9.953.936
In this simulation we have an average of 1 victory each 217.082 tries.
