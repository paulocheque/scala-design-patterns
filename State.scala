package scala.behavioral

// Mudar o comportamento mude de acordo com seu estado

// Abstract Implementation

class Context {
  var state:State = _
  state = new NullState()

  def handle() {
    state.handle()
  }
}

trait State {
 def handle()
}

// Concrete Implementation

class NullState extends State {
  override def handle() {
    println("blank algorithm, maybe throw an exception of unitilized context")
  }
}

class StateA extends State {
  override def handle() {
    println("algorithm for state A")
  }
}

class StateB extends State {
  override def handle() {
    println("algorithm for state B")
  }
}

// Client

object StateClient extends Application {
  var context = new Context()
  context.state = new StateA()
  context.handle()
  context.state = new StateB()
  context.handle()
}