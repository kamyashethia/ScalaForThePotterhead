
/** Define magical object classes */
class MagicalObject {
  val isDangerous: Boolean = false;
}

//When all 3 hallows are owned by one wizard, the owner is said to have mastery over death
class DeathlyHallows extends MagicalObject {
  override val isDangerous: Boolean = true;
}
//The smoke contained inside the remembrall turns red if it's owner has forgotten something
class Remembrall extends MagicalObject
//An object containing a piece of a human soul
class Horcrux extends MagicalObject {
  var isDestroyed = false
  override val isDangerous: Boolean = true;
}

//A magical map of Hogwarts
class MaraudersMap extends MagicalObject

class InvisibilityCloak extends DeathlyHallows
class ResurrectionStone extends DeathlyHallows
class ElderWand extends DeathlyHallows {
  var owner = "Antioch Peverell"
}

//Diadem (tiara) of one of the founders of Hogwarts: Rowena Ravenclaw
class RavenclawDiadem extends Horcrux
//The high school diary of Tom Riddle aka Lord Voldemort
class RiddleDiary extends Horcrux
//The ring of Voldemort's maternal grandfather
class MarvoloGauntRing extends Horcrux

/** Code examples  */

//We create instances of our magical objects
val remembrall = new Remembrall
val ravenclawDiadem = new RavenclawDiadem
val gauntRing = new MarvoloGauntRing
val riddleDiary = new RiddleDiary
val elderWand = new ElderWand
val resurrectionStone = new ResurrectionStone
val invisibilityCloak = new InvisibilityCloak
val maraudersMap = new MaraudersMap


//All the magical objects owned by Harry Potter
val magicalObjectsOwnedByHarry: List[MagicalObject] = List(elderWand, maraudersMap, riddleDiary, invisibilityCloak)

//filter down to dangerous objects 
val dangerousObjects = magicalObjectsOwnedByHarry.filter(magicObject => magicObject.isDangerous)
