package scala.creational

// Permitir a criação de uma só instância de um tipo de objeto


object Singleton {
// object in scala is a singleton class
 var value:Int = _

 def someMethod() : String  = {
  "Hello Singleton!"
 }
}

// Error:
//class BadSingleton private () {
// private var instance:BadSingleton = null
//
//  def getInstance() : BadSingleton = {
//    if(instance == null) instance = new DummySingleton()
//    return instance
//  }
//}

// Client

object SingletonClient extends Application {
 println(Singleton.someMethod())
 // Compile error
 // var s = new Singleton()
 var s1 = Singleton
 var s2 = Singleton
 println(Singleton.value)
 s1.value = 1
 println(Singleton.value)
 s2.value = 2
 println(Singleton.value)
 println(s1 == s2)

 // Compile error
 //  println(new BadSingleton().getInstance())
 //  println(BadSingleton.getInstance())
}