/**
 * 
 */
package smartkv.client.util;

import java.util.List;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Shorts;


/**
 * @author fabiim
 *
 */
public interface Serializer<T> {
	
	public static enum SerialNum{
		INT (Serializer.INT),
		UNSAFE (UnsafeJavaSerializer.getInstance()), 
		STRING(Serializer.STRING),
		SHORT(Serializer.SHORT); 
		
		public final Serializer serial; 
		SerialNum(Serializer o){
			this.serial =o; 
		}
	}
	

	public static  Serializer<Long> LONG = new Serializer<Long>(){

		@Override
		public byte[] serialize(Long obj) {
			return Longs.toByteArray(obj);
		}

		@Override
		public Long deserialize(byte[] bytes) {
			return Longs.fromByteArray(bytes); 
		}
		
	};
	
	public static Serializer<String> STRING = new Serializer<String>(){

		@Override
		public byte[] serialize(String obj) {
			return obj.getBytes();
		}

		@Override
		public String deserialize(byte[] bytes) {
			return new String(bytes); 
		}
		
	};

	public static Serializer<Short> SHORT = new Serializer<Short>(){

		@Override
		public byte[] serialize(Short v) {
			return Shorts.toByteArray(v);
		}

		@Override
		public Short deserialize(byte[] bytes) {
			return Shorts.fromByteArray(bytes); 
		}
		
	};
	
	public static Serializer<Integer> INT = new Serializer<Integer>(){

		@Override 
		public byte[] serialize(Integer v) {
			return Ints.toByteArray(v);
		}

		@Override
		public Integer deserialize(byte[] bytes) {
			return Ints.fromByteArray(bytes); 
		}
		
	};
	
	
	public byte[] serialize(T obj);
	public T deserialize(byte[] bytes); 
}
