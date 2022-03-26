package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.IceMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BiteMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Snake
 *
 * @author ucfoh
 * @version 1.0
 */
public class Snake extends Monster {
    private static final int SNAKEHEALTHPOINTS = 31;

    /**
     * Constructor to create an instance of the Snake
     *
     * @param name of the Snake
     */
    public Snake(String name) {
        super(SNAKEHEALTHPOINTS, Type.ICE, name, List.of(
                new BiteMonsterSkill(MonsterSkillEnum.BITE, 2),
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 2),
                new IceMonsterSkill(MonsterSkillEnum.ICE, 2)
        ));
    }
}
