
// Main goal of for-expressions is :
// - make combinatorial problems easier to solve.
// - help you “grow” the Scala language
// grow into new application domains.

// syntax : for ( seq ) yield expr

case class Person(
  name: String,
  isMale: Boolean,
  children: Person*)


object Person {

  
  def allPairsOfMothersAndTheirChildren_00(persons: List[Person]) = 
    persons filter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name))))

  // optimized bit by using withFilter call instead of filter.
  // This would avoid the creation of an intermediate data structure for mal persons
  // These queries does thier job but still not exactly trivial to WRITE or understand.
  def allPairsOfMothersAndTheirChildren_01(persons: List[Person]) =
    persons withFilter (p => !p.isMale) flatMap (p => (p.children map (c => (p.name, c.name))))


  // A Simple notation : For-expression
  def allPairsOfMothersAndTheirChildren_10(persons: List[Person]) =
    for {
      p <- persons
      if !p.isMale
      c <- p.children
    } yield (p.name, c.name)


}
