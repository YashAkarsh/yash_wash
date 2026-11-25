package com.haier.uhome.control.base.json.resp;

import com.haier.library.common.util.c;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;
import m0.a;

/* JADX INFO: loaded from: classes2.dex */
public class BleMeshSelfNodeInfoResp extends BasicResp {

    @b(name = "appkeyIndex")
    private int appKeyIndex;

    @b(name = a.f37449i)
    private byte[] appkey;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "ivIndex")
    private int ivIndex;

    @b(name = "netID")
    private int netID;

    @b(name = "netkey")
    private byte[] netKey;

    @b(name = "netkeyIndex")
    private int netKeyIndex;

    public int getAppKeyIndex() {
        return this.appKeyIndex;
    }

    public byte[] getAppkey() {
        return this.appkey;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    public int getIvIndex() {
        return this.ivIndex;
    }

    public int getNetID() {
        return this.netID;
    }

    public byte[] getNetKey() {
        return this.netKey;
    }

    public int getNetKeyIndex() {
        return this.netKeyIndex;
    }

    public void setAppKeyIndex(int i7) {
        this.appKeyIndex = i7;
    }

    public void setAppkey(String str) {
        this.appkey = c.g(str);
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setIvIndex(int i7) {
        this.ivIndex = i7;
    }

    public void setNetID(int i7) {
        this.netID = i7;
    }

    public void setNetKey(String str) {
        this.netKey = c.g(str);
    }

    public void setNetKeyIndex(int i7) {
        this.netKeyIndex = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "BleMeshSelfNodeInfoResp{netKey=" + c.o(this.netKey) + ", netKeyIndex=" + this.netKeyIndex + ", appkey=" + c.o(this.appkey) + ", appKeyIndex=" + this.appKeyIndex + ", elementAddr=" + this.elementAddr + ", ivIndex=" + this.ivIndex + ", netID=" + this.netID + '}';
    }
}
