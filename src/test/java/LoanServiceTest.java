
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoanServiceTest {

    IUserService mockUserService;
    IPersonRepository mockPersonRepo;

    @Before
    public void testInit(){
        //mockito is instantiating a mock object which abides to the contract IUserService
        mockUserService = mock(IUserService.class);
        //mockito is instantiating a mock object which abides to the contract IPersonRepository
        mockPersonRepo = mock(IPersonRepository.class);
    }

    @Test
    public void isEligibleForLoan_MustBeTrue() {
        //arrange
        when(mockUserService
                .IsUserValid(anyString()))
                .thenReturn(true);

        //mock data
        var person = new Person();
        person.setAge(18);
        person.setCreditScore(1200);

        when(mockPersonRepo.Get(anyString()))
                .thenReturn(person);

        var loanService = new LoanService(mockUserService, mockPersonRepo);

        //act
        var result = loanService.IsEligibleForLoan(anyString());

        //assert
        assertTrue(result);
    }
}