package com.alearner.common;

/**
 * Created by mzg on 2018/7/10.
 */
public class ErrorStatus {
    public static final Integer SUCCESS = Integer.valueOf(0);
    public static final Integer SERVER_INTERNAL_ERROR = Integer.valueOf(1);
    public static final Integer USER_NOT_EXIST = Integer.valueOf(2);
    public static final Integer BAD_REQUEST = Integer.valueOf(3);
    public static final Integer UNAUTHORIZED = Integer.valueOf(4);
    public static final Integer TOKEN_EXPIRED = Integer.valueOf(5);
    public static final Integer TRANS_DATA_ERROR = Integer.valueOf(101);
    public static final Integer APP_SCHEMA_NOT_FOUND = 101001;
    public static final Integer APP_SCHEMA_INVALID = 101002;
    public static final Integer APP_SCHEMA_UNSUPPORT_DATASOURCE = 101003;
    public static final Integer APP_POST_DS_NOT_SUPPORT = 101004;
    public static final Integer APP_POST_UNKNOWN_TABLE = 101005;
    public static final Integer APP_POST_COLUMN_NOT_FOUND = 101006;
    public static final Integer APP_POST_UNEXPECT_COLUMN_TYPE = 101007;
    public static final Integer APP_POST_COLUMN_SIZE_NOT_SAME = 101008;
    public static final Integer APP_TRANSFORM_READ_VALUE_ERROR = 101009;
    public static final Integer APP_DATASOURCE_EMPTY = 101010;

    private ErrorStatus() {
    }
}
