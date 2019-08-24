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
//For comprehension that prints all wands with length > 7 inches
val wandsLongerThan7Inches: List[wand] = for {
//Generator expression
wand <- wands
//Guard
  if wand.length > 7
//Yielding
} yield wand

```

Let's talk about each of the pieces: 

1. Generator expression (`wand <- wands`): 
This gives us access to individual elements of the `wands` list. In python we would write this as `for wand in wands`. The `<-` operator is called a left arrow operator, and it's scala's way of iterating through elements in a `List` 

2. Guard (`if wand.length > 7`):
A guard is just an `if` expression that helps us filter elements in the foor loop. In this case, we only want to keeo wands that are greater than 7 inches.

3. Yielding (`yield wand`) 
Yielding is a way to return values from the for comprehension. In this case, every time a wand passes the guard statement, we `yield` it to the `wandsLongerThan7Inches` List. 

4. For comprehension: 
This entire block is called a for comprehension. It's similar to a for loop in other programming languages, but we call it a comprehension because it can have side effects (in this case, populating the `wandsLongerThan7Inches` array. 




