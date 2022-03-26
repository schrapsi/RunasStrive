package edu.kit.informatik.runasstrive.model.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;

/**
 * This class models the Skill: Lightning for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class LightningSkill extends Skill {

    private static final int LIGHTNING_ADDITION = 5;

    /**
     * Public constructor for the Lightning skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public LightningSkill(RunaSkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 1);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        int damage = ((2 * super.skillLevel + LIGHTNING_ADDITION) * focusPoints) + 2;
        if (target.getType().equals(Type.FIRE)) {
            damage += 2 * super.skillLevel;
        }
        target.takeMagicalDamage(damage);
        runa.removeFocusPoint(cost);
    }

}
