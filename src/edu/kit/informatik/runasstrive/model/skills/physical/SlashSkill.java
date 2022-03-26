package edu.kit.informatik.runasstrive.model.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;

/**
 * This class models the Skill: Slash for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class SlashSkill extends Skill {

    private static final int SLASH_MULTIPLIER = 4;

    /**
     * Public constructor for the Slash skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public SlashSkill(RunaSkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 0);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        target.takePhysicalDamage(SLASH_MULTIPLIER * super.skillLevel + diceNumber);
        target.breakFocus();
    }

}
