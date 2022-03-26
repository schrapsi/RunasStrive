package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.LightningMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.WaterMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: DarkElf
 *
 * @author ucfoh
 * @version 1.0
 */
public class DarkElf extends Monster {
    private static final int DARKELFHEALTHPOINTS = 34;

    /**
     * Constructor to create an instance of the DarkElf
     *
     * @param name of the DarkElf
     */
    public DarkElf(String name) {
        super(DARKELFHEALTHPOINTS, Type.NONE, name, List.of(
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 2),
                new WaterMonsterSkill(MonsterSkillEnum.WATER, 1),
                new LightningMonsterSkill(MonsterSkillEnum.LILGHTNING, 1)
        ));
    }
}
