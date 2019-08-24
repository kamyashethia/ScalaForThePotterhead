class wand(typeOfWood: String, lengthOfWand: Long, magicalMaterial:String) {
  val wood = typeOfWood
  val length = lengthOfWand
  val magic = magicalMaterial

  override def toString(): String = {
    wood + " wand of length " + length + " inches with " + magic
  }
}

val wandA = new wand("english wood", 6, "wampus cat hair")
val wandB = new wand("hazel", 9, "veela hair")
val wandC = new wand("Walnut", 11, "troll whisker")
val wandD = new wand("Cypress", 9, "kelpie hair")
val wandE = new wand("ash", 7, "phoenix feather")
val wandF = new wand("birch", 5, "unicorn tail hair")


val wands = List(wandA, wandB, wandC, wandD, wandE, wandF)

//print all wands with length > 7 inches
val wandsLongerThan7Inches: List[wand] = for {
  wand <- wands
  if wand.length > 7
} yield wand

//A guard statement with two if conditions
val wandsLongerThan7InchesWithMagicalCreatureHair: List[wand] = for {
  wand <- wands
  if wand.length > 7
  if wand.magic.contains("hair")
} yield wand
