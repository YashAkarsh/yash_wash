package com.haier.uhome.mesh.api.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InitNodeParam {
    private List<MeshAppKey> mAppKeys;
    private long mIvIndex;
    private List<MeshDeviceNode> mKnownNodes;
    private List<MeshNetKey> mNetKeys;
    private int mUnicast;

    public static class Builder {
        private List<MeshAppKey> appKeys;
        private long ivIndex;
        private List<MeshDeviceNode> knownNodes;
        private List<MeshNetKey> netKeys;
        private int unicast;

        public Builder appKey(List<MeshAppKey> list) {
            this.appKeys = new ArrayList(list);
            return this;
        }

        public InitNodeParam build() {
            return new InitNodeParam(this);
        }

        public Builder ivIndex(long j7) {
            this.ivIndex = j7;
            return this;
        }

        public Builder knownNode(List<MeshDeviceNode> list) {
            this.knownNodes = new ArrayList(list);
            return this;
        }

        public Builder netKey(List<MeshNetKey> list) {
            this.netKeys = new ArrayList(list);
            return this;
        }

        public Builder unicast(int i7) {
            this.unicast = i7;
            return this;
        }
    }

    public List<MeshAppKey> getAppKeys() {
        return this.mAppKeys;
    }

    public long getIvIndex() {
        return this.mIvIndex;
    }

    public List<MeshDeviceNode> getKnownNodes() {
        return this.mKnownNodes;
    }

    public List<MeshNetKey> getNetKeys() {
        return this.mNetKeys;
    }

    public int getUnicast() {
        return this.mUnicast;
    }

    public String toString() {
        return "InitNodeParam{mUnicast=" + this.mUnicast + ", mIvIndex=" + this.mIvIndex + ", mKnownNodes=" + this.mKnownNodes + ", mNetKeys=" + this.mNetKeys + ", mAppKeys=" + this.mAppKeys + '}';
    }

    private InitNodeParam(Builder builder) {
        this.mUnicast = builder.unicast;
        this.mIvIndex = builder.ivIndex;
        this.mKnownNodes = builder.knownNodes;
        this.mNetKeys = builder.netKeys;
        this.mAppKeys = builder.appKeys;
    }
}
