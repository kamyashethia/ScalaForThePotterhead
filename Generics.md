Before diving into Generics, let's talk about something a bit more benign ... like Horcruxes.

A Horcrux is a magical object used to store a piece of a person's soul.
The darkest of all magic is needed to create one, so ofcourse Voldemort created 7 of them. 
Not all magical objects are nefarious, like the Remembrall, a small orb which turns red when the owner has forgotten something. 


Let's try and represent magical objects in Scala: 



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
```

