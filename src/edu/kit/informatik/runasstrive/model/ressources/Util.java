package edu.kit.informatik.runasstrive.model.ressources;

import edu.kit.informatik.runasstrive.model.monsters.Monster;
import edu.kit.informatik.runasstrive.model.monsters.level1.Frog;
import edu.kit.informatik.runasstrive.model.monsters.level1.Ghost;
import edu.kit.informatik.runasstrive.model.monsters.level1.Goblin;
import edu.kit.informatik.runasstrive.model.monsters.level1.Gorgon;
import edu.kit.informatik.runasstrive.model.monsters.level1.Mushroomlin;
import edu.kit.informatik.runasstrive.model.monsters.level1.Rat;
import edu.kit.informatik.runasstrive.model.monsters.level1.Skeleton;
import edu.kit.informatik.runasstrive.model.monsters.level1.Spider;
import edu.kit.informatik.runasstrive.model.monsters.level2.Bear;
import edu.kit.informatik.runasstrive.model.monsters.level2.DarkElf;
import edu.kit.informatik.runasstrive.model.monsters.level2.Hornet;
import edu.kit.informatik.runasstrive.model.monsters.level2.Mushroomlon;
import edu.kit.informatik.runasstrive.model.monsters.level2.ShadowBlade;
import edu.kit.informatik.runasstrive.model.monsters.level2.Snake;
import edu.kit.informatik.runasstrive.model.monsters.level2.Tarantula;
import edu.kit.informatik.runasstrive.model.monsters.level2.WildBoar;
import edu.kit.informatik.runasstrive.model.skills.Skill;
import edu.kit.informatik.runasstrive.model.skills.magical.FireSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.FocusSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.IceSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.LightningSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.ReflectSkill;
import edu.kit.informatik.runasstrive.model.skills.magical.WaterSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.ParrySkill;
import edu.kit.informatik.runasstrive.model.skills.physical.PierceSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.SlashSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.SwingSkill;
import edu.kit.informatik.runasstrive.model.skills.physical.ThrustSkill;

import java.util.ArrayList;
import java.util.List;


/**
 * Utility Class for the game Setup
 *
 * @author ucfoh
 * @version 1.0
 */
public final class Util {

    private Util() {
    }

    /**
     * this method fills the list with monsters for the first level
     *
     * @return the filled monster list
     */
    public static List<Monster> fillMonsterListLevel1() {

        ArrayList<Monster> skillList = new ArrayList<>();
        skillList.add(new Frog("Frog"));
        skillList.add(new Ghost("Ghost"));
        skillList.add(new Gorgon("Gorgon"));
        skillList.add(new Skeleton("Skeleton"));
        skillList.add(new Spider("Spider"));
        skillList.add(new Goblin("Goblin"));
        skillList.add(new Rat("Rat"));
        skillList.add(new Mushroomlin("Mushroomlin"));
        return skillList;

    }

    /**
     * this method fills the list with monsters for the second level
     *
     * @return the filled monster list
     */
    public static List<Monster> fillMonsterListLevel2() {
        ArrayList<Monster> skillList = new ArrayList<>();
        skillList.add(new Snake("Snake"));
        skillList.add(new DarkElf("Dark Elf"));
        skillList.add(new ShadowBlade("Shadow Blade"));
        skillList.add(new Hornet("Hornet"));
        skillList.add(new Tarantula("Tarantula"));
        skillList.add(new Bear("Bear"));
        skillList.add(new Mushroomlon("Mushroomlon"));
        skillList.add(new WildBoar("Wild Boar"));
        return skillList;
    }

    /**
     * this method fills the list skills with given input level
     *
     * @param level of the skills
     * @return the filled monster list
     */
    public static List<Skill> fillSkillList(int level) {

        ArrayList<Skill> skillList = new ArrayList<>();
        skillList.add(new SlashSkill(RunaSkillEnum.SLASH, level));
        skillList.add(new SwingSkill(RunaSkillEnum.SWING, level));
        skillList.add(new ThrustSkill(RunaSkillEnum.THRUST, level));
        skillList.add(new PierceSkill(RunaSkillEnum.PIERCE, level));
        skillList.add(new ParrySkill(RunaSkillEnum.PARRY, level));
        skillList.add(new FocusSkill(RunaSkillEnum.FOCUS, level));
        skillList.add(new ReflectSkill(RunaSkillEnum.REFLECT, level));
        skillList.add(new WaterSkill(RunaSkillEnum.WATER, level));
        skillList.add(new IceSkill(RunaSkillEnum.ICE, level));
        skillList.add(new FireSkill(RunaSkillEnum.FIRE, level));
        skillList.add(new LightningSkill(RunaSkillEnum.LIGHTNING, level));
        return skillList;

    }


}
