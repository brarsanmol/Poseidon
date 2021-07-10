package ca.anmolbrar.tablist;

import ca.anmolbrar.Poseidon;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import ca.anmolbrar.packet.WrapperPlayServerPlayerInfo;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.stream.Collectors;

public class TablistTask extends BukkitRunnable {

    public TablistTask(long period) {
        runTaskTimerAsynchronously(Poseidon.getInstance().getPlugin(), 2L, period);
    }

    @Override
    public void run() {
        Poseidon.getInstance().getTablistManager().getTablists().values().forEach(tablist -> {
            WrapperPlayServerPlayerInfo packet = new WrapperPlayServerPlayerInfo(EnumWrappers.PlayerInfoAction.ADD_PLAYER,
                    tablist.getSlots().stream()
                            .filter(slot -> slot.isShouldUpdate())
                            .peek(slot -> slot.setShouldUpdate(false))
                            .map(slot -> new PlayerInfoData(
                                    slot.getProfile(),
                                    slot.getLatency(),
                                    EnumWrappers.NativeGameMode.NOT_SET,
                                    WrappedChatComponent.fromText(slot.getText())))
                            .collect(Collectors.toList()));
            packet.sendPacket(tablist.getPlayer());
        });
    }
}
