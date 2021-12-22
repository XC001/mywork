package com.netflix.zuul;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class HttpZuulFilterDaoBuilder implements IZuulFilterDaoBuilder {

	private static final DynamicStringProperty appName = DynamicPropertyFactory.getInstance()
			.getStringProperty(Constants.DEPLOYMENT_APPLICATION_ID, Constants.APPLICATION_NAME);

	public HttpZuulFilterDaoBuilder() {

	}

	@Override
	public IZuulFilterDao build() {
		return new HttpZuulFilterDao(appName.get());

	}

}
