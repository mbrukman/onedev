package io.onedev.server.util.input.showcondition;

import java.io.Serializable;

import io.onedev.server.util.editable.annotation.Editable;

@Editable
public interface ValueMatcher extends Serializable {

	boolean matches(String value);
	
}
