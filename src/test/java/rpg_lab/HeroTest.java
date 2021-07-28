package rpg_lab;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {


    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled() {

        Weapon weapon = mock(Weapon.class);

        Hero hero = new Hero("JavaWizard", weapon);

        Target target = mock(Target.class);

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(13);

        hero.attack(target);
        assertEquals(13, hero.getExperience());

    }

}