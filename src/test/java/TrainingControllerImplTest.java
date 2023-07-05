import io.github.cdimascio.dotenv.Dotenv;
import org.example.model.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.example.repository.TrainingRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.controller.TrainingControllerImpl;

import static com.mongodb.assertions.Assertions.fail;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Group of units tests for the training controller")
public class TrainingControllerImplTest {
    @Mock
    TrainingRepositoryImpl trainingRepository;
    Training armTraining = new Training(
            "Arm Training",
            "60",
            "Training for arms",
            "TestPER",
            "TestCharge");
    Training legTraining = new Training(
            "Leg Training",
            "60",
            "Training for legs",
            "TestPER",
            "TestCharge");
    String id = "idArmTraining";
    private static final Dotenv dotenv = Dotenv.load();
    private static final String connectionString = "mongodb+srv://" + dotenv.get("DB_USERNAME") + ":" + dotenv.get("DB_PASSWORD") + "@devdescktop.vpi0ffm.mongodb.net/";

    TrainingControllerImpl classUnderTest;

    @BeforeEach
    public void setUp () {
        classUnderTest = new TrainingControllerImpl(trainingRepository);
    }

    @Disabled
    @Test
    @DisplayName("Test an action")
    public void voidAction_isTested_shouldFail () {
        fail("Not yet implemented");
    }

    @Test
    @DisplayName("Test if the save method of the repository is called with a Training")
    public void save_withTraining_shouldCallRepository () {
        //Arrange
        when(trainingRepository.addTraining(armTraining, connectionString)).thenReturn(id);

        //Act
        String result = classUnderTest.saveTraining(armTraining, connectionString);

        //Assert
        verify(trainingRepository).addTraining(armTraining, connectionString);
    }
}
