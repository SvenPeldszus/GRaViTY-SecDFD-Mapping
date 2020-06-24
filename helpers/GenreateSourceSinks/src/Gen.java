import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;

public class Gen {

	public static void main(String[] args) throws IOException {
		File sources = new File("sources.txt");
		sources.createNewFile();
		File sinks = new File("sinks.txt");
		sinks.createNewFile();
		generate(sources, sinks, PreparedStatement.class);
	}

	private static void generate(File sources, File sinks, Class<?> clazz) throws FileNotFoundException {
		try (PrintWriter sourceWriter = new PrintWriter(sources); PrintWriter sinkWriter = new PrintWriter(sinks)) {
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.getName().startsWith("set")) {
					printSignature(sinkWriter, clazz, m);
				} else if (m.getName().startsWith("get")) {
					printSignature(sourceWriter, clazz, m);
				}
			}
		}
	}

	private static void printSignature(PrintWriter sinkWriter, Class<?> clazz, Method m) {
		sinkWriter.print("<");
		sinkWriter.print(clazz.getName());
		sinkWriter.print(": ");
		sinkWriter.print(m.getReturnType().getName());
		sinkWriter.print(' ');
		sinkWriter.print(m.getName());
		sinkWriter.print("(");
		Class<?>[] params = m.getParameterTypes();
		if (params.length > 0) {
			sinkWriter.print(params[0].getName());
			if (params.length > 1) {
				for (int i = 1; i < params.length; i++) {
					sinkWriter.print(",");
					sinkWriter.print(params[i].getName());
				}
			}
		}
		sinkWriter.println(")>");
	}
}
