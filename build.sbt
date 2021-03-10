name := "scala-akka-swagger"

version := "0.1"

scalaVersion in ThisBuild := "2.12.13"

triggeredMessage in ThisBuild := Watched.clearWhenTriggered

initialCommands in console := "import com.github.nullptr7._"

addCommandAlias("testc", ";clean;coverage;test;coverageReport")

val akkaVersion = "2.6.13"
val akkaHttpVersion = "10.2.4"
val jacksonVersion = "2.12.2"
val swaggerVersion = "2.1.7"

libraryDependencies ++= Seq(
  "javax.ws.rs" % "javax.ws.rs-api" % "2.0.1",
  "com.github.swagger-akka-http" %% "swagger-akka-http" % "2.4.0",
  "com.github.swagger-akka-http" %% "swagger-scala-module" % "2.3.0",
  "com.github.swagger-akka-http" %% "swagger-enumeratum-module" % "2.1.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion,
  "pl.iterators" %% "kebs-spray-json" % "1.9.0",
  "io.swagger.core.v3" % "swagger-core" % swaggerVersion,
  "io.swagger.core.v3" % "swagger-annotations" % swaggerVersion,
  "io.swagger.core.v3" % "swagger-models" % swaggerVersion,
  "io.swagger.core.v3" % "swagger-jaxrs2" % swaggerVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "ch.megard" %% "akka-http-cors" % "1.1.1",
  "org.slf4j" % "slf4j-simple" % "1.7.30",

  "io.spray" % "spray-client" % "1.3.1",
  "joda-time" % "joda-time" % "2.9.9",
  "org.json4s" %% "json4s-jackson" % "3.5.3"
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds")