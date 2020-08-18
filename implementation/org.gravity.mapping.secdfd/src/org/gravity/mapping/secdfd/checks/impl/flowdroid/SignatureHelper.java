package org.gravity.mapping.secdfd.checks.impl.flowdroid;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.gravity.typegraph.basic.BasicPackage;
import org.gravity.typegraph.basic.TAbstractType;
import org.gravity.typegraph.basic.TMember;
import org.gravity.typegraph.basic.TMethodDefinition;
import org.gravity.typegraph.basic.TMethodSignature;
import org.gravity.typegraph.basic.TParameter;
import org.gravity.typegraph.basic.TypeGraph;

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
		if (!method.getTAnnotation(BasicPackage.eINSTANCE.getTConstructor()).isEmpty()) {
			return "";
		}
		StringBuilder buffer = new StringBuilder("<");
		buffer.append(method.getDefinedBy().getFullyQualifiedName());
		buffer.append(": ");
		buffer.append(method.getReturnType().getFullyQualifiedName());
		if (method.isArray()) {
			buffer.append("[]");
		}
		buffer.append(' ');
		buffer.append(method.getSignature().getMethod().getTName());
		buffer.append('(');
		TParameter param = method.getSignature().getFirstParameter();
		while (param != null) {
			buffer.append(param.getType().getFullyQualifiedName());
			if (param.isArray()) {
				buffer.append("[]");
			}
			TParameter next = param.getNext();
			if (next != null) {
				buffer.append(',');
			}
			param = next;
		}
		buffer.append(")>");
		return buffer.toString();
	}
	
	public static TMethodDefinition getDefinition(TypeGraph pm, String sootSignature) {
		if(!sootSignature.startsWith("<") || !sootSignature.endsWith(">")) {
			throw new IllegalArgumentException("Not a soot signature");
		}
		
		int colonIndex = sootSignature.indexOf(':');
		if (colonIndex == -1) {
			throw new IllegalArgumentException("Not a soot signature");
		}
		String definingClassName = sootSignature.substring(1, colonIndex).trim();
		TAbstractType definingClass = pm.getType(definingClassName);
		if(definingClass == null) {
			return null;
		}
		
		String sootDefinitionString = sootSignature.substring(colonIndex + 1, sootSignature.length() - 1).trim();
		String[] split = sootDefinitionString.split("\\s+");
		if( split.length != 2) {
			throw new IllegalArgumentException("Not a soot signature");
		}
		int openIndex = split[1].indexOf('(');
		if (openIndex == -1) {
			throw new IllegalArgumentException("Not a soot signature");
		}
		String methodName = split[1].substring(0, openIndex).trim();
		String[] parameters;
		String parameterList = split[1].substring(openIndex + 1, split[1].length() - 1);
		if (parameterList.isEmpty()) {
			parameters = new String[0];
		} else {
			parameters = parameterList.split(",\\s*");
		}
		
		for (TMember definition : definingClass.getDefines()) {
			if (definition instanceof TMethodDefinition) {
				TMethodSignature signature = ((TMethodDefinition) definition).getSignature();
				if (signature.getMethod().getTName().equals(methodName)
						&& parameters.length == signature.getParameters().size()) {
					boolean equal = true;
					TParameter current = signature.getFirstParameter();
					for(String paramType : parameters) {
						if(current.getType().getFullyQualifiedName().endsWith(paramType)) {
							current = current.getNext();
						}
						else {
							equal = false;
							break;
						}
					}
					if(equal) {
						return (TMethodDefinition) definition;
					}
				}
			}
		}
		return definingClass.getTMethodDefinition(split[1]+':'+split[0]);
	}
}
