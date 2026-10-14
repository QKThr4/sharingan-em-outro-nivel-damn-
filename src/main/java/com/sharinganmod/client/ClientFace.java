package com.sharinganmod.client;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Qual olho aparece no rosto de cada jogador (recebido do servidor). Codigos em FacePayload. */
public final class ClientFace {
    private ClientFace() {}

    private static final Map<UUID, Integer> FACES = new HashMap<>();

    /** Quando (ms) cada jogador ligou o Sharingan: os olhos dao uma girada logo depois de ligar. */
    private static final Map<UUID, Long> SPIN_START = new HashMap<>();

    public static void set(UUID id, int code) {
        if (code <= 0) {
            FACES.remove(id);
            SPIN_START.remove(id);
        } else {
            Integer old = FACES.put(id, code);
            if (old == null) SPIN_START.put(id, System.currentTimeMillis());
        }
    }

    /** Progresso (0 a 1) da girada dos olhos; 1 = terminou. */
    public static float spinProgress(UUID id, long durationMs) {
        Long start = SPIN_START.get(id);
        if (start == null) return 1f;
        float t = (System.currentTimeMillis() - start) / (float) durationMs;
        if (t >= 1f) {
            SPIN_START.remove(id);
            return 1f;
        }
        return Math.max(0f, t);
    }

    public static int get(UUID id) {
        return FACES.getOrDefault(id, 0);
    }

    /** Layout dos olhos escolhido por cada jogador no proprio rosto: {dx, y, half, espelhado (0/1)}. */
    private static final Map<UUID, float[]> LAYOUTS = new HashMap<>();

    public static void setLayout(UUID id, float dx, float y, float half, boolean mirror) {
        LAYOUTS.put(id, new float[] {dx, y, half, mirror ? 1f : 0f});
    }

    /** Layout do jogador, ou null se ele ainda nao enviou (usa o padrao). */
    public static float[] layout(UUID id) {
        return LAYOUTS.get(id);
    }

    public static void clear() {
        FACES.clear();
        SPIN_START.clear();
        LAYOUTS.clear();
    }
}
