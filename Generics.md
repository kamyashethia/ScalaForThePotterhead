# Generics 

Before diving into Generics, let's talk about something a bit more benign ... like Horcruxes.

A Horcrux is a magical object used to store a piece of a person's soul.
The darkest of all magic is needed to create one, so ofcourse Voldemort created 7 of them. 
Not all magical objects are nefarious, like the Remembrall, a small orb which turns red when the owner has forgotten something. 

Let's represent some magical objects in Scala: 

```scala
class MagicalObject {
  val isDangerous: Boolean = false;
}

//When all 3 hallows are owned by one wizard, the owner is said to have mastery over death
class DeathlyHallows extends MagicalObject {
  override val isDangerous: Boolean = true;
}
//The smoke contained inside the remembrall turns red if it's owner has forgotten something
class Remembrall extends MagicalObject
//An object containing a piece of a human soul
class Horcrux extends MagicalObject {
  var isDestroyed = false
  override val isDangerous: Boolean = true;
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
val magicalObjectsOwnedByHarry: List[MagicalObject] = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak)

```

Let's zoom in on the type of the variable `magicalObjectsOwnedByHarry`. It is a List that accepts elements of the type MagicalObject. Scala implements the List type as a Generic class, which allows us to do this. 

Let's confirm that the scala compiler is happy with our code: 

```sh 
scala> val magicalObjectsOwnedByHarry: List[MagicalObject] = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak)

magicalObjectsOwnedByHarry: List[MagicalObject] = List(ElderWand@66032b8d, MaraudersMap@1fb66050, RiddleDiary@28068327, InvisibilityCloak@65c2610f)

```

Generics is sometimes known as Parametric Polymorphism. It helps us write code that is more expressive and promotes code reusability without compromising type safety.
When we use Generics, the scala compiler will be able to detect any unexpected type errors at compile time. 

In our example, if we try to insert a nonmagical item, the scala compiler will immediately alert us that there is an error with our code.

```sh 
scala> val magicalObjectsOwnedByHarry: List[MagicalObject] = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak, "Non-magical kettle")
                                                                                                                           ^
       error: type mismatch;
        found   : String("Non-magical kettle")
        required: MagicalObject
```

You might be tempted to solve for the compile error by removing the type altogether. While this might make our code compile, it might fail later anyway with an error that is harder to debug. 

Consider the following snippet where we try and find all the dangerous objects owned by Harry. 

```sh 
scala> scala> val magicalObjectsOwnedByHarryWithoutGenericType = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak, "Non-magical kettle")
magicalObjectsOwnedByHarryWithoutGenericType: List[Object] = List(ElderWand@772357e9, MaraudersMap@22ccd80f, RiddleDiary@45b7b254, InvisibilityCloak@3b47178c, Non-magical kettle)

scala> val dangerousObjects = magicalObjectsOwnedByHarryWithoutStrongTypes.filter(magicObject => magicObject.isDangerous)
                                                                                                             ^
       error: value isDangerous is not a member of Object

scala
```

Our code fails with an error that is a lot harder to understand, as opposed to the neat type error we saw earlier. 


---
* You can check the full code sample [here](https://github.com/kamyashethia/ScalaForThePotterhead/blob/Generics/GenericsExample.scala)
* You can read more about generic classes in the official [scaladoc](https://docs.scala-lang.org/tour/generic-classes.html)
* [This](https://en.wikipedia.org/wiki/Magical_objects_in_Harry_Potter) fantastic wikipenedia entry is a fun read about magical objects:   
