package token.domain;

public class ValueValidator {
	
	protected boolean isNullOrEmpty(String val) {
		return val == null || val.trim().length() == 0;
	}

}
