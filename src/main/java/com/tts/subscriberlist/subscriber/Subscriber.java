package com.tts.subscriberlist.subscriber;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

// Tell the JPA that we want to store objects of this class to the database
// A table named "SUBSCRIBER" will be automatically created.
@Entity
public class Subscriber
{
    @Id // Mark the ID field as our database primary key
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    
    @Column // Attribute is stored in a database table column whose names matches that of the persistent field or property.  
    @CreationTimestamp // sets the value of the data field to the current time and date
    private Date signedUp;
    
    // This empty, no-argument constructor is necessary if we are going to store an @Entity to the database.
    public Subscriber()
    {
        super();
    }

    // Constructor
    public Subscriber(String firstName, String lastName, String userName, Date signedUp)
    {
        super(); // This calls the empty constructor of the superclass (Object)
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.signedUp = signedUp;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Date getSignedUp()
    {
        return signedUp;
    }

    public void setSignedUp(Date signedUp)
    {
        this.signedUp = signedUp;
    }

    @Override
    public String toString()
    {
        return "Subscriber [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", signedUp=" + signedUp + "]";
    }
    
    
    
}
