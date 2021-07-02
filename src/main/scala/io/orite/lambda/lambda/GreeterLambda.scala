package io.orite.lambda.lambda

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import com.typesafe.scalalogging.LazyLogging
import io.orite.lambda.event.GreetingInput

import javax.inject.Named

/**
 * Input argument is nothing but a plain string representation of a JSON structure or a Map[String, Object] representation.
 * For the map representation, Key is the name of the attribute, and the value is
 * 1. A String if it is a primitive value or
 * 2. A List if it has multiple values, is another Map<String, Object> or another JSON structure.
 */
@Named("greeter")
class GreeterLambda extends RequestHandler[GreetingInput, String] with LazyLogging {
  override def handleRequest(input: GreetingInput, context: Context): String = {
    logger info s"Invoking lambda function using the input: $input"
    s"Hello ${input.message}!"
  }
}
