package ru.sms.organization.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column
    String id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(name = "contact_name")
    String contactName;

    @Column(name = "contact_email")
    String contactEmail;

    @Column(name = "contact_phone")
    String contactPhone;

}