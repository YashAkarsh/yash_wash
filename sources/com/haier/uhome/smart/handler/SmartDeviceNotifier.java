package com.haier.uhome.smart.handler;

import com.haier.uhome.smart.json.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDeviceNotifier extends com.haier.uhome.usdk.base.c.d {
    private final List<ISmartDeviceNotifier> mNotifiers;
    private final List<ISmartDeviceGroupNotifier> mSmartDeviceGroupNotifers;
    private final List<ISmartBindNotifier> mSmartNotifiers;
    private final List<ISmartDeviceOtaNotifer> mSmartOtaNotifiers;

    private static class SingletonFactory {
        private static SmartDeviceNotifier sInstance = new SmartDeviceNotifier();

        private SingletonFactory() {
        }
    }

    public static SmartDeviceNotifier getInstance() {
        return SingletonFactory.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyConfigProgress$14(int i7, int i8) {
        Iterator<ISmartBindNotifier> it = this.mSmartNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyConfigProgress(i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyConfigResult$15(int i7, int i8) {
        Iterator<ISmartBindNotifier> it = this.mSmartNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyConfigResult(i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceAuthToken$9(int i7, String str, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceAuthToken(i7, str, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceBindResult$10(String str, int i7, int i8, int i9) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceBindResult(str, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceBindStatus$23(String str, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceBindStatus(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceBindWindow$5(String str, String str2, int i7, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceBindWindow(str, str2, i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceBusiness$4(String str, String str2, byte[] bArr, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceBusinessDown(str, str2, bArr, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceCloudMsg$6(String str, int i7, int i8, int i9) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceCloudMsg(str, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceCloudState$3(int i7, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceCloudState(i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceDepairing$19(String str, String str2, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceDepairing(str, str2, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceGetLocalKey$7(String str, String str2, int i7, int i8, int i9, int i10) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceGetLocalKey(str, str2, i7, i8, i9, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceGroupControl$26(int i7, int i8, String str, String str2) {
        Iterator<ISmartDeviceGroupNotifier> it = this.mSmartDeviceGroupNotifers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceGroupControl(i7, i8, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceGroupMember$27(String str, int i7, List list) {
        Iterator<ISmartDeviceGroupNotifier> it = this.mSmartDeviceGroupNotifers.iterator();
        while (it.hasNext()) {
            it.next().notifyGroupMember(str, i7, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceOp$2(String str, int i7, String str2, ArrayList arrayList, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceOp(str, i7, str2, arrayList, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDevicePairing$18(String str, int i7, String str2, String str3, String str4, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDevicePairing(str, i7, str2, str3, str4, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceRead$0(String str, int i7, String str2, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceRead(str, i7, str2, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceRelationResult$30(String str, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceRelationResult(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceUnbindStatus$24(String str, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceUnbindStatus(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyDeviceWrite$1(String str, int i7, String str2, String str3, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceWrite(str, i7, str2, str3, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOtaDownload$21(String str, String str2, String str3, String str4, int i7) {
        Iterator<ISmartDeviceOtaNotifer> it = this.mSmartOtaNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceOtaDownload(str, str2, str3, str4, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOtaDownloadFinish$22(String str, String str2, int i7, String str3, int i8) {
        Iterator<ISmartDeviceOtaNotifer> it = this.mSmartOtaNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceOtaDownloadFinish(str, str2, i7, str3, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyOtaDownloadStart$20(String str, String str2, String str3, String str4, int i7) {
        Iterator<ISmartDeviceOtaNotifer> it = this.mSmartOtaNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceOtaDownloadStart(str, str2, str3, str4, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyQueryDeviceBindStatus$25(String str, int i7, int i8, int i9, int i10) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyQueryDeviceBindStatus(str, i7, i8, i9, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyRegisterRes$17(String str, String str2, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceRegisterRes(str, str2, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyResChannelStatus$16(String str, int i7, int i8) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyDeviceResChannalStatus(str, i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifySlaveDeviceBindResult$28(String str, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifySlaveDeviceBindResult(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifySlaveDeviceUnbindResult$29(String str, int i7) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifySlaveDeviceUnbindResult(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyUSDKReq$8(String str, int i7, int i8, int i9) {
        Iterator<ISmartDeviceNotifier> it = this.mNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyUSDKReq(str, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyWifiAddDevice$12(String str, String str2, int i7, int i8, int i9) {
        Iterator<ISmartBindNotifier> it = this.mSmartNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyWifiAddDevice(str, str2, i7, i8, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyWifiDelDevice$13(String str, int i7) {
        Iterator<ISmartBindNotifier> it = this.mSmartNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyWifiDelDevice(str, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyWifiScanStatus$11(int i7, int i8) {
        Iterator<ISmartBindNotifier> it = this.mSmartNotifiers.iterator();
        while (it.hasNext()) {
            it.next().notifyWifiScanStatus(i7, i8);
        }
    }

    public void addGroupNotifier(ISmartDeviceGroupNotifier iSmartDeviceGroupNotifier) {
        if (iSmartDeviceGroupNotifier == null) {
            return;
        }
        this.mSmartDeviceGroupNotifers.add(iSmartDeviceGroupNotifier);
    }

    public void addNotifier(ISmartDeviceNotifier iSmartDeviceNotifier) {
        if (iSmartDeviceNotifier == null) {
            return;
        }
        synchronized (this.mNotifiers) {
            if (!this.mNotifiers.contains(iSmartDeviceNotifier)) {
                this.mNotifiers.add(iSmartDeviceNotifier);
            }
        }
    }

    public void addOtaNotifier(ISmartDeviceOtaNotifer iSmartDeviceOtaNotifer) {
        if (iSmartDeviceOtaNotifer == null || this.mSmartOtaNotifiers.contains(iSmartDeviceOtaNotifer)) {
            return;
        }
        this.mSmartOtaNotifiers.add(iSmartDeviceOtaNotifer);
    }

    public void notifyConfigProgress(final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f30143a.lambda$notifyConfigProgress$14(i7, i8);
            }
        });
    }

    public void notifyConfigResult(final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30074a.lambda$notifyConfigResult$15(i7, i8);
            }
        });
    }

    public void notifyDeviceAuthToken(final int i7, final String str, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f30146a.lambda$notifyDeviceAuthToken$9(i7, str, i8);
            }
        });
    }

    public void notifyDeviceBindResult(final String str, final int i7, final int i8, final int i9) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f30138a.lambda$notifyDeviceBindResult$10(str, i7, i8, i9);
            }
        });
    }

    public void notifyDeviceBindStatus(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f30163a.lambda$notifyDeviceBindStatus$23(str, i7);
            }
        });
    }

    public void notifyDeviceBindWindow(final String str, final String str2, final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f30178a.lambda$notifyDeviceBindWindow$5(str, str2, i7, i8);
            }
        });
    }

    public void notifyDeviceBusiness(final String str, final String str2, final byte[] bArr, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f30058a.lambda$notifyDeviceBusiness$4(str, str2, bArr, i7);
            }
        });
    }

    public void notifyDeviceCloudMsg(final String str, final int i7, final int i8, final int i9) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f30069a.lambda$notifyDeviceCloudMsg$6(str, i7, i8, i9);
            }
        });
    }

    public void notifyDeviceCloudState(final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f30166a.lambda$notifyDeviceCloudState$3(i7, i8);
            }
        });
    }

    public void notifyDeviceDepairing(final String str, final String str2, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f30048a.lambda$notifyDeviceDepairing$19(str, str2, i7);
            }
        });
    }

    public void notifyDeviceGetLocalKey(final String str, final String str2, final int i7, final int i8, final int i9, final int i10) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f30122a.lambda$notifyDeviceGetLocalKey$7(str, str2, i7, i8, i9, i10);
            }
        });
    }

    public void notifyDeviceGroupControl(final int i7, final int i8, final String str, final String str2) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f30095a.lambda$notifyDeviceGroupControl$26(i7, i8, str, str2);
            }
        });
    }

    public void notifyDeviceGroupMember(final String str, final int i7, final List<String> list) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f30150a.lambda$notifyDeviceGroupMember$27(str, i7, list);
            }
        });
    }

    public void notifyDeviceOp(final String str, final int i7, final String str2, final ArrayList<Pair> arrayList, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f30157a.lambda$notifyDeviceOp$2(str, i7, str2, arrayList, i8);
            }
        });
    }

    public void notifyDevicePairing(final String str, final int i7, final String str2, final String str3, final String str4, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f30106a.lambda$notifyDevicePairing$18(str, i7, str2, str3, str4, i8);
            }
        });
    }

    public void notifyDeviceRead(final String str, final int i7, final String str2, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f30077a.lambda$notifyDeviceRead$0(str, i7, str2, i8);
            }
        });
    }

    public void notifyDeviceRelationResult(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f30154a.lambda$notifyDeviceRelationResult$30(str, i7);
            }
        });
    }

    public void notifyDeviceUnbindStatus(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f30092a.lambda$notifyDeviceUnbindStatus$24(str, i7);
            }
        });
    }

    public void notifyDeviceWrite(final String str, final int i7, final String str2, final String str3, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f30100a.lambda$notifyDeviceWrite$1(str, i7, str2, str3, i8);
            }
        });
    }

    public void notifyOtaDownload(final String str, final String str2, final String str3, final String str4, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30052a.lambda$notifyOtaDownload$21(str, str2, str3, str4, i7);
            }
        });
    }

    public void notifyOtaDownloadFinish(final String str, final String str2, final int i7, final String str3, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f30132a.lambda$notifyOtaDownloadFinish$22(str, str2, i7, str3, i8);
            }
        });
    }

    public void notifyOtaDownloadStart(final String str, final String str2, final String str3, final String str4, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30082a.lambda$notifyOtaDownloadStart$20(str, str2, str3, str4, i7);
            }
        });
    }

    public void notifyQueryDeviceBindStatus(final String str, final int i7, final int i8, final int i9, final int i10) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30063a.lambda$notifyQueryDeviceBindStatus$25(str, i7, i8, i9, i10);
            }
        });
    }

    public void notifyRegisterRes(final String str, final String str2, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f30088a.lambda$notifyRegisterRes$17(str, str2, i7);
            }
        });
    }

    public void notifyResChannelStatus(final String str, final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f30118a.lambda$notifyResChannelStatus$16(str, i7, i8);
            }
        });
    }

    public void notifySlaveDeviceBindResult(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f30042a.lambda$notifySlaveDeviceBindResult$28(str, i7);
            }
        });
    }

    public void notifySlaveDeviceUnbindResult(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f30045a.lambda$notifySlaveDeviceUnbindResult$29(str, i7);
            }
        });
    }

    public void notifyUSDKReq(final String str, final int i7, final int i8, final int i9) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f30113a.lambda$notifyUSDKReq$8(str, i7, i8, i9);
            }
        });
    }

    public void notifyWifiAddDevice(final String str, final String str2, final int i7, final int i8, final int i9) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f30169a.lambda$notifyWifiAddDevice$12(str, str2, i7, i8, i9);
            }
        });
    }

    public void notifyWifiDelDevice(final String str, final int i7) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f30129a.lambda$notifyWifiDelDevice$13(str, i7);
            }
        });
    }

    public void notifyWifiScanStatus(final int i7, final int i8) {
        dispatchToMainThread(new Runnable() { // from class: com.haier.uhome.smart.handler.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f30175a.lambda$notifyWifiScanStatus$11(i7, i8);
            }
        });
    }

    public void removeGroupNotifier(ISmartDeviceGroupNotifier iSmartDeviceGroupNotifier) {
        if (iSmartDeviceGroupNotifier == null) {
            return;
        }
        this.mSmartDeviceGroupNotifers.remove(iSmartDeviceGroupNotifier);
    }

    public void removeNotifier(ISmartDeviceNotifier iSmartDeviceNotifier) {
        if (iSmartDeviceNotifier == null) {
            return;
        }
        this.mNotifiers.remove(iSmartDeviceNotifier);
    }

    public void removeOtaNotifier(ISmartDeviceOtaNotifer iSmartDeviceOtaNotifer) {
        if (iSmartDeviceOtaNotifer == null) {
            return;
        }
        this.mSmartOtaNotifiers.remove(iSmartDeviceOtaNotifer);
    }

    private SmartDeviceNotifier() {
        this.mNotifiers = new CopyOnWriteArrayList();
        this.mSmartNotifiers = new CopyOnWriteArrayList();
        this.mSmartOtaNotifiers = new CopyOnWriteArrayList();
        this.mSmartDeviceGroupNotifers = new CopyOnWriteArrayList();
    }

    public void removeNotifier(ISmartBindNotifier iSmartBindNotifier) {
        if (iSmartBindNotifier == null) {
            return;
        }
        this.mSmartNotifiers.remove(iSmartBindNotifier);
    }

    public void addNotifier(ISmartBindNotifier iSmartBindNotifier) {
        if (iSmartBindNotifier == null) {
            return;
        }
        synchronized (this.mSmartNotifiers) {
            if (!this.mSmartNotifiers.contains(iSmartBindNotifier)) {
                this.mSmartNotifiers.add(iSmartBindNotifier);
            }
        }
    }
}
