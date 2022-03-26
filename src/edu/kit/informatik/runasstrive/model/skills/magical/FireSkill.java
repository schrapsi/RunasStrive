package edu.kit.informatik.runasstrive.model.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;

/**
 * This class models the Skill: Fire for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class FireSkill extends Skill {

    private static final int FIRE_ADDITION = 5;

    /**
     * Public constructor for the Fire skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public FireSkill(SkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 1);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        int damage = ((2 * super.skillLevel + FIRE_ADDITION) * focusPoints);
        if (target.getType().equals(Type.ICE)) {
            damage += 2 * super.skillLevel;
        }
        target.takeMagicalDamage(damage);
        runa.removeFocusPoint(cost);
    }
}
