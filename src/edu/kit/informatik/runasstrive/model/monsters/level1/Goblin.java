package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.DeflectMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.SmashMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Goblin
 *
 * @author ucfoh
 * @version 1.0
 */
public class Goblin extends Monster {
    private static final int GOBLINHEALTHPOINTS = 12;

    /**
     * Constructor to create an instance of the Goblin
     *
     * @param name of the Goblin
     */
    public Goblin(String name) {
        super(GOBLINHEALTHPOINTS, Type.NONE, name, List.of(
                new SmashMonsterSkill(MonsterSkillEnum.SMASH, 1),
                new DeflectMonsterSkill(MonsterSkillEnum.DEFLECT, 1)));
    }
}
