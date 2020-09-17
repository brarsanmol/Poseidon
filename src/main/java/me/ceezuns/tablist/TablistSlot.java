package me.ceezuns.tablist;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedSignedProperty;
import com.google.common.base.Preconditions;
import me.ceezuns.Poseidon;

import java.util.UUID;

public class TablistSlot {

    private static final WrappedSignedProperty DEFAULT_SKIN = new WrappedSignedProperty("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYwMDMwNTQ1NDg2NCwKICAicHJvZmlsZUlkIiA6ICI0ZDcwNDg2ZjUwOTI0ZDMzODZiYmZjOWMxMmJhYjRhZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJzaXJGYWJpb3pzY2hlIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2JmODNlNjk0NjYzMDVmYWZmMmFjNzYwNzZhZWE2ZGUyZjRiMzliMzkwOTkwMmUwNWJmMGU3NTBiM2U3YThhOCIKICAgIH0KICB9Cn0=", "aWIsgxVvNgGa8XVJK2+Ygh7K/M9QwYeOPsg7SDrVhbr6SjidbO1NLT68czbwfyriUdA7ZNhAkgW991tUlHMBnePmQOoe2Dr/OfE7AnVbkH4xV6iNMR3wEBaJd3AKiiZmRbWW2Fb7ZXHXIMjJQJSHBS7AhrRBj/Z7gajUIsQdDRUfM792sss1OiFyok4UrpPWMb6LpwHsqIK5D0jsGK4nu6bavtiJW7HYes4p7mQMKeAymWtOwBagq/UlXqFae6DdM8lpQUo6Nzdz+mFzcpxhxZzazMCK2nifVYBFKIFEUXZy8KOO/BE2Mbo35Pa3aEVoMLvkyqA8sNlihzqoxH5q7hgk4h/pb33Kn9yUF5tjkgJ5d42W+OVcSig7emYWjQafWJZTPF+WzWqV9fr9COESotNHbzJSkbKYHiFa/v1Go2XaS0G0tfczflXXqs5YL2sg0Wem2swpFQ3lvLEDwiwiKR7NSbj+3lcto//JJnG5ExcaGhwgrQ6pKUhBV5QdlDm5WE03Li8fbINsJTkzIhicjUBxhA21uN4OXOntKxSon3HB1wo4oG+xfvpKazcgJeJvv7V0LhZ9Ix62c6dKJ6FmMeWuspGGn/GePKvMREyIsMXCY7hVqDzZjLm6m5lsZb4GemS0mCElobumbClhSj2Q6hwbvTAjZYbCT6XELUAZgig=");

    private String text;
    private int latency;
    private WrappedGameProfile profile;
    private boolean shouldUpdate;

    protected TablistSlot(int index) {
        this.text = " ";
        this.latency = 149;
        this.profile = new WrappedGameProfile(UUID.randomUUID(), "!" + Poseidon.getInstance().getTablistKeyGenerator().getNextKey(index));
        this.profile.getProperties().put("textures", DEFAULT_SKIN);
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
