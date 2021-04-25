package net.fabricmc.fabric.mixin.client.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.render.model.json.JsonUnbakedModel;

import net.fabricmc.fabric.api.client.model.JsonModelDeserializeCallback;
import net.fabricmc.fabric.impl.client.model.ModelLoaderTracker;

@Mixin(JsonUnbakedModel.Deserializer.class)
public abstract class MixinJsonUnbakedModelDeserializer {
	@Inject(at = @At("TAIL"), method = "deserialize(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/client/render/model/json/JsonUnbakedModel;")
	private void onTailDeserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonContext, CallbackInfoReturnable<JsonUnbakedModel> cir) {
		JsonModelDeserializeCallback.EVENT.invoker().onJsonModelDeserialize(jsonElement.getAsJsonObject(), jsonContext, cir.getReturnValue(), ModelLoaderTracker.CURRENT_JSON_ID.get().get());
	}
}
