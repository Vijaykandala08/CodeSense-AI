package com.spring.devpilot.controller;

import com.spring.devpilot.dto.IndexStatusResponse;
import com.spring.devpilot.dto.RepositoryResponse;
import com.spring.devpilot.entity.Repository;
import com.spring.devpilot.security.CurrentUser;
import com.spring.devpilot.services.RepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/repos")
@RequiredArgsConstructor
public class RepoController {

    private final CurrentUser currentUser;
    private final RepoService repoService;

    @GetMapping
    public List<RepositoryResponse> list(
            @RequestParam(name = "refresh", defaultValue = "true") boolean refresh){
        UUID userId = currentUser.require().getId();
        if(refresh){
            return repoService.syncAndListRepos(userId);
        }
        return repoService.listStored(userId);
    }

    @GetMapping("/{id}")
    public RepositoryResponse get(@PathVariable UUID id){
        UUID userId = currentUser.require().getId();
        return repoService.toResponse(repoService.requireOwned(id,userId));
    }

    @GetMapping("/{id}/status")
    public IndexStatusResponse status(@PathVariable UUID id){
        UUID userId = currentUser.require().getId();
        return repoService.status(id,userId);
    }
}
