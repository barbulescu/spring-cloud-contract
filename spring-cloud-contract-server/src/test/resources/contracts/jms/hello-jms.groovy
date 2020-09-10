package contracts

import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.verifier.util.ContentType.TEXT

Contract.make {
    label 'basic_hello'
    input {
        messageFrom("hello-request")
        messageBody("Marius")
        messageHeaders {
            header('JMSCorrelationID', 'correlation#123')
        }
    }
    outputMessage {
        sentTo("hello-response")
        body("Hello Marius!")
        headers {
            messagingContentType(TEXT.mimeType)
//            header('JMSCorrelationID', 'correlation#123')
        }

    }
}