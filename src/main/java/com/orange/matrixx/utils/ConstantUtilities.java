package com.orange.matrixx.utils;

import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.matrixx.constants.ConfigurationConstants;

public class ConstantUtilities {
	public static void loadConstants() {
		ResourceBundle rb = ResourceBundle.getBundle("application");
		ConfigurationConstants.bootStrapServer = rb.getString("bootstrapservers");
		if (ConfigurationConstants.mapper == null) {
			ConfigurationConstants.mapper = new ObjectMapper();
		}
		ConfigurationConstants.consumerTopicName = rb.getString("consumer_topic_name");
		ConfigurationConstants.producerTopicName = rb.getString("producer_topic_name");
	}
}
