package ru.sms.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.sms.organization.exception.EntityNotFoundException;
import ru.sms.organization.model.Organization;
import ru.sms.organization.repository.OrganizationRepository;

import java.util.Locale;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private MessageSource messages;

    public Organization getOrganization(String organizationId) {
        final Organization organization = organizationRepository.findById(organizationId).orElse(null);
        if (organization == null) {
            final String message = messages.getMessage("organization.search.error.message",
                    new Object[]{organizationId}, Locale.getDefault());
            throw new EntityNotFoundException(message);
        }
        return organization;
    }

    public String updateOrganization(Organization organization) {
        organizationRepository.save(organization);
        return messages.getMessage("organization.update.message",
                new Object[]{organization.getId()}, Locale.getDefault());
    }

    public String createOrganization(Organization organization) {
        organizationRepository.save(organization);
        return messages.getMessage("organization.create.message",
                new Object[]{organization.getId()}, Locale.getDefault());
    }

    public String deleteOrganization(String organizationId) {
        organizationRepository.deleteById(organizationId);
        return messages.getMessage("organization.delete.message",
                new Object[]{organizationId}, Locale.getDefault());
    }
}
