package com.haier.uhome.mesh.bridge;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class RtkErrMsg {
    private static final HashMap<Integer, String> MESH_PROVISIONING_CODES;
    private static final HashMap<Integer, String> MESH_STATUS_CODES;
    public static final int PROVISIONING_CANNOT_ASSIGN_ADDRESSES = 8;
    public static final int PROVISIONING_CONFIRMATION_FAILED = 4;
    public static final int PROVISIONING_DECRYPTION_FAILED = 6;
    public static final int PROVISIONING_INVALID_FORMAT = 2;
    public static final int PROVISIONING_INVALID_PDU = 1;
    public static final int PROVISIONING_OUT_OF_RESOURCES = 5;
    public static final int PROVISIONING_PROHIBITED = 0;
    public static final int PROVISIONING_RFU = 9;
    public static final int PROVISIONING_UNEXPECTED_ERROR = 7;
    public static final int PROVISIONING_UNEXPECTED_PDU = 3;
    private static final HashMap<Integer, String> RTK_ERR_CODES;
    public static final int RTK_FAIL_TYPE_BEARER_IDLE = 3;
    public static final int RTK_FAIL_TYPE_BEARER_LOSS = 1;
    public static final int RTK_FAIL_TYPE_BEARER_TIMEOUT = 2;
    public static final int RTK_FAIL_TYPE_BT_OFF = 18;
    public static final int RTK_FAIL_TYPE_OK = 0;
    public static final int RTK_FAIL_TYPE_OOB_ERROR = 6;
    public static final int RTK_FAIL_TYPE_PROCEDURE_ABNORMAL = 5;
    public static final int RTK_FAIL_TYPE_PROCEDURE_TIMEOUT = 4;
    public static final int STATUS_CANNOT_BIND = 13;
    public static final int STATUS_CANNOT_REMOVE = 12;
    public static final int STATUS_CANNOT_SET = 15;
    public static final int STATUS_CANNOT_UPDATE = 11;
    public static final int STATUS_FEATURE_NOT_SUPPORTED = 10;
    public static final int STATUS_INSUFFICIENT_RESOURCES = 5;
    public static final int STATUS_INVALID_ADDRESS = 1;
    public static final int STATUS_INVALID_APPKEY_INDEX = 3;
    public static final int STATUS_INVALID_BINDING = 17;
    public static final int STATUS_INVALID_MODEL = 2;
    public static final int STATUS_INVALID_NETKEY_INDEX = 4;
    public static final int STATUS_INVALID_PUBLISH_PARAMETERS = 7;
    public static final int STATUS_KEY_INDEX_ALREADY_STORED = 6;
    public static final int STATUS_NOT_A_SUBSCRIBE_MODE = 8;
    public static final int STATUS_STORAGE_FAILURE = 9;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TEMPORARILY_UNABLE_TO_CHANGE_STATE = 14;
    public static final int STATUS_UNSPECIFIED_ERROR = 16;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        RTK_ERR_CODES = map;
        HashMap<Integer, String> map2 = new HashMap<>();
        MESH_PROVISIONING_CODES = map2;
        HashMap<Integer, String> map3 = new HashMap<>();
        MESH_STATUS_CODES = map3;
        map.put(1, "pb-adv link close or le link disconnect");
        map.put(2, "pb-adv transaction timeout");
        map.put(3, "pb-adv link idle timeout");
        map.put(4, "provision procedure timeout");
        map.put(6, "provision procedure timeout");
        map.put(18, "bluetooth adapter disable");
        map2.put(0, "Prohibited");
        map2.put(1, "Invalid PDU");
        map2.put(2, "Invalid Format");
        map2.put(3, "Unexpected PDU");
        map2.put(4, "Confirmation Failed");
        map2.put(5, "Out of Resources");
        map2.put(6, "Decryption Failed");
        map2.put(7, "Unexpected Error");
        map2.put(8, "Cannot Assign Addresses");
        map3.put(0, "Success");
        map3.put(1, "Invalid Address");
        map3.put(2, "Invalid Model");
        map3.put(3, "Invalid AppKey Index");
        map3.put(4, "Invalid NetKey Index");
        map3.put(5, "Insufficient Resources");
        map3.put(6, "Key Index Already Stored");
        map3.put(7, "Invalid Publish Parameters");
        map3.put(8, "Not a Subscribe Mode");
        map3.put(9, "Storage Failure");
        map3.put(10, "Feature Not Supported");
        map3.put(11, "Cannot Update");
        map3.put(12, "Cannot Remove");
        map3.put(13, "Cannot Bind");
        map3.put(14, "Temporarily Unable to Change State");
        map3.put(15, "Cannot Set");
        map3.put(16, "Unspecified Error");
        map3.put(17, "Invalid Binding");
    }

    public static String getProvisioningErrMsg(int i7) {
        String str = MESH_PROVISIONING_CODES.get(Integer.valueOf(i7));
        return TextUtils.isEmpty(str) ? "RFU" : str;
    }

    public static String getRtkErrMsg(int i7) {
        String str = RTK_ERR_CODES.get(Integer.valueOf(i7));
        return TextUtils.isEmpty(str) ? "RFU" : str;
    }

    public static String getStatusErrMsg(int i7) {
        String str = MESH_STATUS_CODES.get(Integer.valueOf(i7));
        return TextUtils.isEmpty(str) ? "RFU" : str;
    }
}
