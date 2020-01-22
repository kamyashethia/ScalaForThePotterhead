Pattern Matching might seem a bit puzzling at first. Luckily, we don't have the pressure of stopping Voldemort from getting the Sorceror's Stone, like Harry and Hermione did! The Potions Puzzle was one of the challenges that protected the Stone. 

There are seven potion bottles in the puzzle, and only one of the bottles allows you to progress. Let's write some scala code to represent our potion bottles. 

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
We could do this with a `if-elseif` block. Here's a function that does that:

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

And if we pass in our bottles to this function, it will accurately tell us the effect the potion had on the wizard. 
If the wizard drank the potion in bottle 6, our function will accurately inform the wizard of their intoxicated state. 

```sh 
scala> checkBottle(bottle6)
res4: String = Well I guess you're drunk now
```
We can simplify this function by using pattern matching. If you are familiar with the `switch` statement found in many programming languages, the following code block should look familiar. 

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

The above code block matches on `potion.content`. The last case block, `case _` is a catch-all. You can think of it as a default block, or a match-anything. 

Let's test this function: 

```sh

scala> checkBottle(bottle6)
res6: String = Well I guess you're drunk now

```

This seems correct! Now let's see what happens if we tried to pass in a bottle of Amortentia, the strongest love potion, into the function: 

```sh 

scala> val bottle8 = Potion("Amortentia")
bottle8: Potion = Potion(Amortentia)

scala> checkBottle(bottle8)
res7: String = this bottle has an unknown substance

```

As expected, Amortentia matched on our default case statement, and we know that our function cannot recognize it. 

I hope you learnt a little bit about the basics of Pattern Matching in Scala. We covered a fairly simple example, but we can do more complex things with pattern matching. We will cover those in the next article. 
____

Here are some links that you might find interesting: 
1. [Code on github](PatternMatching1.scala)
2. [Scaladocs on Pattern Matching ](https://docs.scala-lang.org/tour/pattern-matching.html)
3. [Pottermore on Prior Incantato](https://pottermore.fandom.com/wiki/Prior_Incantato)