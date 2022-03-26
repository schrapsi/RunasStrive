package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.DeflectMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ScratchMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Mushroomlon
 *
 * @author ucfoh
 * @version 1.0
 */
public class Mushroomlon extends Monster {
    private static final int MUSHROOMLONHEALTHPOINTS = 50;

    /**
     * Constructor to create an instance of the Mushroomlon
     *
     * @param name of the Mushroomlon
     */
    public Mushroomlon(String name) {
        super(MUSHROOMLONHEALTHPOINTS, Type.NONE, name, List.of(
                new DeflectMonsterSkill(MonsterSkillEnum.DEFLECT, 2),
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 2),
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 2)
        ));
    }
}
