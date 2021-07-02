# quarkus-lambda Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-lambda-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Local invocation 

- First package the application and then the serverless function can be invoked locally using SAM as shown below.
It accepts JSON representing case class as input and outputs a string; which is displayed in the console.  

```docker
❯ sam local invoke --template target/sam.jvm.yaml --event data/sam-local-input-event-payload.json
Invoking io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest (java11)
Decompressing /Users/viswanath/projects/quarkus-lambda/target/function.zip
Skip pulling image and use local one: amazon/aws-sam-cli-emulation-image-java11:rapid-1.23.0.

Mounting /private/var/folders/sg/fcz8bfpd2jq2x_x4myr7jwgc0000gn/T/tmpl3usogmt as /var/task:ro,delegated inside runtime container
START RequestId: d5281438-3982-4fca-bf04-45d65707c468 Version: $LATEST
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
2021-07-02 14:34:20,507 INFO  [io.quarkus] (main) quarkus-lambda 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.0.0.Final) started in 3.592s. Listening on: http://0.0.0.0:8081
2021-07-02 14:34:20,510 INFO  [io.quarkus] (main) Profile prod activated.
2021-07-02 14:34:20,511 INFO  [io.quarkus] (main) Installed features: [amazon-lambda, cdi, scala, smallrye-context-propagation]
2021-07-02 14:34:20,542 INFO  [io.ori.lam.lam.GreeterLambda] (main) Invoking lambda function using the input: GreetingInput(world)
END RequestId: d5281438-3982-4fca-bf04-45d65707c468
REPORT RequestId: d5281438-3982-4fca-bf04-45d65707c468	Init Duration: 0.21 ms	Duration: 3955.16 ms	Billed Duration: 4000 ms	Memory Size: 512 MB	Max Memory Used: 512 MB
"Hello world!"
```

## Related Guides

- AWS Lambda ([guide](https://quarkus.io/guides/amazon-lambda)): Write AWS Lambda functions

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
