package com.haier.uhome.usdk.scene.json.down;

import com.haier.library.json.a;
import com.haier.uhome.usdk.scene.json.ProtocolConst;
import g3.b;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SceneSubscribeResp implements BaseDown {

    @b(name = "devId")
    private String devId;

    @b(name = "errNo")
    private int errNo;

    @b(name = "sn")
    private int sn;

    @Override // com.haier.uhome.usdk.scene.json.down.BaseDown
    public String buildJson() {
        HashMap map = new HashMap(1);
        map.put(ProtocolConst.DOWN_SCENE_SUBSCRIBE_RESP, this);
        return a.Z(map);
    }

    public String getDevId() {
        return this.devId;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public int getSn() {
        return this.sn;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public String toString() {
        return "SceneSubscribeResp{sn='" + this.sn + "', devId='" + this.devId + "', errNo='" + this.errNo + "'}";
    }
}
