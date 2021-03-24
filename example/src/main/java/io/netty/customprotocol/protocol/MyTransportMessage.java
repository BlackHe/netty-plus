package io.netty.customprotocol.protocol;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MyTransportMessage {

    /**
     * 消息体字节长度
     */
    private int length;


    /**
     * 消息体字节数组
     */
    private byte[] payload;

    public MyTransportMessage(int length, byte[] payload) {
        this.length = length;
        this.payload = payload;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "MyTransportMessage{" +
                "length=" + length +
                ", payload=" + new String(payload, StandardCharsets.UTF_8) +
                '}';
    }


    public MyTransportMessage() {
    }
}
