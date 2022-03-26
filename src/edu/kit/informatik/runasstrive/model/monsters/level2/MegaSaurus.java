package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FireMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.LightningMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BiteMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: MegaSaurus
 *
 * @author ucfoh
 * @version 1.0
 */
public class MegaSaurus extends Monster {
    private static final int MEGASAURUSHEALTHPOINTS = 100;

    /**
     * Constructor to create an instance of the MegaSaurus
     *
     * @param name of the MegaSaurus
     */
    public MegaSaurus(String name) {
        super(MEGASAURUSHEALTHPOINTS, Type.NONE, name, List.of(
                new BiteMonsterSkill(MonsterSkillEnum.BITE, 2),
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 2),
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 2),
                new FireMonsterSkill(MonsterSkillEnum.FIRE, 1),
                new LightningMonsterSkill(MonsterSkillEnum.LILGHTNING, 1)
        ));
    }
}
