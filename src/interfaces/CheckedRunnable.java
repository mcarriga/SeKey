package interfaces;

@FunctionalInterface
public interface CheckedRunnable {
	void run() throws Exception;
}
