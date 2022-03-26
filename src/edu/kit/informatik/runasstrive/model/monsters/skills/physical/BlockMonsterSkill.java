package edu.kit.informatik.runasstrive.model.monsters.skills.physical;

import edu.kit.informatik.runasstrive.model.Runa;
import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.skills.MonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

/**
 * This class models the MonsterSkill: Block
 *
 * @author ucfoh
 * @version 1.0
 */
public class BlockMonsterSkill extends MonsterSkill {

    /**
     * Public constructor for the Block Skill
     *
     * @param name       name of the Skill as Enum
     * @param skillLevel level of the Skill
     */
    public BlockMonsterSkill(MonsterSkillEnum name, int skillLevel) {
        super(name, skillLevel, 0);
    }

    @Override
    public void execute(Monster monster, Runa runa) {
        //there is no execution for the Block skill (It's calculated in the take damage method)
    }
}
