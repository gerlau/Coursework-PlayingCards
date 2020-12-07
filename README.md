# What is this project about?
* Populating an array, arraylist with class object ,and 2-dimensional arraylist 
* Demonstrating a shuffle among the values in an array
* Demonstrating sorting of values based on the values' ranks and suits 

![Assignment_1_Output](https://user-images.githubusercontent.com/48362970/101310109-f0b47c80-3888-11eb-9a47-6e93692e73ef.png)

# How are we going to do it?

1. Populate an arraylist called "cardList" with PlayingCard objects

```
ArrayList<PlayingCard> cardList = new ArrayList<PlayingCard>();
deckOfCards(cardList);
```

2. OPTIONAL : Transfer values from an ArrayList (variable length) to an Array of PlayingCard objects (fixed length)

```
PlayingCard[] cardArray = new PlayingCard[MAXD];
listToArray(cardList, cardArray);
```

3. OPTIONAL : Transfer values from an Array of PlayingCard objects to an Array of String objects

```
String[] strArray = new String[MAXD];
transfer(cardArray, strArray);
```

4. In this case, we are shuffling the array of String objects

```
shuffle(strArray);
```

5. Transfer values from an array of String objects into a 2 dimensional array of String objects

```
String[][] twoD = new String[4][13];
transfer2D(twoD, strArray);
```

6. Lastly, we re-arrange the 2D array

```
sort2D(twoD);
```

