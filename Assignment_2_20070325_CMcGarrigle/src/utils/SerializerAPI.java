package utils;

public interface SerializerAPI {
	void push(Object o);
	Object pop();
	void write() throws Exception;
	void read() throws Exception;
}
