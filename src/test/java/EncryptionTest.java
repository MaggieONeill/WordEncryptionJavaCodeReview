import org.junit.*;
import static org.junit.Assert.*;

public class EncryptionTest{

  @Test
  public void encryption_replacesVowelsWithDashes_returnsEncryptedPhrase (){
    assertEquals("M-ggs -n M-ggs -n M-ggs", App.encryption("Maggs on Maggs on Maggs"));
  }

  @Test
  public void encryption_replacesCapitalizedVowels_returnsEncryptedPhrase () {
    assertEquals("-HHHHH - GH-ST", App.encryption("AHHHHH A GHOST"));
  }
}
