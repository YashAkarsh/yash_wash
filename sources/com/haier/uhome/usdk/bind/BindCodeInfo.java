package com.haier.uhome.usdk.bind;

/* JADX INFO: loaded from: classes2.dex */
public class BindCodeInfo {

    @g3.b(name = "bindCode")
    private long bindCode;

    @g3.b(name = "open")
    private boolean open;

    @g3.b(name = "seed")
    private int seed;

    @g3.b(name = "traceIdB")
    private String traceIdB;

    public long getBindCode() {
        return this.bindCode;
    }

    public int getSeed() {
        return this.seed;
    }

    public String getTraceIdB() {
        return this.traceIdB;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setBindCode(long j7) {
        this.bindCode = j7;
    }

    public void setOpen(boolean z7) {
        this.open = z7;
    }

    public void setSeed(int i7) {
        this.seed = i7;
    }

    public void setTraceIdB(String str) {
        this.traceIdB = str;
    }

    public String toString() {
        return "BindCodeInfo{seed=" + this.seed + ", bindCode=" + this.bindCode + ", traceIdB='" + this.traceIdB + "', open=" + this.open + '}';
    }
}
