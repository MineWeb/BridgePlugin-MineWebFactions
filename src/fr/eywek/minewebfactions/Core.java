package fr.eywek.minewebfactions;

import fr.eywek.minewebfactions.methods.GetFactions;
import fr.vmarchaud.mineweb.bukkit.BukkitCore;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions());
    }

    @Override
    public void onDisable() {
    }

}
