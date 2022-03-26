package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.WaterMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Frog
 *
 * @author ucfoh
 * @version 1.0
 */
public class Frog extends Monster {

    private static final int FROGHEALTHPOINTS = 16;

    /**
     * Constructor to create an instance of the Frog
     *
     * @param name of the Frog
     */
    public Frog(String name) {
        super(FROGHEALTHPOINTS, Type.WATER, name, List.of(
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 1),
                new WaterMonsterSkill(MonsterSkillEnum.WATER, 1)
        ));
    }


}
