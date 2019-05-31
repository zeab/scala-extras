package zeab.scalaextras.sys.terminal.seed

case class TerminalSeed(
                         command: String,
                         workingDir: Option[String] = None
                       )