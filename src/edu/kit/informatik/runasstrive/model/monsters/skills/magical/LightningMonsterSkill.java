package edu.kit.informatik.runasstrive.model.monsters.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Lightning
 *
 * @author ucfoh
 * @version 1.0
 */
public class LightningMonsterSkill extends MonsterSkill {

    private static final int LIGHTNING_MULTIPLIER = 14;

    /**
     * Public constructor for the Lightning Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public LightningMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, skillLevel);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        runa.takeMagicalDamage(monster, (LIGHTNING_MULTIPLIER * skillLevel) + 2);
        monster.removeFocusPoint(cost);
    }
}
