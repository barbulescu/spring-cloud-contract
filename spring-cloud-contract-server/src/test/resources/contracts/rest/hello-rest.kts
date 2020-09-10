import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract
import org.springframework.cloud.contract.spec.internal.HttpMethods
import org.springframework.cloud.contract.spec.internal.HttpStatus

contract {
    request {
        url = url("/hello?name=Marius")
        method = GET
    }
    response {
        status = OK
        body = body("Hello Marius!")
    }
}