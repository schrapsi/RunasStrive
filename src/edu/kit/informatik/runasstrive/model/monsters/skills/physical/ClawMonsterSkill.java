package edu.kit.informatik.runasstrive.model.monsters.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Claw
 *
 * @author ucfoh
 * @version 1.0
 */
public class ClawMonsterSkill extends MonsterSkill {

    private static final int CLAW_MULTIPLIER = 6;

    /**
     * Public constructor for the Claw Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public ClawMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, 0);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        runa.takePhysicalDamage(CLAW_MULTIPLIER * skillLevel);
        runa.breakFocus();
    }
}
