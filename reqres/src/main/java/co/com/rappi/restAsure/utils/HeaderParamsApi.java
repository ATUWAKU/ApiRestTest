package co.com.rappi.restAsure.utils;

import static co.com.rappi.restAsure.utils.Constants.CONTENTTYPE;
import static co.com.rappi.restAsure.utils.Constants.CONTENTTYPE_VALUE;

public enum HeaderParamsApi {

    CONTENT_TYPE_JSON(CONTENTTYPE,CONTENTTYPE_VALUE);

    private String key;
    private String value;

    HeaderParamsApi(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
