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

import us.myles.ViaVersion.api.ViaVersionConfig;
import us.myles.ViaVersion.util.Config;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VRViaConfig extends Config implements ViaVersionConfig {
    // Based on Sponge ViaVersion
    private static List<String> UNSUPPORTED = Arrays.asList("anti-xray-patch", "bungee-ping-interval",
            "bungee-ping-save", "bungee-servers", "quick-move-action-fix", "nms-player-ticking",
            "item-cache", "velocity-ping-interval", "velocity-ping-save", "velocity-servers",
            "blockconnection-method", "change-1_9-hitbox", "change-1_14-hitbox");

    public VRViaConfig(File configFile) {
        super(configFile);
        // Load config
        reloadConfig();
    }

    @Override
    public URL getDefaultConfigURL() {
        return getClass().getClassLoader().getResource("assets/viaversion/config.yml");
    }

    @Override
    protected void handleConfig(Map<String, Object> config) {
        // Nothing Currently
    }

    @Override
    public List<String> getUnsupportedOptions() {
        return UNSUPPORTED;
    }

    public boolean isCheckForUpdates() {
        return getBoolean("checkforupdates", true);
    }

    @Override
    public boolean isPreventCollision() {
        return getBoolean("prevent-collision", true);
    }

    @Override
    public boolean isNewEffectIndicator() {
        return getBoolean("use-new-effect-indicator", true);
    }

    @Override
    public boolean isShowNewDeathMessages() {
        return getBoolean("use-new-deathmessages", true);
    }

    @Override
    public boolean isSuppressMetadataErrors() {
        return getBoolean("suppress-metadata-errors", false);
    }

    @Override
    public boolean isShieldBlocking() {
        return getBoolean("shield-blocking", true);
    }

    @Override
    public boolean isHologramPatch() {
        return getBoolean("hologram-patch", false);
    }

    @Override
    public boolean isPistonAnimationPatch() {
        return getBoolean("piston-animation-patch", false);
    }

    @Override
    public boolean isBossbarPatch() {
        return getBoolean("bossbar-patch", true);
    }

    @Override
    public boolean isBossbarAntiflicker() {
        return getBoolean("bossbar-anti-flicker", false);
    }

    @Override
    @Deprecated
    public boolean isUnknownEntitiesSuppressed() {
        return false;
    }

    @Override
    public double getHologramYOffset() {
        return getDouble("hologram-y", -0.96D);
    }

    @Override
    @Deprecated
    public boolean isBlockBreakPatch() {
        return false;
    }

    @Override
    public int getMaxPPS() {
        return getInt("max-pps", 800);
    }

    @Override
    public String getMaxPPSKickMessage() {
        return getString("max-pps-kick-msg", "Sending packets too fast? lag?");
    }

    @Override
    public int getTrackingPeriod() {
        return getInt("tracking-period", 6);
    }

    @Override
    public int getWarningPPS() {
        return getInt("tracking-warning-pps", 120);
    }

    @Override
    public int getMaxWarnings() {
        return getInt("tracking-max-warnings", 3);
    }

    @Override
    public String getMaxWarningsKickMessage() {
        return getString("tracking-max-kick-msg", "You are sending too many packets, :(");
    }

    @Override
    public boolean isAntiXRay() {
        return false;
    }

    @Override
    public boolean isSendSupportedVersions() {
        return getBoolean("send-supported-versions", false);
    }

    @Override
    public boolean isStimulatePlayerTick() {
        return getBoolean("simulate-pt", true);
    }

    @Override
    public boolean isItemCache() {
        return false;
    }

    @Override
    public boolean isNMSPlayerTicking() {
        return false;
    }

    @Override
    public boolean isReplacePistons() {
        return getBoolean("replace-pistons", false);
    }

    @Override
    public int getPistonReplacementId() {
        return getInt("replacement-piston-id", 0);
    }

    public boolean isAutoTeam() {
        // Collision has to be enabled first
        return isPreventCollision() && getBoolean("auto-team", true);
    }

    @Override
    public boolean isForceJsonTransform() {
        return getBoolean("force-json-transform", false);
    }

    @Override
    public boolean is1_12NBTArrayFix() {
        return getBoolean("chat-nbt-fix", true);
    }

    @Override
    public boolean is1_12QuickMoveActionFix() {
        return false;
    }

    @Override
    public List<Integer> getBlockedProtocols() {
        return getIntegerList("block-protocols");
    }

    @Override
    public String getBlockedDisconnectMsg() {
        return getString("block-disconnect-msg", "You are using an unsupported Minecraft version!");
    }

    @Override
    public String getReloadDisconnectMsg() {
        return getString("reload-disconnect-msg", "Server reload, please rejoin!");
    }

    @Override
    public boolean is1_13TeamColourFix() {
        return getBoolean("team-colour-fix", true);
    }

    @Override
    public boolean isSuppress1_13ConversionErrors() {
        return getBoolean("suppress-1_13-conversion-errors", false);
    }

    @Override
    public boolean isMinimizeCooldown() {
        return this.getBoolean("minimize-cooldown", true);
    }

    @Override
    public boolean isDisable1_13AutoComplete() {
        return this.getBoolean("disable-1_13-auto-complete", false);
    }

    @Override
    public boolean isServersideBlockConnections() {
        return this.getBoolean("serverside-blockconnections", false);
    }

    @Override
    public String getBlockConnectionMethod() {
        return "packet";
    }

    @Override
    public boolean isReduceBlockStorageMemory() {
        return this.getBoolean("reduce-blockstorage-memory", false);
    }

    @Override
    public boolean isStemWhenBlockAbove() {
        return this.getBoolean("flowerstem-when-block-above", false);
    }

    @Override
    public boolean isSnowCollisionFix() {
        return this.getBoolean("fix-low-snow-collision", false);
    }

    @Override
    public int get1_13TabCompleteDelay() {
        return this.getInt("1_13-tab-complete-delay", 0);
    }

    @Override
    public boolean isTruncate1_14Books() {
        return this.getBoolean("truncate-1_14-books", false);
    }

    @Override
    public boolean isLeftHandedHandling() {
        return this.getBoolean("left-handed-handling", true);
    }

    @Override
    public boolean is1_9HitboxFix() {
        return false;
    }

    @Override
    public boolean is1_14HitboxFix() {
        return false;
    }

    @Override
    public boolean isNonFullBlockLightFix() {
        return this.getBoolean("fix-non-full-blocklight", true);
    }

    @Override
    public boolean is1_14HealthNaNFix() {
        return this.getBoolean("fix-1_14-health-nan", true);
    }

    @Override
    public boolean is1_15InstantRespawn() {
        return this.getBoolean("use-1_15-instant-respawn", false);
    }
}