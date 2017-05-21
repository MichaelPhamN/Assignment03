
public class StringStack {
	private InternalStringStack stack;

	public StringStack() {
		// Create an empty stack
		stack = null;
	}

	public void push(String s) {
		stack = new InternalStringStack(s, stack);
	}

	public int size() {
		if (stack == null)
			return 0;
		return stack.size();
	}

	public String top() {
		if (stack == null)
			return null;
		return stack.getData();
	}
	
	public String pop() {
		if (stack == null)
			return null;
		String s = stack.getData();
		stack = stack.getRest();
		return s;
	}
	
	public boolean isEmpty() {
		return stack == null;
	}

}
