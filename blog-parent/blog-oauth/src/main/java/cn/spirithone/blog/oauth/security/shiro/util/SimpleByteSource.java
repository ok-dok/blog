package cn.spirithone.blog.oauth.security.shiro.util;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.util.ByteSource;

/**
 * 原本在Realm中使用的org.apache.util.SimpleByteSource类，由于没有实现序列化接口，
 * 导致无法使用ehcache缓存，报错java.io.NotSerializableException:
 * org.apache.shiro.util.SimpleByteSource
 * 所以必须实现序列化接口，才可以使用集成缓存，实现序列化。如果仅仅实现序列接口，SimpleByteSource没有默认构造方法，导致在反序列化时失败，
 * 报错：java.io.InvalidClassException: no valid constructor，所以必须提供默认的构造方法，
 * 然而在org.apache.util.SimpleByteSource类中有 private final byte[] bytes;
 * 所以直接继承该类并实现Serializable接口，默认构造方法会出错，提示bytes没有初始化赋值，因此，只能够仿照该类，重新构造一个与该类功能一致的类，
 * 实现ByteSouce,Serializable接口，并添加默认构造方法，将属性bytes变量的final声明移除。
 * Shiro在登陆超时后重新登陆时，会从缓存中进行认证，而不是去查询数据库，因此，此时会调用缓存中的序列化数据进行反序列化操作，而此时就将触发上述的问题。
 * 
 * @author Shawn_Hou 2017年5月4日 下午1:50:39
 *
 */
public class SimpleByteSource implements ByteSource, Serializable {
	private static final long serialVersionUID = 2758795907917526798L;
	private byte[] bytes;
	private String cachedHex;
	private String cachedBase64;

	public SimpleByteSource() {
	}

	public SimpleByteSource(byte[] bytes) {
		this.bytes = bytes;
	}

	public SimpleByteSource(char[] chars) {
		this.bytes = CodecSupport.toBytes(chars);
	}

	public SimpleByteSource(String string) {
		this.bytes = CodecSupport.toBytes(string);
	}

	public SimpleByteSource(ByteSource source) {
		this.bytes = source.getBytes();
	}

	public SimpleByteSource(File file) {
		this.bytes = new BytesHelper().getBytes(file);
	}

	public SimpleByteSource(InputStream stream) {
		this.bytes = new BytesHelper().getBytes(stream);
	}

	public static boolean isCompatible(Object o) {
		return ((o instanceof byte[]) || (o instanceof char[]) || (o instanceof String) || (o instanceof ByteSource)
				|| (o instanceof File) || (o instanceof InputStream));
	}

	public byte[] getBytes() {
		return this.bytes;
	}

	public boolean isEmpty() {
		return ((this.bytes == null) || (this.bytes.length == 0));
	}

	public String toHex() {
		if (this.cachedHex == null) {
			this.cachedHex = Hex.encodeToString(getBytes());
		}
		return this.cachedHex;
	}

	public String toBase64() {
		if (this.cachedBase64 == null) {
			this.cachedBase64 = Base64.encodeToString(getBytes());
		}
		return this.cachedBase64;
	}

	public String toString() {
		return toBase64();
	}

	public int hashCode() {
		if ((this.bytes == null) || (this.bytes.length == 0)) {
			return 0;
		}
		return Arrays.hashCode(this.bytes);
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof ByteSource) {
			ByteSource bs = (ByteSource) o;
			return Arrays.equals(getBytes(), bs.getBytes());
		}
		return false;
	}

	private static final class BytesHelper extends CodecSupport {
		public BytesHelper() {
		}

		public byte[] getBytes(File file) {
			return toBytes(file);
		}

		public byte[] getBytes(InputStream stream) {
			return toBytes(stream);
		}
	}
}