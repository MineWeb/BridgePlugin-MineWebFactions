package fr.eywek.minewebfactions;

import fr.eywek.minewebfactions.methods.GetFactions;
import fr.eywek.minewebfactions.methods.GetFactionsUUID;
import fr.vmarchaud.mineweb.bukkit.BukkitCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        String version = Bukkit.getPluginManager().getPlugin("Factions").getDescription().getVersion();
        if (version.startsWith("2."))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions());
        else if (version.startsWith("1.6"))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactionsUUID());
    }

    @Override
    public void onDisable() {
    }

}
