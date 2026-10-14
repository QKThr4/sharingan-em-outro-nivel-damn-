package com.sharinganmod.net;

import com.sharinganmod.SharinganMod;
import io.netty.buffer.ByteBuf;
import java.util.UUID;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/** Servidor para clientes: como o dono 'uuid' configurou o tamanho/posicao dos olhos no proprio rosto. */
public record LayoutPayload(UUID uuid, float dx, float y, float half, boolean mirror) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<LayoutPayload> TYPE =
            new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(SharinganMod.MODID, "layout"));
    public static final StreamCodec<ByteBuf, LayoutPayload> CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, LayoutPayload::uuid,
            ByteBufCodecs.FLOAT, LayoutPayload::dx,
            ByteBufCodecs.FLOAT, LayoutPayload::y,
            ByteBufCodecs.FLOAT, LayoutPayload::half,
            ByteBufCodecs.BOOL, LayoutPayload::mirror,
            LayoutPayload::new);

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
