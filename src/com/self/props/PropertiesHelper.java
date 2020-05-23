package com.self.props;

import java.util.ResourceBundle;

/*Singleton Pattern implemented in Properties Helper
Properties Helper used to get the appconfig using Resource Bundle.. JavaApi > util > resource bundle
note for future reference: do not forget to add config folder --> buildPath > source > add folder*/

public class PropertiesHelper {

	private static PropertiesHelper instance = null;
	ResourceBundle bundle = null;

	private PropertiesHelper() {
		bundle = ResourceBundle.getBundle("appconfig");
	}

	public static PropertiesHelper getinstance() {

		if (instance == null) {
			instance = new PropertiesHelper();
		}
		System.out.println(instance);
		return instance;
	}

	public String getProperty(String key) {
		return bundle.getString(key);
	}
}
