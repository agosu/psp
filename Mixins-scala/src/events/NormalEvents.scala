package events

trait NormalEvents {
  var events: Array[Event] = new Array[Event](10)
  var numberOfEvents: Integer = 0

  def organizeEvent(budget: Integer, numberOfAttendees: Integer): Unit = {
    events(numberOfEvents) = new Event("normal", "normal", "normal", budget, numberOfAttendees)
    numberOfEvents += 1
  }

  def getEventsType: String = {
    "normal events"
  }

  def getEvents: Array[Event] = {
    events
  }
}
