package com.github.nullptr7

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.getFromResourceDirectory
import akka.http.scaladsl.server.RouteConcatenation
import ch.megard.akka.http.cors.scaladsl.CorsDirectives.cors
import com.github.nullptr7.service.{GreetService, HelloService}
import com.github.nullptr7.swagger.SwaggerDocService

import scala.concurrent.ExecutionContextExecutor

object RestServer extends App with RouteConcatenation {
  implicit val system: ActorSystem = ActorSystem("akka-http-sample")
  sys.addShutdownHook(system.terminate())

  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  val routes = cors()(
    new GreetService().route ~ new HelloService().route ~ SwaggerDocService.routes ~ getFromResourceDirectory("swagger-ui"))
  Http().newServerAt("0.0.0.0", 8080).bind(routes)
}
