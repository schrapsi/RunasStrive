package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BiteMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ScratchMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Tarantula
 *
 * @author ucfoh
 * @version 1.0
 */
public class Tarantula extends Monster {
    private static final int TARANTULAHEALTHPOINTS = 33;

    /**
     * Constructor to create an instance of the Tarantula
     *
     * @param name of the Tarantula
     */
    public Tarantula(String name) {
        super(TARANTULAHEALTHPOINTS, Type.NONE, name, List.of(
                new BiteMonsterSkill(MonsterSkillEnum.BITE, 2),
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 2),
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 2)
        ));
    }
}
