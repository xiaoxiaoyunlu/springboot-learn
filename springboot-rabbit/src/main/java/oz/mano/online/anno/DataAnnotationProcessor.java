package oz.mano.online.anno;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.squareup.javawriter.JavaWriter;

public class DataAnnotationProcessor extends AbstractProcessor {

	private Messager messager; // 用于打印日志
	private Elements elementUtils; // 用于处理元素
	private Filer filer; // 用于创建java 或 class 文件

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> set = new HashSet<>();
		set.add(Data.class.getCanonicalName());
		return Collections.unmodifiableSet(set);
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		// TODO Auto-generated method stub
		super.init(processingEnv);
		messager = processingEnv.getMessager();
		elementUtils = processingEnv.getElementUtils();
		filer = processingEnv.getFiler();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		messager.printMessage(Diagnostic.Kind.NOTE, "-----------开始自动生成源代码");
		try {
			boolean isClass = false;
			// 类的全限定名
			String classAllName = null;
			Set<? extends Element> elements = roundEnv
					.getElementsAnnotatedWith(Data.class);
			Element element = null;
			for (Element e : elements) {
				// 如果注解在类上
				if (e.getKind() == ElementKind.CLASS
						&& e instanceof TypeElement) {
					TypeElement t = (TypeElement) e;
					isClass = true;
					classAllName = t.getQualifiedName().toString();
					element = t;
					break;
				}
			}

			// 未在类上使用注解，则返回false 停止编译
			if (!isClass) {
				return true;
			}

			// 返回类上的所有节点
			List<? extends Element> enclosedElements = element
					.getEnclosedElements();
			HashMap<TypeMirror, Name> fieldMap = new HashMap<TypeMirror, Name>();
			for (Element ele : enclosedElements) {
				if (ele.getKind() == ElementKind.FIELD) {
					// 字段类型
					TypeMirror typeMirror = ele.asType();

					// 字段名称
					Name simpleName = ele.getSimpleName();
					fieldMap.put(typeMirror, simpleName);
				}
			}

			// 生成一个java源文件
			JavaFileObject sourceFile = filer
					.createSourceFile(getClassName(classAllName));

			// 写入代码
			createSourceFile(classAllName, fieldMap, sourceFile.openWriter());
			// 手动编译
			Compiler(sourceFile.toUri().getPath());

		} catch (IOException e) {
			messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage());
		}
		messager.printMessage(Diagnostic.Kind.NOTE, "-----完成自动生成源代码");
		return true;
	}

	/**
	 * 编译文件
	 * @param path
	 * @throws IOException 
	 */
	private void Compiler(String path) throws IOException {
		// TODO Auto-generated method stub
        // 拿到 编译器
		JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
		// 获取文件管理器
	    StandardJavaFileManager fileMgr = complier.getStandardFileManager(null,null,null);
	    //获取文件
	    Iterable<? extends JavaFileObject> units = fileMgr.getJavaFileObjects(path);
	    //编译任务
	    CompilationTask task = complier.getTask(null, fileMgr, null,null,null,units);
	    task.call();
	    fileMgr.close();
	}

	private void createSourceFile(String classAllName,
			HashMap<TypeMirror, Name> fieldMap, Writer openWriter)
			throws IOException {
		JavaWriter jw = new JavaWriter(openWriter);
		jw.emitPackage(getPackage(classAllName));

		jw.beginType(getClassName(classAllName), "class",
				EnumSet.of(Modifier.PUBLIC));
		for (Map.Entry<TypeMirror, Name> map : fieldMap.entrySet()) {
			String type = map.getKey().toString();
			String name = map.getValue().toString();
			// 字段
			jw.emitField(type, name, EnumSet.of(Modifier.PRIVATE));
		}
		for (Map.Entry<TypeMirror, Name> map : fieldMap.entrySet()) {
			String type = map.getKey().toString();
			String name = map.getValue().toString();
			// getter
			jw.beginMethod(type, "get" + humpString(name),
					EnumSet.of(Modifier.PUBLIC))
					.emitStatement("return " + name).endMethod();
			// setter
			jw.beginMethod("void", "set" + humpString(name),
					EnumSet.of(Modifier.PUBLIC), type, "arg")
					.emitStatement("this." + name + " = arg").endMethod();
		}
		jw.endType().close();

	}

	/**
	 * 驼峰命名
	 *
	 * @param name
	 * @return
	 */
	private String humpString(String name) {
		String result = name;
		if (name.length() == 1) {
			result = name.toUpperCase();
		}
		if (name.length() > 1) {
			result = name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		return result;
	}

	/**
	 * 读取类名
	 * 
	 * @param name
	 * @return
	 */
	private String getClassName(String name) {
		String result = name;
		if (name.contains(".")) {
			result = name.substring(name.lastIndexOf(".") + 1);
		}
		return result;
	}

	/**
	 * 读取包名
	 * 
	 * @param name
	 * @return
	 */
	private String getPackage(String name) {
		String result = name;
		if (name.contains(".")) {
			result = name.substring(0, name.lastIndexOf("."));
		} else {
			result = "";
		}
		return result;
	}

}
