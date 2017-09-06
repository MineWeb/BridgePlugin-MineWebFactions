package fr.eywek.minewebfactions.methods;

import com.massivecraft.factions.Factions;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;
import fr.vmarchaud.mineweb.common.ICore;
import fr.vmarchaud.mineweb.common.IMethod;
import fr.vmarchaud.mineweb.common.MethodHandler;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

@MethodHandler
public class GetFactions implements IMethod {

    @Override
    public Object execute(ICore instance, Object... inputs) {
        ArrayList<Hashtable> factions = new ArrayList<>();
        for (Faction faction : FactionColl.get().getAll())
        {
            if (Objects.equals(faction.getName(), Factions.NAME_NONE_DEFAULT) ||
                Objects.equals(faction.getName(), Factions.NAME_SAFEZONE_DEFAULT) ||
                Objects.equals(faction.getName(), Factions.NAME_WARZONE_DEFAULT))
                continue;
            // Basic
            Hashtable<String, Object> f = new Hashtable<>();
            f.put("id", faction.getId());
            f.put("name", faction.getName());
            f.put("description", faction.getDescriptionDesc());
            f.put("claims_count", faction.getLandCount());

            // Power
            Hashtable<String, Double> power = new Hashtable<>();
            power.put("max", faction.getPowerMax());
            power.put("current", faction.getPower());
            f.put("power", power);
            f.put("leader", faction.getLeader().getName());

            // Players
            ArrayList<String> players = new ArrayList<>();
            for (MPlayer mplayer : faction.getMPlayers())
            {
                players.add(mplayer.getName());
            }
            f.put("players", players);

            // Add
            factions.add(f);
        }
        return factions;
    }

}
