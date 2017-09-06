package pl.oskarpolak.models.dao.impl;

import com.sun.webkit.graphics.Ref;
import pl.oskarpolak.MysqlConnector;
import pl.oskarpolak.models.ContactModel;
import pl.oskarpolak.models.dao.ContactDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao {

    private MysqlConnector mysqlConnector = MysqlConnector.getInstance();

    public void addContact(ContactModel model) {
        try {
            PreparedStatement statement = mysqlConnector.getConnection().prepareStatement(
                    "INSERT INTO contact VALUES(?, ?, ?, ?)"
            );
            statement.setInt(1, 0);
            statement.setString(2, model.getNumber());
            statement.setString(3, model.getName());
            statement.setString(4, model.getLastname());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeContact(String number) {
        try {
            PreparedStatement statement = mysqlConnector.getConnection().prepareStatement(
                    "DELETE FROM contact WHERE number = ?"
            );
            statement.setString(1, number);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ContactModel> getAllContacts() {
        List<ContactModel> contactModels = new ArrayList<ContactModel>();
        try {
            PreparedStatement statement = mysqlConnector.getConnection().prepareStatement(
                    "SELECT * FROM contact"
            );
            ResultSet set = statement.executeQuery();
            while (set.next()){
                contactModels.add(new ContactModel(set.getString("number"), set.getString("name"),
                set.getString("lastname")));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactModels;
    }

    @Override
    public ContactModel getContactByNumber(String number) {
        ContactModel model = null;
        try {
            PreparedStatement preparedStatement = mysqlConnector.getConnection().prepareStatement(
                    "SELECT * FROM contact WHERE number = ?"
            );
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                model = new ContactModel(set.getString("number"),
                        set.getString("name"),
                        set.getString("lastname"));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return model;
    }
}
