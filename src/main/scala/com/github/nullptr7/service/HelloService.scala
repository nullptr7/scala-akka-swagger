package com.github.nullptr7.service

import akka.http.scaladsl.server.{Directives, Route}
import akka.util.Timeout
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.DurationInt

@Path("/hello")
class HelloService()(implicit executionContext: ExecutionContext) extends Directives {

  implicit val timeout: Timeout = Timeout(2.seconds)

  val route: Route = getHello

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Operation(summary = "Return hello message", description = "Return hello message",
    responses = Array(
      new ApiResponse(responseCode = "200", description = "Hello response"),
      new ApiResponse(responseCode = "500", description = "Internal server error")
    ))
  def getHello: Route =
    path("hello") {
      get {
        complete {
          """
            |{
            |   "message": "Hello from HelloService"
            |}
            |""".stripMargin
        }
      }
    }
}
