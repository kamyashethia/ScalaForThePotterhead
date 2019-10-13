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

If we needed to case the Prior Incantato spell on a wand, we might thing of implementing a function that does so, like this: 

```scala 
def PriorIncantato(wand:Wand): Spell = {
  wand.spellsCast.last
}
```

Does this look right? Let's pause to think about what would happen if we called `priorIncantato` on a wand that has never cast a spell. 

```scala 
val wand = Wand() 
priorIncantato(wand)
```

We would expect something to go very wrong if we tried this, and sure enough, we see an error. 

```sh
scala> java.util.NoSuchElementException: last of empty ListBuffer
  at scala.collection.mutable.ListBuffer.last(ListBuffer.scala:343)
  at .priorIncantato(<console>:2)
  ... 28 elided

```

We tried to access the last element of an empty list, and the Scala compiler was unhappy. Now you might be tempted to just use null to fix this problem. Maybe you want to try something like this: 

```scala 
def priorIncantato(wand:Wand): Spell = {
  if( wand.spellsCast.isEmpty) 
    null 
  else 
    wand.spellsCast.last
}
```

You wouldn't be wrong, the code would run! 
 ```sh
 scala> val spell:Spell = priorIncantato(wand)
spell: Spell = null
 ```
 
 But now, we have to remember the val `spell` contains a value, or a null. If we tried doing something with it, like trying to see what sort of spell was cast, we might get a frustrating `NullPointerException`.
 
 ``sh 
 scala> spell.getClass
java.lang.NullPointerException
  ... 28 elided
 ```
 
Let's try to do this using Scala's Options. The function would look like this: 

```scala 
// We explicitly state that the function optionally returns a spell
def priorIncantato(wand:Wand): Option[Spell] = {
  // The lastOption function can be called on lists. This will not throw a `NoSuchElementException`, but 
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

There's no runtime error this time, we simply get back a `None`. Let's cast some spells with our wand, and then call the `priorIncantato` function. 

```sh
scala> wand.castSpell(expelliarmus)
Cast spell!

scala> val spell = priorIncantato(wand)
spell: Option[Spell] = Some(Expelliarmus())

```

This time, the function returned `Some(Expelliarmus())`. `Option` is an abstract class in Scala, with two possible subclasses, `Some` or `None`. 
In general, an `Option[A]` can return `Some(A)` or `None`. If you want to access the spell, we would call `spell.get`.






