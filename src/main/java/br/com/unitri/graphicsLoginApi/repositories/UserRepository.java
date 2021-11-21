package br.com.unitri.graphicsLoginApi.repositories;

import br.com.unitri.graphicsLoginApi.models.GraphicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GraphicUser, Long> {

    Optional<GraphicUser> findByLogin(String login);

    Optional<GraphicUser> findById(Long id);
}
