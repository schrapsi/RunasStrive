package edu.kit.informatik.runasstrive.model.skills.physical;


import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;

/**
 * This class models the Skill: Parry for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class ParrySkill extends Skill {

    /**
     * Public constructor for the Parry skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public ParrySkill(SkillEnum name, int skillLevel) {
        super(name, skillLevel, true, 0);
    }


    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        //there is no execution for the Parry skill (It's calculated in the take damage method)
    }
}
