import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

class PersonSpec extends FlatSpec with ShouldMatchers {

  "Person.allPairsOfMothersAndTheirChildren0x" should "return 2 Persons" in {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    val result =  Person.allPairsOfMothersAndTheirChildren_01(persons)

    assert(result.length === 2)
    assert(result contains ("Julie", "Bob"))
    assert(result contains ("Julie", "Lara"))
  }


  "Person.allPairsOfMothersAndTheirChildren1x" should "return 2 Persons" in {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    val result =  Person.allPairsOfMothersAndTheirChildren_10(persons)

    assert(result.length === 2)
    assert(result contains ("Julie", "Bob"))
    assert(result contains ("Julie", "Lara"))

  }
}

