package api.tchiiwa.microservice.features.person.infrastructure.repository;

import api.tchiiwa.microservice.features.person.application.ports.out.PersonRepositoryOutPort;
import api.tchiiwa.microservice.features.person.domain.mappers.PersonMapper;
import api.tchiiwa.microservice.features.person.domain.models.PersonModel;
import api.tchiiwa.microservice.features.person.infrastructure.entity.PersonEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PersonRepository implements PersonRepositoryOutPort {
    private final PnPersonRepository personRepository;
    private final PersonMapper personMapper;

    @Inject
    public PersonRepository(PnPersonRepository personRepository, PersonMapper personMapper) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public List<PersonModel> findAll() {
        return personRepository
                .findAll()
                .stream()
                .map(personMapper::toModel)
                .toList();
    }

    @Override
    public List<PersonModel> findAll(int page, int size) {
        return personRepository
                .findAll()
                .page(page, size)
                .stream()
                .map(personMapper::toModel)
                .toList();
    }

    @Override
    public Optional<PersonModel> findById(Long id) {
        return personRepository.findByIdOptional(id)
                .map(personMapper::toModel);
    }

    @Override
    public Optional<PersonModel> findByUuid(UUID uuid) {
        return personRepository.find("uuid", uuid).firstResultOptional()
                .map(personMapper::toModel);
    }

    @Override
    public PersonModel create(PersonModel personModel) {
        PersonEntity personEntity = personMapper.toEntity(personModel);
        personRepository.persist(personEntity);
        return personMapper.toModel(personEntity);
    }

    @Override
    public PersonModel update(PersonModel personModel) {
        PersonEntity personEntity = personMapper.toEntity(personModel);
        personRepository.getEntityManager().merge(personEntity);
        return personMapper.toModel(personEntity);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
