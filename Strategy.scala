package scala.behavioral

// Strategy = Policy
// Encapsular um algoritmo para que ele possa ser alterado dinamicamente

// Abstract Implementation
trait Strategy {
 def run() { // Template method for legibility
  algorithm()
 }

 def algorithm()
}

// Concrete Implementation
class DefaulStrategy extends Strategy {
 override def algorithm() {
  println("default algorithm")
 }
}

class StrategyA extends Strategy {
 override def algorithm() {
  println("solved using algorithm A")
 }
}

class StrategyB extends Strategy {
 override def algorithm() {
  println("solved using algorithm B")
 }
}

class MyApplication(var strategy:Strategy) {
 def doSomething() {
  strategy.run()
 }
}

// Client
object StrategyClient extends Application {
 var arg = "a"
 var strategy:Strategy = _
 arg match {
  case "a" => strategy = new StrategyA()
  case "b" => strategy = new StrategyB()
  case _ => strategy = new DefaulStrategy()
 }
 var myapp = new MyApplication(strategy)
 myapp.doSomething()
 myapp.strategy = new StrategyB()
 myapp.doSomething()
}