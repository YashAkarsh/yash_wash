package com.haier.uhome.mesh.bridge;

import com.haier.library.common.util.u;
import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DataCenter {
    private List<MeshAppKey> mAppKeys;
    private long mIvIndex;
    private List<MeshDeviceNode> mKnownNodes;
    private List<MeshNetKey> mNetKeys;
    private int mUnicast;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static DataCenter f29493a = new DataCenter();

        private a() {
        }
    }

    public static DataCenter getInstance() {
        return a.f29493a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getAppKey$0(int i7, MeshAppKey meshAppKey) {
        return i7 == meshAppKey.getIndex();
    }

    void addKnownNodes(MeshDeviceNode meshDeviceNode) {
        this.mKnownNodes.add(meshDeviceNode);
    }

    public MeshAppKey getAppKey(final int i7) {
        if (u.h(this.mAppKeys)) {
            return null;
        }
        ArrayList arrayListB = u.b(this.mAppKeys, new u.c() { // from class: com.haier.uhome.mesh.bridge.a
            @Override // com.haier.library.common.util.u.c
            public final boolean a(Object obj) {
                return DataCenter.lambda$getAppKey$0(i7, (MeshAppKey) obj);
            }
        });
        if (u.h(arrayListB)) {
            return null;
        }
        return (MeshAppKey) arrayListB.get(0);
    }

    List<MeshAppKey> getAppKeys() {
        return new ArrayList(this.mAppKeys);
    }

    public long getIvIndex() {
        return this.mIvIndex;
    }

    List<MeshDeviceNode> getKnownNodes() {
        return new ArrayList(this.mKnownNodes);
    }

    List<MeshNetKey> getNetKeys() {
        return new ArrayList(this.mNetKeys);
    }

    public int getUnicast() {
        return this.mUnicast;
    }

    void recordInitData(int i7, long j7, List<MeshDeviceNode> list, List<MeshNetKey> list2, List<MeshAppKey> list3) {
        this.mUnicast = i7;
        this.mIvIndex = j7;
        this.mKnownNodes = new CopyOnWriteArrayList(list);
        this.mNetKeys = new CopyOnWriteArrayList(list2);
        this.mAppKeys = new CopyOnWriteArrayList(list3);
    }

    private DataCenter() {
    }
}
