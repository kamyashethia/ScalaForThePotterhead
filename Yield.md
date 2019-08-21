# Yielding

Wandmakers like to think of theselves as creative geniuses. Olivanders apprentice thought that sounded much nicer than calling his bosses workspace untidy. 

On a hot summer's day, Olivander came bursting through the doors to announce that a Silver Sphinx had been spotted near the pyramids in Egypt. Sphinx feathers made powerful material for wands! Olivander ran out, leaving the young apprentice in charge, 

The apprentice was a muggle born, and decided to use Scala to help him! 

Let's start by creating a wand class, Everyone knows that good wands have powerful magical materials bound to complementary woods. 

```scala 
class wand(typeOfWood: String, lengthOfWand: Long, magicalMaterial:String) {
  val wood = typeOfWood
  val length = lengthOfWand
  val magic = magicalMaterial

  override def toString(): String = {
    wood + "wood wand of length " + length + " inches with " + magic
  }
}
```
Notice that we override the `toString` method. Whenever we call the print function on an object, scala asks the object's `toString` method how it should be displayed to the console. 

Let's create a wand object to see that in action: 

```sh 
scala> val wandA = new wand("english wood", 6, "wampus cat hair")

wandA: wand = english woodwood wand of length 6 inches with wampus cat hair
```

That looks good! The apprentice Cataloged all the wands in Olivander's shop, and stored it in a List.

```scala

val wandA = new wand("english wood", 6, "wampus cat hair")
val wandB = new wand("hazel", 9, "veela hair")
val wandC = new wand("Walnut", 11, "troll whisker")
val wandD = new wand("Cypress", 9, "kelpie hair")
val wandE = new wand("ash", 7, "phoenix feather")
val wandF = new wand("birch", 5, "unicorn tail hair")


val wands = List(wandA, wandB, wandC, wandD, wandE, wandF)

```

Now a wizard walks in, and asks for a wand. The wizard is tall, and the apprentice knows right away that he will need to find a wand that is longer than 7 inches. 
Let's look at some code that does just that: 

```scala 
1. //print all wands with length > 7 inches
2. val wandsLongerThan7Inches: List[wand] = for {
3.  wand <- wands
4. //guard expression
5. } yield wand

```

