Pattern Matching might seem a bit puzzling. But imagine having to solve a puzzle to prevent Voldemort from getting his hands on the Sorceror's Stone! The Potions Puzzle was one of the challenges that protected the Sorcerers Stone in the very first Harry Potter book. As we all know, this stone could be used to create the elixer of life and grant it's owner immortality. 

There are seven potion bottles in the puzzle. Drinking the wrong bottle could kill you -- but one bottle contained a potion that would allow you to progress. Let's write some scala code to represent our potion bottles. 

```scala 

case class Potion(content:String) {}

val bottle1 = Potion("poison")
val bottle2 = Potion("nettle wine")
val bottle3 = Potion("move ahead")
val bottle4 = Potion("poison")
val bottle5 = Potion("poison")
val bottle6 = Potion("nettle wine")
val bottle7 = Potion("go back")

```

We now have 7 bottles ready to go. Next, we want to write a function that will tell us what will happen if a wizard chooses a bottle. 
We could represent this logic with a `if-elseif` block. Here's a function that does that:

```scala 

def checkBottle(bottle:Potion): String =
   if (bottle.content == "poison") {
     "you are dead"
   } else if (bottle.content == "move ahead") {
     "go ahead and find the mirror"
   } else if (bottle.content == "nettle wine") {
     "Well I guess you're drunk now"
   } else if (bottle.content == "go back") {
     "go and get Dumbledore -- quick!"
   } else {
     "this bottle has an unknown substance"
   }
   
```

If we pass in our bottles to this function, it will accurately tell us the effect the potion had on the wizard. 
If the wizard drank the potion in bottle 6, our function will accurately inform the wizard of their intoxicated state. 

```sh 
scala> checkBottle(bottle6)
res4: String = Well I guess you're drunk now
```
We can simplify this function by using pattern matching. If you are familiar with the `switch` statement found in many programming languages, the following code block might look familiar. 

```scala 

def checkBottle(bottle:Potion): String =

  bottle.content match {
    case "poison" => "you are dead"
    case "move ahead" => "go ahead and find the mirror"
    case "nettle wine" => "Well I guess you're drunk now"
    case "go back" => "go and get Dumbledore -- quick!"
    case _ => "this bottle has an unknown substance"
  }
  
```

The above code block looks at `potion.content` and tries to find a 'pattern' to 'match' it with.
It specifies four strings explicitly to match on.  The last case, `case _` is a catch-all. You can think of it as a default block, or a match-anything. 

Let's test this function: 

```sh

scala> checkBottle(bottle6)
res6: String = Well I guess you're drunk now

```

This seems correct! Now let's see what happens if we tried to pass in a bottle containing Amortentia, the strongest love potion. 

```sh 

scala> val bottle8 = Potion("Amortentia")
bottle8: Potion = Potion(Amortentia)

scala> checkBottle(bottle8)
res7: String = this bottle has an unknown substance

```

As expected, Amortentia matched on our default case statement. 

I hope you learnt a little bit about the basics of Pattern Matching in Scala. We will cover a more complex use case soon!
____

Here are some links that you might find interesting: 
1. [View this article on github](https://github.com/kamyashethia/ScalaForThePotterhead/blob/master/PatternMatching1.md)
2. [Scaladocs on Pattern Matching ](https://docs.scala-lang.org/tour/pattern-matching.html)
3. [The Potion Puzzle on Pottermore](https://pottermore.fandom.com/wiki/The_Potion_Puzzle)
