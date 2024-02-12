public class LoanService implements ILoanService {
    IUserService _userService;
    IPersonRepository _personRepository;

    public LoanService(IUserService userService, IPersonRepository personRepository) {
        _userService = userService;
        _personRepository = personRepository;
    }

    public boolean IsEligibleForLoan(String userId) {
        var isUserValid = _userService.IsUserValid(userId);

        if (!isUserValid) return false;

        var person = _personRepository.Get(userId);

        if (person == null) return false;

        if (person.getAge() < 18 || person.getCreditScore() < 1000)
            return false;

        return true;
    }
}