package org.springframework.beans;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * TODO: 类描述
 *
 * @author marco.pan
 * @version 1.0
 * @date 2026年03月28日 23:07
 */
public class MyConfig {
	public static void main(String[] args) throws IOException {
		SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
		MetadataReader metadataReader = metadataReaderFactory.getMetadataReader("org.springframework.beans.OrderService");

		ClassMetadata metadata = metadataReader.getClassMetadata();
		System.out.println(metadata.getClassName());

		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		annotationMetadata.getAnnotationTypes().forEach(System.out::println);

		System.out.println(annotationMetadata.hasAnnotation(Service.class.getName()));
	}
}