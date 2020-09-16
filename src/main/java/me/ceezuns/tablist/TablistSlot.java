package me.ceezuns.tablist;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.google.common.base.Preconditions;
import me.ceezuns.Poseidon;

import java.util.UUID;

public class TablistSlot {

    private String text;
    private int latency;
    private WrappedGameProfile profile;
    private boolean shouldUpdate;

    protected TablistSlot(int index) {
        this.text = " ";
        this.latency = 149;
        this.profile = new WrappedGameProfile(UUID.randomUUID(), "!" + Poseidon.getInstance().getTablistKeyGenerator().getNextKey(index));
        this.profile.getProperties().removeAll("textures");
        this.shouldUpdate = true;
    }

    protected String getText() {
        return text;
    }

    protected int getLatency() {
        return latency;
    }

    protected WrappedGameProfile getProfile() {
        return profile;
    }

    protected boolean isShouldUpdate() {
        return shouldUpdate;
    }

    public void setText(String text) {
        Preconditions.checkNotNull(text , "Text cannot be null");
        if (this.text.equals(text)) return;
        this.text = text;
        this.shouldUpdate = true;
    }

    public void setLatency(Latency latency) {
        Preconditions.checkNotNull(latency, "Latency cannot be null");
        this.setLatency(latency.getValue());
    }

    public void setLatency(int latency) {
        if (this.latency == latency) return;
        this.latency = latency;
        this.shouldUpdate = true;
    }

    protected void setShouldUpdate(boolean shouldUpdate) {
        this.shouldUpdate = shouldUpdate;
    }
}
