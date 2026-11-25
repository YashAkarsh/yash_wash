package d4;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33478a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f33479b = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f33480c = 19;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f33481d = 22;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f33482e = 62;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f33483f = 34;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f33484g = 40;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f33485h = 256;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f33486i = 133;

    public static String a(int i7) {
        if (i7 == 257) {
            return "0x0101-TOO MANY OPEN CONNECTIONS";
        }
        switch (i7) {
            case 0:
                return "0x0000 - SUCCESS";
            case 1:
                return "0x0001-GATT_INVALID_HANDLE";
            case 2:
                return "0x0002-GATT_READ_NOT_PERMIT";
            case 3:
                return "0x0003-GATT_WRITE_NOT_PERMIT";
            case 4:
                return "0x0004-GATT_INVALID_PDU";
            case 5:
                return "0x0005-GATT_INSUF_AUTHENTICATION";
            case 6:
                return "0x0006-GATT_REQ_NOT_SUPPORTED";
            case 7:
                return "0x0007-GATT_INVALID_OFFSET";
            case 8:
                return "0x0008-GATT_INSUF_AUTHORIZATION";
            case 9:
                return "0x0009-GATT_PREPARE_Q_FULL";
            case 10:
                return "0x000a-GATT_NOT_FOUND";
            case 11:
                return "0x000b-GATT_NOT_LONG";
            case 12:
                return "0x000c-GATT_INSUF_KEY_SIZE";
            case 13:
                return "0x000d-GATT_INVALID_ATTR_LEN";
            case 14:
                return "0x000e-GATT_ERR_UNLIKELY";
            case 15:
                return "0x000f-GATT_INSUF_ENCRYPTION";
            case 16:
                return "0x0010-GATT_UNSUPPORT_GRP_TYPE";
            case 17:
                return "0x0011-GATT_INSUF_RESOURCE";
            default:
                switch (i7) {
                    case 128:
                        return "0x0080-GATT_NO_RESOURCES";
                    case 129:
                        return "0x0081-GATT_INTERNAL_ERROR";
                    case 130:
                        return "0x0082-GATT_WRONG_STATE";
                    case 131:
                        return "0x0083-GATT_DB_FULL";
                    case 132:
                        return "0x0084-GATT_BUSY";
                    case f33486i /* 133 */:
                        return "0x0085-GATT_ERROR";
                    case 134:
                        return "0x0086-GATT_CMD_STARTED";
                    case 135:
                        return "0x0087-GATT_ILLEGAL_PARAMETER";
                    case 136:
                        return "0x0088-GATT_PENDING";
                    case 137:
                        return "0x0089-GATT_AUTH_FAIL";
                    case 138:
                        return "0x008a-GATT_MORE";
                    case 139:
                        return "0x008b-GATT_INVALID_CFG";
                    case 140:
                        return "0x008c-GATT_SERVICE_STARTED";
                    case 141:
                        return "0x008d-GATT_ENCRYPED_NO_MITM";
                    case 142:
                        return "0x008e-GATT_NOT_ENCRYPTED";
                    case 143:
                        return "0x008f-GATT_CONGESTED";
                    default:
                        switch (i7) {
                            case 253:
                                return "0x00FD-GATT_CCC_CFG_ERR";
                            case 254:
                                return "0x00FE-GATT_PRC_IN_PROGRESS";
                            case 255:
                                return "0x00FF-GATT_OUT_OF_RANGE";
                            default:
                                return "UNKNOWN (" + i7 + ")";
                        }
                }
        }
    }

    public static String b(int i7) {
        if (i7 == 0) {
            return "0x0000 - SUCCESS";
        }
        if (i7 == 1) {
            return "0x01-GATT_CONN_L2C_FAILURE";
        }
        if (i7 == 8) {
            return "0x08-GATT_CONN_TIMEOUT";
        }
        if (i7 == 19) {
            return "0x13-GATT_CONN_TERMINATE_PEER_USER";
        }
        if (i7 == 22) {
            return "0x16-GATT_CONN_TERMINATE_LOCAL_HOST";
        }
        if (i7 == 34) {
            return "0x22-GATT_CONN_LMP_TIMEOUT";
        }
        if (i7 == 62) {
            return "0x3E-GATT_CONN_FAIL_ESTABLISH";
        }
        if (i7 == 133) {
            return "0x0085-GATT_ERROR";
        }
        if (i7 == 256) {
            return "0x0100-GATT_CONN_CANCEL";
        }
        return "UNKNOWN (" + i7 + ")";
    }
}
