# For Comprehensions

Let's talk about for loops in Scala. We use a lot terms here (some of which come from functional programming), but don't let that scare you! We'll cover for comprehensions, generator expressions, guards and yielding. 

But first, let's talk about wands. Everyone knows that good wands are crafted from the finest wood, which is imbued with a token from a magical creature. Let's look at the wand class: 

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
Notice that we override the `toString` method. Whenever we call the print function on an object, scala asks the object's `toString` method how it should be displayed to the console. Let's see that in action: 

```sh 
scala> val wandA = new wand("english wood", 6, "wampus cat hair")

wandA: wand = english woodwood wand of length 6 inches with wampus cat hair
```

That looks good! Now let's create a catalog of more wands in Olivander's shop. We will store them in a `List`.

```scala

val wandA = new wand("english wood", 6, "wampus cat hair")
val wandB = new wand("hazel", 9, "veela hair")
val wandC = new wand("Walnut", 11, "troll whisker")
val wandD = new wand("Cypress", 9, "kelpie hair")
val wandE = new wand("ash", 7, "phoenix feather")
val wandF = new wand("birch", 5, "unicorn tail hair")


val wands = List(wandA, wandB, wandC, wandD, wandE, wandF)

```

Now, we want to find a wand for a particularly tall wizard. We know that he will require a wand that is greater than 7 inches in length. Let's look at some code that does that: 

```scala 
//print all wands with length > 7 inches
val wandsLongerThan7Inches: List[wand] = for {
  wand <- wands
  if wand.length > 7
} yield wand

```

