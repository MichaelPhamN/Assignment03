
public class InternalStringStack {
	private String data;
	private InternalStringStack rest;
	
	public InternalStringStack(String data, InternalStringStack rest) {
		this.data = data;
		this.rest = rest;
	}
	
	public String getData() {
		return data;
	}
	
	public InternalStringStack getRest() {
		return rest;
	}
	
	public int size() {
		if (rest == null) return 1;
		return 1 + rest.size();
	}
	
}
