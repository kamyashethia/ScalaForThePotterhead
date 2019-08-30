# Mixins

At the end of this tutorial, you should know about: 
1. Mixins 
2. Traits 
3. The `abtract override` qualifier in a function header

Before delving into the magical world of abtractions, let's talk about a very magical school. 

The Book of Acceptance records all the students who will be admitted to the Hogwarts School of Withcraft and Wizardry.
The summer before they are scheduled to start school, Hogwarts will make sure that the letter reaches all accepted sudents.

Let's start by representing a Wizard and the Owlery in scala.

```scala 
case class Wizard(name: String) {}

case class Owlery() {
  def sendOwl(message: String): Unit = {
    println("Sending message: " + message)
  }
}

```
Now, let's write an abstract class `HogwartsAcceptance` that knows how to send letters to students 

```scala 
abstract class HogwartsAcceptance {
  def sendToStudent(student: Wizard): Unit =  {}
}
```
This class doesn't do much, but defines a method called `sendToStudent` that knows how to inform students of their acceptance. 

Hogwarts admits students born to wizard families as well as those born to muggle born families. 

