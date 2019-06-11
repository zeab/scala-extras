
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
