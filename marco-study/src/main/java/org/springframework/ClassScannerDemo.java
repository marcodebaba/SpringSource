package org.springframework;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 类描述
 * Author: Marco.Pan
 * Version: 1.0
 * Date: 2026年04月11日 22:09
 */
public class ClassScannerDemo {
	public static void main(String[] args) throws Exception {
		String basePackage = "org.springframework.beans"; // 你要扫描的包
		List<String> classNames = scanClassNames(basePackage);

		for (String className : classNames) {
			System.out.println(className);
		}
	}

	/**
	 * 扫描包下的 class 名称（不触发 Class.forName，不加载类）
	 */
	public static List<String> scanClassNames(String basePackage) throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
		Path classesRoot = Paths.get("marco-study", "build", "classes", "java", "main").toAbsolutePath().normalize();
		String classesRootUri = classesRoot.toUri().toString();
		if (!classesRootUri.endsWith("/")) {
			classesRootUri = classesRootUri + "/";
		}

		String packageSearchPattern = classesRootUri
				+ ClassUtils.convertClassNameToResourcePath(basePackage)
				+ "/**/*.class";

		Resource[] resources = resolver.getResources(packageSearchPattern);

		List<String> result = new ArrayList<>();
		for (Resource resource : resources) {
			if (!resource.isReadable()) {
				continue;
			}

			MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
			boolean hasServiceAnnotation =
					metadataReader.getAnnotationMetadata().hasAnnotation(Service.class.getName());
			if (hasServiceAnnotation) {
				result.add(metadataReader.getClassMetadata().getClassName());
			}
		}
		return result;
	}
}
