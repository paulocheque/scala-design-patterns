package scala.behavioral
// Strategy = Policy
// Encapsular um algoritmo para que ele possa ser alterado dinamicamente
// Example with function-objects
// Concrete Implementation
class SomeParam
class SomeReturnValue

object Strategies {
 def strategyA(param:SomeParam) : SomeReturnValue = {
  println("strategy A")
  return new SomeReturnValue()
 }

 def strategyB(param:SomeParam) : SomeReturnValue = {
  println("strategy B")
  return new SomeReturnValue()
 }

 def strategyC(param:SomeParam) : SomeReturnValue = {
  println("strategy C")
  return new SomeReturnValue()
 }
}

class MyApplication2(var strategy: (SomeParam => SomeReturnValue)) {
 def doSomething(param:SomeParam) : SomeReturnValue = {
  return strategy(param)
 }
}

// Client
object StrategyClient2 extends Application {
 var arg = "a"
 var strategy:(SomeParam => SomeReturnValue) = _
 arg match {
  case "a" => strategy = Strategies.strategyA
  case "b" => strategy = Strategies.strategyB
  case _ => strategy = Strategies.strategyC
 }
 var myapp = new MyApplication2(strategy)
 myapp.doSomething(new SomeParam())
 myapp.strategy = Strategies.strategyC
 myapp.doSomething(new SomeParam())
}