package com.example.data;

import org.springframework.data.repository.CrudRepository;

/**
 * Allows managing {@link User} instances.
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}
