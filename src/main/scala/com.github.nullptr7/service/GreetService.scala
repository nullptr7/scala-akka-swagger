package com.github.nullptr7

package service

import akka.http.scaladsl.server.Directives
import scala.concurrent.ExecutionContext
import akka.util.Timeout
import scala.concurrent.duration._
import akka.http.scaladsl.server.Route

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}

@Path("/greet")
class GreetService()(implicit executionContext: ExecutionContext) extends Directives {

  implicit val timeout: Timeout = Timeout(2.seconds)

  val route: Route = getGreetResponseV1 ~ getGreetResponseV2

  @GET
  @Path("/ping-greet-1")
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Operation(summary = "Returns hello greeting with no message", description = "Returns hello greeting with no message",
    responses = Array(
      new ApiResponse(responseCode = "200", description = "Hello response"),
      new ApiResponse(responseCode = "500", description = "Internal server error")
    ))
  def getGreetResponseV1: Route = {
    path("greet" / "ping-greet-1") {
      get {
        complete {
          """
            |{
            |   "message": "Hello from Ping 1"
            |}
            |""".stripMargin
        }
      }
    }
  }

  @GET
  @Path("/ping-greet-2")
  @Produces(Array(MediaType.APPLICATION_JSON))
  @Operation(summary = "Returns hello greeting with no message", description = "Returns hello greeting with no message",
    responses = Array(
      new ApiResponse(responseCode = "200", description = "Hello response"),
      new ApiResponse(responseCode = "500", description = "Internal server error")
    ))
  def getGreetResponseV2: Route = {
    path("greet" / "ping-greet-2") {
      get {
        complete {
          """
            |{
            |   "message": "Hello from Ping 2"
            |}
            |""".stripMargin
        }
      }
    }
  }
}
