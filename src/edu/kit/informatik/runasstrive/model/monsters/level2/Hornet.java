package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FireMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ScratchMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Hornet
 *
 * @author ucfoh
 * @version 1.0
 */
public class Hornet extends Monster {
    private static final int HORNETHEALTHPOINTS = 32;

    /**
     * Constructor to create an instance of the Hornet
     *
     * @param name of the Hornet
     */
    public Hornet(String name) {
        super(HORNETHEALTHPOINTS, Type.FIRE, name, List.of(
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 2),
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 2),
                new FireMonsterSkill(MonsterSkillEnum.FIRE, 1),
                new FireMonsterSkill(MonsterSkillEnum.FIRE, 2)
        ));
    }
}
