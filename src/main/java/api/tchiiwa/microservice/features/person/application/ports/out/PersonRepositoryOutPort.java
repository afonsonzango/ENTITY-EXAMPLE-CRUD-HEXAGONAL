package api.tchiiwa.microservice.features.person.application.ports.out;

import api.tchiiwa.microservice.features.person.domain.models.PersonModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonRepositoryOutPort {
    List<PersonModel> findAll();

    List<PersonModel> findAll(int page, int size);

    Optional<PersonModel> findById(Long id);

    Optional<PersonModel> findByUuid(UUID uuid);

    PersonModel create(PersonModel personModel);

    PersonModel update(PersonModel personModel);

    void deleteById(Long id);
}
