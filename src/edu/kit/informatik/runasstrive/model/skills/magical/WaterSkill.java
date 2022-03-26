package edu.kit.informatik.runasstrive.model.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;

/**
 * This class models the Skill: Water for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class WaterSkill extends Skill {

    private static final int WATER_ADDITION = 4;

    /**
     * Public constructor for the Water skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public WaterSkill(RunaSkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 1);
    }


    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        int damage = (2 * skillLevel + WATER_ADDITION) * focusPoints;
        if (target.getType().equals(Type.LIGHTNING)) {
            damage += 2 * skillLevel;
        }
        target.takeMagicalDamage(damage);
        runa.removeFocusPoint(cost);
    }
}
