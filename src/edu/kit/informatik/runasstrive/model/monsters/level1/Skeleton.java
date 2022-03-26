package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.LightningMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: Skeleton
 *
 * @author ucfoh
 * @version 1.0
 */
public class Skeleton extends Monster {

    private static final int SKELETONHEALTHPOINTS = 14;

    /**
     * Constructor to create an instance of the Skeleton
     *
     * @param name of the Skeleton
     */
    public Skeleton(String name) {
        super(SKELETONHEALTHPOINTS, Type.LIGHTNING, name, List.of(
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 1),
                new LightningMonsterSkill(MonsterSkillEnum.LILGHTNING, 1)
        ));
    }
}
