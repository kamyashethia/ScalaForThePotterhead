Before we dive into Options, let's talk about the spell Prior Incantato. Prior Incantato is an incantation that reveals the last spell cast by a wand. 

Let's represent a wand class that can cast spells.

```scala 
// Collections available to us in Scala are immutable by default. If we want to store a value that can change, we explicitly declare it's mutability
import scala.collection.mutable
case class Wand() {

  // A mutable collection that stores each spell cast by the wand.
  val spellsCast: mutable.ListBuffer[Spell] = new mutable.ListBuffer[Spell]()

  // A function that allows a wizard to cast a spell
  def castSpell(spell:Spell) = {
    // Store the spell
    spellsCast.addOne(spell)
    println("Cast spell!")
  }
}
```

If we needed to cast the Prior Incantato spell on a wand, we might think of implementing a function like this: 

```scala 
def PriorIncantato(wand:Wand): Spell = {
  wand.spellsCast.last
}
```

But wait, what would happen if we called `priorIncantato` on a wand that has never cast a spell. 

```scala 
val wand = Wand() 
priorIncantato(wand)
```

We would probably expect something to go wrong if we tried this. Sure enough, we see a a runtime error: 

```sh
scala> java.util.NoSuchElementException: last of empty ListBuffer
  at scala.collection.mutable.ListBuffer.last(ListBuffer.scala:343)
  at .priorIncantato(<console>:2)
  ... 28 elided

```

We tried to access the last element of an empty list, and the Scala compiler was unhappy. Now there might be some temptation to just use null to fix this problem. 

```scala 
def priorIncantato(wand:Wand): Spell = {
  if( wand.spellsCast.isEmpty) 
    null 
  else 
    wand.spellsCast.last
}
```

The code above would work just fine!

 ```sh
 scala> val spell:Spell = priorIncantato(wand)
spell: Spell = null
 ```
 
 But now, we have to remember that the `val spell` could potentially be null. If we tried to use it, we might encounter a frustrating `NullPointerException`.
 
 ```sh 
 scala> spell.getClass
java.lang.NullPointerException
  ... 28 elided
  
 ```
 
Scala's `Option` provides us with an abstraction for dealing with values that have the potential to be non-existent. Let's refactor the `priorIncantato` function. 

```scala 
// We explicitly state that the function optionally returns a spell
def priorIncantato(wand:Wand): Option[Spell] = {
  // The lastOption function can be called on the ListBuffer. Instead of throwing a `NoSuchElementException`, the function will return None if the list is empty
  wand.spellsCast.lastOption
}
```

Let's see what happens when we run this!

```sh
//call the priorIncantato function on a wand that has not cast any spells
scala> val spell = priorIncantato(wand)
spell: Option[Spell] = None

//try to find the name of the spell
scala> spell.getClass
res8: Class[_ <: Option[Spell]] = class scala.None$

```

Yay -- we don't have a runtime error anymore! We simply get back a `class scala.None`, which represents to `None` class.

Let's cast a spell with our wand, and then call the `priorIncantato` function: 

```sh
scala> wand.castSpell(expelliarmus)
Cast spell!

scala> val spell = priorIncantato(wand)
spell: Option[Spell] = Some(Expelliarmus())

scala> spell.getClass
res7: Class[_ <: Option[Spell]] = class scala.Some

```

This time, the function returns `Some(Expelliarmus())`. The value stored in `spell` is an Instance of the `Some` class in scala.

`Option` is an abstract class in Scala, with two possible subclasses, `Some` or `None`.
- This means that the `priorIncantaton(wand:Wand): Option[Spell]` function will return either `Some(Spell)` or `None`. 
- In general, an `Option[A]` can either be `Some(A)` or `None`. 

____

Options provide us with a handy way of representing missing values. Here are some links that you might find interesting: 
1. [Code on github](Options.scala)
2. [Scaladocs on the Option abstract class](https://www.scala-lang.org/api/2.12.8/scala/Option.html)
3. [Pottermore on Prior Incantato](https://pottermore.fandom.com/wiki/Prior_Incantato)
4. [Null References - The Billion Dollar Mistake](https://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare/)






