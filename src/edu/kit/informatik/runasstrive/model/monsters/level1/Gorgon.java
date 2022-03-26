package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FireMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Gorgon
 *
 * @author ucfoh
 * @version 1.0
 */
public class Gorgon extends Monster {
    private static final int GORGONHEALTHPOINTS = 13;

    /**
     * Constructor to create an instance of the Gorgon
     *
     * @param name of the Gorgon
     */
    public Gorgon(String name) {
        super(GORGONHEALTHPOINTS, Type.FIRE, name, List.of(
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 1),
                new FireMonsterSkill(MonsterSkillEnum.FIRE, 1)
        ));
    }
}
