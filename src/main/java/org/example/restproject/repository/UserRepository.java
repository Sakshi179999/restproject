
package org.example.restproject.repository; // Corrected spelling of 'repository'

import org.example.restproject.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Todo, Long> {

    // Added 'extends'
    // You can add custom query methods here if needed
}
