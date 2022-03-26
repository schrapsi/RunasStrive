package edu.kit.informatik.runasstrive.model.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;

/**
 * This class models the Skill: Swing for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class SwingSkill extends Skill {

    private static final int SWING_MULTIPLIER = 5;

    /**
     * Public constructor for the Swing skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public SwingSkill(SkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 0);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        target.takePhysicalDamage(SWING_MULTIPLIER * super.skillLevel + diceNumber);
        target.breakFocus();
    }
}
