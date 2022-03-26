package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ClawMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Rat
 *
 * @author ucfoh
 * @version 1.0
 */
public class Rat extends Monster {
    private static final int RATHEALTHPOINTS = 14;

    /**
     * Constructor to create an instance of the Rat
     *
     * @param name of the Rat
     */
    public Rat(String name) {
        super(RATHEALTHPOINTS, Type.NONE, name, List.of(
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 1),
                new ClawMonsterSkill(MonsterSkillEnum.CLAW, 1)
        ));
    }
}
