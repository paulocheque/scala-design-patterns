package scala.behavioral

// Define o esqueleto de um algoritmo e delega a implementação de alguns passos às sub-classes
// Abstract Implementation
abstract class SomeFramework {
 def templateMethod() {
  // some implementation here
  someAbstractMethod()
  // some implementation here
 }

 def someAbstractMethod()
}

// Concrete Implementation
class MyFramework extends ClassWithTemplateMethod {
 override def someAbstractMethod() {
  println("partial implementation of the framework")
 }
}

// Client
object TemplateMethodClient extends Application {
 var framework = new MyFramework()
 framework.templateMethod()
}