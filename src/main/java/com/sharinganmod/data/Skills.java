package com.sharinganmod.data;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/** Tabelas de nomes, recargas (ticks), custo de chakra e desgaste dos olhos por habilidade. */
public final class Skills {
    private Skills() {}

    public static final String[] TYPE_NAMES = {"Nenhum", "Itachi", "Sasuke", "Obito", "Shisui", "Eterno"};

    public static final String[][] NAMES = {
            {"", "", "", ""},
            {"Tsukuyomi", "Amaterasu", "Karasu Bunshin", "Susanoo"},
            {"Chidori Corrente", "Enton: Kagutsuchi", "Kirin", "Susanoo"},
            {"Kamui: Intangibilidade", "Kamui: Teletransporte", "Kamui: Sucção", "Susanoo"},
            {"Kotoamatsukami", "Shunshin", "Olhar Revelador", "Susanoo"},
            {"Tsukuyomi", "Amaterasu", "Kirin", "Susanoo Perfeito"}
    };

    /** Recarga base em ticks (20 ticks = 1 s). */
    public static final int[][] COOLDOWN = {
            {0, 0, 0, 0},
            {600, 400, 500, 0},
            {200, 450, 900, 0},
            {600, 300, 700, 0},
            {1200, 100, 500, 0},
            {600, 400, 900, 0}
    };

    /** Chakra gasto por uso (a barra base do 3 tomoe/Mangekyou e 300 e chega a 960 com os 5 upgrades). */
    public static final float[][] CHAKRA = {
            {0, 0, 0, 0},
            {40, 35, 25, 0},
            {20, 40, 60, 0},
            {30, 25, 45, 0},
            {50, 12, 25, 0},
            {40, 35, 60, 0}
    };

    /**
     * Desgaste ocular por uso (de 100 ate cegar, sem recuperacao).
     * Media proxima de 1,0: cerca de 100 habilidades ate a cegueira.
     */
    public static final float[][] STRAIN = {
            {0, 0, 0, 0},
            {1.5f, 1.2f, 0.6f, 0},
            {0.6f, 1.2f, 2.0f, 0},
            {0.8f, 0.5f, 1.5f, 0},
            {2.0f, 0.3f, 0.6f, 0},
            {0, 0, 0, 0}
    };

    public static final float SUSANOO_COST = 50f;
    /** Chakra extra gasto por tick enquanto o Susanoo esta ativo (1,2 por segundo, alem dos 3 do Mangekyou). */
    public static final float SUSANOO_DRAIN_PER_TICK = 0.06f;
    public static final float SUSANOO_STRAIN_ON_START = 0.5f;
    /** Desgaste passivo por tick com o Mangekyou ligado e com o Susanoo ativo. */
    public static final float MANGEKYOU_STRAIN_PER_TICK = 0.0003f;
    public static final float SUSANOO_STRAIN_PER_TICK = 0.003f;

    /** Nome traduzido do olho/lado: 0 os dois olhos, 1 olho esquerdo, 2 olho direito. */
    public static MutableComponent sideName(int side) {
        return Tx.t("side." + Math.max(0, Math.min(2, side)));
    }

    /** Nome do tipo de Mangekyou (Itachi, Sasuke, Obito, Shisui, Eterno). */
    public static MutableComponent typeName(int type) {
        int t = Math.max(0, Math.min(5, type));
        return t == 5 ? Tx.t("type.eternal") : Component.literal(TYPE_NAMES[t]);
    }

    /** Nome traduzido da habilidade (slot 0 a 3). */
    public static MutableComponent name(int type, int slot) {
        return Tx.t("skill." + Math.max(0, Math.min(5, type)) + "." + Math.max(0, Math.min(3, slot)));
    }

    public static MutableComponent stageName(SharinganData d) {
        if (d.stage <= 0) return Tx.t("stage.none");
        MutableComponent base;
        if (d.stage <= 3) base = Tx.t("stage.tier", d.stage);
        else if (d.stage == 4) base = Tx.t("stage.mk", typeName(d.type));
        else base = Tx.t("stage.eternal");
        return d.eyeSide != 0 ? Tx.t("stage.only", base, sideName(d.eyeSide)) : base;
    }
}
