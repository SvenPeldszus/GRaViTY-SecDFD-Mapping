package org.gravity.flowdroid;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TParameter;

/**
 * This class provides functions to create signatures in the soot format
 * 
 * @author speldszus
 *
 */
public final class SignatureHelper {
	
	private SignatureHelper() {
		// This class should not be instantiated 
	}

	public static String getSootSignature(Method method) {
		StringBuilder buffer = new StringBuilder("<");
		buffer.append(method.getDeclaringClass().getName());
		buffer.append(": ");
		buffer.append(method.getReturnType().getName());
		buffer.append(' ');
		buffer.append(method.getName());
		buffer.append('(');
		buffer.append(Stream.of(method.getParameterTypes()).map(Class::getName).collect(Collectors.joining(",")));
		buffer.append(")>");
		return buffer.toString();
	}

	public static String getSootSignature(TMethodDefinition method) {
		if(!method.getTAnnotation(BasicPackage.eINSTANCE.getTConstructor()).isEmpty()){
			return "";
		}
		StringBuilder buffer = new StringBuilder("<");
		buffer.append(method.getDefinedBy().getFullyQualifiedName());
		buffer.append(": ");
		buffer.append(method.getReturnType().getFullyQualifiedName());
		if(method.isArray()) {
			buffer.append("[]");
		}
		buffer.append(' ');
		buffer.append(method.getSignature().getMethod().getTName());
		buffer.append('(');
		TParameter param = method.getSignature().getFirstParameter();
		while(param != null) {
			buffer.append(param.getType().getFullyQualifiedName());
			if(param.isArray()) {
				buffer.append("[]");
			}
			TParameter next = param.getNext();
			if(next!=null) {
				buffer.append(',');
			}
			param = next;
		}
		buffer.append(")>");
		return buffer.toString();
	}

}
