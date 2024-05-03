package ru.sms.organization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sms.organization.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
//    Organization findOrganizationById(String organizationId);
}
