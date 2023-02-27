package com.example.ihearu;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    List<Contact> getAllContacts();

    @Query("SELECT * FROM contact")
    Flowable<List<Contact>> getAllContactsAsync();



    @Query("SELECT * FROM contact WHERE name LIKE :name")
    Contact getContact(String name);


    @Query("SELECT * FROM contact WHERE contact_id LIKE :id")
    Contact getContactById(String id);

    @Insert
    void addContact(Contact contact);

    @Insert
    Completable addContactAsync(Contact contact);

    @Delete
    void removeContact(Contact contact);

    @Delete
    Completable removeContactAsync(Contact contact);



}
