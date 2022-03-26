package edu.kit.informatik.runasstrive.model.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.ressources.SkillEnum;


/**
 * This class models the Skill: Thrust for Runa
 *
 * @author ucfoh
 * @version 1.0
 */
public class ThrustSkill extends Skill {

    private static final int THRUST_MULTIPLIER = 6;
    private static final int BONUS_THRESHOLD = 6;
    private static final int BONUS_MULTIPLIER = 4;

    /**
     * Public constructor for the Thrust skill
     *
     * @param name       of the Skill as enum
     * @param skillLevel level of the skill
     */
    public ThrustSkill(SkillEnum name, int skillLevel) {
        super(name, skillLevel, false, 0);
    }


    @Override
    public void execute(int diceNumber, Monster target, int focusPoints, Runa runa) {
        int damage = THRUST_MULTIPLIER * super.skillLevel + diceNumber;
        if (diceNumber >= BONUS_THRESHOLD) {
            damage += BONUS_MULTIPLIER * super.skillLevel;
        }
        target.takePhysicalDamage(damage);

    }


}
