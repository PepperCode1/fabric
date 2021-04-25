package net.fabricmc.fabric.api.client.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface JsonModelDeserializeCallback {
	Event<JsonModelDeserializeCallback> EVENT = EventFactory.createArrayBacked(JsonModelDeserializeCallback.class, (listeners) -> (jsonObject, jsonContext, model, id) -> {
		for (JsonModelDeserializeCallback listener : listeners) {
			listener.onJsonModelDeserialize(jsonObject, jsonContext, model, id);
		}
	});

	void onJsonModelDeserialize(JsonObject jsonObject, JsonDeserializationContext jsonContext, JsonUnbakedModel model, @Nullable Identifier id);
}
