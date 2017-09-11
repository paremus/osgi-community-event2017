package org.example.command;

import java.text.MessageFormat;

import org.osgi.service.component.annotations.*;

@Component(
		service = Object.class,
		property = {
				"osgi.command.scope=greeting",
				"osgi.command.function=sayHello"
		})
public class HelloCommand {

	public String sayHello() {
		return sayHello("anonymous user");
	}
	
	public String sayHello(String name) {
		return MessageFormat.format("Hello, {0}", name);
	}

}
