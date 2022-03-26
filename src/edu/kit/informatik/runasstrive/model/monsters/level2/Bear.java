package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.DeflectMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ClawMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Bear
 *
 * @author ucfoh
 * @version 1.0
 */
public class Bear extends Monster {
    private static final int BEARHEALTHPOINTS = 40;

    /**
     * Constructor to create an instance of the Bear
     *
     * @param name of the Bear
     */
    public Bear(String name) {
        super(BEARHEALTHPOINTS, Type.NONE, name, List.of(
                new ClawMonsterSkill(MonsterSkillEnum.CLAW, 2),
                new DeflectMonsterSkill(MonsterSkillEnum.DEFLECT, 2),
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 2)

        ));
    }
}