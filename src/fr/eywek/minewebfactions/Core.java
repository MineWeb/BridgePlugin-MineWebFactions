package fr.eywek.minewebfactions;

import fr.eywek.minewebfactions.methods.GetFactions2_13;
//import fr.eywek.minewebfactions.methods.GetFactions2_3;
import fr.eywek.minewebfactions.methods.GetFactions2_14;
import fr.eywek.minewebfactions.methods.GetFactions3_0_5;
import fr.eywek.minewebfactions.methods.GetFactions2_8;
import fr.eywek.minewebfactions.methods.GetFactionsUUID;
import fr.vmarchaud.mineweb.bukkit.BukkitCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        String version = Bukkit.getPluginManager().getPlugin("Factions").getDescription().getVersion();
        if (version.startsWith("3.0"))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions3_0_5());
        else if (version.startsWith("2.14"))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions2_14());
        else if (version.startsWith("2.13"))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions2_13());
        else if (version.startsWith("2.8"))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions2_8());
            //else if (version.startsWith("2.3") || version.startsWith("2.5"))
            //    BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactions2_3());
        else if (version.startsWith("1.6"))
            BukkitCore.get().getMethods().put("GET_FACTIONS", new GetFactionsUUID());
    }

    @Override
    public void onDisable() {
    }

}
