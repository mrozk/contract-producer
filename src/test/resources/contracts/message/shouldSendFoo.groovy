package contracts.message

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	label("trigger")
	description("description")
	input {
		triggeredBy("trigger()")
	}
	outputMessage {
		sentTo("topic1")
		body([
		        foo: "example"
		])
	}
}