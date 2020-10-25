package com.thoughtworks.capability.gtb.restfulapidesign;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupingController {
    private final GroupingService groupingService;

    public GroupingController(GroupingService groupingService) {
        this.groupingService = groupingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> groupStudent() {
        return groupingService.grouping();
    }

    @PatchMapping(value = "/{id}")
    public void updateStudent(@RequestParam(name = "name", required = true) String name,
                              @PathVariable int id) {
        groupingService.updateGroupName(id, name);
    }

    @GetMapping
    public List<Group> getGroupLists() {
        return groupingService.getGroupLists();
    }
}
