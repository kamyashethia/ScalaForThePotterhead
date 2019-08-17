Before diving into Generics, let's talk about something a bit more benign ... like Horcruxes.

A Horcrux is a magical object used to store a piece of a person's soul.
The darkest of all magic is needed to create one, so ofcourse Voldemort created 7 of them. 
Not all magical objects are nefarious, like the Remembrall, a small orb which turns red when the owner has forgotten something. 

Let's represent some magical objects in Scala: 

```scala
class MagicalObject

//When all 3 hallows are owned by one wizard, the owner is said to have mastery over death
class DeathlyHallows extends MagicalObject

//The smoke contained inside the remembrall turns red if it's owner has forgotten something
class Remembrall extends MagicalObject

//An object containing a piece of a human soul
class Horcrux extends MagicalObject {
  var isDestroyed = false
}

//A magical map of Hogwarts
class MaraudersMap extends MagicalObject
```

An old wizarding story, The tale of the Three Brothers talks about the Deathly Hallows. There is an Unbeatable Wand, a Stone that can bring the dead back to life, and an invisibility cloak! As the legend goes, if a single wizard comes to possess all three of these things, he or she will have complete mastery over death.  
Let's represent this in Scala 


```scala 
class InvisibilityCloak extends DeathlyHallows
class ResurrectionStone extends DeathlyHallows
class ElderWand extends DeathlyHallows {
  var owner = "Antioch Peverell"
}
```

You will never hear a Hogwarts professor mention Horcruxes, and any references to them have been banned from the library. Voldemort turned several items of significance into hosts for his soul. 

```scala 
//Diadem (tiara) of one of the founders of Hogwarts: Rowena Ravenclaw
class RavenclawDiadem extends Horcrux

//The high school diary of Tom Riddle aka Lord Voldemort
class RiddleDiary extends Horcrux

//The ring of Voldemort's maternal grandfather
class MarvoloGauntRing extends Horcrux
```
Let's create a list of magical objects that have been owned by the famous Harry Potter. Below is some scala code that does just that:

```scala
val ownedByHarry: List[MagicalObject] = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak)

```

Let's zoom in on the type of the variable `ownedByHarry`. It is a List that accepts elements of the type Magical Object. Scala implements the List type as a Generic class, which allows us to do this. 

Let's confirm that the scala compiler is happy with our code: 

```sh 
scala> val ownedByHarry: List[MagicalObject] = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak)

ownedByHarry: List[MagicalObject] = List(ElderWand@66032b8d, MaraudersMap@1fb66050, RiddleDiary@28068327, InvisibilityCloak@65c2610f)

```





