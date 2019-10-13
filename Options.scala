import scala.collection.mutable

abstract class Spell() {}
case class Expelliarmus() extends Spell {}

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


def priorIncantato(wand:Wand): Option[Spell] = {
  wand.spellsCast.lastOption
}


//val wand = Wand()
//val spell = priorIncantato(wand)
//spell.getClass
//wand.castSpell(expelliarmus)
//val secondAttemptSpell = priorIncantato(wand)
//secondAttemptSpell.getClass
//wand: Wand = Wand()
