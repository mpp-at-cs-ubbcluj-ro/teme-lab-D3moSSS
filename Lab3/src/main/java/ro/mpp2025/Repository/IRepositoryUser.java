package ro.mpp2025.Repository;

import ro.mpp2025.Domain.User;

import java.util.Optional;

public class IRepositoryUser implements IRepository<Integer , User>{
    Optional<User> findOneOrganizatorByEmail(String email) {
        return null;
    }

    @Override
    public Optional<User> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> save(User entity) {
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(User entity) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User entity) {
        return Optional.empty();
    }
}
