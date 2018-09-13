package com.jetblue.api.constant;

import org.apache.commons.lang3.StringUtils;

public final class AppConstant {

	
	public static String MASTER_KEY =
            System.getProperty("ACCOUNT_KEY", 
                    StringUtils.defaultString(StringUtils.trimToNull(
                            System.getenv().get("ACCOUNT_KEY")),
                            "KZbQ5mRdh4YxTnSdBXWia5GsmNSF8C8k1RzsdfOF012GlQ3xIO4NJn0BjkVLkwz6GIk2A9FCM83Fil9mZLfWcg=="));

    public static String HOST =
            System.getProperty("ACCOUNT_HOST",
                    StringUtils.defaultString(StringUtils.trimToNull(
                            System.getenv().get("ACCOUNT_HOST")),
                            "https://airport-fetcher.documents.azure.com:443/"));
	
}
