import logging.Logger.info

class Project(name: String, daysToComplete: Int)

class LoggerUsage {
  val project1 = new Project("TPS Reports", 1)
  val project2 = new Project("Website redesign", 5)
  info("Created projects") // Prints "INFO: Created projects"
}
