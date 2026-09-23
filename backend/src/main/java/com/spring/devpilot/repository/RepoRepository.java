package com.spring.devpilot.repository;
import java.util.List;
import com.spring.devpilot.entity.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RepoRepository extends JpaRepository<Repository, UUID> {
    List<Repository> findByUserIdOrderByFullNameAsc(UUID userId);

    Optional<Repository> findByIdAndUserId(UUID id, UUID userId);

    Optional<Repository> findByUserIdAndGithubRepoId(UUID userId, Long githubRepoId);

}
