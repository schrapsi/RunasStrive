package edu.kit.informatik.runasstrive.model.monsters.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Scratch
 *
 * @author ucfoh
 * @version 1.0
 */
public class ScratchMonsterSkill extends MonsterSkill {

    private static final int SCRATCH_MULTIPLIER = 5;

    /**
     * Public constructor for the Scratch Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public ScratchMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, 0);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        runa.breakFocus();
        runa.takePhysicalDamage(SCRATCH_MULTIPLIER * skillLevel);
    }
}
