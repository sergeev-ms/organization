package ru.sms.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sms.organization.model.Organization;
import ru.sms.organization.service.OrganizationService;

@RestController
@RequestMapping("v1/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String organizationId) {
        final Organization organization = organizationService.getOrganization(organizationId);
        return ResponseEntity.ok(organization);
    }

    @PutMapping
    public ResponseEntity<String> updateOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.updateOrganization(organization));
    }

    @PostMapping
    public ResponseEntity<String> createOrganization(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.createOrganization(organization));
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<String> deleteOrganization(@PathVariable String organizationId) {
        return ResponseEntity.ok(organizationService.deleteOrganization(organizationId));
    }


}
