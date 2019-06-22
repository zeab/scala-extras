
### Scala-Extras
 Collection of useful extensions and additions to items already in scala.sys

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.zeab/scalaextras_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.zeab/scalaextras_2.12)
[![Build Status](https://travis-ci.org/zeab/scala-extras.svg?branch=master)](https://travis-ci.org/zeab/scala-extras)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/23b2d46830074d47b854207b109d5215)](https://www.codacy.com/app/zeab/scala-extras?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zeab/scala-extras&amp;utm_campaign=Badge_Grade)

ThreadLocalRandom:
```scala
import zeab.scalaextras.util.ThreadLocalRandom._
val randomInt: Int = getRandomInt(1, 0)
val randomLong: Long = getRandomLong(10, 5)
val randomDouble: Double = getRandomDouble(0.510000000000001, 0.51)
val randomAlpha: String = getRandomAlpha(5)
val randomNumeric: String = getRandomNumeric(5)
val randomAlphaNumeric: String = getRandomAlphaNumeric(5, 3)
val randomCustom: String = getRandomCustom(10, 3, Seq('k', ':'))
```

Environment Variables: 
```scala
val someString: String = getEnvVar[String]("MY_STRING", "127.0.0.1")
val someString: String = getEnvVar[Boolean]("MY_BOOLEAN", false)
val someString: String = getEnvVar[Double]("MY_DOUBLE")
```

logback.xml
```
<?xml version="1.0"?>
<configuration>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%msg%n</pattern>
        </encoder>
    </appender>

    <appender name="CONSOLE-JSON" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder">
            <providers>
                <timestamp>
                    <fieldName>logTimestamp</fieldName>
                    <pattern>yyyy-MM-dd'T'HH:mm:ss.SSSZZ</pattern>
                </timestamp>
                <logLevel>
                    <fieldName>level</fieldName>
                </logLevel>
                <loggerName>
                    <fieldName>loggerName</fieldName>
                </loggerName>
                <threadName>
                    <fieldName>thread</fieldName>
                </threadName>
                <message/>
                <stackTrace>
                    <throwableConverter class="net.logstash.logback.stacktrace.ShortenedThrowableConverter">
                        <maxDepthPerThrowable>30</maxDepthPerThrowable>
                        <maxLength>512</maxLength>
                        <shortenedClassNameLength>50</shortenedClassNameLength>
                        <rootCauseFirst>true</rootCauseFirst>
                    </throwableConverter>
                </stackTrace>
            </providers>
        </encoder>
    </appender>

    <appender name="UDP" class="net.logstash.logback.appender.LogstashUdpSocketAppender">
        <host>${UDP_HOST:-localhost}</host>
        <port>${UDP_HOST:-8125}</port>
        <layout class="net.logstash.logback.layout.LogstashLayout"/>
    </appender>

    <logger name="udp" additivity="false">
        <appender-ref ref="UDP"/>
    </logger>

    <logger name="stdout-raw" additivity="false">
        <appender-ref ref="CONSOLE"/>
    </logger>

    <root additivity="false">
        <appender-ref ref="CONSOLE-JSON"/>
    </root>

</configuration>
```