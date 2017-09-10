package cn.spirithone.blog.core.hibernate.naming;

import java.io.Serializable;
import java.util.Locale;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl implements Serializable {

	private static final long serialVersionUID = -7887200980084818474L;
	public static final PhysicalNamingStrategyImpl INSTANCE = new PhysicalNamingStrategyImpl();
	private static String tablePrefix = "";
	 @Override
	 public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
	     return new Identifier(tablePrefix + addUnderscores(name.getText()), name.isQuoted());
	 }

	 @Override
	 public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
	     return new Identifier(addUnderscores(name.getText()), name.isQuoted());
	 }


	 protected static String addUnderscores(String name) {
	     final StringBuilder buf = new StringBuilder( name.replace('.', '_') );
	     for (int i=1; i<buf.length()-1; i++) {
	        if (
	             Character.isLowerCase( buf.charAt(i-1) ) &&
	             Character.isUpperCase( buf.charAt(i) ) &&
	             Character.isLowerCase( buf.charAt(i+1) )
	         ) {
	             buf.insert(i++, '_');
	         }
	     }
	     return buf.toString().toLowerCase(Locale.ROOT);
	 }

	public static String getTablePrefix() {
		return tablePrefix;
	}

	public static void setTablePrefix(String tablePrefix) {
		PhysicalNamingStrategyImpl.tablePrefix = tablePrefix;
	}
}