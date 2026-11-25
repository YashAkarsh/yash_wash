package com.haier.uhome.usdk.base.api;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public enum ErrorConst {
    RET_USDK_OK(0, "接口执行成功"),
    ERR_USDK_INVALID_PARAM(-10001, "无效参数错误"),
    ERR_USDK_UNSTARTED(-10002, "SDK未启动"),
    ERR_USDK_TIMEOUT(com.haier.uhome.usdk.base.a.C0377a.f31094i, "接口执行超时"),
    ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD(-10004, "主线程执行耗时操作"),
    ERR_USDK_NOT_CALL_INIT(-10005, "未调用SDK初始化"),
    ERR_INTERNAL(-10006, "内部错误"),
    ERR_USDK_ALREADY_STOPPED(-10007, "SDK已经停止"),
    ERR_USDK_CLOUD_COMMON_ERROR(-10008, "云平台通用错误"),
    ERR_USDK_INVALID_COMMAND(-10009, "非法命令"),
    ERR_MODULE_UNSTARTED(-10010, "模块未启动"),
    ERR_MODULE_STOPPED(-10011, "模块已经停止"),
    ERR_USDK_APPID_APPKEY_NULL(-10012, "APPID或APPKEY为空"),
    ERR_USDK_SSID_NOT_MATCHING(-10013, "SSID不匹配"),
    ERR_USDK_NAME_MAC_NULL(-10014, "设备NAME和MAC为空"),
    ERR_USDK_NETWORK_EXCEPTION(-10015, "网络异常"),
    ERR_USDK_START_FAILED(-12001, "SDK启动失败"),
    ERR_USDK_STARTING(-12002, "SDK正在启动"),
    ERR_USDK_ROUTER_VERSION_TOO_LOW(-12003, "路由器版本过低"),
    ERR_USDK_ROUTER_TYPE_UNSPPORTED(-12004, "路由器型号不支持"),
    ERR_USDK_CLOUD_OFFLINE(-12005, "云连接离线"),
    ERR_USDK_FEATURE_NOT_SUPPORT(-12006, "不支持该特性"),
    ERR_USDK_REMOTE_DEVICE_DUPLICATE(-13001, "远程设备重复"),
    ERR_USDK_REMOTE_DEVICE_NOT_EXIST(-13002, "远程设备不存在"),
    ERR_USDK_WIFI_NOT_ENABLE(-13003, "WIFI未打开"),
    ERR_USDK_DEVICE_SCANNING(-13004, "正在扫描设备"),
    ERR_USDK_DEVICE_SCANNER_LISTENER_NOT_REGIST(-13005, "未注册设备扫描监听器"),
    ERR_USDK_DEVICE_CONFIG_IN_PROGRESS(-13006, "设备正在配置中"),
    ERR_USDK_CONFIG_BE_CANCELED(-13007, "配置被取消"),
    ERR_USDK_RECV_ACK_BUT_NOT_FIND_DEVICE(-13008, "SMLK收到ACK,但未找到上线设备"),
    ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE(-13009, "配置完成,但未找到上线设备"),
    ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID(-13010, "配置完成,但当前网络未切换到配置SSID上"),
    ERR_USDK_DEVICE_UPLUSID_INVALID(-13011, "无效的uplusID"),
    ERR_USDK_TIMEOUT_WITHOUT_GETCONFIGINFO_ACK(-13012, "首次执行GetConfigInfo未收到结果已超时"),
    ERR_USDK_TIMEOUT_WITHOUT_SOFTAPCONFIG_ACK(-13013, "首次执行SoftApConfig未收到结果已超时"),
    ERR_USDK_SOFTAP_CONFIG_IS_CANCELED_BY_USER(-13014, "softap配置被用户主动取消"),
    ERR_USDK_DEVICE_UPLUSID_NOT_MATCH(-13015, "uplusID不匹配"),
    ERR_USDK_CURRENT_SSID_IS_NOT_IOT(-13016, "softap配置未连接到设备热点"),
    ERR_USDK_SOFTAP_CONFIG_NOT_RECEIVE_ACK_BUT_SSID_CHANGED(-13017, "softap配置下发信息未收到ACK，但SSID已变化"),
    ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_FIND_DEVICE(-13018, "softap配置未收到ACK, 且未找到上线设备"),
    ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_SWITCH_TO_CONFIGED_SSID(-13019, "softap配置未收到ACK, 且网络未切换到配置的SSID上"),
    ERR_USDK_PASSWORD_LENGTH_INVALID(-13020, "密码长度不符合要求"),
    ERR_USDK_BLE_NOT_OPEN(-13021, "蓝牙未打开"),
    ERR_USDK_NOT_RECV_ACK(-13022, "未收到ACK"),
    ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT(-13023, "设备进入组网模式超时"),
    ERR_USDK_GET_BIND_RESULT_TIMEOUT(-13024, "获取绑定结果超时"),
    ERR_USDK_WAIT_NETWORKING_RESULT_TIMEOUT(-13025, "等待组网结果超时"),
    ERR_USDK_DEVICE_NEED_TRIGGER_CONFIG(-13027, "设备需要触发进配置"),
    ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE(-13028, "设备不在配网状态"),
    ERR_USDK_DEVICE_VERIFY_FAILED(-13029, "设备校验失败"),
    ERR_USDK_DEVICE_VERIFY_TIMEOUT(-13030, "设备校验超时"),
    ERR_USDK_SEND_CONFIG_REQ_TIMEOUT(-13031, "发送配置请求超时"),
    ERR_USDK_DEVICE_ALREADY_CONNECTED(-14001, "设备已连接"),
    ERR_USDK_DEVICE_READ_ATTR(-14002, "读取设备属性异常"),
    ERR_USDK_DEVICE_NOT_CONNECT(-14003, "设备未连接"),
    ERR_USDK_DEVICE_NOT_CONNECTED(-14004, "设备未连接成功或未就绪"),
    ERR_USDK_SUBDEVICE_DO_NOT_NEED_CONNECT(-14006, "子机设备不需要连接"),
    ERR_USDK_DEVICE_IS_BUSY(-14007, "设备状态繁忙"),
    ERR_USDK_DEVICE_NOT_LOCAL(-14009, "设备不是本地设备"),
    ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST(-14010, "请先调用connectToCloud接口"),
    ERR_USDK_SECURITY_DEVICE_WITHOUT_TOKEN(-14011, "安全设备无token"),
    ERR_USDK_OFFLINE_DECLARE(-14014, "设备进入配置模式导致的离线"),
    ERR_USDK_DEVICE_IS_OFFLINE(-14017, "设备离线"),
    ERR_USDK_GATEWAY_IS_CONNECTED(-14018, "云平台已连接，切换用户需先断开云平台连接，再使用新token连接云平台"),
    ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE(-14019, "停止搜索导致的离线"),
    ERR_USDK_NOT_SUPPORT(-14020, "不支持的操作"),
    ERR_USDK_DEVICE_NOT_NETQUALITY(-14021, "设备没有网络信号质量指标"),
    ERR_USDK_DEVICE_NOT_GET_NETQUALITY(-14022, "未获取到网络信号质量指标"),
    ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE(-14023, "设备不支持授权"),
    ERR_USDK_DEVICE_AUTHORIZE_ERROR(-14024, "授权失败"),
    ERR_USDK_DEVICE_AUTHORIZE_INVALID_ERROR(-14025, "取消授权失败"),
    ERR_USDK_DEVICE_QUERY_AUTHORIZE_STATUS_FAILURE(-14026, "查询设备授权状态失败"),
    ERR_USDK_DEVICE_NOT_FOUND(-14028, "找不到设备"),
    ERR_USDK_DEVICE_REMOTE_STATE_NOT_READY(-14029, "远程未就绪"),
    ERR_USDK_BLE_CHARACTERISTICS_NOT_FOUND(-14030, "未找到指定的蓝牙属性"),
    ERR_USDK_BLE_OPERATION_NOT_SUPPORT(-14031, "该操作不支持"),
    ERR_USDK_NETWORK_IS_NONE(-14032, "网络开关被关闭"),
    ERR_USDK_NETWORK_IS_SWITCHED(-14033, "发生了切网"),
    ERR_USDK_PHONE_IS_OFFLINE(-14035, "手机离线"),
    ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE(-14036, "BLE设备进配置导致离线"),
    ERR_USDK_BLE_IS_POWER_OFF(-14037, "蓝牙开关被关闭"),
    ERR_USDK_FOTA_INFO_IS_NULL(-14038, "无升级信息，需要先调用checkBoardFOTAInfo接口获取升级信息"),
    ERR_USDK_DONT_NEED_FOTA(-14039, "设备无需升级"),
    ERR_USDK_DONT_NEED_OTA(-14040, "设备无需升级"),
    ERR_USDK_MODULE_IS_OTAING(-14041, "设备正在升级中"),
    ERR_USDK_MODULE_OTA_TIMEOUT(-14042, "设备OTA升级超时"),
    ERR_USDK_MODULE_OTA_SEARCH_FAIL(-14043, "设备OTA升级搜索失败"),
    ERR_USDK_DEVICE_IS_NOT_BOUND(-14044, "设备未被绑定"),
    ERR_USDK_DEVICE_NOT_CONNECT_ROUTER_CAUSE_OFFLINE(-14046, "设备未连接路由器导致离线"),
    ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD(-14047, "设备无需更新SSID、PWD"),
    ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR(-14048, "设备更新SSID、PWD失败,SSID没搜到或PWD错误"),
    ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT(-14052, "设备更新SSID、PWD超时"),
    ERR_USDK_IS_NOT_MESH_DEVICE(-14053, "设备不是MESH设备"),
    ERR_USDK_IS_NOT_GROUP_DEVICE(-14054, "不是组设备"),
    ERR_USDK_DEVICE_NOT_SUPPORT_GROUP(-14055, "设备不具备分组能力"),
    ERR_USDK_NO_GROUPABLE_DEVICE(-14056, "无可分组设备"),
    ERR_USDK_GROUP_IS_OPERATING(-14057, "当前正在进行组操作"),
    ERR_USDK_GROUP_DEVICE_CAN_NOT_CREATE_GROUP(-14058, "组设备不能再创建组"),
    ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE(-14059, "该设备蓝牙通路不可达"),
    ERR_USDK_NOT_SUPPORT_SUCH_DEVICE_OTA(-14060, "接口不支持此类设备OTA"),
    ERR_USDK_DEVICE_DISCONNECT_FROM_US(-14061, "当前设备主动断开连接"),
    ERR_USDK_TRACE_IS_NOT_STARTED(-15001, "链式跟踪未创建起点"),
    ERR_USDK_TRACE_NODE_DUPLICATED(-15002, "链式跟踪重复打点"),
    ERR_USDK_TRACE_NODE_STEP_DISORDER(-15003, "链式跟踪打点顺序错误"),
    ERR_USDK_DEVICE_IS_IN_BINDING(-16001, "设备正在绑定中"),
    ERR_USDK_DEVICE_IS_NOT_IN_BINDING(-16002, "设备不在绑定中"),
    ERR_USDK_BIND_DEVICE_IS_CANCELED(-16003, "设备绑定已取消"),
    ERR_USDK_GET_BINDINFO_TIMEOUT(-16004, "uSDK获取设备绑定信息超时"),
    ERR_USDK_BIND_DEVICE_TIMEOUT(-16005, "uSDK绑定设备超时"),
    ERR_USDK_SECURITY_MODULE_NOT_STARTED(-16006, "Mesh网络初始化失败"),
    ERR_USDK_CREATE_SECURITY_SDK_BIND_CLASS_FAIL(-16007, "反射创建安防SDK绑定类失败"),
    ERR_USDK_DEVICE_BIND_FAILED(-16008, "设备绑定失败"),
    ERR_USDK_MESH_DEVICE_INFO_REQUEST_FAIL(-16008, "设备Mesh信息分配失败"),
    ERR_USDK_CAMERA_SDK_COMMON_ERROR(-16009, "安防通用错误"),
    ERR_USDK_USER_TOKEN_INVALID(-16010, "TOKEN失效"),
    ERR_USDK_USER_BIND_COUNT_LIMIT(-16011, "用户绑定数量达到上限"),
    ERR_USDK_DEVICE_LOCAL_EXIST_AND_GET_BIND_RESULT_TIMEOUT(-16012, "小循环搜到了且mqtt或https消息超时"),
    ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT(-16013, "小循环没搜到且mqtt或https消息超时"),
    ERR_USDK_NO_RESULT_BINDING(-16014, "mqtt或https成功，但无此次绑定的绑定结果"),
    ERR_USDK_PHONE_BIND_DEVICE_TIMEOUT(-16015, "mqtt或https消息超时"),
    ERR_USDK_OPENING_BINDING_TIME_WINDOW_TIMEOUT(-16016, "开启绑定时间窗超时"),
    ERR_USDK_SECURITY_SIDE_BINDING_TIMEOUT(-16017, "安防侧绑定超时"),
    ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND(-16018, "绑定超时需要重试绑定"),
    ERR_USDK_NO_NEED_RETYR_BIND(-16019, "没有需要重试的绑定"),
    ERR_USDK_BIND_CODE_FAILED(-16020, "获取BindCode失败"),
    ERR_USDK_NOT_SUPPORT_GET_ROUTER_INFO(-16021, "不支持获取配置的路由器信息"),
    ERR_USDK_GET_ROUTER_INFO_FAIL(-16022, "获取路由器信息失败"),
    ERR_USDK_GET_ROUTER_INFO_TIMEOUT(-16023, "获取路由器信息超时"),
    ERR_USDK_SAVE_DEVICE_VERSION_FAIL(-16024, "保存设备版本信息失败"),
    ERR_USDK_MESH_DEVICE_PROVISION_FAIL(-16025, "设备provision失败"),
    ERR_USDK_MESH_DEVICE_CONFIGURATION_FAIL(-16026, "设备configuration失败"),
    ERR_USDK_QRCODE_INVALID(-16027, "绑定的二维码已失效"),
    ERR_USDK_UGW_DEVICE_ADDING(-17001, "UWG设备正在添加"),
    ERR_USDK_UGW_DEVICE_ALREADY_ADD(-17002, "UGW设备已经添加"),
    ERR_USDK_UGW_HOST_DEVICE_NOT_ADD(-17003, "主机设备未添加"),
    ERR_USDK_PING_IS_IN_WORKING(-18001, "ping正在进行中"),
    ERR_USDK_PING_IS_STOPED(-18002, "ping被中断"),
    ERR_USDK_HTTP_DNS_ERROR(-19001, "域名解析错误"),
    ERR_USDK_NO_SIMILAR_DEVICE(-19002, "无可分组设备"),
    ERR_USDK_ADD_DEVICE_NONE_TO_GROUP(-19003, "没有添加任何设备到组"),
    ERR_USDK_REMOVE_DEVICE_NONE_FROM_GROUP(-19004, "从组内没有移除任何设备"),
    ERR_USDK_IS_NO_MESH_DEVICE(-19005, "不是MESH设备"),
    ERR_USDK_IS_NO_MESH_GROUP_DEVICE(-19006, "不是MESH组设备"),
    ERR_USDK_IS_CREATING_MESH_GROUP(-19007, "设备正在创建mesh组中"),
    ERR_USDK_IS_ADDING_DEVICE_TO_MESH_GROUP(-19008, "正在添加设备到mesh组中"),
    ERR_USDK_IS_REMOVING_DEVICE_FROM_MESH_GROUP(-19009, "正在移除设备到mesh组中"),
    ERR_USDK_NOT_SEARCH_DEVICE_CAUSE_NOT_OTA(-19010, "手机未搜索到设备，无法进FOTA相关操作"),
    ERR_USDK_DEVICE_OTA_PKG_DOWNLOAD_FAIL(-19011, "OTA升级包下载失败"),
    ERR_USDK_DEVICE_OTA_PKG_VALIDATE_FAIL(-19012, "OTA升级包校验失败"),
    ERR_USDK_DEVICE_OTA_INTERRUPTED(-19013, "设备升级异常终止"),
    ERR_USDK_DEVICE_NOT_IN_OTA_MODE(-19014, "模块不处于ota状态中"),
    ERR_USDK_DEVICE_SEND_OTA_FILE_TIMEOUT(-19015, "设备OTA升级超时"),
    ERR_USDK_REMOVE_DEVICE_CLOUD_FAIL(-19016, "移出分组成功但同步平台失败"),
    ERR_USDK_MONITOR_DEVICE_NOT_PLAY(-19017, "监控设备未开始播放"),
    ERR_USDK_MONITOR_DEVICE_CONNECT_FAILURE(-19018, "监控设备连接失败"),
    ERR_USDK_PLAYER_COMMON_FAILURE(-19500, "视频功能通用错误"),
    ERR_USDK_PLAYER_INTERNAL_FAILURE(-19501, "视频功能内部错误"),
    ERR_USDK_PLAYER_PLAYBACKLIST_EMPTY(-19502, "录像列表为空"),
    ERR_USER_MONITOR_RESOLUTION_CHANGED(-19503, "视频分辨率已改变"),
    ERR_USER_MAXIMUM_CHANNEL_EXCEEDED(-19504, "超过设备可支持的最大P2P通道数"),
    ERR_USER_CHANNEL_MESSAGE_SEND_FAILED(-19505, "P2P通道消息发送失败"),
    ERR_USER_CHANNEL_MESSAGE_SEND_TIMEOUT(-19506, "P2P通道消息发送超时"),
    ERR_USER_DEVICE_RECORD(-19507, "设备正在录制"),
    ERR_USER_CHANNEL_NUMBER_FULL(-19508, "APP端通道连接数已达上限"),
    ERR_USER_FAIL_GET_DATA(-19509, "获取数据失败"),
    ERR_USER_BEGIN(-20000, "定义ErrorConst的边界");

    private static SparseArray<ErrorConst> mMap = new SparseArray<>();
    private int errorId;
    private String errorInfo;
    private int secondErrorId;

    static {
        for (ErrorConst errorConst : values()) {
            mMap.put(errorConst.errorId, errorConst);
        }
    }

    ErrorConst(int i7, String str) {
        this.errorId = i7;
        this.errorInfo = str;
    }

    public static ErrorConst getCustomErrorConst(int i7, int i8, String str) {
        ErrorConst errorConstById = getErrorConstById(i7, i8);
        errorConstById.setErrorInfo(str);
        return errorConstById;
    }

    public static ErrorConst getCustomInternalErrorConst(int i7) {
        return getErrorConstById(ERR_INTERNAL.getErrorId(), i7);
    }

    @Deprecated
    public static ErrorConst getErrorConstById(int i7) {
        return getErrorConstById(i7, 0);
    }

    private void setErrorId(int i7) {
        this.errorId = i7;
    }

    private void setErrorInfo(String str) {
        this.errorInfo = str;
    }

    private void setSecondErrorId(int i7) {
        this.secondErrorId = i7;
    }

    public int getErrorId() {
        return this.errorId;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public int getSecondErrorId() {
        return this.secondErrorId;
    }

    public uSDKError toError() {
        uSDKError usdkerror = new uSDKError();
        usdkerror.setCode(getErrorId());
        usdkerror.setDescription(getErrorInfo());
        return usdkerror;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ErrorConst{errorId=" + this.errorId + ", errorInfo=" + this.errorInfo + ", secondErrorId=" + this.secondErrorId + "} ";
    }

    public static ErrorConst getErrorConstById(int i7, int i8) {
        ErrorConst errorConst = ERR_INTERNAL;
        if (mMap.get(i7) == null) {
            errorConst.setErrorId(i7);
            e3.a.h("internal uSDK error id :" + i7, new Object[0]);
        } else {
            errorConst = mMap.get(i7);
        }
        errorConst.setSecondErrorId(i8);
        return errorConst;
    }
}
