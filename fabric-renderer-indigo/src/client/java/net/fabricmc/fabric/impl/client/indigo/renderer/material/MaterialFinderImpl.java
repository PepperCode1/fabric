/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.fabric.impl.client.indigo.renderer.material;

import net.fabricmc.fabric.api.renderer.v1.material.BlendMode;
import net.fabricmc.fabric.api.renderer.v1.material.MaterialFinder;
import net.fabricmc.fabric.api.renderer.v1.material.MaterialView;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;

public class MaterialFinderImpl extends MaterialViewImpl implements MaterialFinder {
	@Override
	public MaterialFinder blendMode(BlendMode blendMode) {
		if (blendMode == null) {
			blendMode = BlendMode.DEFAULT;
		}

		bits = (bits & ~BLEND_MODE_MASK) | blendMode.ordinal();
		return this;
	}

	@Override
	public MaterialFinder disableColorIndex(boolean disable) {
		bits = disable ? (bits | COLOR_DISABLE_FLAG) : (bits & ~COLOR_DISABLE_FLAG);
		return this;
	}

	@Override
	public MaterialFinder emissive(boolean isEmissive) {
		bits = isEmissive ? (bits | EMISSIVE_FLAG) : (bits & ~EMISSIVE_FLAG);
		return this;
	}

	@Override
	public MaterialFinder disableDiffuse(boolean disable) {
		bits = disable ? (bits | DIFFUSE_FLAG) : (bits & ~DIFFUSE_FLAG);
		return this;
	}

	@Override
	public MaterialFinder disableAo(boolean disable) {
		bits = disable ? (bits | AO_FLAG) : (bits & ~AO_FLAG);
		return this;
	}

	@Override
	public MaterialFinder clear() {
		bits = 0;
		return this;
	}

	@Override
	public MaterialFinder copyFrom(MaterialView material) {
		bits = ((MaterialViewImpl) material).bits;
		return this;
	}

	@Override
	public RenderMaterial find() {
		return RenderMaterialImpl.byIndex(bits);
	}
}
