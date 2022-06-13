package facades;

import dtos.PersonDTO;

import java.util.List;

public interface IPersonFacade {
    public PersonDTO addPerson(String fName, String lName, String phone);
    public PersonDTO deletePerson(int id);
    public PersonDTO getPerson(int id);
    public List<PersonDTO> getAllPersons();
    public PersonDTO editPerson(PersonDTO p);
}
