package com.haier.uhome.video.a;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static uSDKError a(int i7) {
        if (i7 == 21030 || i7 == 21033 || i7 == 21036 || i7 == 21037) {
            return ErrorConst.ERR_USDK_PLAYER_INTERNAL_FAILURE.toError();
        }
        if (i7 == 21032) {
            return ErrorConst.ERR_USDK_PLAYER_PLAYBACKLIST_EMPTY.toError();
        }
        if (i7 == 21035) {
            return ErrorConst.ERR_USER_MONITOR_RESOLUTION_CHANGED.toError();
        }
        if (i7 == 20007) {
            return ErrorConst.ERR_USER_MAXIMUM_CHANNEL_EXCEEDED.toError();
        }
        if (i7 == 21000 || i7 == 21001 || i7 == 21021 || i7 == 21022 || i7 == 21023 || i7 == 21024 || i7 == 21005 || i7 == 21006 || i7 == 21007 || i7 == 21008 || i7 == 20140 || i7 == 20006 || i7 == 20009 || i7 == 20010 || i7 == 20011 || i7 == 20012 || i7 == 20013) {
            return ErrorConst.ERR_USER_CHANNEL_MESSAGE_SEND_FAILED.toError();
        }
        if (i7 == 20001 || i7 == 20003 || i7 == 20005 || i7 == 21002 || i7 == 20008 || i7 == 20002 || i7 == 20004 || i7 == 21025) {
            return ErrorConst.ERR_USER_CHANNEL_MESSAGE_SEND_TIMEOUT.toError();
        }
        return i7 == 21034 ? ErrorConst.ERR_USER_DEVICE_RECORD.toError() : ErrorConst.ERR_USDK_INVALID_PARAM.toError();
    }
}
