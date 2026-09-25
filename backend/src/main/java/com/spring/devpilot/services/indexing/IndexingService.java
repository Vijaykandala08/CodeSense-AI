package com.spring.devpilot.services.indexing;

import com.spring.devpilot.entity.Repository;
import org.springframework.ai.vectorstore.VectorStore;
import com.spring.devpilot.repository.RepoRepository;
import com.spring.devpilot.services.UserService;
import com.spring.devpilot.services.github.GithubApiClient;
import com.spring.devpilot.services.github.GithubRateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexingService {

    private static final int VECTOR_BATCH_SIZE = 32;

    private static final int PROGRESS_EVERY_N_FILES = 5;
    private final RepoRepository  repoRepository;
    private final UserService userService;
    private final GithubApiClient githubApiClient;
    private final CodeFileFilter codeFileFilter;
    private final CodeChunker  codeChunker;
    private final GithubRateLimiter   githubRateLimiter;
    private final VectorStore vectorStore;

}
