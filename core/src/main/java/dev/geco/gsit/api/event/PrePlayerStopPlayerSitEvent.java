package dev.geco.gsit.api.event;

import dev.geco.gsit.object.GStopReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PrePlayerStopPlayerSitEvent extends PlayerEvent implements Cancellable {

    private final GStopReason reason;
    private final boolean removePassengers;
    private boolean cancel = false;
    private static final HandlerList handlers = new HandlerList();

    public PrePlayerStopPlayerSitEvent(@NotNull Player player, @NotNull GStopReason reason, boolean removePassengers) {
        super(player);
        this.reason = reason;
        this.removePassengers = removePassengers;
    }

    public @NotNull GStopReason getReason() { return reason; }

    public boolean shouldRemovePassengers() { return removePassengers; }

    public boolean isCancelled() { return cancel; }

    public void setCancelled(boolean cancelled) { cancel = cancelled; }

    public @NotNull HandlerList getHandlers() { return handlers; }

    public static @NotNull HandlerList getHandlerList() { return handlers; }

}