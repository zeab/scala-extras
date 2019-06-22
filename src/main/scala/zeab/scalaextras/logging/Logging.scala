package zeab.scalaextras.logging

//Imports
import zeab.scalaextras.sys.EnvironmentVariables
//Logback
import ch.qos.logback.classic.{Level, LoggerContext}
//Slf4j
import org.slf4j.{Logger, LoggerFactory}

trait Logging extends EnvironmentVariables {

  //Grab the logging context
  val loggerContext: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]

  //Set all the log levels
  val rootLogLevel: Level = getLogLevel("ROOT_LOG_LEVEL", "INFO")
  loggerContext.getLogger(Logger.ROOT_LOGGER_NAME).setLevel(rootLogLevel)

  val akkaLogLevel: Level = getLogLevel("AKKA_LOG_LEVEL", "INFO")
  loggerContext.getLogger("akka").setLevel(akkaLogLevel)

  val zooKeeperLogLevel: Level = getLogLevel("ZOOKEEPER_LOG_LEVEL", "WARN")
  loggerContext.getLogger("org.apache.zookeeper").setLevel(zooKeeperLogLevel)

  val kafkaLogLevel: Level = getLogLevel("KAFKA_LOG_LEVEL", "WARN")
  loggerContext.getLogger("org.apache.kafka").setLevel(kafkaLogLevel)

  val cassandraLogLevel: Level = getLogLevel("CASSANDRA_LOG_LEVEL", "WARN")
  loggerContext.getLogger("com.datastax.driver.core").setLevel(cassandraLogLevel)
  loggerContext.getLogger("io.netty.util.internal").setLevel(cassandraLogLevel)

  //Log to console
  val log: Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)

  //Log to consume without json wrapping
  val logRaw: Logger = LoggerFactory.getLogger("stdout")

  //Log to udp
  val udp: Logger = LoggerFactory.getLogger("udp")

  def getLogLevel(key:String, default:String): Level =
    getEnvVar(key, default).toUpperCase match {
      case "ERROR" => Level.ERROR
      case "WARN" | "WARNING" => Level.WARN
      case "INFO" => Level.INFO
      case "DEBUG" => Level.DEBUG
      case "OFF" => Level.OFF
      case "TRACE" => Level.TRACE
    }

}