package fr.eywek.minewebfactions.methods;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import fr.vmarchaud.mineweb.common.ICore;
import fr.vmarchaud.mineweb.common.IMethod;
import fr.vmarchaud.mineweb.common.MethodHandler;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

@MethodHandler
public class GetFactionsUUID implements IMethod {

    @Override
    public Object execute(ICore instance, Object... inputs) {
        ArrayList<Hashtable> factions = new ArrayList<>();
        for (Faction faction : Factions.getInstance().getAllFactions())
        {
            Faction wilderness;
            try {
                Factions.getInstance().getClass().getMethod("getWilderness");
                wilderness = Factions.getInstance().getWilderness();
            } catch (Exception e) {
                wilderness = Factions.getInstance().getNone();
            }
            if (Objects.equals(faction.getTag(), wilderness.getTag()) ||
                    Objects.equals(faction.getTag(), Factions.getInstance().getSafeZone().getTag()) ||
                    Objects.equals(faction.getTag(), Factions.getInstance().getWarZone().getTag()))
                continue;
            // Basic
            Hashtable<String, Object> f = new Hashtable<>();
            f.put("id", faction.getId());
            f.put("name", faction.getTag());
            f.put("description", faction.getDescription());
            f.put("claims_count", faction.getLandRounded());

            // Power
            Hashtable<String, Double> power = new Hashtable<>();
            power.put("max", faction.getPowerMax());
            power.put("current", faction.getPower());
            f.put("power", power);
            f.put("leader", faction.getFPlayerAdmin().getName());

            // Players
            ArrayList<String> players = new ArrayList<>();
            for (FPlayer mplayer : faction.getFPlayers())
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
