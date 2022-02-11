package one.digitalinnovation.personapi.test.service;

import one.digitalinnovation.personapi.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.service.PersonService;
import one.digitalinnovation.personapi.test.java.one.digitalinnovation.personapi.test.util.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.test.java.one.digitalinnovation.personapi.test.util.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
   void testGivenPersonDTOThenReturnSabedMessage(){
     PersonDTO personDTO = PersonUtils.createFakeDTO();
    Person expectedSavedPerson = createFakeEntity();

       when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
       //commit
  personService.createPerson(personDTO);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());

       MessageResponseDTO successMessage = personService.createPerson(personDTO);
       assertEquals(expectedSuccessMessage, successMessage);

   }
    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + savedPersonId)
                .build();
    }



}
