package io.orite.lambda

import io.orite.lambda.event.GreetingInput
import io.quarkus.amazon.lambda.test.LambdaClient.invoke
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.{DisplayName, Test}

@QuarkusTest
class GreeterLambdaTest {

    @Test
    @DisplayName("Greeter lambda must handle serialsed request correctly")
    def shouldHandleRequestProperly(): Unit = {
        val output = invoke(classOf[String], GreetingInput("there"))
        assertEquals("Hello there!", output)
    }

}