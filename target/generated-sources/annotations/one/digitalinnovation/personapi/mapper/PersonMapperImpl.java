package one.digitalinnovation.personapi.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO.PersonDTOBuilder;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Person.PersonBuilder;
import one.digitalinnovation.personapi.entity.Phone;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-11T13:40:44-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonBuilder person = Person.builder();

        if ( personDTO.getBirthDate() != null ) {
            person.birthDate( LocalDate.parse( personDTO.getBirthDate(), DateTimeFormatter.ofPattern( "dd-MM-yyyy" ) ) );
        }
        person.id( personDTO.getId() );
        person.firstName( personDTO.getFirstName() );
        person.lastName( personDTO.getLastName() );
        person.cpf( personDTO.getCpf() );
        List<Phone> list = personDTO.getPhones();
        if ( list != null ) {
            person.phones( new ArrayList<Phone>( list ) );
        }

        return person.build();
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.id( person.getId() );
        personDTO.firstName( person.getFirstName() );
        personDTO.lastName( person.getLastName() );
        personDTO.cpf( person.getCpf() );
        if ( person.getBirthDate() != null ) {
            personDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        List<Phone> list = person.getPhones();
        if ( list != null ) {
            personDTO.phones( new ArrayList<Phone>( list ) );
        }

        return personDTO.build();
    }
}
