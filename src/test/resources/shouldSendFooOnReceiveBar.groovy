

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	label("should Send Foo On Receive Bar")
	description("description")
	input {
		messageFrom('topico')
		messageBody([
				foo: 'goose'
		])
	}
	outputMessage {
		sentTo("test1")
		body([
		        foo: "goose"
		])
	}
}