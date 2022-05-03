import app.Arrivee;
import app.Complexe;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class getMontantTest {
    private Arrivee arrivee;
    private Complexe complexe;
    @Before
    public void init(){
        // Todo: créer un fake complexe
        complexe = new Complexe(1,1,"");
        arrivee = new Arrivee(complexe,'M');
    }

    @Test
    public void ShouldPayFor16Minutes() {

        arrivee.setHoraireArrivee(0);
        arrivee.setHoraireDepart(16*60*1000);
        assertEquals(0.5, arrivee.getMontant(),0.01);
    }
    @Test
    public void ShouldPayFor10Minutes() {

        arrivee.setHoraireArrivee(0);
        arrivee.setHoraireDepart(10 * 60 * 1000);
        assertEquals(0, arrivee.getMontant(), 0.01);
    }
    @Test
    public void ShouldPayFor35Minutes() {
        arrivee.setHoraireArrivee(0);
        arrivee.setHoraireDepart(35 * 60 * 1000);
        assertEquals(1, arrivee.getMontant(), 0.01);
    }
    @Test
    public void ShouldPayFor150Minutes() {
        arrivee.setHoraireArrivee(0);
        arrivee.setHoraireDepart(150 * 60 * 1000);
        assertEquals(4, arrivee.getMontant(), 0.01);
        System.out.println(arrivee.getMontant());
    }

}
