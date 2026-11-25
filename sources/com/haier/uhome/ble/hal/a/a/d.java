package com.haier.uhome.ble.hal.a.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.haier.library.common.util.c0;
import com.haier.uhome.control.base.json.ProtocolConst;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BluetoothGatt f28240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BluetoothDevice f28241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f28242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f28243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<BluetoothGattService> f28244e;

    d(String str) {
        BluetoothAdapter bluetoothAdapterA = com.haier.uhome.usdk.base.utils.a.a();
        if (bluetoothAdapterA == null) {
            throw new IllegalStateException("ble adapter null");
        }
        this.f28241b = bluetoothAdapterA.getRemoteDevice(str);
    }

    private BluetoothGattCharacteristic b(UUID uuid, UUID uuid2) {
        for (BluetoothGattService bluetoothGattService : this.f28244e) {
            if (uuid == bluetoothGattService.getUuid()) {
                return bluetoothGattService.getCharacteristic(uuid2);
            }
        }
        return null;
    }

    private BluetoothGattCharacteristic c(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service;
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = (uuid == null || uuid2 == null) ? null : b(uuid, uuid2);
        return (bluetoothGattCharacteristicB != null || (bluetoothGatt = this.f28240a) == null || (service = bluetoothGatt.getService(uuid)) == null) ? bluetoothGattCharacteristicB : service.getCharacteristic(uuid2);
    }

    private void d(int i7) {
        this.f28243d = i7;
    }

    private void i() {
        this.f28244e = this.f28240a.getServices();
    }

    public String a() {
        com.haier.library.json.b bVar = new com.haier.library.json.b();
        for (BluetoothGattService bluetoothGattService : this.f28244e) {
            com.haier.library.json.e eVar = new com.haier.library.json.e();
            eVar.put("uuid", bluetoothGattService.getUuid());
            com.haier.library.json.b bVar2 = new com.haier.library.json.b();
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                com.haier.library.json.e eVar2 = new com.haier.library.json.e();
                eVar2.put("uuid", bluetoothGattCharacteristic.getUuid());
                com.haier.library.json.b bVar3 = new com.haier.library.json.b();
                for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                    com.haier.library.json.e eVar3 = new com.haier.library.json.e();
                    eVar3.put("uuid", bluetoothGattDescriptor.getUuid());
                    byte[] value = bluetoothGattDescriptor.getValue();
                    if (value == null) {
                        value = new byte[0];
                    }
                    eVar3.put("value", new String(Base64.decode(value, 2)));
                    eVar3.put("value_len", Integer.valueOf(value.length));
                    bVar3.add(eVar3);
                }
                eVar2.put("descriptors", bVar3);
                bVar2.add(eVar2);
            }
            eVar.put("characters", bVar2);
            bVar.add(eVar);
        }
        return bVar.k();
    }

    public boolean e() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> discoverService.", new Object[0]);
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt != null) {
            return bluetoothGatt.discoverServices();
        }
        e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> discoverService failed, mBluetoothGatt is null", new Object[0]);
        return false;
    }

    public int f() {
        return this.f28243d;
    }

    public String g() {
        int i7 = this.f28243d;
        if (i7 == 0) {
            return "DISCONNECTED";
        }
        if (i7 == 1) {
            return ProtocolConst.ONLINE_STATE_CONNECTED;
        }
        if (i7 == 2) {
            return "REQUESTED";
        }
        if (i7 != 3) {
            return i7 != 4 ? "Un" : "READY";
        }
        return "REQUEST_FAILED";
    }

    public void h() {
        d(3);
    }

    public void d() {
        a(true);
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void b(int i7, int i8) {
        if (i8 == 0) {
            d(2);
        }
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.b(i7, i8);
        }
    }

    private void e(int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "broadcastConnectState %d", Integer.valueOf(i7));
        Intent intent = new Intent(com.haier.uhome.ble.a.f28138l);
        intent.putExtra(com.haier.uhome.ble.a.f28144r, this.f28241b.getAddress());
        intent.putExtra(com.haier.uhome.ble.a.f28148v, i7);
        com.haier.uhome.usdk.base.d.d dVar = new com.haier.uhome.usdk.base.d.d(com.haier.uhome.ble.hal.b.f28280c, 2);
        dVar.f31264c = intent;
        com.haier.uhome.usdk.base.d.c.a().c(dVar);
    }

    public void c() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> disconnect.", new Object[0]);
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr) {
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.b(bluetoothGattCharacteristic, i7, bArr);
        }
    }

    public boolean c(int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> requestMtu.", new Object[0]);
        if (this.f28240a == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> requestMtu failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        if (!com.haier.uhome.usdk.base.utils.a.d()) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "this device not support request Mtu!!!", new Object[0]);
            d(2);
            f fVar = this.f28242c;
            if (fVar == null) {
                return true;
            }
            fVar.b(23, 0);
            return true;
        }
        return this.f28240a.requestMtu(i7);
    }

    public boolean b() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> connectGatt.", new Object[0]);
        if (this.f28240a != null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> connectGatt failed, mBluetoothGatt is null", new Object[0]);
            return true;
        }
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> connectGatt failed, context is null.", new Object[0]);
            return false;
        }
        b bVar = new b(this);
        if (c0.a()) {
            this.f28240a = this.f28241b.connectGatt(contextB, false, bVar, 2);
        } else {
            this.f28240a = this.f28241b.connectGatt(contextB, false, bVar);
        }
        return this.f28240a != null;
    }

    void b(int i7) {
        a(true, i7);
    }

    public void b(f fVar) {
        if (this.f28242c == fVar) {
            this.f28242c = null;
        }
    }

    public boolean b(UUID uuid, UUID uuid2, byte[] bArr) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeCharacteristicWithNoRsp %s.", uuid2);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeCharacteristicWithNoRsp failed, characteristic is null", new Object[0]);
            return false;
        }
        if (this.f28240a == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeCharacteristicWithNoRsp failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        bluetoothGattCharacteristicC.setValue(bArr);
        bluetoothGattCharacteristicC.setWriteType(1);
        return this.f28240a.writeCharacteristic(bluetoothGattCharacteristicC);
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(int i7, int i8) {
        if (i7 == 0 && i8 == 2) {
            d(1);
            f fVar = this.f28242c;
            if (fVar != null) {
                fVar.a(i7, i8);
                return;
            }
            return;
        }
        b(i7);
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(int i7) {
        if (i7 == 0) {
            i();
            d(4);
            e(2);
        }
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.a(i7);
        }
    }

    public boolean b(UUID uuid, UUID uuid2, boolean z7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "----->  setCharacteristicIndication %s", uuid2);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicIndication failed, characteristic is null", new Object[0]);
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicIndication failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristicC, z7)) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicIndication failed, setCharacteristicNotification return false.", new Object[0]);
            return false;
        }
        return a(uuid, uuid2, com.haier.uhome.ble.a.f28132f, z7 ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr) {
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.a(bluetoothGattCharacteristic, i7, bArr);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7, byte[] bArr) {
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.a(bluetoothGattDescriptor, i7, bArr);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.a(bluetoothGattDescriptor, i7);
        }
    }

    void a(boolean z7) {
        a(z7, 0);
    }

    void a(boolean z7, int i7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> closeGatt, broadcast %s. trace %s", Boolean.valueOf(z7), e3.a.k(5));
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.f28240a = null;
        }
        f fVar = this.f28242c;
        if (fVar != null) {
            fVar.a(0, 0);
        }
        d(0);
        if (z7) {
            e(i7);
        }
    }

    public void a(f fVar) {
        this.f28242c = fVar;
    }

    public boolean a(UUID uuid, UUID uuid2) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> readCharacteristic\u3000%s .", uuid2);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> readCharacteristic failed, characteristic is null", new Object[0]);
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> readCharacteristic failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristicC);
    }

    public boolean a(UUID uuid, UUID uuid2, byte[] bArr) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeCharacteristic %s.", uuid2);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeCharacteristic failed, characteristic is null", new Object[0]);
            return false;
        }
        if (this.f28240a == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeCharacteristic failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        bluetoothGattCharacteristicC.setValue(bArr);
        return this.f28240a.writeCharacteristic(bluetoothGattCharacteristicC);
    }

    public boolean a(UUID uuid, UUID uuid2, UUID uuid3) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> readDescriptor %s.", uuid3);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> readDescriptor failed, characteristic is null", new Object[0]);
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicC.getDescriptor(uuid3);
        if (descriptor == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> readDescriptor failed, gattDescriptor is null", new Object[0]);
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> readDescriptor failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        return bluetoothGatt.readDescriptor(descriptor);
    }

    public boolean a(UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeDescriptor %s.", uuid3);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeDescriptor failed, characteristic is null", new Object[0]);
            return false;
        }
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristicC.getDescriptor(uuid3);
        if (descriptor == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeDescriptor failed, gattDescriptor is null", new Object[0]);
            return false;
        }
        if (this.f28240a == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> writeDescriptor failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        descriptor.setValue(bArr);
        return this.f28240a.writeDescriptor(descriptor);
    }

    public boolean a(UUID uuid, UUID uuid2, boolean z7) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicNotification %s", uuid2);
        BluetoothGattCharacteristic bluetoothGattCharacteristicC = c(uuid, uuid2);
        if (bluetoothGattCharacteristicC == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicNotification failed, characteristic is null", new Object[0]);
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f28240a;
        if (bluetoothGatt == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicNotification failed, mBluetoothGatt is null", new Object[0]);
            return false;
        }
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristicC, z7)) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "-----> setCharacteristicNotification failed, setCharacteristicNotification return false.", new Object[0]);
            return false;
        }
        return a(uuid, uuid2, com.haier.uhome.ble.a.f28132f, z7 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
    }
}
