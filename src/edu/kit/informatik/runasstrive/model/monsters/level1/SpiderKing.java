package edu.kit.informatik.runasstrive.model.monsters.level1;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.ressources.Type;
import edu.kit.informatik.runasstrive.model.ressources.MonsterSkillEnum;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.FocusMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.magical.LightningMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BiteMonsterSkill;
import edu.kit.informatik.runasstrive.model.monsters.skills.physical.BlockMonsterSkill;

import java.util.List;

/**
 * This Class models the Monster: SpiderKing
 *
 * @author ucfoh
 * @version 1.0
 */
public class SpiderKing extends Monster {

    private static final int SPIDERKINGHELATHPOINTS = 50;

    /**
     * Constructor to create an instance of the SpiderKing
     *
     * @param name of the SpiderKing
     */
    public SpiderKing(String name) {
        super(SPIDERKINGHELATHPOINTS, Type.LIGHTNING, name, List.of(
                new BiteMonsterSkill(MonsterSkillEnum.BITE, 1),
                new BlockMonsterSkill(MonsterSkillEnum.BLOCK, 1),
                new FocusMonsterSkill(MonsterSkillEnum.FOCUS, 1),
                new LightningMonsterSkill(MonsterSkillEnum.LILGHTNING, 1)));
    }
}
