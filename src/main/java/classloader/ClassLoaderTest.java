package classloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class ClassLoaderTest {
	static class FileSelector implements FilenameFilter {
		String extension;
		FileSelector(String extension) {
			this.extension = extension;
		}
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(extension);
		}
	}
	public static File[] getFiles(String selector, String path) {
		File dir = new File(path);
		return dir.listFiles(new FileSelector(selector));
	}
	static class MyClassLoader extends URLClassLoader {
		public MyClassLoader(URL[] urls, ClassLoader parent) {
			super(urls, parent);
		}
		public void addJar(URL url) {
			this.addURL(url);
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		URL[] urls = new URL[] {};
		MyClassLoader classLoader = new MyClassLoader(urls, null);
		try {
			Scanner in = new Scanner(new BufferedInputStream(System.in));
			File[] files = getFiles(".jar", in.next());
			for(File file : files) {
				classLoader.addJar(file.toURI().toURL());
			}
			Class<?> cl = classLoader.loadClass("java_learning.TestRegex");
			Class<?> cl2 = classLoader.loadClass("Cc.Print");
			Method method = cl.getDeclaredMethod("testRegex", String.class);
			Method method2 = cl2.getDeclaredMethod("print", Object.class);

			while(in.hasNext()) {
				method2.invoke(null, method.invoke(null, in.next()));
			}
			classLoader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
