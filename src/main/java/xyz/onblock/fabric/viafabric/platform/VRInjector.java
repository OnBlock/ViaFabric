/*
 * MIT License
 *
 * Copyright (c) 2018 creeper123123321 and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package xyz.onblock.fabric.viafabric.platform;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;
import us.myles.ViaVersion.api.platform.ViaInjector;
import us.myles.ViaVersion.util.GsonUtil;
import us.myles.viaversion.libs.gson.JsonObject;

import java.lang.reflect.Method;
import java.util.Arrays;

public class VRInjector implements ViaInjector {
    @Override
    public void inject() {
        // *looks at Mixins*
    }

    @Override
    public void uninject() {
        // not possible *plays sad violin*
    }

    @Override
    public int getServerProtocolVersion() {
        return SharedConstants.getGameVersion().getProtocolVersion();
    }

    @Override
    public String getEncoderName() {
        return "encoder";
    }

    @Override
    public String getDecoderName() {
        return "decoder";
    }

    @Override
    public JsonObject getDump() {
        JsonObject obj = new JsonObject();
        try {
            obj.add("serverNetworkIOChInit", GsonUtil.getGson().toJsonTree(
                    Arrays.stream(Class.forName("net.minecraft.class_3242$1").getDeclaredMethods())
                            .map(Method::toString)
                            .toArray(String[]::new)));
        } catch (ClassNotFoundException ignored) {
        }
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            try {
                obj.add("clientConnectionChInit", GsonUtil.getGson().toJsonTree(
                        Arrays.stream(Class.forName("net.minecraft.class_2535$1").getDeclaredMethods())
                                .map(Method::toString)
                                .toArray(String[]::new)));
            } catch (ClassNotFoundException ignored) {
            }
        }
        return obj;
    }
}
