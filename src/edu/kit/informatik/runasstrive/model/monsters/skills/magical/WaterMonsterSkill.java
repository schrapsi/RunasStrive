package edu.kit.informatik.runasstrive.model.monsters.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Water
 *
 * @author ucfoh
 * @version 1.0
 */
public class WaterMonsterSkill extends MonsterSkill {

    private static final int WATER_MULTIPLIER = 8;

    /**
     * Public constructor for the Water Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public WaterMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, skillLevel);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        runa.takeMagicalDamage(monster, (WATER_MULTIPLIER * skillLevel) + 2);
        monster.removeFocusPoint(cost);
    }
}
