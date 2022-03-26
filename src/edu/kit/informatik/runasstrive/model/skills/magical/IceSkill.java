package edu.kit.informatik.runasstrive.model.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;

/**
 * This class models the Skill: Ice for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class IceSkill extends Skill {

    private static final int ICE_ADDITION = 4;

    /**
     * Public constructor for the Ice skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public IceSkill(RunaSkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 1);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        int damage = ((2 * super.skillLevel + ICE_ADDITION) * focusPoints) + 2;
        if (target.getType().equals(Type.WATER)) {
            damage += 2 * super.skillLevel;
        }
        target.takeMagicalDamage(damage);
        runa.removeFocusPoint(cost);

    }
}

