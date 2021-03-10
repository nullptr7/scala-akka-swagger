package com.github.nullptr7

package swagger

import com.github.nullptr7.service.{GreetService, HelloService}
import com.github.swagger.akka.SwaggerHttpService
import com.github.swagger.akka.model.Info
import io.swagger.v3.oas.models.ExternalDocumentation

object SwaggerDocService extends SwaggerHttpService {
  override val apiClasses = Set(classOf[GreetService], classOf[HelloService])
  override val host = "localhost:8080"
  override val info: Info = Info(version = "1.0")
  override val externalDocs: Option[ExternalDocumentation] = Some(new ExternalDocumentation().description("Core Docs").url("http://acme.com/docs"))
  override val unwantedDefinitions = Seq("Function1", "Function1RequestContextFutureRouteResult")
}
