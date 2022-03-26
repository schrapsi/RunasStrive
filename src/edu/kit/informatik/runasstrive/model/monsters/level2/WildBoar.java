package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.DeflectMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ScratchMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: WildBoar
 *
 * @author ucfoh
 * @version 1.0
 */
public class WildBoar extends Monster {
    private static final int WILDBOARHEALTHPOINTS = 27;

    /**
     * Constructor to create an instance of the WildBoar
     *
     * @param name of the WildBoar
     */
    public WildBoar(String name) {
        super(WILDBOARHEALTHPOINTS, Type.NONE, name, List.of(
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 2),
                new DeflectMonsterSkill(MonsterSkillEnum.DEFLECT, 2),
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 2)
        ));
    }
}
