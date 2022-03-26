package edu.kit.informatik.runasstrive.model.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;

/**
 * This class models the Skill: Focus for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class FocusSkill extends Skill {

    /**
     * Public constructor for the Focus skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public FocusSkill(SkillEnum name, int skillLevel) {
        super(name, skillLevel, true, 0);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        runa.focus(skillLevel);
    }
}
