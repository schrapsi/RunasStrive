package edu.kit.informatik.runasstrive.model.monsters.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Fire
 *
 * @author ucfoh
 * @version 1.0
 */
public class FireMonsterSkill extends MonsterSkill {

    private static final int FIRE_MULTIPLIER = 12;

    /**
     * Public constructor for the Fire Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public FireMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, skillLevel);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        runa.takeMagicalDamage(monster, (FIRE_MULTIPLIER * skillLevel) + 2);
        monster.removeFocusPoint(cost);
    }
}
