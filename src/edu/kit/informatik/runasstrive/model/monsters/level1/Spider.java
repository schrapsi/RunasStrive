package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BiteMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Spider
 *
 * @author ucfoh
 * @version 1.0
 */
public class Spider extends Monster {
    private static final int SPIDERHEALTHPOINTS = 15;

    /**
     * Constructor to create an instance of the Spider
     *
     * @param name of the Spider
     */
    public Spider(String name) {
        super(SPIDERHEALTHPOINTS, Type.NONE, name, List.of(
                new BiteMonsterSkill(MonsterSkillEnum.BITE, 1),
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 1)));
    }
}
