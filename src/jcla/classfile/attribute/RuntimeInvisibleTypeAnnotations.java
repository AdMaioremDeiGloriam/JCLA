package jcla.classfile.attribute;

import jcla.classfile.ConstantPool;
import jcla.classfile.struct.AttributeInfo;
import jcla.classfile.struct.TypeAnnotation;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author link
 */
public final class RuntimeInvisibleTypeAnnotations extends AttributeInfo {

	private final TypeAnnotation[] annotations;

	public RuntimeInvisibleTypeAnnotations(DataInput in, ConstantPool owner) throws IOException {
		super(in, owner);
		annotations = new TypeAnnotation[in.readUnsignedShort()];
		for (int i = 0; i < annotations.length; i++) {
			annotations[i] = new TypeAnnotation(in, owner);
		}
	}

	public RuntimeInvisibleTypeAnnotations(int nameIndex, int length, DataInput in, ConstantPool owner) throws IOException {
		super(nameIndex, length, owner);
		annotations = new TypeAnnotation[in.readUnsignedShort()];
		for (int i = 0; i < annotations.length; i++) {
			annotations[i] = new TypeAnnotation(in, owner);
		}
	}

	public TypeAnnotation[] getAnnotations() {
		return annotations;
	}

	@Override
	public byte[] getInfo() {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream(8 + annotations.length * 6);
		DataOutputStream      out   = new DataOutputStream(bytes);
		try {
			out.writeShort(name);
			out.writeInt(length);
			out.writeShort(annotations.length);

			for(TypeAnnotation annotation : annotations) {
				out.write(annotation.toBytes());
			}
		} catch (IOException e) {
			// ignore
		}

		return bytes.toByteArray();
	}

}
