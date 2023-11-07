package be.brahms.Forum.controllers;

import be.brahms.Forum.repositories.ForumRepo;
import be.brahms.Forum.Models.entities.Forum;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = {"/forums"})
public class ForumCont {

    private ForumRepo forumRepo;

    public ForumCont(ForumRepo forumRepo){
        this.forumRepo = forumRepo;
    }

    @GetMapping(path = "")
    public List<Forum> showAllAction(){
        return this.forumRepo.findAll();
    }

    @PostMapping(path = "")
    public Forum createAction( @RequestBody Forum forum){
        forum.setCreateAt(LocalDate.now());
        return this.forumRepo.save(forum);
    }

    @PatchMapping(path = "/{id}")
    public Forum updateAction( @PathVariable("id") String id, @RequestBody Forum forum){
        Forum leForum = (Forum) this.forumRepo.findById(id).orElseThrow();

        if(leForum.getMessage()!= null){
            leForum.setMessage(forum.getMessage());
        }
        leForum.setUpdateAt(LocalDate.now());

        return this.forumRepo.save(leForum);
    }
}
