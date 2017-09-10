/**
 * Title: NumberUtils.java
 * Description: 
 * CopyRight: CopyRight © 
 * @author Shawn_Hou
 * 2017年8月23日 下午11:42:05
 */
package cn.spirithone.common.util;

/**
 *
 * @author Shawn_Hou
 * 2017年8月23日 下午11:42:05
 * 
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils{
	/**
	 * 如果给定Byte对象为null或值为0，返回true，否则返回false
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNullOrZero(Byte value){
		if(value == null || BYTE_ZERO.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 如果给定Byte对象为null或值为0，返回false，否则返回true。
	 * 此方法与 isNullOrZero(Byte value) 相对。
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNotNullOrZero(Byte value){
		return !isNullOrZero(value);
	}
	/**
	 * 如果给定Short对象为null或值为0，返回true，否则返回false
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNullOrZero(Short value){
		if(value == null || SHORT_ZERO.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 如果给定Short对象为null或值为0，返回false，否则返回true。
	 * 此方法与 isNullOrZero(Short value) 相对。
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNotNullOrZero(Short value){
		return !isNullOrZero(value);
	}
	/**
	 * 如果给定Integer对象为null或值为0，返回true，否则返回false
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNullOrZero(Integer value){
		if(value == null || INTEGER_ZERO.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 如果给定Integer对象为null或值为0，返回false，否则返回true。
	 * 此方法与 isNullOrZero(Integer value) 相对。
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNotNullOrZero(Integer value){
		return !isNullOrZero(value);
	}
	
	/**
	 * 如果给定Long对象为null或值为0，返回true，否则返回false
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNullOrZero(Long value){
		if(value == null || LONG_ZERO.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 如果给定Long对象为null或值为0，返回false，否则返回true。
	 * 此方法与 isNullOrZero(Long value) 相对。
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNotNullOrZero(Long value){
		return !isNullOrZero(value);
	}
	/**
	 * 如果给定Float对象为null或值为0，返回true，否则返回false
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNullOrZero(Float value){
		if(value == null || FLOAT_ZERO.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 如果给定Float对象为null或值为0，返回false，否则返回true。
	 * 此方法与 isNullOrZero(Float value) 相对。
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNotNullOrZero(Float value){
		return !isNullOrZero(value);
	}
	/**
	 * 如果给定Long对象为null或值为0，返回true，否则返回false
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNullOrZero(Double value){
		if(value == null || DOUBLE_ZERO.equals(value)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 如果给定Double对象为null或值为0，返回false，否则返回true。
	 * 此方法与 isNullOrZero(Double value) 相对。
	 * @param value
	 * @return true 或 false
	 */
	public static boolean isNotNullOrZero(Double value){
		return !isNullOrZero(value);
	}
	
	public static short toShort(Byte _byte){
		return toShort(_byte, (short)0);
	}
	
	public static short toShort(Byte _byte, short defaultValue){
		if(_byte == null){
			return defaultValue;
		}
		return _byte.shortValue();
	}
	
	public static int toInt(Byte _byte){
		return toInt(_byte, 0);
	}
	
	public static int toInt(Byte _byte, int defaultValue){
		if(_byte == null){
			return defaultValue;
		}
		return _byte.intValue();
	}
	
	public static int toInt(Short _short){
		return toInt(_short, 0);
	}
	
	public static int toInt(Short _short, int defaultValue){
		if(_short == null){
			return defaultValue;
		}
		return _short.intValue();
	}
	
	public static long toLong(Byte _byte){
		return toLong(_byte, 0L);
	}
	
	private static long toLong(Byte _byte, long defaultValue) {
		if(_byte == null){
			return defaultValue;
		}
		return _byte.longValue();
	}
	
	public static long toLong(Short _short){
		return toLong(_short, 0L);
	}
	/**
	 * @param _short
	 * @param defaultValue
	 * @return
	 */
	public static long toLong(Short _short, long defaultValue) {
		if(_short == null){
			return defaultValue;
		}
		return _short.longValue();
	}
	
	public static long toLong(Integer _int){
		return toLong(_int, 0L);
	}
	/**
	 * @param _int
	 * @param defaultValue
	 * @return
	 */
	public static long toLong(Integer _int, long defaultValue) {
		if(_int == null){
			return defaultValue;
		}
		return _int.longValue();
	}
	
	public static float toFloat(Byte _byte){
		return toFloat(_byte, 0F);
	}
	/**
	 * @param _byte
	 * @param defaultValue
	 * @return
	 */
	public static float toFloat(Byte _byte, float defaultValue) {
		if(_byte == null){
			return defaultValue;
		}
		return _byte.floatValue();
	}
	
	public static float toFloat(Short _short){
		return toFloat(_short, 0F);
	}
	/**
	 * @param _short
	 * @param defaultValue
	 * @return
	 */
	public static float toFloat(Short _short, float defaultValue) {
		if(_short == null){
			return defaultValue;
		}
		return _short.floatValue();
	}
	public static float toFloat(Integer _int){
		return toFloat(_int, 0F);
	}
	/**
	 * @param _byte
	 * @param defaultValue
	 * @return
	 */
	public static float toFloat(Integer _int, float defaultValue) {
		if(_int == null){
			return defaultValue;
		}
		return _int.floatValue();
	}
	public static float toFloat(Long _long){
		return toFloat(_long, 0F);
	}
	/**
	 * @param _byte
	 * @param defaultValue
	 * @return
	 */
	public static float toFloat(Long _long, float defaultValue) {
		if(_long == null){
			return defaultValue;
		}
		return _long.floatValue();
	}
	public static double toDouble(Byte _byte){
		return toDouble(_byte, 0D);
	}
	/**
	 * @param _byte
	 * @param defaultValue
	 * @return
	 */
	public static double toDouble(Byte _byte, double defaultValue) {
		if(_byte == null){
			return defaultValue;
		}
		return _byte.doubleValue();
	}
	
	public static double toDouble(Short _short){
		return toDouble(_short, 0D);
	}
	/**
	 * @param _short
	 * @param defaultValue
	 * @return
	 */
	public static double toDouble(Short _short, double defaultValue) {
		if(_short == null){
			return defaultValue;
		}
		return _short.doubleValue();
	}
	
	public static double toDouble(Integer _int){
		return toDouble(_int, 0D);
	}
	/**
	 * @param _int
	 * @param defaultValue
	 * @return
	 */
	public static double toDouble(Integer _int, double defaultValue) {
		if(_int == null){
			return defaultValue;
		}
		return _int.doubleValue();
	}
	
	public static double toDouble(Long _long){
		return toDouble(_long, 0D);
	}
	/**
	 * @param _long
	 * @param defaultValue
	 * @return
	 */
	public static double toDouble(Long _long, double defaultValue) {
		if(_long == null){
			return defaultValue;
		}
		return _long.doubleValue();
	}
	
	public static double toDouble(Float _float){
		return toDouble(_float, 0D);
	}
	/**
	 * @param _float
	 * @param defaultValue
	 * @return
	 */
	public static double toDouble(Float _float, double defaultValue) {
		if(_float == null){
			return defaultValue;
		}
		return _float.doubleValue();
	}
	
	
}
