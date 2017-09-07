package fr.eywek.minewebfactions.methods;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.FactionColls;
import com.massivecraft.factions.entity.UPlayer;
import fr.vmarchaud.mineweb.common.ICore;
import fr.vmarchaud.mineweb.common.IMethod;
import fr.vmarchaud.mineweb.common.MethodHandler;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

@MethodHandler
public class GetFactions2_3 implements IMethod {

    @Override
    public Object execute(ICore instance, Object... inputs) {
        /*ArrayList<Hashtable> factions = new ArrayList<>();
        for (FactionColl coll : FactionColls.get().getColls()) {
            for (Faction faction : coll.getAll()) {
                if (Objects.equals(faction.getName(), coll.getNone().getName()) ||
                        Objects.equals(faction.getName(), coll.getSafezone().getName()) ||
                        Objects.equals(faction.getName(), coll.getWarzone().getName()))
                    continue;
                // Basic
                Hashtable<String, Object> f = new Hashtable<>();
                f.put("id", faction.getId());
                f.put("name", faction.getName());
                f.put("description", faction.getDescription());
                f.put("claims_count", faction.getLandCount());

                // Power
                Hashtable<String, Double> power = new Hashtable<>();
                power.put("max", faction.getPowerMax());
                power.put("current", faction.getPower());
                f.put("power", power);
                f.put("leader", faction.getLeader().getName());

                // Players
                ArrayList<String> players = new ArrayList<>();
                for (UPlayer player : faction.getUPlayers()) {
                    players.add(player.getName());
                }
                f.put("players", players);

                // Add
                factions.add(f);
            }
        }
        return factions;*/
        return "NOT_IMPLEMENTED";
    }

}
