package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.IceMonsterSkill;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;

import java.util.List;

/**
 * This Class models the Monster: Ghost
 *
 * @author ucfoh
 * @version 1.0
 */
public class Ghost extends Monster {

    private static final int GHOSTHEALTHPOINTS = 15;

    /**
     * Constructor to create an instance of the Ghost
     *
     * @param name of the Ghost
     */
    public Ghost(String name) {
        super(GHOSTHEALTHPOINTS, Type.ICE, name, List.of(
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 1),
                new IceMonsterSkill(MonsterSkillEnum.ICE, 1)
        ));
    }

}
