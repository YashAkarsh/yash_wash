package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import easypay.appinvoke.manager.Constants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ERR_MODULE_UNSTARTED' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class uSDKErrorConst {
    private static final /* synthetic */ uSDKErrorConst[] $VALUES;
    public static final uSDKErrorConst ERR_INTERNAL;
    public static final uSDKErrorConst ERR_MODULE_STOPPED;
    public static final uSDKErrorConst ERR_MODULE_UNSTARTED;
    public static final uSDKErrorConst ERR_USDK_ALREADY_STOPPED;
    public static final uSDKErrorConst ERR_USDK_APPID_APPKEY_NULL;
    public static final uSDKErrorConst ERR_USDK_BIND_CODE_FAILED;
    public static final uSDKErrorConst ERR_USDK_BIND_DEVICE_IS_CANCELED;
    public static final uSDKErrorConst ERR_USDK_BIND_DEVICE_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND;
    public static final uSDKErrorConst ERR_USDK_BLE_CHARACTERISTICS_NOT_FOUND;
    public static final uSDKErrorConst ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE;
    public static final uSDKErrorConst ERR_USDK_BLE_IS_POWER_OFF;
    public static final uSDKErrorConst ERR_USDK_BLE_NOT_OPEN;
    public static final uSDKErrorConst ERR_USDK_BLE_OPERATION_NOT_SUPPORT;
    public static final uSDKErrorConst ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST;
    public static final uSDKErrorConst ERR_USDK_CAMERA_SDK_COMMON_ERROR;
    public static final uSDKErrorConst ERR_USDK_CLOUD_COMMON_ERROR;
    public static final uSDKErrorConst ERR_USDK_CLOUD_OFFLINE;
    public static final uSDKErrorConst ERR_USDK_CONFIG_BE_CANCELED;
    public static final uSDKErrorConst ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID;
    public static final uSDKErrorConst ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE;
    public static final uSDKErrorConst ERR_USDK_CREATE_SECURITY_SDK_BIND_CLASS_FAIL;
    public static final uSDKErrorConst ERR_USDK_CURRENT_SSID_IS_NOT_IOT;
    public static final uSDKErrorConst ERR_USDK_DEVICE_ALREADY_CONNECTED;
    public static final uSDKErrorConst ERR_USDK_DEVICE_AUTHORIZE_ERROR;
    public static final uSDKErrorConst ERR_USDK_DEVICE_AUTHORIZE_INVALID_ERROR;
    public static final uSDKErrorConst ERR_USDK_DEVICE_BIND_FAILED;
    public static final uSDKErrorConst ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_CONFIG_IN_PROGRESS;
    public static final uSDKErrorConst ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD;
    public static final uSDKErrorConst ERR_USDK_DEVICE_IS_BUSY;
    public static final uSDKErrorConst ERR_USDK_DEVICE_IS_IN_BINDING;
    public static final uSDKErrorConst ERR_USDK_DEVICE_IS_NOT_BOUND;
    public static final uSDKErrorConst ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_IS_NOT_IN_BINDING;
    public static final uSDKErrorConst ERR_USDK_DEVICE_IS_OFFLINE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_LOCAL_EXIST_AND_GET_BIND_RESULT_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT;

    @Deprecated
    public static final uSDKErrorConst ERR_USDK_DEVICE_NEED_TRIGGER_CONFIG;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_CONNECT;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_CONNECTED;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_CONNECT_ROUTER_CAUSE_OFFLINE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_FOUND;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_GET_NETQUALITY;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_IN_OTA_MODE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_LOCAL;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_NETQUALITY;
    public static final uSDKErrorConst ERR_USDK_DEVICE_NOT_SUPPORT_GROUP;
    public static final uSDKErrorConst ERR_USDK_DEVICE_OTA_INTERRUPTED;
    public static final uSDKErrorConst ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL;
    public static final uSDKErrorConst ERR_USDK_DEVICE_QUERY_AUTHORIZE_STATUS_FAILURE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_READ_ATTR;
    public static final uSDKErrorConst ERR_USDK_DEVICE_REMOTE_STATE_NOT_READY;
    public static final uSDKErrorConst ERR_USDK_DEVICE_SCANNER_LISTENER_NOT_REGIST;
    public static final uSDKErrorConst ERR_USDK_DEVICE_SCANNING;
    public static final uSDKErrorConst ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE;
    public static final uSDKErrorConst ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR;
    public static final uSDKErrorConst ERR_USDK_DEVICE_UPLUSID_INVALID;
    public static final uSDKErrorConst ERR_USDK_DEVICE_UPLUSID_NOT_MATCH;
    public static final uSDKErrorConst ERR_USDK_DEVICE_VERIFY_FAILED;
    public static final uSDKErrorConst ERR_USDK_DEVICE_VERIFY_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_DONT_NEED_FOTA;
    public static final uSDKErrorConst ERR_USDK_DONT_NEED_OTA;
    public static final uSDKErrorConst ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_FEATURE_NOT_SUPPORT;
    public static final uSDKErrorConst ERR_USDK_FOTA_INFO_IS_NULL;
    public static final uSDKErrorConst ERR_USDK_GATEWAY_IS_CONNECTED;
    public static final uSDKErrorConst ERR_USDK_GET_BINDINFO_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_GET_BIND_RESULT_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_GROUP_DEVICE_CAN_NOT_CREATE_GROUP;
    public static final uSDKErrorConst ERR_USDK_GROUP_IS_OPERATING;
    public static final uSDKErrorConst ERR_USDK_HTTP_DNS_ERROR;
    public static final uSDKErrorConst ERR_USDK_INVALID_COMMAND;
    public static final uSDKErrorConst ERR_USDK_INVALID_PARAM;
    public static final uSDKErrorConst ERR_USDK_IS_NOT_GROUP_DEVICE;
    public static final uSDKErrorConst ERR_USDK_IS_NOT_MESH_DEVICE;
    public static final uSDKErrorConst ERR_USDK_MESH_DEVICE_INFO_REQUEST_FAIL;
    public static final uSDKErrorConst ERR_USDK_MODULE_IS_OTAING;
    public static final uSDKErrorConst ERR_USDK_MODULE_OTA_SEARCH_FAIL;
    public static final uSDKErrorConst ERR_USDK_MODULE_OTA_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_MONITOR_DEVICE_CONNECT_FAILURE;
    public static final uSDKErrorConst ERR_USDK_MONITOR_DEVICE_NOT_PLAY;
    public static final uSDKErrorConst ERR_USDK_NAME_MAC_NULL;
    public static final uSDKErrorConst ERR_USDK_NETWORK_EXCEPTION;
    public static final uSDKErrorConst ERR_USDK_NETWORK_IS_NONE;
    public static final uSDKErrorConst ERR_USDK_NETWORK_IS_SWITCHED;
    public static final uSDKErrorConst ERR_USDK_NOT_CALL_INIT;
    public static final uSDKErrorConst ERR_USDK_NOT_RECV_ACK;
    public static final uSDKErrorConst ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_FIND_DEVICE;
    public static final uSDKErrorConst ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_SWITCH_TO_CONFIGED_SSID;
    public static final uSDKErrorConst ERR_USDK_NOT_SUPPORT;
    public static final uSDKErrorConst ERR_USDK_NO_GROUPABLE_DEVICE;
    public static final uSDKErrorConst ERR_USDK_NO_NEED_RETYR_BIND;
    public static final uSDKErrorConst ERR_USDK_NO_RESULT_BINDING;
    public static final uSDKErrorConst ERR_USDK_OFFLINE_DECLARE;
    public static final uSDKErrorConst ERR_USDK_OPENING_BINDING_TIME_WINDOW_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_PASSWORD_LENGTH_INVALID;
    public static final uSDKErrorConst ERR_USDK_PHONE_BIND_DEVICE_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_PHONE_IS_OFFLINE;
    public static final uSDKErrorConst ERR_USDK_PING_IS_IN_WORKING;
    public static final uSDKErrorConst ERR_USDK_PING_IS_STOPED;
    public static final uSDKErrorConst ERR_USDK_PLAYER_COMMON_FAILURE;
    public static final uSDKErrorConst ERR_USDK_RECV_ACK_BUT_NOT_FIND_DEVICE;
    public static final uSDKErrorConst ERR_USDK_REMOTE_DEVICE_DUPLICATE;
    public static final uSDKErrorConst ERR_USDK_REMOTE_DEVICE_NOT_EXIST;
    public static final uSDKErrorConst ERR_USDK_REMOVE_DEVICE_CLOUD_FAIL;
    public static final uSDKErrorConst ERR_USDK_ROUTER_TYPE_UNSPPORTED;
    public static final uSDKErrorConst ERR_USDK_ROUTER_VERSION_TOO_LOW;
    public static final uSDKErrorConst ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
    public static final uSDKErrorConst ERR_USDK_SAVE_DEVICE_VERSION_FAIL;
    public static final uSDKErrorConst ERR_USDK_SECURITY_DEVICE_WITHOUT_TOKEN;
    public static final uSDKErrorConst ERR_USDK_SECURITY_SIDE_BINDING_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_SOFTAP_CONFIG_IS_CANCELED_BY_USER;
    public static final uSDKErrorConst ERR_USDK_SOFTAP_CONFIG_NOT_RECEIVE_ACK_BUT_SSID_CHANGED;
    public static final uSDKErrorConst ERR_USDK_SSID_NOT_MATCHING;
    public static final uSDKErrorConst ERR_USDK_STARTING;
    public static final uSDKErrorConst ERR_USDK_START_FAILED;
    public static final uSDKErrorConst ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE;
    public static final uSDKErrorConst ERR_USDK_SUBDEVICE_DO_NOT_NEED_CONNECT;
    public static final uSDKErrorConst ERR_USDK_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_TIMEOUT_WITHOUT_GETCONFIGINFO_ACK;
    public static final uSDKErrorConst ERR_USDK_TIMEOUT_WITHOUT_SOFTAPCONFIG_ACK;
    public static final uSDKErrorConst ERR_USDK_TRACE_IS_NOT_STARTED;
    public static final uSDKErrorConst ERR_USDK_TRACE_NODE_DUPLICATED;
    public static final uSDKErrorConst ERR_USDK_TRACE_NODE_STEP_DISORDER;
    public static final uSDKErrorConst ERR_USDK_UGW_DEVICE_ADDING;
    public static final uSDKErrorConst ERR_USDK_UGW_DEVICE_ALREADY_ADD;
    public static final uSDKErrorConst ERR_USDK_UGW_HOST_DEVICE_NOT_ADD;
    public static final uSDKErrorConst ERR_USDK_UNSTARTED;
    public static final uSDKErrorConst ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_USER_BIND_COUNT_LIMIT;
    public static final uSDKErrorConst ERR_USDK_USER_TOKEN_INVALID;
    public static final uSDKErrorConst ERR_USDK_WAIT_NETWORKING_RESULT_TIMEOUT;
    public static final uSDKErrorConst ERR_USDK_WIFI_NOT_ENABLE;
    public static final uSDKErrorConst RET_USDK_OK;
    private ErrorConst errorConst;

    static {
        uSDKErrorConst usdkerrorconst = new uSDKErrorConst("RET_USDK_OK", 0, ErrorConst.RET_USDK_OK);
        RET_USDK_OK = usdkerrorconst;
        uSDKErrorConst usdkerrorconst2 = new uSDKErrorConst("ERR_USDK_INVALID_PARAM", 1, ErrorConst.ERR_USDK_INVALID_PARAM);
        ERR_USDK_INVALID_PARAM = usdkerrorconst2;
        uSDKErrorConst usdkerrorconst3 = new uSDKErrorConst("ERR_USDK_UNSTARTED", 2, ErrorConst.ERR_USDK_UNSTARTED);
        ERR_USDK_UNSTARTED = usdkerrorconst3;
        uSDKErrorConst usdkerrorconst4 = new uSDKErrorConst("ERR_USDK_TIMEOUT", 3, ErrorConst.ERR_USDK_TIMEOUT);
        ERR_USDK_TIMEOUT = usdkerrorconst4;
        uSDKErrorConst usdkerrorconst5 = new uSDKErrorConst("ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD", 4, ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD);
        ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD = usdkerrorconst5;
        uSDKErrorConst usdkerrorconst6 = new uSDKErrorConst("ERR_USDK_NOT_CALL_INIT", 5, ErrorConst.ERR_USDK_NOT_CALL_INIT);
        ERR_USDK_NOT_CALL_INIT = usdkerrorconst6;
        uSDKErrorConst usdkerrorconst7 = new uSDKErrorConst("ERR_INTERNAL", 6, ErrorConst.ERR_INTERNAL);
        ERR_INTERNAL = usdkerrorconst7;
        uSDKErrorConst usdkerrorconst8 = new uSDKErrorConst("ERR_USDK_ALREADY_STOPPED", 7, ErrorConst.ERR_USDK_ALREADY_STOPPED);
        ERR_USDK_ALREADY_STOPPED = usdkerrorconst8;
        uSDKErrorConst usdkerrorconst9 = new uSDKErrorConst("ERR_USDK_CLOUD_COMMON_ERROR", 8, ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR);
        ERR_USDK_CLOUD_COMMON_ERROR = usdkerrorconst9;
        uSDKErrorConst usdkerrorconst10 = new uSDKErrorConst("ERR_USDK_INVALID_COMMAND", 9, ErrorConst.ERR_USDK_INVALID_COMMAND);
        ERR_USDK_INVALID_COMMAND = usdkerrorconst10;
        ErrorConst errorConst = ErrorConst.ERR_MODULE_UNSTARTED;
        uSDKErrorConst usdkerrorconst11 = new uSDKErrorConst("ERR_MODULE_UNSTARTED", 10, errorConst);
        ERR_MODULE_UNSTARTED = usdkerrorconst11;
        uSDKErrorConst usdkerrorconst12 = new uSDKErrorConst("ERR_MODULE_STOPPED", 11, errorConst);
        ERR_MODULE_STOPPED = usdkerrorconst12;
        uSDKErrorConst usdkerrorconst13 = new uSDKErrorConst("ERR_USDK_APPID_APPKEY_NULL", 12, ErrorConst.ERR_USDK_APPID_APPKEY_NULL);
        ERR_USDK_APPID_APPKEY_NULL = usdkerrorconst13;
        uSDKErrorConst usdkerrorconst14 = new uSDKErrorConst("ERR_USDK_SSID_NOT_MATCHING", 13, ErrorConst.ERR_USDK_SSID_NOT_MATCHING);
        ERR_USDK_SSID_NOT_MATCHING = usdkerrorconst14;
        uSDKErrorConst usdkerrorconst15 = new uSDKErrorConst("ERR_USDK_NAME_MAC_NULL", 14, ErrorConst.ERR_USDK_NAME_MAC_NULL);
        ERR_USDK_NAME_MAC_NULL = usdkerrorconst15;
        uSDKErrorConst usdkerrorconst16 = new uSDKErrorConst("ERR_USDK_NETWORK_EXCEPTION", 15, ErrorConst.ERR_USDK_NETWORK_EXCEPTION);
        ERR_USDK_NETWORK_EXCEPTION = usdkerrorconst16;
        uSDKErrorConst usdkerrorconst17 = new uSDKErrorConst("ERR_USDK_START_FAILED", 16, ErrorConst.ERR_USDK_START_FAILED);
        ERR_USDK_START_FAILED = usdkerrorconst17;
        uSDKErrorConst usdkerrorconst18 = new uSDKErrorConst("ERR_USDK_STARTING", 17, ErrorConst.ERR_USDK_STARTING);
        ERR_USDK_STARTING = usdkerrorconst18;
        uSDKErrorConst usdkerrorconst19 = new uSDKErrorConst("ERR_USDK_ROUTER_VERSION_TOO_LOW", 18, ErrorConst.ERR_USDK_ROUTER_VERSION_TOO_LOW);
        ERR_USDK_ROUTER_VERSION_TOO_LOW = usdkerrorconst19;
        uSDKErrorConst usdkerrorconst20 = new uSDKErrorConst("ERR_USDK_ROUTER_TYPE_UNSPPORTED", 19, ErrorConst.ERR_USDK_ROUTER_TYPE_UNSPPORTED);
        ERR_USDK_ROUTER_TYPE_UNSPPORTED = usdkerrorconst20;
        uSDKErrorConst usdkerrorconst21 = new uSDKErrorConst("ERR_USDK_CLOUD_OFFLINE", 20, ErrorConst.ERR_USDK_CLOUD_OFFLINE);
        ERR_USDK_CLOUD_OFFLINE = usdkerrorconst21;
        uSDKErrorConst usdkerrorconst22 = new uSDKErrorConst("ERR_USDK_FEATURE_NOT_SUPPORT", 21, ErrorConst.ERR_USDK_FEATURE_NOT_SUPPORT);
        ERR_USDK_FEATURE_NOT_SUPPORT = usdkerrorconst22;
        uSDKErrorConst usdkerrorconst23 = new uSDKErrorConst("ERR_USDK_REMOTE_DEVICE_DUPLICATE", 22, ErrorConst.ERR_USDK_REMOTE_DEVICE_DUPLICATE);
        ERR_USDK_REMOTE_DEVICE_DUPLICATE = usdkerrorconst23;
        uSDKErrorConst usdkerrorconst24 = new uSDKErrorConst("ERR_USDK_REMOTE_DEVICE_NOT_EXIST", 23, ErrorConst.ERR_USDK_REMOTE_DEVICE_NOT_EXIST);
        ERR_USDK_REMOTE_DEVICE_NOT_EXIST = usdkerrorconst24;
        uSDKErrorConst usdkerrorconst25 = new uSDKErrorConst("ERR_USDK_WIFI_NOT_ENABLE", 24, ErrorConst.ERR_USDK_WIFI_NOT_ENABLE);
        ERR_USDK_WIFI_NOT_ENABLE = usdkerrorconst25;
        uSDKErrorConst usdkerrorconst26 = new uSDKErrorConst("ERR_USDK_DEVICE_SCANNING", 25, ErrorConst.ERR_USDK_DEVICE_SCANNING);
        ERR_USDK_DEVICE_SCANNING = usdkerrorconst26;
        uSDKErrorConst usdkerrorconst27 = new uSDKErrorConst("ERR_USDK_DEVICE_SCANNER_LISTENER_NOT_REGIST", 26, ErrorConst.ERR_USDK_DEVICE_SCANNER_LISTENER_NOT_REGIST);
        ERR_USDK_DEVICE_SCANNER_LISTENER_NOT_REGIST = usdkerrorconst27;
        uSDKErrorConst usdkerrorconst28 = new uSDKErrorConst("ERR_USDK_DEVICE_CONFIG_IN_PROGRESS", 27, ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS);
        ERR_USDK_DEVICE_CONFIG_IN_PROGRESS = usdkerrorconst28;
        uSDKErrorConst usdkerrorconst29 = new uSDKErrorConst("ERR_USDK_CONFIG_BE_CANCELED", 28, ErrorConst.ERR_USDK_CONFIG_BE_CANCELED);
        ERR_USDK_CONFIG_BE_CANCELED = usdkerrorconst29;
        uSDKErrorConst usdkerrorconst30 = new uSDKErrorConst("ERR_USDK_RECV_ACK_BUT_NOT_FIND_DEVICE", 29, ErrorConst.ERR_USDK_RECV_ACK_BUT_NOT_FIND_DEVICE);
        ERR_USDK_RECV_ACK_BUT_NOT_FIND_DEVICE = usdkerrorconst30;
        uSDKErrorConst usdkerrorconst31 = new uSDKErrorConst("ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE", 30, ErrorConst.ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE);
        ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE = usdkerrorconst31;
        uSDKErrorConst usdkerrorconst32 = new uSDKErrorConst("ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID", 31, ErrorConst.ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID);
        ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID = usdkerrorconst32;
        uSDKErrorConst usdkerrorconst33 = new uSDKErrorConst("ERR_USDK_DEVICE_UPLUSID_INVALID", 32, ErrorConst.ERR_USDK_DEVICE_UPLUSID_INVALID);
        ERR_USDK_DEVICE_UPLUSID_INVALID = usdkerrorconst33;
        uSDKErrorConst usdkerrorconst34 = new uSDKErrorConst("ERR_USDK_TIMEOUT_WITHOUT_GETCONFIGINFO_ACK", 33, ErrorConst.ERR_USDK_TIMEOUT_WITHOUT_GETCONFIGINFO_ACK);
        ERR_USDK_TIMEOUT_WITHOUT_GETCONFIGINFO_ACK = usdkerrorconst34;
        uSDKErrorConst usdkerrorconst35 = new uSDKErrorConst("ERR_USDK_TIMEOUT_WITHOUT_SOFTAPCONFIG_ACK", 34, ErrorConst.ERR_USDK_TIMEOUT_WITHOUT_SOFTAPCONFIG_ACK);
        ERR_USDK_TIMEOUT_WITHOUT_SOFTAPCONFIG_ACK = usdkerrorconst35;
        uSDKErrorConst usdkerrorconst36 = new uSDKErrorConst("ERR_USDK_SOFTAP_CONFIG_IS_CANCELED_BY_USER", 35, ErrorConst.ERR_USDK_SOFTAP_CONFIG_IS_CANCELED_BY_USER);
        ERR_USDK_SOFTAP_CONFIG_IS_CANCELED_BY_USER = usdkerrorconst36;
        uSDKErrorConst usdkerrorconst37 = new uSDKErrorConst("ERR_USDK_DEVICE_UPLUSID_NOT_MATCH", 36, ErrorConst.ERR_USDK_DEVICE_UPLUSID_NOT_MATCH);
        ERR_USDK_DEVICE_UPLUSID_NOT_MATCH = usdkerrorconst37;
        uSDKErrorConst usdkerrorconst38 = new uSDKErrorConst("ERR_USDK_CURRENT_SSID_IS_NOT_IOT", 37, ErrorConst.ERR_USDK_CURRENT_SSID_IS_NOT_IOT);
        ERR_USDK_CURRENT_SSID_IS_NOT_IOT = usdkerrorconst38;
        uSDKErrorConst usdkerrorconst39 = new uSDKErrorConst("ERR_USDK_SOFTAP_CONFIG_NOT_RECEIVE_ACK_BUT_SSID_CHANGED", 38, ErrorConst.ERR_USDK_SOFTAP_CONFIG_NOT_RECEIVE_ACK_BUT_SSID_CHANGED);
        ERR_USDK_SOFTAP_CONFIG_NOT_RECEIVE_ACK_BUT_SSID_CHANGED = usdkerrorconst39;
        uSDKErrorConst usdkerrorconst40 = new uSDKErrorConst("ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_FIND_DEVICE", 39, ErrorConst.ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_FIND_DEVICE);
        ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_FIND_DEVICE = usdkerrorconst40;
        uSDKErrorConst usdkerrorconst41 = new uSDKErrorConst("ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_SWITCH_TO_CONFIGED_SSID", 40, ErrorConst.ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_SWITCH_TO_CONFIGED_SSID);
        ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_SWITCH_TO_CONFIGED_SSID = usdkerrorconst41;
        uSDKErrorConst usdkerrorconst42 = new uSDKErrorConst("ERR_USDK_PASSWORD_LENGTH_INVALID", 41, ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID);
        ERR_USDK_PASSWORD_LENGTH_INVALID = usdkerrorconst42;
        uSDKErrorConst usdkerrorconst43 = new uSDKErrorConst("ERR_USDK_BLE_NOT_OPEN", 42, ErrorConst.ERR_USDK_BLE_NOT_OPEN);
        ERR_USDK_BLE_NOT_OPEN = usdkerrorconst43;
        uSDKErrorConst usdkerrorconst44 = new uSDKErrorConst("ERR_USDK_NOT_RECV_ACK", 43, ErrorConst.ERR_USDK_NOT_RECV_ACK);
        ERR_USDK_NOT_RECV_ACK = usdkerrorconst44;
        uSDKErrorConst usdkerrorconst45 = new uSDKErrorConst("ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT", 44, ErrorConst.ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT);
        ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT = usdkerrorconst45;
        uSDKErrorConst usdkerrorconst46 = new uSDKErrorConst("ERR_USDK_GET_BIND_RESULT_TIMEOUT", 45, ErrorConst.ERR_USDK_GET_BIND_RESULT_TIMEOUT);
        ERR_USDK_GET_BIND_RESULT_TIMEOUT = usdkerrorconst46;
        uSDKErrorConst usdkerrorconst47 = new uSDKErrorConst("ERR_USDK_WAIT_NETWORKING_RESULT_TIMEOUT", 46, ErrorConst.ERR_USDK_WAIT_NETWORKING_RESULT_TIMEOUT);
        ERR_USDK_WAIT_NETWORKING_RESULT_TIMEOUT = usdkerrorconst47;
        uSDKErrorConst usdkerrorconst48 = new uSDKErrorConst("ERR_USDK_DEVICE_NEED_TRIGGER_CONFIG", 47, ErrorConst.ERR_USDK_DEVICE_NEED_TRIGGER_CONFIG);
        ERR_USDK_DEVICE_NEED_TRIGGER_CONFIG = usdkerrorconst48;
        uSDKErrorConst usdkerrorconst49 = new uSDKErrorConst("ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE", 48, ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE);
        ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE = usdkerrorconst49;
        uSDKErrorConst usdkerrorconst50 = new uSDKErrorConst("ERR_USDK_DEVICE_VERIFY_FAILED", 49, ErrorConst.ERR_USDK_DEVICE_VERIFY_FAILED);
        ERR_USDK_DEVICE_VERIFY_FAILED = usdkerrorconst50;
        uSDKErrorConst usdkerrorconst51 = new uSDKErrorConst("ERR_USDK_DEVICE_VERIFY_TIMEOUT", 50, ErrorConst.ERR_USDK_DEVICE_VERIFY_TIMEOUT);
        ERR_USDK_DEVICE_VERIFY_TIMEOUT = usdkerrorconst51;
        uSDKErrorConst usdkerrorconst52 = new uSDKErrorConst("ERR_USDK_NETWORK_IS_SWITCHED", 51, ErrorConst.ERR_USDK_NETWORK_IS_SWITCHED);
        ERR_USDK_NETWORK_IS_SWITCHED = usdkerrorconst52;
        uSDKErrorConst usdkerrorconst53 = new uSDKErrorConst("ERR_USDK_NETWORK_IS_NONE", 52, ErrorConst.ERR_USDK_NETWORK_IS_NONE);
        ERR_USDK_NETWORK_IS_NONE = usdkerrorconst53;
        uSDKErrorConst usdkerrorconst54 = new uSDKErrorConst("ERR_USDK_PHONE_IS_OFFLINE", 53, ErrorConst.ERR_USDK_PHONE_IS_OFFLINE);
        ERR_USDK_PHONE_IS_OFFLINE = usdkerrorconst54;
        uSDKErrorConst usdkerrorconst55 = new uSDKErrorConst("ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE", 54, ErrorConst.ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE);
        ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE = usdkerrorconst55;
        uSDKErrorConst usdkerrorconst56 = new uSDKErrorConst("ERR_USDK_BLE_IS_POWER_OFF", 55, ErrorConst.ERR_USDK_BLE_IS_POWER_OFF);
        ERR_USDK_BLE_IS_POWER_OFF = usdkerrorconst56;
        uSDKErrorConst usdkerrorconst57 = new uSDKErrorConst("ERR_USDK_DEVICE_ALREADY_CONNECTED", 56, ErrorConst.ERR_USDK_DEVICE_ALREADY_CONNECTED);
        ERR_USDK_DEVICE_ALREADY_CONNECTED = usdkerrorconst57;
        uSDKErrorConst usdkerrorconst58 = new uSDKErrorConst("ERR_USDK_DEVICE_READ_ATTR", 57, ErrorConst.ERR_USDK_DEVICE_READ_ATTR);
        ERR_USDK_DEVICE_READ_ATTR = usdkerrorconst58;
        uSDKErrorConst usdkerrorconst59 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_CONNECT", 58, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECT);
        ERR_USDK_DEVICE_NOT_CONNECT = usdkerrorconst59;
        uSDKErrorConst usdkerrorconst60 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_CONNECTED", 59, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED);
        ERR_USDK_DEVICE_NOT_CONNECTED = usdkerrorconst60;
        uSDKErrorConst usdkerrorconst61 = new uSDKErrorConst("ERR_USDK_SUBDEVICE_DO_NOT_NEED_CONNECT", 60, ErrorConst.ERR_USDK_SUBDEVICE_DO_NOT_NEED_CONNECT);
        ERR_USDK_SUBDEVICE_DO_NOT_NEED_CONNECT = usdkerrorconst61;
        uSDKErrorConst usdkerrorconst62 = new uSDKErrorConst("ERR_USDK_DEVICE_IS_BUSY", 61, ErrorConst.ERR_USDK_DEVICE_IS_BUSY);
        ERR_USDK_DEVICE_IS_BUSY = usdkerrorconst62;
        uSDKErrorConst usdkerrorconst63 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_LOCAL", 62, ErrorConst.ERR_USDK_DEVICE_NOT_LOCAL);
        ERR_USDK_DEVICE_NOT_LOCAL = usdkerrorconst63;
        uSDKErrorConst usdkerrorconst64 = new uSDKErrorConst("ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST", 63, ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST);
        ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST = usdkerrorconst64;
        uSDKErrorConst usdkerrorconst65 = new uSDKErrorConst("ERR_USDK_SECURITY_DEVICE_WITHOUT_TOKEN", 64, ErrorConst.ERR_USDK_SECURITY_DEVICE_WITHOUT_TOKEN);
        ERR_USDK_SECURITY_DEVICE_WITHOUT_TOKEN = usdkerrorconst65;
        uSDKErrorConst usdkerrorconst66 = new uSDKErrorConst("ERR_USDK_OFFLINE_DECLARE", 65, ErrorConst.ERR_USDK_OFFLINE_DECLARE);
        ERR_USDK_OFFLINE_DECLARE = usdkerrorconst66;
        uSDKErrorConst usdkerrorconst67 = new uSDKErrorConst("ERR_USDK_DEVICE_IS_OFFLINE", 66, ErrorConst.ERR_USDK_DEVICE_IS_OFFLINE);
        ERR_USDK_DEVICE_IS_OFFLINE = usdkerrorconst67;
        uSDKErrorConst usdkerrorconst68 = new uSDKErrorConst("ERR_USDK_GATEWAY_IS_CONNECTED", 67, ErrorConst.ERR_USDK_GATEWAY_IS_CONNECTED);
        ERR_USDK_GATEWAY_IS_CONNECTED = usdkerrorconst68;
        uSDKErrorConst usdkerrorconst69 = new uSDKErrorConst("ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE", 68, ErrorConst.ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE);
        ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE = usdkerrorconst69;
        uSDKErrorConst usdkerrorconst70 = new uSDKErrorConst("ERR_USDK_NOT_SUPPORT", 69, ErrorConst.ERR_USDK_NOT_SUPPORT);
        ERR_USDK_NOT_SUPPORT = usdkerrorconst70;
        uSDKErrorConst usdkerrorconst71 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_NETQUALITY", 70, ErrorConst.ERR_USDK_DEVICE_NOT_NETQUALITY);
        ERR_USDK_DEVICE_NOT_NETQUALITY = usdkerrorconst71;
        uSDKErrorConst usdkerrorconst72 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_GET_NETQUALITY", 71, ErrorConst.ERR_USDK_DEVICE_NOT_GET_NETQUALITY);
        ERR_USDK_DEVICE_NOT_GET_NETQUALITY = usdkerrorconst72;
        uSDKErrorConst usdkerrorconst73 = new uSDKErrorConst("ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE", 72, ErrorConst.ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE);
        ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE = usdkerrorconst73;
        uSDKErrorConst usdkerrorconst74 = new uSDKErrorConst("ERR_USDK_DEVICE_AUTHORIZE_ERROR", 73, ErrorConst.ERR_USDK_DEVICE_AUTHORIZE_ERROR);
        ERR_USDK_DEVICE_AUTHORIZE_ERROR = usdkerrorconst74;
        uSDKErrorConst usdkerrorconst75 = new uSDKErrorConst("ERR_USDK_DEVICE_AUTHORIZE_INVALID_ERROR", 74, ErrorConst.ERR_USDK_DEVICE_AUTHORIZE_INVALID_ERROR);
        ERR_USDK_DEVICE_AUTHORIZE_INVALID_ERROR = usdkerrorconst75;
        uSDKErrorConst usdkerrorconst76 = new uSDKErrorConst("ERR_USDK_DEVICE_QUERY_AUTHORIZE_STATUS_FAILURE", 75, ErrorConst.ERR_USDK_DEVICE_QUERY_AUTHORIZE_STATUS_FAILURE);
        ERR_USDK_DEVICE_QUERY_AUTHORIZE_STATUS_FAILURE = usdkerrorconst76;
        uSDKErrorConst usdkerrorconst77 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_FOUND", 76, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
        ERR_USDK_DEVICE_NOT_FOUND = usdkerrorconst77;
        uSDKErrorConst usdkerrorconst78 = new uSDKErrorConst("ERR_USDK_DEVICE_REMOTE_STATE_NOT_READY", 77, ErrorConst.ERR_USDK_DEVICE_REMOTE_STATE_NOT_READY);
        ERR_USDK_DEVICE_REMOTE_STATE_NOT_READY = usdkerrorconst78;
        uSDKErrorConst usdkerrorconst79 = new uSDKErrorConst("ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL", 78, ErrorConst.ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL);
        ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL = usdkerrorconst79;
        uSDKErrorConst usdkerrorconst80 = new uSDKErrorConst("ERR_USDK_DEVICE_OTA_INTERRUPTED", 79, ErrorConst.ERR_USDK_DEVICE_OTA_INTERRUPTED);
        ERR_USDK_DEVICE_OTA_INTERRUPTED = usdkerrorconst80;
        uSDKErrorConst usdkerrorconst81 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_IN_OTA_MODE", 80, ErrorConst.ERR_USDK_DEVICE_NOT_IN_OTA_MODE);
        ERR_USDK_DEVICE_NOT_IN_OTA_MODE = usdkerrorconst81;
        uSDKErrorConst usdkerrorconst82 = new uSDKErrorConst("ERR_USDK_BLE_CHARACTERISTICS_NOT_FOUND", 81, ErrorConst.ERR_USDK_BLE_CHARACTERISTICS_NOT_FOUND);
        ERR_USDK_BLE_CHARACTERISTICS_NOT_FOUND = usdkerrorconst82;
        uSDKErrorConst usdkerrorconst83 = new uSDKErrorConst("ERR_USDK_BLE_OPERATION_NOT_SUPPORT", 82, ErrorConst.ERR_USDK_BLE_OPERATION_NOT_SUPPORT);
        ERR_USDK_BLE_OPERATION_NOT_SUPPORT = usdkerrorconst83;
        uSDKErrorConst usdkerrorconst84 = new uSDKErrorConst("ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE", 83, ErrorConst.ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE);
        ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE = usdkerrorconst84;
        uSDKErrorConst usdkerrorconst85 = new uSDKErrorConst("ERR_USDK_TRACE_IS_NOT_STARTED", 84, ErrorConst.ERR_USDK_TRACE_IS_NOT_STARTED);
        ERR_USDK_TRACE_IS_NOT_STARTED = usdkerrorconst85;
        uSDKErrorConst usdkerrorconst86 = new uSDKErrorConst("ERR_USDK_TRACE_NODE_DUPLICATED", 85, ErrorConst.ERR_USDK_TRACE_NODE_DUPLICATED);
        ERR_USDK_TRACE_NODE_DUPLICATED = usdkerrorconst86;
        uSDKErrorConst usdkerrorconst87 = new uSDKErrorConst("ERR_USDK_TRACE_NODE_STEP_DISORDER", 86, ErrorConst.ERR_USDK_TRACE_NODE_STEP_DISORDER);
        ERR_USDK_TRACE_NODE_STEP_DISORDER = usdkerrorconst87;
        uSDKErrorConst usdkerrorconst88 = new uSDKErrorConst("ERR_USDK_DEVICE_IS_IN_BINDING", 87, ErrorConst.ERR_USDK_DEVICE_IS_IN_BINDING);
        ERR_USDK_DEVICE_IS_IN_BINDING = usdkerrorconst88;
        uSDKErrorConst usdkerrorconst89 = new uSDKErrorConst("ERR_USDK_DEVICE_IS_NOT_IN_BINDING", 88, ErrorConst.ERR_USDK_DEVICE_IS_NOT_IN_BINDING);
        ERR_USDK_DEVICE_IS_NOT_IN_BINDING = usdkerrorconst89;
        uSDKErrorConst usdkerrorconst90 = new uSDKErrorConst("ERR_USDK_BIND_DEVICE_IS_CANCELED", 89, ErrorConst.ERR_USDK_BIND_DEVICE_IS_CANCELED);
        ERR_USDK_BIND_DEVICE_IS_CANCELED = usdkerrorconst90;
        uSDKErrorConst usdkerrorconst91 = new uSDKErrorConst("ERR_USDK_GET_BINDINFO_TIMEOUT", 90, ErrorConst.ERR_USDK_GET_BINDINFO_TIMEOUT);
        ERR_USDK_GET_BINDINFO_TIMEOUT = usdkerrorconst91;
        uSDKErrorConst usdkerrorconst92 = new uSDKErrorConst("ERR_USDK_BIND_DEVICE_TIMEOUT", 91, ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT);
        ERR_USDK_BIND_DEVICE_TIMEOUT = usdkerrorconst92;
        uSDKErrorConst usdkerrorconst93 = new uSDKErrorConst("ERR_USDK_CREATE_SECURITY_SDK_BIND_CLASS_FAIL", 92, ErrorConst.ERR_USDK_CREATE_SECURITY_SDK_BIND_CLASS_FAIL);
        ERR_USDK_CREATE_SECURITY_SDK_BIND_CLASS_FAIL = usdkerrorconst93;
        uSDKErrorConst usdkerrorconst94 = new uSDKErrorConst("ERR_USDK_MESH_DEVICE_INFO_REQUEST_FAIL", 93, ErrorConst.ERR_USDK_MESH_DEVICE_INFO_REQUEST_FAIL);
        ERR_USDK_MESH_DEVICE_INFO_REQUEST_FAIL = usdkerrorconst94;
        uSDKErrorConst usdkerrorconst95 = new uSDKErrorConst("ERR_USDK_DEVICE_BIND_FAILED", 94, ErrorConst.ERR_USDK_DEVICE_BIND_FAILED);
        ERR_USDK_DEVICE_BIND_FAILED = usdkerrorconst95;
        uSDKErrorConst usdkerrorconst96 = new uSDKErrorConst("ERR_USDK_CAMERA_SDK_COMMON_ERROR", 95, ErrorConst.ERR_USDK_CAMERA_SDK_COMMON_ERROR);
        ERR_USDK_CAMERA_SDK_COMMON_ERROR = usdkerrorconst96;
        uSDKErrorConst usdkerrorconst97 = new uSDKErrorConst("ERR_USDK_USER_TOKEN_INVALID", 96, ErrorConst.ERR_USDK_USER_TOKEN_INVALID);
        ERR_USDK_USER_TOKEN_INVALID = usdkerrorconst97;
        uSDKErrorConst usdkerrorconst98 = new uSDKErrorConst("ERR_USDK_USER_BIND_COUNT_LIMIT", 97, ErrorConst.ERR_USDK_USER_BIND_COUNT_LIMIT);
        ERR_USDK_USER_BIND_COUNT_LIMIT = usdkerrorconst98;
        uSDKErrorConst usdkerrorconst99 = new uSDKErrorConst("ERR_USDK_DEVICE_LOCAL_EXIST_AND_GET_BIND_RESULT_TIMEOUT", 98, ErrorConst.ERR_USDK_DEVICE_LOCAL_EXIST_AND_GET_BIND_RESULT_TIMEOUT);
        ERR_USDK_DEVICE_LOCAL_EXIST_AND_GET_BIND_RESULT_TIMEOUT = usdkerrorconst99;
        uSDKErrorConst usdkerrorconst100 = new uSDKErrorConst("ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT", 99, ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT);
        ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT = usdkerrorconst100;
        uSDKErrorConst usdkerrorconst101 = new uSDKErrorConst("ERR_USDK_NO_RESULT_BINDING", 100, ErrorConst.ERR_USDK_NO_RESULT_BINDING);
        ERR_USDK_NO_RESULT_BINDING = usdkerrorconst101;
        uSDKErrorConst usdkerrorconst102 = new uSDKErrorConst("ERR_USDK_PHONE_BIND_DEVICE_TIMEOUT", 101, ErrorConst.ERR_USDK_PHONE_BIND_DEVICE_TIMEOUT);
        ERR_USDK_PHONE_BIND_DEVICE_TIMEOUT = usdkerrorconst102;
        uSDKErrorConst usdkerrorconst103 = new uSDKErrorConst("ERR_USDK_OPENING_BINDING_TIME_WINDOW_TIMEOUT", 102, ErrorConst.ERR_USDK_OPENING_BINDING_TIME_WINDOW_TIMEOUT);
        ERR_USDK_OPENING_BINDING_TIME_WINDOW_TIMEOUT = usdkerrorconst103;
        uSDKErrorConst usdkerrorconst104 = new uSDKErrorConst("ERR_USDK_SECURITY_SIDE_BINDING_TIMEOUT", Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, ErrorConst.ERR_USDK_SECURITY_SIDE_BINDING_TIMEOUT);
        ERR_USDK_SECURITY_SIDE_BINDING_TIMEOUT = usdkerrorconst104;
        uSDKErrorConst usdkerrorconst105 = new uSDKErrorConst("ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND", 104, ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND);
        ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND = usdkerrorconst105;
        uSDKErrorConst usdkerrorconst106 = new uSDKErrorConst("ERR_USDK_NO_NEED_RETYR_BIND", 105, ErrorConst.ERR_USDK_NO_NEED_RETYR_BIND);
        ERR_USDK_NO_NEED_RETYR_BIND = usdkerrorconst106;
        uSDKErrorConst usdkerrorconst107 = new uSDKErrorConst("ERR_USDK_BIND_CODE_FAILED", Constants.ACTION_SUBMIT_CLICKED, ErrorConst.ERR_USDK_BIND_CODE_FAILED);
        ERR_USDK_BIND_CODE_FAILED = usdkerrorconst107;
        uSDKErrorConst usdkerrorconst108 = new uSDKErrorConst("ERR_USDK_SAVE_DEVICE_VERSION_FAIL", Constants.OTP_FILLER_WEB_SUCCESS, ErrorConst.ERR_USDK_SAVE_DEVICE_VERSION_FAIL);
        ERR_USDK_SAVE_DEVICE_VERSION_FAIL = usdkerrorconst108;
        uSDKErrorConst usdkerrorconst109 = new uSDKErrorConst("ERR_USDK_UGW_DEVICE_ADDING", 108, ErrorConst.ERR_USDK_UGW_DEVICE_ADDING);
        ERR_USDK_UGW_DEVICE_ADDING = usdkerrorconst109;
        uSDKErrorConst usdkerrorconst110 = new uSDKErrorConst("ERR_USDK_UGW_DEVICE_ALREADY_ADD", 109, ErrorConst.ERR_USDK_UGW_DEVICE_ALREADY_ADD);
        ERR_USDK_UGW_DEVICE_ALREADY_ADD = usdkerrorconst110;
        uSDKErrorConst usdkerrorconst111 = new uSDKErrorConst("ERR_USDK_UGW_HOST_DEVICE_NOT_ADD", Constants.LOG_ERROR_OTP, ErrorConst.ERR_USDK_UGW_HOST_DEVICE_NOT_ADD);
        ERR_USDK_UGW_HOST_DEVICE_NOT_ADD = usdkerrorconst111;
        uSDKErrorConst usdkerrorconst112 = new uSDKErrorConst("ERR_USDK_PING_IS_IN_WORKING", 111, ErrorConst.ERR_USDK_PING_IS_IN_WORKING);
        ERR_USDK_PING_IS_IN_WORKING = usdkerrorconst112;
        uSDKErrorConst usdkerrorconst113 = new uSDKErrorConst("ERR_USDK_PING_IS_STOPED", 112, ErrorConst.ERR_USDK_PING_IS_STOPED);
        ERR_USDK_PING_IS_STOPED = usdkerrorconst113;
        uSDKErrorConst usdkerrorconst114 = new uSDKErrorConst("ERR_USDK_HTTP_DNS_ERROR", 113, ErrorConst.ERR_USDK_HTTP_DNS_ERROR);
        ERR_USDK_HTTP_DNS_ERROR = usdkerrorconst114;
        uSDKErrorConst usdkerrorconst115 = new uSDKErrorConst("ERR_USDK_FOTA_INFO_IS_NULL", 114, ErrorConst.ERR_USDK_FOTA_INFO_IS_NULL);
        ERR_USDK_FOTA_INFO_IS_NULL = usdkerrorconst115;
        uSDKErrorConst usdkerrorconst116 = new uSDKErrorConst("ERR_USDK_DONT_NEED_FOTA", 115, ErrorConst.ERR_USDK_DONT_NEED_FOTA);
        ERR_USDK_DONT_NEED_FOTA = usdkerrorconst116;
        uSDKErrorConst usdkerrorconst117 = new uSDKErrorConst("ERR_USDK_DONT_NEED_OTA", 116, ErrorConst.ERR_USDK_DONT_NEED_OTA);
        ERR_USDK_DONT_NEED_OTA = usdkerrorconst117;
        uSDKErrorConst usdkerrorconst118 = new uSDKErrorConst("ERR_USDK_MODULE_IS_OTAING", 117, ErrorConst.ERR_USDK_MODULE_IS_OTAING);
        ERR_USDK_MODULE_IS_OTAING = usdkerrorconst118;
        uSDKErrorConst usdkerrorconst119 = new uSDKErrorConst("ERR_USDK_MODULE_OTA_TIMEOUT", 118, ErrorConst.ERR_USDK_MODULE_OTA_TIMEOUT);
        ERR_USDK_MODULE_OTA_TIMEOUT = usdkerrorconst119;
        uSDKErrorConst usdkerrorconst120 = new uSDKErrorConst("ERR_USDK_MODULE_OTA_SEARCH_FAIL", 119, ErrorConst.ERR_USDK_MODULE_OTA_SEARCH_FAIL);
        ERR_USDK_MODULE_OTA_SEARCH_FAIL = usdkerrorconst120;
        uSDKErrorConst usdkerrorconst121 = new uSDKErrorConst("ERR_USDK_DEVICE_IS_NOT_BOUND", 120, ErrorConst.ERR_USDK_DEVICE_IS_NOT_BOUND);
        ERR_USDK_DEVICE_IS_NOT_BOUND = usdkerrorconst121;
        uSDKErrorConst usdkerrorconst122 = new uSDKErrorConst("ERR_USDK_REMOVE_DEVICE_CLOUD_FAIL", Constants.OTP_VIEW_GONE, ErrorConst.ERR_USDK_REMOVE_DEVICE_CLOUD_FAIL);
        ERR_USDK_REMOVE_DEVICE_CLOUD_FAIL = usdkerrorconst122;
        uSDKErrorConst usdkerrorconst123 = new uSDKErrorConst("ERR_USDK_IS_NOT_MESH_DEVICE", 122, ErrorConst.ERR_USDK_IS_NOT_MESH_DEVICE);
        ERR_USDK_IS_NOT_MESH_DEVICE = usdkerrorconst123;
        uSDKErrorConst usdkerrorconst124 = new uSDKErrorConst("ERR_USDK_IS_NOT_GROUP_DEVICE", 123, ErrorConst.ERR_USDK_IS_NOT_GROUP_DEVICE);
        ERR_USDK_IS_NOT_GROUP_DEVICE = usdkerrorconst124;
        uSDKErrorConst usdkerrorconst125 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_CONNECT_ROUTER_CAUSE_OFFLINE", 124, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECT_ROUTER_CAUSE_OFFLINE);
        ERR_USDK_DEVICE_NOT_CONNECT_ROUTER_CAUSE_OFFLINE = usdkerrorconst125;
        uSDKErrorConst usdkerrorconst126 = new uSDKErrorConst("ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD", 125, ErrorConst.ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD);
        ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD = usdkerrorconst126;
        uSDKErrorConst usdkerrorconst127 = new uSDKErrorConst("ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR", 126, ErrorConst.ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR);
        ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR = usdkerrorconst127;
        uSDKErrorConst usdkerrorconst128 = new uSDKErrorConst("ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT", 127, ErrorConst.ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT);
        ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT = usdkerrorconst128;
        uSDKErrorConst usdkerrorconst129 = new uSDKErrorConst("ERR_USDK_DEVICE_NOT_SUPPORT_GROUP", 128, ErrorConst.ERR_USDK_DEVICE_NOT_SUPPORT_GROUP);
        ERR_USDK_DEVICE_NOT_SUPPORT_GROUP = usdkerrorconst129;
        uSDKErrorConst usdkerrorconst130 = new uSDKErrorConst("ERR_USDK_NO_GROUPABLE_DEVICE", 129, ErrorConst.ERR_USDK_NO_GROUPABLE_DEVICE);
        ERR_USDK_NO_GROUPABLE_DEVICE = usdkerrorconst130;
        uSDKErrorConst usdkerrorconst131 = new uSDKErrorConst("ERR_USDK_GROUP_IS_OPERATING", 130, ErrorConst.ERR_USDK_GROUP_IS_OPERATING);
        ERR_USDK_GROUP_IS_OPERATING = usdkerrorconst131;
        uSDKErrorConst usdkerrorconst132 = new uSDKErrorConst("ERR_USDK_GROUP_DEVICE_CAN_NOT_CREATE_GROUP", 131, ErrorConst.ERR_USDK_GROUP_DEVICE_CAN_NOT_CREATE_GROUP);
        ERR_USDK_GROUP_DEVICE_CAN_NOT_CREATE_GROUP = usdkerrorconst132;
        uSDKErrorConst usdkerrorconst133 = new uSDKErrorConst("ERR_USDK_MONITOR_DEVICE_NOT_PLAY", 132, ErrorConst.ERR_USDK_MONITOR_DEVICE_NOT_PLAY);
        ERR_USDK_MONITOR_DEVICE_NOT_PLAY = usdkerrorconst133;
        uSDKErrorConst usdkerrorconst134 = new uSDKErrorConst("ERR_USDK_MONITOR_DEVICE_CONNECT_FAILURE", d4.d.f33486i, ErrorConst.ERR_USDK_MONITOR_DEVICE_CONNECT_FAILURE);
        ERR_USDK_MONITOR_DEVICE_CONNECT_FAILURE = usdkerrorconst134;
        uSDKErrorConst usdkerrorconst135 = new uSDKErrorConst("ERR_USDK_PLAYER_COMMON_FAILURE", 134, ErrorConst.ERR_USDK_PLAYER_COMMON_FAILURE);
        ERR_USDK_PLAYER_COMMON_FAILURE = usdkerrorconst135;
        $VALUES = new uSDKErrorConst[]{usdkerrorconst, usdkerrorconst2, usdkerrorconst3, usdkerrorconst4, usdkerrorconst5, usdkerrorconst6, usdkerrorconst7, usdkerrorconst8, usdkerrorconst9, usdkerrorconst10, usdkerrorconst11, usdkerrorconst12, usdkerrorconst13, usdkerrorconst14, usdkerrorconst15, usdkerrorconst16, usdkerrorconst17, usdkerrorconst18, usdkerrorconst19, usdkerrorconst20, usdkerrorconst21, usdkerrorconst22, usdkerrorconst23, usdkerrorconst24, usdkerrorconst25, usdkerrorconst26, usdkerrorconst27, usdkerrorconst28, usdkerrorconst29, usdkerrorconst30, usdkerrorconst31, usdkerrorconst32, usdkerrorconst33, usdkerrorconst34, usdkerrorconst35, usdkerrorconst36, usdkerrorconst37, usdkerrorconst38, usdkerrorconst39, usdkerrorconst40, usdkerrorconst41, usdkerrorconst42, usdkerrorconst43, usdkerrorconst44, usdkerrorconst45, usdkerrorconst46, usdkerrorconst47, usdkerrorconst48, usdkerrorconst49, usdkerrorconst50, usdkerrorconst51, usdkerrorconst52, usdkerrorconst53, usdkerrorconst54, usdkerrorconst55, usdkerrorconst56, usdkerrorconst57, usdkerrorconst58, usdkerrorconst59, usdkerrorconst60, usdkerrorconst61, usdkerrorconst62, usdkerrorconst63, usdkerrorconst64, usdkerrorconst65, usdkerrorconst66, usdkerrorconst67, usdkerrorconst68, usdkerrorconst69, usdkerrorconst70, usdkerrorconst71, usdkerrorconst72, usdkerrorconst73, usdkerrorconst74, usdkerrorconst75, usdkerrorconst76, usdkerrorconst77, usdkerrorconst78, usdkerrorconst79, usdkerrorconst80, usdkerrorconst81, usdkerrorconst82, usdkerrorconst83, usdkerrorconst84, usdkerrorconst85, usdkerrorconst86, usdkerrorconst87, usdkerrorconst88, usdkerrorconst89, usdkerrorconst90, usdkerrorconst91, usdkerrorconst92, usdkerrorconst93, usdkerrorconst94, usdkerrorconst95, usdkerrorconst96, usdkerrorconst97, usdkerrorconst98, usdkerrorconst99, usdkerrorconst100, usdkerrorconst101, usdkerrorconst102, usdkerrorconst103, usdkerrorconst104, usdkerrorconst105, usdkerrorconst106, usdkerrorconst107, usdkerrorconst108, usdkerrorconst109, usdkerrorconst110, usdkerrorconst111, usdkerrorconst112, usdkerrorconst113, usdkerrorconst114, usdkerrorconst115, usdkerrorconst116, usdkerrorconst117, usdkerrorconst118, usdkerrorconst119, usdkerrorconst120, usdkerrorconst121, usdkerrorconst122, usdkerrorconst123, usdkerrorconst124, usdkerrorconst125, usdkerrorconst126, usdkerrorconst127, usdkerrorconst128, usdkerrorconst129, usdkerrorconst130, usdkerrorconst131, usdkerrorconst132, usdkerrorconst133, usdkerrorconst134, usdkerrorconst135};
    }

    private uSDKErrorConst(String str, int i7, ErrorConst errorConst) {
        super(str, i7);
        this.errorConst = errorConst;
    }

    public static uSDKErrorConst getErrorConst(ErrorConst errorConst) {
        if (errorConst == null) {
            return ERR_INTERNAL;
        }
        uSDKErrorConst usdkerrorconst = getInstance(errorConst.name());
        usdkerrorconst.errorConst = ErrorConst.getCustomErrorConst(errorConst.getErrorId(), errorConst.getSecondErrorId(), errorConst.getErrorInfo());
        return usdkerrorconst;
    }

    public static uSDKErrorConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return ERR_INTERNAL;
        }
    }

    public static uSDKErrorConst valueOf(String str) {
        return (uSDKErrorConst) Enum.valueOf(uSDKErrorConst.class, str);
    }

    public static uSDKErrorConst[] values() {
        return (uSDKErrorConst[]) $VALUES.clone();
    }

    public int getErrorId() {
        return this.errorConst.getErrorId();
    }

    public int getSecondErrorId() {
        return this.errorConst.getSecondErrorId();
    }

    public String getValue() {
        return this.errorConst.getErrorInfo();
    }

    public uSDKError toError() {
        uSDKError usdkerror = new uSDKError();
        usdkerror.setCode(getErrorId());
        usdkerror.setDescription(getValue());
        return usdkerror;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "uSDKErrorConst{errorId=" + getErrorId() + ", secondErrorId=" + getSecondErrorId() + ", errorInf=" + getValue() + '}';
    }
}
