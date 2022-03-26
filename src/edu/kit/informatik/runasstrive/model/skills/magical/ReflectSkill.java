package edu.kit.informatik.runasstrive.model.skills.magical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.RunaSkillEnum;

/**
 * This class models the Skill: Reflect for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class ReflectSkill extends Skill {

    /**
     * Public constructor for the Reflect skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public ReflectSkill(RunaSkillEnum name, int skillLevel) {
        super(name, skillLevel, true, 0);
    }

    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        //there is no execution for the reflect skill (It's calculated in the take damage method)
    }
}
