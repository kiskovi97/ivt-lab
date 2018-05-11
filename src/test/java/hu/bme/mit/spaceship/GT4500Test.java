package hu.bme.mit.spaceship;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class GT4500Test {

  private TorpedoStore prim;
  private TorpedoStore sec;
  private GT4500 ship;

  @Before
  public void init(){
    prim = mock(TorpedoStore.class);
    sec = mock(TorpedoStore.class);
    this.ship = new GT4500(prim,sec);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(prim.isEmpty()).thenReturn(false);
    when(prim.fire(1)).thenReturn(true);
    when(sec.isEmpty()).thenReturn(false);
    when(sec.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
      verify(prim, times(1)).fire(1);
  }

    @Test
    public void fireTorpedo_Single_Emptys(){
        // Arrange
        when(prim.isEmpty()).thenReturn(true);
        when(sec.isEmpty()).thenReturn(true);
        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(false, result);
        verify(prim, times(0)).fire(1);
        verify(sec, times(0)).fire(1);
    }
    @Test
    public void fireTorpedo_Single_EmptyPrim(){
        // Arrange
        when(prim.isEmpty()).thenReturn(true);
        when(sec.isEmpty()).thenReturn(false);
        when(sec.fire(1)).thenReturn(true);
        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
        verify(prim, times(0)).fire(1);
        verify(sec, times(1)).fire(1);
    }
    @Test
    public void fireTorpedo_Twice(){
        // Arrange
        when(prim.isEmpty()).thenReturn(false);
        when(prim.fire(1)).thenReturn(true);
        when(sec.isEmpty()).thenReturn(false);
        when(sec.fire(1)).thenReturn(true);
        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
        // Assert
        assertEquals(true, result);
        assertEquals(true, result2);
        verify(prim, times(1)).fire(1);
        verify(sec, times(1)).fire(1);
    }



  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

      when(prim.isEmpty()).thenReturn(false);
      when(prim.fire(1)).thenReturn(true);
      when(sec.isEmpty()).thenReturn(false);
      when(sec.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
     verify(prim, times(1)).fire(1);
    verify(sec, times(1)).fire(1);
  }

    @Test
    public void fireTorpedo_All_Emptys(){
        // Arrange

        when(prim.isEmpty()).thenReturn(true);
        when(sec.isEmpty()).thenReturn(true);
        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(false, result);
        verify(prim, times(0)).fire(1);
        verify(sec, times(0)).fire(1);
    }

    @Test
    public void fireTorpedo_All_FirstEmpty(){
        // Arrange

        when(prim.isEmpty()).thenReturn(true);
        when(sec.isEmpty()).thenReturn(false);
        when(sec.fire(1)).thenReturn(true);
        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
        verify(prim, times(0)).fire(1);
        verify(sec, times(1)).fire(1);
    }
    @Test
    public void fireLaser(){
        // Act
        boolean result = ship.fireLaser(FiringMode.ALL);

        // Assert
        assertEquals(false, result);
    }
    @Test
    public void fireTorpedo_SINGLE_SecondEmpty(){
        // Arrange

        when(prim.isEmpty()).thenReturn(false);

        when(prim.fire(1)).thenReturn(true);
        when(sec.isEmpty()).thenReturn(true);
        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);
        boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
        // Assert
        assertEquals(true, result);
        assertEquals(true, result2);
        verify(prim, times(2)).fire(1);
        verify(sec, times(0)).fire(1);
    }

}
