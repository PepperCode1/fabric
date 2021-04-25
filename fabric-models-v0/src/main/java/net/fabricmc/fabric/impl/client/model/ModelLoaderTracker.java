package net.fabricmc.fabric.impl.client.model;

import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.util.SimpleMutableWrapper;

public class ModelLoaderTracker {
	public static final ThreadLocal<SimpleMutableWrapper<Identifier>> CURRENT_JSON_ID = ThreadLocal.withInitial(() -> new SimpleMutableWrapper<>());
}
