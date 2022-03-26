package edu.kit.informatik.runasstrive.model.monsters.level2;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.LightningMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.ScratchMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: ShadowBlade
 *
 * @author ucfoh
 * @version 1.0
 */
public class ShadowBlade extends Monster {
    private static final int SHADOWBLADEHEALTHPOINTS = 27;

    /**
     * Constructor to create an instance of the ShadowBlade
     *
     * @param name of the ShadowBlade
     */
    public ShadowBlade(String name) {
        super(SHADOWBLADEHEALTHPOINTS, Type.LIGHTNING, name, List.of(
                new ScratchMonsterSkill(MonsterSkillEnum.SCRATCH, 2),
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 2),
                new LightningMonsterSkill(MonsterSkillEnum.LILGHTNING, 2)
        ));
    }
}
