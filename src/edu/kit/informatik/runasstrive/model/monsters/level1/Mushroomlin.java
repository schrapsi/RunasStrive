package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.DeflectMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ScratchMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Mushroomlin
 *
 * @author ucfoh
 * @version 1.0
 */
public class Mushroomlin extends Monster {

    private static final int MUSHROOMLINHEALTHPOINTS = 20;

    /**
     * Constructor to create an instance of the Mushroomlin
     *
     * @param name of the Mushroomlin
     */
    public Mushroomlin(String name) {
        super(MUSHROOMLINHEALTHPOINTS, Type.NONE, name, List.of(
                new DeflectMonsterSkill(MonsterSkillEnum.DEFLECT, 1),
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 1)));
    }
}
