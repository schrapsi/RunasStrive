package edu.kit.informatik.runasstrive.model.monsters.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Bite
 *
 * @author ucfoh
 * @version 1.0
 */
public class BiteMonsterSkill extends MonsterSkill {

    private static final int BITE_MULTIPLIER = 10;

    /**
     * Public constructor for the Bite Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public BiteMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, 0);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        runa.takePhysicalDamage(BITE_MULTIPLIER * skillLevel);
    }
}
