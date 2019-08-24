# For Comprehensions

We'll cover For comprehensions, generator expressions, guards and yielding in this tutorial. Before we dive in, let's talk about wands. Everyone knows that good wands are crafted from the finest wood, and imbued with a token from a magical creature. Here is a wand class represented in Scala:

```scala 
class wand(typeOfWood: String, lengthOfWand: Long, magicalMaterial:String) {
  val wood = typeOfWood
  val length = lengthOfWand
  val magic = magicalMaterial

  override def toString(): String = {
    wood + " wand of length " + length + " inches with " + magic
  }
}
```
Notice that we override the `toString` method. Whenever we call the print function on an object, scala asks the object's `toString` method how it should be displayed to the console. Let's see that in action: 

```sh 
scala> val wandA = new wand("english wood", 6, "wampus cat hair")
wandA: wand = english wood wand of length 6 inches with wampus cat hair
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
A guard is just an `if` expression that helps us filter elements in the foor loop. In this case, we only want to keep wands that are greater than 7 inches.

3. Yielding (`yield wand`):  
Yielding is a way to return values from the For comprehension. In this case, every time a wand passes the guard statement, we `yield` it to the `wandsLongerThan7Inches` List. 

4. For comprehension: 
This entire block is called a For comprehension. It's similar to a for loop in other programming languages, but we call it a comprehension because it can have side effects. In this case, the side effect is populating the `wandsLongerThan7Inches` List. 


Let's see what the `wandsLongerThan7Inches` List looks like: 

```sh 

scala> wandsLongerThan7Inches
res30: List[wand] = List(hazelwood wand of length 9 inches with veela hair, Walnutwood wand of length 11 inches with troll whisker, Cypresswood wand of length 9 inches with kelpie hair)

```

Yay! Our new list only contains wands that are greater than 7 inches in length. But we're not done yet! We think that the wizard will do very well with a wand composed with the hair of a magical creature. Let's add that to our Guard condition: 

```scala 
scala> val wandsLongerThan7InchesWithMagicalCreatureHair: List[wand] = for {
  wand <- wands
  if wand.length > 7
  if wand.magic.contains("hair")
} yield wand
```
We can add multiple if statements in our guard if we choose to do so. In this case, we also have the option of simplifying the code and grouping the conditions: 

```scala 
scala> val wandsLongerThan7InchesWithMagicalCreatureHair: List[wand] = for {
  wand <- wands
  if wand.length > 7 && wand.magic.contains("hair")
} yield wand
```

This looks good, let's take a look at the result:

```sh
scala> wandsLongerThan7InchesWithMagicalCreatureHair
res1: List[wand] = List(hazel wand of length 9 inches with veela hair, Cypress wand of length 9 inches with kelpie hair)
```

Nice! The wizard only has to 'swish and flick' two wands, and wait for one of them to pick him! 

We've learnt about For comprehensions! You can find links below to learn more about for comprehensions or magical wands. 

Thanks for reading!
___

1. All the example code on [github](https://github.com/kamyashethia/ScalaForThePotterhead/blob/master/ForComprehension.scala)
2. [This](https://www.pottermore.com/features/the-great-wand-o-graphic) neat wand-o-graphic from pottermore
3. Official documentation about [for comprehensions](https://docs.scala-lang.org/tour/for-comprehensions.html) 
4. [These](https://alvinalexander.com/scala/scala-for-loop-yield-examples-yield-tutorial) examples of for loops from the author of the scala cookbook


